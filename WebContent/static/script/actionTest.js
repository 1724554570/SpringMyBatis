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
	if (typeof data === 'object') {
		data = JSON.stringify(data);
		console.log(data);
	} else {
		if(typeof data === 'string'){
			
		}
		//data = JSON.stringify({});
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
	function toJSONparse(n) {
		return JSON.parse(n);
	}
	$(".allBut").on("click", function() {
		var _this = $(this);
		var _url = _this.attr("data-href");
		var stringJson = toJSONparse(_this.attr("data-parms"));
		console.log(stringJson,typeof stringJson);
		//return;
		_allPsot(_url, stringJson);
	});
});