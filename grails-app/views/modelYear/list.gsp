
<%@ page import="com.psvintagecycles.ModelYear" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'modelYear.label', default: 'Model Year')}" />
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
					
						<g:sortableColumn property="name" title="${message(code: 'modelYear.value.label', default: 'Year')}" />					
					</tr>
				</thead>
				<tbody>
				<g:each in="${modelYearInstanceList}" status="i" var="modelYearInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="edit" id="${modelYearInstance.id}"><g:formatNumber number="${modelYearInstance.value}" /></g:link></td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${modelYearInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
