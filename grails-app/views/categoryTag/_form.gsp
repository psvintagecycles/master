<%@ page import="com.psvintagecycles.part.CategoryTag" %>

<table>
	<psv:editTextField instance="${categoryTagInstance}" field="tagKey" required="true" value="${categoryTagInstance.tagKey }" default="Key"/>
	<psv:editTextField instance="${categoryTagInstance}" field="tagValue" required="true" value="${categoryTagInstance.tagValue }" default="Value"/>
</table>

