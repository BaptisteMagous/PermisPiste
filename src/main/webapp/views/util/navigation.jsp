<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="container">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/">Permis facile</a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="/"> <span class="glyphicon glyphicon-home"></span> Accueil </a></li>

                <c:if test="${sessionScope.id == null }">
                <li class="dropdown">
                    <a class="nav navbar-nav navbar-right"  href="/login">
                        <span class="glyphicon glyphicon-user"></span>
                        Se Connecter
                        <span class="caret"></span>
                    </a>
                </li>
                </c:if>

                <c:if test="${sessionScope.id > 0  }">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <span class="glyphicon glyphicon-user"></span>
                            Mon Espace
                            <span class="caret"></span>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a href="/mission/liste"><span class="glyphicon glyphicon-th-list"></span> Lister des missions</a></li>
                            <li><a href="/action/liste"><span class="glyphicon glyphicon-th-list"></span> Lister des actions</a></li>
                            <li><a href="/apprenant/liste"><span class="glyphicon glyphicon-th-list"></span> Lister des apprenants</a></li>
                        </ul>
                    </li>
                <li><a href="javascript:fermer()"><span class="glyphicon glyphicon-log-out"></span> Quitter</a></li>
                </c:if>
            </ul>
        </div>
    </nav>
</div>

<c:if test="${message != null}">
<div class="alert alert-success fade in">
    <div class="col-md-3 ">
        <c:out value="${message}" />
    </div>
</div>
</c:if>