<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        window.onload = function () {
            document.getElementById("img1").onclick = function () {
                alert(1);
                this.src = "${pageContext.request.contextPath}/checkCode?time="+new Date();
            }
        }

        ${sessionScope.get("code")}.value()
    </script>
</head>
<body>
<form action="/doLogin" method="post">
    账号：<input type="text" name="username"><br>
    密码：<input type="text" name="password"><br>
    <img src="${pageContext.request.contextPath}/checkCode"id="img1" ><br>
    <input type="text" name="code"><br>
    <a href="login">看不清，换一张</a>
    <input type="submit" value="提交"><br>
    <span style="color: red;font-size: 20px">${errorMsg}</span>
</form>
</body>
</html>
