
<%@ page import="com.psvintagecycles.VehicleModel" %>
<!DOCTYPE html>
<html>
	<head>
		<g:set var="entityName" value="${message(code: 'vehicleModel.label', default: 'VehicleModel')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="show-vehicleModel" class="content scaffold-show" role="main">
			<h1>${vehicleModelInstance.name}</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:render template="/part/templates/parts" model="['parts':vehicleModelInstance.parts]"/>
		</div>
	</body>
</html>
