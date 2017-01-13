/**
 * 解析url参数
 * 
 * @param {type}
 *            name
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
 * 
 * @param {type}
 *            url
 * @param {type}
 *            data
 * @returns {undefined}
 */
var _allPsot = function(url, data) {
	if (data) {
		data = JSON.stringify(data);
		console.log(data);
	} else {
		data = JSON.stringify({});
	}
	console.log(data);
	$.ajax({
		contentType : "application/json",
		type : "post",
		dataType : "json",
		timeout : "600000",
		url : '' + url,
		data : data,
		error : function(x, y, Exception) {
			alert("请求错误");
			console.log(Exception);
		},
		success : function(res) {
			console.log(res);
		}
	});
};
$().ready(function() {
	var actionURL = {
		login : "ouser/login",
		userlist : "ouser/userlist",
		getArticleList : "article/getArticleList"
	};
	var actionData = [ {
		username : "",
		userpass : ""
	}, {
		startIndex : 1,
		pageSize : 10,
		searchname : ""
	}, ];
	function ckURL(v) {
		var data = {};
		var ck = v.replace("/sm/", "");
		switch (ck) {
		case actionURL.login:
			data.username = "mms";
			data.userpass = "123456";
			break;
		case actionURL.userlist:
			data.startIndex = 1;
			data.pageSize = 10;
			data.searchname = "7";
			break;
		case actionURL.getArticleList:
			data.startIndex = 1;
			data.pageSize = 10;
			break;
		}
		return data;
	}
	$(".allBut").on("click", function() {
		var _this = $(this);
		var _url = _this.attr("data-href");
		var json = ckURL(_url);
		console.log(json);
		// var data = {};
		// data.startIndex = 1;
		// data.pageSize = 10;
		// json = data;
		_allPsot(_url, json);
	});
});