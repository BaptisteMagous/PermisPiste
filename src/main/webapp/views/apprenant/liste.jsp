<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="../util/header.jsp" %>
<body>
<%@include file="../util/navigation.jsp"%>

<div class="jumbotron text-center">
    <h1>Liste des apprenants</h1>
</div>

<div class="container">
    <table class="table table-hover">
        <tr>
            <th class="col-md-1">Numéro</th>
            <th class="col-md-2">Nom</th>
            <th class="col-md-2">Prénom</th>
            <th class="col-md-2">Email</th>
            <th class="cod-md-1">Admin</th>
            <th class="col-md-4"></th>
        </tr>

        <c:forEach items="${apprenants}" var="apprenant">
            <tr>
                <td>${apprenant.id}</td>
                <td>${apprenant.surname}</td>
                <td>${apprenant.forname}</td>
                <td>${apprenant.email}</td>
                <td>
                    <c:if test="${apprenant.role == \"admin\"}">
                        <span class="glyphicon glyphicon-ok">
                    </c:if>
                    <c:if test="${apprenant.role != \"admin\"}">
                        <span class="glyphicon glyphicon-remove">
                    </c:if>
                </td>
                <td>
                    <a class="btn btn-primary" href="/apprenant/${apprenant.id}" role="button">
                        <span class="glyphicon glyphicon-eye-open"></span>
                        Voir
                    </a>
                    <a class="btn btn-warning" href="/apprenant/${apprenant.id}/update" role="button">
                        <span class="glyphicon glyphicon-pencil"></span>
                        Modifier
                    </a>
                    <a class="btn btn-danger" href="/apprenant/${apprenant.id}/delete" role="button">
                        <span class="glyphicon glyphicon-remove-circle"></span>
                        Supprimer
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<div class="container">
    <a class="btn btn-success" href="/apprenant/new" role="button">
        <span class="glyphicon glyphicon-plus"></span>
        Ajouter
    </a>
</div>

<%@include file="../util/footer.jsp"%>
</body>