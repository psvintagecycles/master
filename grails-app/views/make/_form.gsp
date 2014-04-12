<%@ page import="com.psvintagecycles.Make" %>

<table>
	<psv:editTextField instance="${makeInstance}" field="name" required="true" value="${makeInstance.name }"/>
	<psv:editSelect instance="${makeInstance}" field="vehicleType" required="true" value="${makeInstance.vehicleType?.id }" noSelection="['null':'-Select a Vehicle Type-']" default="Vehicle Type" instanceList="${vehicleTypes}"/>
</table>


