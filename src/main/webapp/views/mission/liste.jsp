<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="../util/header.jsp" %>
<body>
<%@include file="../util/navigation.jsp" %>

<div class="jumbotron text-center">
    <h1>Liste des missions</h1>
</div>

<div class="container">
    <table class="table table-hover">
        <tr>
            <th class="col-md-1">Numéro</th>
            <th class="col-md-7">Objectif</th>
            <th class="col-md-4"></th>
        </tr>

        <c:forEach items="${missions}" var="mission">
            <tr>
                <td>${mission.id}</td>
                <td>${mission.wording}</td>
                <td>
                    <a class="btn btn-primary" href="/mission/${mission.id}" role="button">
                        <span class="glyphicon glyphicon-eye-open"></span>
                        Voir
                    </a>
                    <c:if test="${role eq \"admin\"}">
                    <a class="btn btn-warning" href="/mission/${mission.id}/update" role="button">
                        <span class="glyphicon glyphicon-pencil"></span>
                        Modifier
                    </a>
                    <a class="btn btn-danger" href="/mission/${mission.id}/delete" role="button">
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
    <a class="btn btn-success" href="/mission/create" role="button">
        <span class="glyphicon glyphicon-plus"></span>
        Ajouter
    </a>
</div>

<%@include file="../util/footer.jsp" %>
</body>