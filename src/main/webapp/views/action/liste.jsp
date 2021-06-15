<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="../util/header.jsp" %>
<body>
<%@include file="../util/navigation.jsp"%>

<div class="jumbotron text-center">
    <h1>Liste des actions</h1>
</div>

<div class="container">
    <table class="table table-hover">
        <tr>
            <th class="col-md-1">Numéro</th>
            <th class="col-md-6">Objectif</th>
            <th class="col-md-1">Score min</th>
        </tr>

        <c:forEach items="${actions}" var="action">
            <tr>
                <td>${action.id}</td>
                <td>${action.wording}</td>
                <td>${action.scoreMinimum}</td>
                <td>
                    <a class="btn btn-primary" href="/action/${action.id}" role="button">
                        <span class="glyphicon glyphicon-eye-open"></span>
                        Voir
                    </a>
                    <c:if test="${role eq \"admin\"}">
                    <a class="btn btn-warning" href="/action/${action.id}/update" role="button">
                        <span class="glyphicon glyphicon-pencil"></span>
                        Modifier
                    </a>
                    <a class="btn btn-danger" href="/action/${action.id}/delete" role="button">
                        <span class="glyphicon glyphicon-remove-circle"></span>
                        Supprimer
                    </a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<div class="container">
    <a class="btn btn-success" href="/action/create" role="button">
        <span class="glyphicon glyphicon-plus"></span>
        Ajouter
    </a>
</div>

<%@include file="../util/footer.jsp"%>
</body>