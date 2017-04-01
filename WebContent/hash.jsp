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
        <title>HTML5 File Hash - 在线计算文件Hash值（CRC-32，MD5，SHA1，SHA-256）</title>
        <%-- <link rel="stylesheet" type="text/css" href="static/css/actin.css?v=<%=times %>" /> --%>
        <link rel="stylesheet" type="text/css" href="static/hash/css/bijou.min.css?v=<%=times %>" />
        <link rel="stylesheet" type="text/css" href="static/hash/css/style.new.css?v=<%=times %>" />
        <style>
            .container{
                width: 1000px;
                max-width: 1000px;
                margin: auto;
            }
        </style>
        <style type="text/css">
            #ad-blocks {
                margin: 10px 0;
            }
        </style>
        <style type="text/css">
            #hash_file {
                border: 2px solid rgb(66,158,158);
            }
        </style>
        <script type="text/javascript" src="static/script/jquery-2.0.3.min.js?v=<%=times %>"></script>
        <!-- START file_hash_files-->
        <link rel="stylesheet" type="text/css" href="static/hash/css/dropzone.min.css?v=<%=times %>">
        <script type="text/javascript" src="static/hash/m/dropzone.min.js?v=<%=times %>"></script>
        <script type="text/javascript" src="static/hash/m/md5.js?v=<%=times %>"></script>
        <script type="text/javascript" src="static/hash/m/sha1.js?v=<%=times %>"></script>
        <script type="text/javascript" src="static/hash/m/sha256.js?v=<%=times %>"></script>
        <script type="text/javascript" src="static/hash/m/sha512.js?v=<%=times %>"></script>
        <script type="text/javascript" src="static/hash/m/sha3.js?v=<%=times %>"></script>
        <script type="text/javascript" src="static/hash/m/ripemd160.js?v=<%=times %>"></script>
        <script type="text/javascript" src="static/hash/m/crc32.js?v=<%=times %>"></script>
        <script type="text/javascript" src="static/hash/m/html5hash_1.js?v=<%=times %>"></script>
        <!-- END file_hash_files-->
    </head>
    <body>
        <div class="container">
            <h3 class="explainer">在线计算文件Hash值（CRC-32，MD5，SHA1，SHA-256） - aTool在线工具</h3>
            <div class="divider"></div>
            <ul class="new_tools_list">
                <li>最大支持<span class="green strong">最大支持3G（1024*3M）的文件计算，包括crc32, md5, sha1, sha256, sha512, sha3 and ripdemd160。</span></li>
            </ul>
            <form action="fileAction/fileupload" class="dropzone dz-clickable" id="hash_file">
                <div class="dz-message">
                    Drop files here or click to upload.<br>
                    <span class="note">(文件拖放到这里或者点击选择文件 <strong>计算文件HASH值</strong>)</span>
                </div>
            </form>
            <form action="fileAction/fileupload">
                <input type="checkbox" name="crc32switch" checked="checked">CRC-32
                <input type="checkbox" name="MD5-switch" checked="checked">MD5
                <input type="checkbox" name="SHA1-switch" checked="checked">SHA1
                <input type="checkbox" name="RIPEMD-160-switch">RIPEMD-160
                <input type="checkbox" name="SHA256-switch" checked="checked">SHA256
                <input type="checkbox" name="SHA512-switch">SHA512
                <input type="checkbox" name="SHA3-224-switch">SHA3-224
                <input type="checkbox" name="SHA3-256-switch">SHA3-256
                <input type="checkbox" name="SHA3-384-switch">SHA3-384
                <input type="checkbox" name="SHA3-512-switch">SHA3-512
            </form>
            <div class="divider"></div>
            <table class="table">
                <tbody id="showTable">
                    <tr class="th">
                        <th width="25%">项目</th>
                        <th width="70%">项目值</th>
                    </tr>
                </tbody>
            </table>
            <div class="divider"></div>
            <h4 class="explainer">文件哈希计算 | File Hash Calculate</h4>
            <ul class="new_tools_list">
                <li>MD5是一个将任意长度的数据字符串转化成短的固定长度的值的单向操作。任意两个字符串不应有相同的散列值（即，有“很大可能”是不一样的，并且要人为地创造出来两个散列值相同的字符串应该是困难的）。</li>
                <li>因此MD5经常用于校验字符串或者文件，因为如果文件的MD5不一样，说明文件内容也是不一样的，即经过修改的，如果发现下载的文件和给的md5值不一样，就需要慎重使用。</li>
                <li>MD5文件校验用途非常多，例如：游戏patch包的校验，病毒文件确认，app提审校验等等，只要需要确认某一个文件的唯一性和正确性，都会使用md5作为校验。</li>
                <li>因此我们也经常会使用用到计算文件md5的工具，在一般的后端语言中，都可以进行计算，但是会比较麻烦。</li>
                <li>经过改进之后，支持几乎所有的hash算法，包括crc32, md5, sha1, sha256, sha512, sha3 and ripdemd160，完爆所有互联网上的加密工具。</li>
                <li>本工具使用html5的api计算文件的md5,不会上传文件到后台，而只是使用html文件api在前端进行计算，非常方便，并且对于您的文件绝对安全。最大支持3G（1024*3M）的文件计算</li>
            </ul>
            <div class="divider"></div>
            <script type="text/javascript">console.log('%c在线工具\n%chttp://www.atool.org\n\n%c【这个公司没有年终奖，兄弟别指望了，也别来了，我准备辞职了。你坚持不了多久的，拜拜，祝好！】\n-------------\n%c要网站代码 加QQ交流群: 302883987，并逐步开源到github（https://github.com/aTool-org）', 'color:#5B7102; font-size: 20px;', 'color:#5B7102', 'color:#000;font-size: 10px;', 'color:red;');</script>
            <!--end -->
        </div>
    </body>
</html>
