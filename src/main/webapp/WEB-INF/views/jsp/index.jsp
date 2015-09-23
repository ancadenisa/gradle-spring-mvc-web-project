<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>VoteOn!Line</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Sectie de votare online</a>
		</div>
	</div>
</nav>
<c:if test="${route == 'home'}">
    <div class="jumbotron">
        <div class="container">
            <h2 class="text-center">Bine ati venit!</h2>
            <br>
            <br>
            <fieldset>
                <legend>
                    <p>Pentru informatii apasati butonul "Info".</p>
                    <p>Pentru a afisa toate sectiile de votare, apasati butonul "Incepe proces votare"!</p>
                </legend>
                <div class = "row">
                    <div class = "col-md-6">
                        <!--modala-->
                        <a class="btn btn-primary btn-lg" href="/info" role="button">Info</a>
                        <a class="btn btn-primary btn-lg" href="loadAllVoteSections" role="button">Incepe proces votare</a>
                    </div>
                </div>
            <fieldset>
        </div>
    </div>
</c:if>

<c:if test="${route == 'allVoteSections'}">
    <%@ include file="votesections.jsp" %>
</c:if>

<footer>
    <p>project generated from Mkyong.com</p>
</footer>
<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>


</body>
</html>