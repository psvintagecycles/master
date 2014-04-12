
<%@ page import="com.psvintagecycles.part.Part" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'part.label', default: 'Part')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="list-part" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="name" title="${message(code: 'part.name.label', default: 'Name')}" />
						<g:sortableColumn property="veicleType" title="${message(code: 'part.vehicleType.label', default: 'VehicleType')}" />
						<g:sortableColumn property="make" title="${message(code: 'part.make.label', default: 'Make')}" />
						<g:sortableColumn property="vehicleModel" title="${message(code: 'part.vehicleModel.label', default: 'Model')}" />
						<g:sortableColumn property="brand" title="${message(code: 'part.brand.label', default: 'Brand')}" />
						<g:sortableColumn property="featured" title="${message(code: 'part.featured.label', default: 'Featured')}" />
						<g:sortableColumn property="price" title="${message(code: 'part.price.label', default: 'Price')}" />
						<g:sortableColumn property="purchaseStatus" title="${message(code: 'part.purchaseStatus.label', default: 'Status')}" />
					</tr>
				</thead>
				<tbody>
				<g:each in="${partInstanceList}" status="i" var="partInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="edit" id="${partInstance.id}">${fieldValue(bean: partInstance, field: "name")}</g:link></td>
						<td><g:link controller="vehicleType" action="show" id="${partInstance.vehicleType?.id}">${fieldValue(bean: partInstance, field: "vehicleType")}</g:link></td>
						<td><g:link controller="make" action="show" id="${partInstance.make?.id}">${fieldValue(bean: partInstance, field: "make")}</g:link></td>
						<td><g:link controller="vehicleModel" action="show" id="${partInstance.vehicleModel?.id}">${fieldValue(bean: partInstance, field: "vehicleModel")}</g:link></td>
						<td><g:link controller="brand" action="show" id="${partInstance.brand?.id}">${fieldValue(bean: partInstance, field: "brand")}</g:link></td>
						<td><g:formatBoolean boolean="${partInstance.featured}" true="Yes" false="" /></td>
						<td><g:formatNumber number="${partInstance.price}" type="currency"/></td>
						<td><g:link controller="purchaseStatus" action="show" id="${partInstance.purchaseStatus?.id}">${fieldValue(bean: partInstance, field: "purchaseStatus")}</g:link></td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${partInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
