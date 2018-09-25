<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>CRM - Customer relation managment</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
    <%--<link type="text/css"--%>
          <%--rel="stylesheet"--%>
          <%--href="${pageContext.request.contextPath}/resources/css/style.css" />--%>

</head>
<body>

<div id="wrapper">
    <div id="header">

        <h2>CRM - Customer relationship manager</h2>

    </div>
</div>

<div id="container">
    <div id="content">

        <table>

            <tr>
                <td>First name</td>
                <td>Last name</td>
                <td>Email</td>
            </tr>

            <%--@elvariable id="theCustomer" type="com.mariusz.springdemo.entity.Customer"--%>
            <c:forEach var="theCustomer" items="${customers}">
                <tr>

                    <td>${theCustomer.firstName}</td>
                    <td>${theCustomer.lastName}</td>
                    <td>${theCustomer.email}</td>

                </tr>
            </c:forEach>

        </table>

    </div>
</div>


</body>
</html>
