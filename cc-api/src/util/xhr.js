import 'whatwg-fetch';
import 'es6-promise';
import Promise from 'promise-polyfill';

if (!window.Promise) {
    window.Promise = Promise;
}

function getRequest({ method, url, body, type }) {
    method = method.toUpperCase();
    if (type == 'form') {
        let data = new FormData();
        for (let k in body) {
            data.append(k, body[k]);
        }
        body = data;
    } else {

    }
    return window.fetch(url, {
        method: method,
        headers: {
            'Accept': 'application/json',
            // 'Content-Type': 'application/json;charset=utf-8',
            // 'Content-Token': storageUtils.getCookie('token') || '',
            // 'Source': 'PC',
        },
        body: body,
    }).then((res) => {
        const token = res.headers.get('access-token');
        const response = res.json();
        console.log(token, response);
        return response;
    }).catch((error) => {
        console.error('Error:', error);
    });
}

export const get = url => getRequest('GET', url);
export const getFile = url => getRequest('GET', url, null, 'getFile');
export const postFile = (url, body) => getRequest('POST', url, body, 'postFile');
export const del = (url, body) => getRequest('DELETE', url, body);

export default function xhrPromise(url, body) {
    let xhr = new XMLHttpRequest();
    return new Promise(function (resolve, reject) {
        xhr.open('POST', url, true);
        xhr.timeout = 1000 * 60 * 20;
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        // xhr.setRequestHeader("Content-token", storageUtils.getCookie('token') || '');
        // xhr.setRequestHeader("Source", 'PC');
        xhr.onabort = function () {
            reject(new Error({ errorType: 'abort error', xhr: xhr }));
        };
        xhr.ontimeout = function () {
            reject({ errorType: '请求超时', xhr: xhr });
        };
        xhr.onerror = function () {
            reject({ errorType: '请求错误', xhr: xhr })
        };
        xhr.onloadend = function () {
            if ((xhr.status >= 200 && xhr.status < 300) || xhr.status === 304) {
                resolve(xhr);
            } else {
                reject({ errorType: 'status error:' + xhr.status, xhr: xhr })
            }
        };
        try {
            xhr.send(JSON.stringify(body));
        } catch (e) {
            reject({ errorType: '请求过程失败', error: e });
        }
    })
}

export const post = (url, body) => xhrPromise(url, body).then(xhr => {
    let hds = parseHeaders(xhr.getAllResponseHeaders());
    const token = hds.get('Access-token');
    // console.log(token);
    return JSON.parse(xhr.response)
}).then(res => {
    console.log(res);
    return res
});


function parseHeaders(rawHeaders) {
    let headers = new Headers();
    rawHeaders.split(/\r?\n/).forEach(function (line) {
        let parts = line.split(':');
        let key = parts.shift().trim();
        if (key) {
            let value = parts.join(':').trim();
            headers.append(key, value)
        }
    });
    return headers
}