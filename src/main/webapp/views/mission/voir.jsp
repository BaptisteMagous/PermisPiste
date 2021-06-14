<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="../util/header.jsp" %>
<body>
<%@include file="../util/navigation.jsp" %>

<div class="jumbotron text-center">
    <h1>Mission ${mission.id}</h1>
    <p>${mission.wording}</p>
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
                    <a class="btn btn-primary" href="action/${action.id}" role="button">
                        <span class="glyphicon glyphicon-eye-open"></span>
                        Voir
                    </a>
                    <a class="btn btn-warning" href="action/${action.id}/update" role="button">
                        <span class="glyphicon glyphicon-pencil"></span>
                        Modifier
                    </a>
                    <a class="btn btn-danger" href="mission/${mission.id}/remove/${action.id}" role="button">
                        <span class="glyphicon glyphicon-ban-circle"></span>
                        Retirer
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<div class="container">
    <a class="btn btn-success" href="mission/${mission.id}/start" role="button">
        <span class="glyphicon glyphicon-ok-circle"></span>
        Accepter
    </a>
<%--    TODO: il manque un champs de texte içi--%>
    <a class="btn btn-success disabled" href="mission/${mission.id}/add/$" role="button">
        <span class="glyphicon glyphicon-pushpin"></span>
        Ajouter existant
    </a>
    <a class="btn btn-success" href="mission/${mission.id}/add/new" role="button">
        <span class="glyphicon glyphicon-plus"></span>
        Créer
    </a>
</div>

<%@include file="../util/footer.jsp" %>
</body>