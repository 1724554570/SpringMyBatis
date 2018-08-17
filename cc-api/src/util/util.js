
const utils = {};//function () {}

utils.sun = function (x) {
    function add(y) {
        x = x + y;
        return add;
    }
    add.toString = add.valueOf = function () {
        return +x;
    }
    return add;
}

/**
 * 数值类型判断
 * @param {*} value 
 */
utils.isValueType = function (value) {
    return ({}).toString.call(value);
}

/**
 * 获取地址栏(url)中的参数值
 * @param {*} url 
 */
utils.urlSearchParams = function (url) {
    const params = function () {
        let num, name, value, i = 0;
        let str = decodeURIComponent(window.location.href);
        let num1 = str.indexOf("?"), num2 = str.indexOf("#");
        num = (num1 > 0 && num1 < num2) ? num1 : num2;
        if (num < 0) {
            return {};
        }
        str = str.substr(num + 1);
        let Vlreg = /[\#|\^|\?]/g;
        let macth_c = Vlreg.test(str);
        if (macth_c) {
            str = str.replace(Vlreg, '&');
        }
        let arr = str.split("&");
        for (i; i < arr.length; i++) {
            num = arr[i].indexOf("=");
            if (num > 0) {
                name = arr[i].substring(0, num);
                value = arr[i].substr(num + 1);
                this[name] = value;
            }
        }
    };
    return (new params);
}

export default utils;