<%@ page import="com.psvintagecycles.VehicleType" %>



<div class="fieldcontain ${hasErrors(bean: vehicleTypeInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="vehicleType.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="50" required="" value="${vehicleTypeInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vehicleTypeInstance, field: 'createdBy', 'error')} required">
	<label for="createdBy">
		<g:message code="vehicleType.createdBy.label" default="Created By" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="createdBy" name="createdBy.id" from="${com.philsparts.Person.list()}" optionKey="id" required="" value="${vehicleTypeInstance?.createdBy?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vehicleTypeInstance, field: 'lastUpdatedBy', 'error')} required">
	<label for="lastUpdatedBy">
		<g:message code="vehicleType.lastUpdatedBy.label" default="Last Updated By" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="lastUpdatedBy" name="lastUpdatedBy.id" from="${com.philsparts.Person.list()}" optionKey="id" required="" value="${vehicleTypeInstance?.lastUpdatedBy?.id}" class="many-to-one"/>
</div>

