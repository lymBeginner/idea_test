<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button id="btn">发送ajax 请求</button>
</body>
<script src="../js/jquery-1.8.3.min.js"></script>
<script>
    $(function () {
        // 点击按钮发送ajax 请求
        $("#btn").click(function () {
            $.ajax({
                url:'${pageContext.request.contextPath}/testjson',
                contentType:'application/json;charset=utf-8',
                data: {"name":"abc","price":12},
                success:function (data) {
                    alert(data);
                    alert(data.name);
                }
            })
        })
    });
</script>
</html>
