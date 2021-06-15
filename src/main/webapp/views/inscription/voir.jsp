<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="../util/header.jsp" %>
<body>
<%@include file="../util/navigation.jsp" %>
<div class="jumbotron text-center">
    <h1>Inscription ${inscription.id}</h1><br>
    <h2>Mission ${inscription.fk_mission.wording}</h2><br>
    <form action="/apprenant/${inscription.fk_learner.id}" method="get">
        <div class="row">
            <div class="col-md-2">
                <label for="forname">Nom</label>
            </div>
            <div class="col-md-2">
                <input type="text" class="form-control" name="forname" id="forname" value="${inscription.fk_learner.forname}" disabled />
            </div>
            <div class="col-md-2">
                <label for="surname">Prenom</label>
            </div>
            <div class="col-md-2">
                <input type="text" class="form-control" name="surname" id="surname" value="${inscription.fk_learner.surname}" disabled />
            </div>
            <div class="col-md-1">
                <input type="submit" class="btn btn-success" value="Profil">
            </div>
        </div>
    </form>
</div>

<div class="container">
    <table class="table table-hover">
        <tr>
            <th class="col-md-1">Numéro</th>
            <th class="col-md-6">Mission réalisée</th>
            <th class="col-md-6">Score</th>
        </tr>

        <c:forEach items="${actions}" var="action">
            <tr>
                <td>${action.id}</td>
                <td>${action.fk_action.wording}</td>
                <td>${action.score}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<%@include file="../util/footer.jsp" %>
</body>