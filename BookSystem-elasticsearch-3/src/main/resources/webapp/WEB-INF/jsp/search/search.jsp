<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="layout/header.jsp"/>

<div class="container">
    <div class="page-header">
        <h1>
            Search Results</h1>
    </div>

    <div class="row">
        <div class="span12">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>
                        name
                    </th>
                    <th>
                        country
                    </th>
                    <th>
                        age
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${peopleList}" var="people">
                    <tr>
                        <td>${people.name}</td>
                        <td>${people.country}</td>
                        <td>${people.age}</td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<c:import url="layout/footer.jsp"/>