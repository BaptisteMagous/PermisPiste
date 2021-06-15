<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="../util/header.jsp" %>
<body>
<%@include file="../util/navigation.jsp" %>
<div class="jumbotron text-center">
    <h1>Apprenant ${apprenant.id}</h1><br>
    <form action="/apprenant/${apprenant.id}/update"
            <c:if test="${role eq \"admin\" and updating}">
                method="post"
            </c:if>
            <c:if test="${role eq \"admin\" and !updating}">
                method="get"
            </c:if>
        >
        <div class="row">
            <div class="col-md-2">
                <label for="forname">Nom</label>
            </div>
            <div class="col-md-9">
                <input type="text" class="form-control" name="forname" id="forname" value="${apprenant.forname}" <c:if test="${!updating}">disabled</c:if> />
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                <label for="surname">Prenom</label>
            </div>
            <div class="col-md-9">
                <input type="text" class="form-control" name="surname" id="surname" value="${apprenant.surname}" <c:if test="${!updating}">disabled</c:if> />
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                <label for="email">Email</label>
            </div>
            <div class="col-md-9">
                <input type="text" class="form-control" name="email" id="email" value="${apprenant.email}" <c:if test="${!updating}">disabled</c:if> />
            </div>
        </div>
    </form>
</div>

<div class="container">
    <table class="table table-hover">
        <tr>
            <th class="col-md-1">Numéro</th>
            <th class="col-md-6">Mission réalisée</th>
        </tr>

        <c:forEach items="${inscriptions}" var="inscription">
            <tr>
                <td>${inscription.id}</td>
                <td>${inscription.fk_mission.wording}</td>
                <td>
                    <a class="btn btn-primary" href="/inscription/${inscription.id}" role="button">
                        <span class="glyphicon glyphicon-eye-open"></span>
                        Voir
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<%@include file="../util/footer.jsp" %>
</body>