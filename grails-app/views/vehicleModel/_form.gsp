<%@ page import="com.psvintagecycles.VehicleModel" %>

<table>
	<psv:editTextField instance="${vehicleModelInstance}" field="name" required="true" value="${vehicleModelInstance.name }"/>
	<psv:editSelect instance="${vehicleModelInstance}" field="make" required="true" value="${vehicleModelInstance.make?.id }" noSelection="['null':'-Select a Make-']" default="Make" instanceList="${makes}"/>
</table>


