<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>CRM - Customer relation managment</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>
<body>

<div id="wrapper">
    <div id="header">

        <h2>CRM - Customer relationship manager</h2>

    </div>
</div>

<div id="container">

    <div id="content">

        <input type="button" value="Add Customer"
               onclick="window.location.href='/customer/showFormForAdd'; return false"
               class="add-button">

        <form:form action="searchCustomers"  method="post">

            <label>Search customer:</label>

            <input type="text" name="theSearchName">

            <input type="submit" value="Search" class="add-button">

        </form:form>

        <table>

            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>

            <%--@elvariable id="theCustomer" type="com.mariusz.springdemo.entity.Customer"--%>
            <c:forEach var="theCustomer" items="${customers}">

                <c:url var="updateCustomerLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${theCustomer.id}"/>
                </c:url>

                <c:url var="deleteCustomerLink" value="/customer/deleteCustomer">
                    <c:param name="deleteUserId" value="${theCustomer.id}"/>
                </c:url>

                <tr>

                    <td>${theCustomer.firstName}</td>
                    <td>${theCustomer.lastName}</td>
                    <td>${theCustomer.email}</td>

                    <td>
                        <a href="${updateCustomerLink}">Update</a>
                        |
                        <a href="${deleteCustomerLink}"
                           onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
                    </td>

                </tr>

            </c:forEach>

        </table>

    </div>
</div>


</body>
</html>
