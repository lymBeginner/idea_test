<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/27
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
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
<img src="${pageContext.request.contextPath}/checkCode"id="img1"><br>
<a href="testLogin.jsp">看不清，换一张</a>
</body>
</html>
