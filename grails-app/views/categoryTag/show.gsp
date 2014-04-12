
<%@ page import="com.psvintagecycles.part.CategoryTag" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'categoryTag.label', default: 'CategoryTag')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-categoryTag" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-categoryTag" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list categoryTag">
			
				<g:if test="${categoryTagInstance?.tag_value}">
				<li class="fieldcontain">
					<span id="tag_value-label" class="property-label"><g:message code="categoryTag.tag_value.label" default="Tagvalue" /></span>
					
						<span class="property-value" aria-labelledby="tag_value-label"><g:fieldValue bean="${categoryTagInstance}" field="tag_value"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${categoryTagInstance?.partCategoryTags}">
				<li class="fieldcontain">
					<span id="partCategoryTags-label" class="property-label"><g:message code="categoryTag.partCategoryTags.label" default="Part Category Tags" /></span>
					
						<g:each in="${categoryTagInstance.partCategoryTags}" var="p">
						<span class="property-value" aria-labelledby="partCategoryTags-label"><g:link controller="partCategoryTag" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${categoryTagInstance?.tag_key}">
				<li class="fieldcontain">
					<span id="tag_key-label" class="property-label"><g:message code="categoryTag.tag_key.label" default="Tagkey" /></span>
					
						<span class="property-value" aria-labelledby="tag_key-label"><g:fieldValue bean="${categoryTagInstance}" field="tag_key"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${categoryTagInstance?.id}" />
					<g:link class="edit" action="edit" id="${categoryTagInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
