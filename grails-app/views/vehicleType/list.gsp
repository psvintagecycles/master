
<%@ page import="com.psvintagecycles.VehicleType" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'vehicleType.label', default: 'VehicleType')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-vehicleType" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-vehicleType" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'vehicleType.name.label', default: 'Name')}" />
					
						<th><g:message code="vehicleType.createdBy.label" default="Created By" /></th>
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'vehicleType.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'vehicleType.lastUpdated.label', default: 'Last Updated')}" />
					
						<th><g:message code="vehicleType.lastUpdatedBy.label" default="Last Updated By" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${vehicleTypeInstanceList}" status="i" var="vehicleTypeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${vehicleTypeInstance.id}">${fieldValue(bean: vehicleTypeInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: vehicleTypeInstance, field: "createdBy")}</td>
					
						<td><g:formatDate date="${vehicleTypeInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${vehicleTypeInstance.lastUpdated}" /></td>
					
						<td>${fieldValue(bean: vehicleTypeInstance, field: "lastUpdatedBy")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${vehicleTypeInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
