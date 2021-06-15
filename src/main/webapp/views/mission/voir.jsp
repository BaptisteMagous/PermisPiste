<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="../util/header.jsp" %>
<body>
<%@include file="../util/navigation.jsp" %>
<div class="jumbotron text-center">
    <h1>Mission ${mission.id}</h1><br>
    <form action="/mission/${mission.id}/update" method="post">
        <div class="row">
            <div class="col-md-1">
                <label for="wording">Objectif</label>
            </div>
            <div class="col-md-10">
                <input type="text" class="form-control" name="wording" id="wording" value="${mission.wording}" <c:if test="${!updating}">disabled</c:if> />
            </div>
            <c:if test="${role eq \"admin\" and updating}">
                <div class="col-md-1">
                    <input type="submit" class="btn btn-success" value="Modifier">
                </div>
            </c:if>
        </div>
    </form>
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
                <c:if test="${role eq \"admin\"}">
                    <td>
                        <a class="btn btn-primary" href="/action/${action.id}" role="button">
                            <span class="glyphicon glyphicon-eye-open"></span>
                            Voir
                        </a>
                        <c:if test="${updating}">
                            <a class="btn btn-warning" href="/action/${action.id}/update" role="button">
                                <span class="glyphicon glyphicon-pencil"></span>
                                Modifier
                            </a>
                            <a class="btn btn-danger" href="/mission/${mission.id}/remove/${action.id}" role="button">
                                <span class="glyphicon glyphicon-ban-circle"></span>
                                Retirer
                            </a>
                        </c:if>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>

<div class="container">
    <c:if test="${role eq \"admin\" and updating}">
        <div class="col-md-4">
            <input type="text" class="form-control" id="addAction" placeholder="nom d'action...">
        </div>
        <a class="btn btn-success disabled" href="/mission/${mission.id}/add/$" role="button">
            <span class="glyphicon glyphicon-pushpin"></span>
            Ajouter existant
        </a>
        <a class="btn btn-success" href="/mission/${mission.id}/add/new" role="button">
            <span class="glyphicon glyphicon-plus"></span>
            Créer
        </a>
    </c:if>

    <c:if test="${role ne \"admin\"}">
        <a class="btn btn-success" href="/mission/${mission.id}/start" role="button">
            <span class="glyphicon glyphicon-ok-circle"></span>
            Accepter
        </a>
    </c:if>
</div>

<%@include file="../util/footer.jsp" %>
</body>