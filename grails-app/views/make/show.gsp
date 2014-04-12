
<%@ page import="com.psvintagecycles.Make" %>
<!DOCTYPE html>
<html>
	<head>
		<g:set var="entityName" value="${message(code: 'make.label', default: 'Make')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="show-make" class="content scaffold-show" role="main">
			<h1>${makeInstance.name }</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:render template="form" model="['makeInstance':makeInstance]"/>
		</div>
	</body>
</html>
