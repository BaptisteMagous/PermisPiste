<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="../util/header.jsp" %>
<body>
<%@include file="../util/navigation.jsp" %>
<div class="jumbotron text-center">
    <h1>Action ${action.id}</h1><br>
    <form action="/action/${action.id}/update" method="post">
        <div class="row">
            <div class="col-md-2">
                <label for="wording">Objectif</label>
            </div>
            <div class="col-md-9">
                <input type="text" class="form-control" name="wording" id="wording" value="${action.wording}" <c:if test="${!updating}">disabled</c:if> />
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                <label for="scoreMinimum">Score minimum</label>
            </div>
            <div class="col-md-2">
                <input type="text" class="form-control" name="scoreMinimum" id="scoreMinimum" value="${action.scoreMinimum}" <c:if test="${!updating}">disabled</c:if> />
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
            <th class="col-md-6">Indicateur</th>
            <th class="col-md-1">Valeur si ok</th>
            <th class="col-md-1">Valeur si raté</th>
        </tr>

        <c:forEach items="${indicators}" var="indicator">
            <tr>
<%--                todo: form --%>
                <form method="post" action="/indicator/${indicator.id}">
                    <td>${indicator.id}</td>
                    <td><input type="text" class="form-control" name="wording" value="${indicator.wording}" <c:if test="${!updating}">disabled</c:if> /></td>
                    <td><input type="text" class="form-control" name="valueifcheck" value="${indicator.valueIfCheck}" <c:if test="${!updating}">disabled</c:if> /></td>
                    <td><input type="text" class="form-control" name="valueifuncheck" value="${indicator.valueIfUnCheck}" <c:if test="${!updating}">disabled</c:if> /></td>
                    <c:if test="${role eq \"admin\"}">
                        <td>
                            <c:if test="${updating}">
                                <input class="btn btn-warning" type="submit">
                                    <span class="glyphicon glyphicon-pencil"></span>
                                    Modifier
                                </input>
                                <a class="btn btn-danger" href="/action/${action.id}/remove/${indicator.id}" role="button">
                                    <span class="glyphicon glyphicon-ban-circle"></span>
                                    Retirer
                                </a>
                            </c:if>
                        </td>
                    </c:if>
                </form>

            </tr>
        </c:forEach>
    </table>
</div>

<div class="container">
    <c:if test="${role eq \"admin\" and updating}">
        <a class="btn btn-success" href="/mission/${action.id}/add/new" role="button">
            <span class="glyphicon glyphicon-plus"></span>
            Créer indicateur
        </a>
    </c:if>
</div>

<%@include file="../util/footer.jsp" %>
</body>