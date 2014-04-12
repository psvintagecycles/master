
<%@ page import="com.psvintagecycles.part.Part" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'part.label', default: 'Part')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="show-part" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list part">
			
				<g:if test="${partInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="part.name.label" default="Name" /></span>					
					<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${partInstance}" field="name"/></span>
				</li>
				</g:if>
			
				<g:if test="${partInstance?.make}">
				<li class="fieldcontain">
					<span id="make-label" class="property-label"><g:message code="part.make.label" default="Make" /></span>
					
						<span class="property-value" aria-labelledby="make-label"><g:link controller="make" action="show" id="${partInstance?.make?.id}">${partInstance?.make?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${partInstance?.vehicleModel}">
				<li class="fieldcontain">
					<span id="vehicleModel-label" class="property-label"><g:message code="part.vehicleModel.label" default="Vehicle Model" /></span>
					
						<span class="property-value" aria-labelledby="vehicleModel-label"><g:link controller="vehicleModel" action="show" id="${partInstance?.vehicleModel?.id}">${partInstance?.vehicleModel?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${partInstance?.vehicleType}">
				<li class="fieldcontain">
					<span id="vehicleType-label" class="property-label"><g:message code="part.vehicleType.label" default="Vehicle Type" /></span>
					
						<span class="property-value" aria-labelledby="vehicleType-label"><g:link controller="vehicleType" action="show" id="${partInstance?.vehicleType?.id}">${partInstance?.vehicleType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${partInstance?.price}">
				<li class="fieldcontain">
					<span id="price-label" class="property-label"><g:message code="part.price.label" default="Price" /></span>
					
						<span class="property-value" aria-labelledby="price-label"><g:fieldValue bean="${partInstance}" field="price"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${partInstance?.link}">
				<li class="fieldcontain">
					<span id="link-label" class="property-label"><g:message code="part.link.label" default="Link" /></span>
					
						<span class="property-value" aria-labelledby="link-label"><g:fieldValue bean="${partInstance}" field="link"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${partInstance?.brand}">
				<li class="fieldcontain">
					<span id="brand-label" class="property-label"><g:message code="part.brand.label" default="Brand" /></span>
					
						<span class="property-value" aria-labelledby="brand-label"><g:link controller="brand" action="show" id="${partInstance?.brand?.id}">${partInstance?.brand?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${partInstance?.createdBy}">
				<li class="fieldcontain">
					<span id="createdBy-label" class="property-label"><g:message code="part.createdBy.label" default="Created By" /></span>
					
						<span class="property-value" aria-labelledby="createdBy-label"><g:link controller="person" action="show" id="${partInstance?.createdBy?.id}">${partInstance?.createdBy?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${partInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="part.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${partInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${partInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="part.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${partInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${partInstance?.lastUpdatedBy}">
				<li class="fieldcontain">
					<span id="lastUpdatedBy-label" class="property-label"><g:message code="part.lastUpdatedBy.label" default="Last Updated By" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdatedBy-label"><g:link controller="person" action="show" id="${partInstance?.lastUpdatedBy?.id}">${partInstance?.lastUpdatedBy?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${partInstance?.id}" />
					<g:link class="edit" action="edit" id="${partInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
