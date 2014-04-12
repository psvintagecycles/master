
<%@ page import="com.psvintagecycles.VehicleModel" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'vehicleModel.label', default: 'VehicleModel')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="list-vehicleModel" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="name" title="${message(code: 'vehicleModel.name.label', default: 'Name')}" />				
						<th><g:message code="vehicleModel.make.label" default="Make" /></th>
					</tr>
				</thead>
				<tbody>
				<g:each in="${vehicleModelInstanceList}" status="i" var="vehicleModelInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="edit" id="${vehicleModelInstance.id}">${fieldValue(bean: vehicleModelInstance, field: "name")}</g:link></td>
						<td><g:link action="edit" id="${vehicleModelInstance.make?.id}">${fieldValue(bean: vehicleModelInstance, field: "make")}</g:link></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${vehicleModelInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
