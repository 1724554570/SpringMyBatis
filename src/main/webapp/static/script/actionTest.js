/**
 * 解析url参数
 * @param {type} name
 * @returns {unresolved}
 */
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)
        return unescape(r[2]);
    return null;
}

/**
 * 封装ajax请求
 * @param {type} url
 * @param {type} data
 * @returns {undefined}
 */
var _allPsot = function (url, data) {
    if (data) {
        data = JSON.stringify(data);
    } else {
        data = JSON.stringify({});
    }
    $.ajax({contentType: "application/json", type: "post", dataType: "json", timeout: "600000", url: '' + url, data: data,
        error: function () {
            alert("请求错误");
        }, success: function (res) {
            console.log(res);
        }}
    );
};
$().ready(function () {
    var actionURL = {
        login: "ouser/login",
        userlist: "ouser/userlist",
        getArticleList: "article/getArticleList"
    };
    var actionData = [
        {username: "", userpass: ""},
        {startIndex: 1, userpass: 10},
    ];
    function ckURL(v) {
        var data = {};
        switch (v) {
            case actionURL.login:
                data = actionData[0];
                break;
            case actionURL.userlist:
                data = actionData[1];
                break;
            case actionURL.getArticleList:
                data = actionData[1];
                break;
        }
    }
    $(".allBut").on("click", function () {
        var _this = $(this);
        var _url = _this.attr("data-href");
        var _data = _this.find("input");
        var _value = _data.serialize();
        var json = _value.split('&');
        console.log(json);


        //_allPsot(_url, _value);
    });
});