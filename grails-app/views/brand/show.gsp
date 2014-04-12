
<%@ page import="com.psvintagecycles.Brand" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'brand.label', default: 'Brand')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-brand" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-brand" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list brand">
			
				<g:if test="${brandInstance?.createdBy}">
				<li class="fieldcontain">
					<span id="createdBy-label" class="property-label"><g:message code="brand.createdBy.label" default="Created By" /></span>
					
						<span class="property-value" aria-labelledby="createdBy-label"><g:link controller="person" action="show" id="${brandInstance?.createdBy?.id}">${brandInstance?.createdBy?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${brandInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="brand.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${brandInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${brandInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="brand.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${brandInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${brandInstance?.lastUpdatedBy}">
				<li class="fieldcontain">
					<span id="lastUpdatedBy-label" class="property-label"><g:message code="brand.lastUpdatedBy.label" default="Last Updated By" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdatedBy-label"><g:link controller="person" action="show" id="${brandInstance?.lastUpdatedBy?.id}">${brandInstance?.lastUpdatedBy?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${brandInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="brand.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${brandInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${brandInstance?.parts}">
				<li class="fieldcontain">
					<span id="parts-label" class="property-label"><g:message code="brand.parts.label" default="Parts" /></span>
					
						<g:each in="${brandInstance.parts}" var="p">
						<span class="property-value" aria-labelledby="parts-label"><g:link controller="part" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${brandInstance?.id}" />
					<g:link class="edit" action="edit" id="${brandInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
