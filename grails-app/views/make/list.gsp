
<%@ page import="com.psvintagecycles.Make" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'make.label', default: 'Make')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="list-make" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'make.name.label', default: 'Name')}" />
						<g:sortableColumn property="vehicleType" title="${message(code: 'make.vehicleType.label', default: 'Vehicle Type')}" />					
					</tr>
				</thead>
				<tbody>
				<g:each in="${makeInstanceList}" status="i" var="makeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="edit" id="${makeInstance.id}">${fieldValue(bean: makeInstance, field: "name")}</g:link></td>
						<td><g:link action="edit" controller="vehicleType" id="${makeInstance?.vehicleType?.id}">${fieldValue(bean: makeInstance, field: "vehicleType")}</g:link></td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${makeInstanceTotal}" />
			</div>
		</div>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
	</body>
</html>
