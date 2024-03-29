
<%@ page import="com.psvintagecycles.part.CategoryTag" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'categoryTag.label', default: 'CategoryTag')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="list-categoryTag" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="tagKey" title="${message(code: 'categoryTag.tagKey.label', default: 'Key')}" />
						<g:sortableColumn property="tagValue" title="${message(code: 'categoryTag.tagValue.label', default: 'Value')}" />
					</tr>
				</thead>
				<tbody>
				<g:each in="${categoryTagInstanceList}" status="i" var="categoryTagInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="edit" id="${categoryTagInstance.id}">${fieldValue(bean: categoryTagInstance, field: "tagKey")}</g:link></td>
						<td>${fieldValue(bean: categoryTagInstance, field: "tagValue")}</td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${categoryTagInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
