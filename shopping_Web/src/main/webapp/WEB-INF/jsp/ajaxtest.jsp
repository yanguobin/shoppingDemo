<%--
  Created by IntelliJ IDEA.
  User: yanguobin
  Date: 2019/9/11
  Time: 8:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/statics/js/jquery-3.4.1.js"></script>
    <script>
        $(document).ready(function () {
            $("#btn1").click(function () {
                $.ajax({
                    url:"/user/ajaxresp",
                    success:function (result) {
                        $("#mydiv").html(result);
                    },
                    error:function (xhr) {
                        alert(xhr.status + " " + xhr.statusText);
                    }
                });
            });
        });

    </script>
</head>
<body>
    <img src="/statics/images/buy.png">
    <div id="mydiv"><h3 id="test">请点击下面的按钮，通过JQuery AJAX改变这段文本</h3></div>
    <button id="btn1" type="button">获得外部的内容</button>
</body>
</html>
