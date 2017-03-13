<%@ page language="java" import="java.util.*" contentType="text/html" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String times = Long.toString(System.currentTimeMillis());
//System.out.println(basePath);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <base href="./">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home-Hello World!</title>
        <link href="static/css/actin.css?v=<%=times %>" rel="stylesheet" type="text/css" />
        <script src="static/script/jquery-2.0.3.min.js?v=<%=times %>" type="text/javascript"></script>
        <script src="static/script/layerMaster/src/layer.js?v=<%=times %>" type="text/javascript"></script>
        <script src="static/script/actionTest.js?v=<%=times %>" type="text/javascript"></script>
    </head>
    <body>
        <h2>Hello World!</h2>
        <div class="actionBut">
            <div class="allBut" data-href="/com/ouserAction/login" data-parms='{"username":"mms","userpass":"123456"}'>/com/ouserAction/login Login</div>
            <div class="allBut" data-href="/com/ouserAction/userlist" data-parms='{"startIndex":1,"pageSize":10}'>/com/ouserAction/userlist List</div>
            <div class="allBut" data-href="/com/articleAction/getArticleList" data-parms='{"startIndex":1,"pageSize":10}'>/com/articleAction/getArticleList List</div>
            <div class="allBut" data-href="/com/replysAction/saveOneReply" data-parms='{"articleId":3,"replyUser":4,"replyToId":2,"replyToUser":3,"content":"HAHHAHAHAHAHHAH"}'>/com/replysAction/saveOneReply saveOneReply</div>
        </div>
        <!-- 
        
                replys/saveOneReply?articleId=3&replyUser=2&replyToId=2&replyToUser=3
        
        -->
        <script>
            var s = {username: 'mms', userpass: '123456'};
            var s2 = {startIndex: 1, pageSize: 10};
            var s3 = {articleId: 2, replyUser: 2, replyToId: 2, replyToUser: 3, content: 'HAHHAHAHAHAHHAH'};
            
            console.log(JSON.stringify(s));
            $(function () {
                jQuery.fn.serializeObject = function () {
                    var json = {};
                    var arrObj = this.serializeArray();
                    jQuery.each(arrObj, function () {
                        if (json[this.name]) {
                            if (!json[this.name].push) {
                                json[this.name] = [json[this.name]];
                            }
                            json[this.name].push(this.value || '');
                        } else {
                            json[this.name] = this.value || '';
                        }
                    });
                    return json;
                };

            });
        </script>    
    </body>
</html>
