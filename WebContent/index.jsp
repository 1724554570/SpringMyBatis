<html>
    <head>
        <base href="./">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home-Hello World!</title>
        <link href="static/css/actin.css" rel="stylesheet" type="text/css" />
        <script src="static/script/jquery-2.0.3.min.js" type="text/javascript"></script>
        <script src="static/script/layerMaster/src/layer.js" type="text/javascript"></script>
        <script src="static/script/actionTest.js" type="text/javascript"></script>
    </head>
    <body>
        <h2>Hello World!</h2>
        <div class="actionBut">
            <div class="allBut" data-href="/com/ouser/login">user Login
                <input type="hidden" class="username" name="username" value="mms">
                <input type="hidden" class="userpass" name="userpass" value="123456">
            </div>
            <div class="allBut" data-href="/com/ouser/userlist">user List
                <input type="hidden" class="startIndex" name="startIndex" value="1">
                <input type="hidden" class="pageSize" name="pageSize" value="10">
            </div>
            <div class="allBut" data-href="/com/article/getArticleList">article List
            </div>
        </div>
        <script>
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
