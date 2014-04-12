<script type="text/javascript">
$(document).ready(function() {

    $("#categories").click(function() {
    	onNavHeadingClick('categoryTag',1)
    });

});

function onNavHeadingClick(controller, instanceId, parentId){
	
	$( "div[id*=vehicleType]").html('');
	
	$.ajax({
		url: "${request.contextPath}/" + controller + "/ajaxRenderNavSubList",
	  	data: "id="+instanceId+"&parentId="+parentId,
	  	cache: false,
	  	success: function(html) {
	        $("#"+controller+instanceId+"subList").html(html);
	  	}
	});
	
};
</script>
<h1>Navigation</h1> 
<ul>
	<li><h4><a id="featured" href="${createLink(controller:'home') }">Featured</a></h4></li>
	<g:each var="vehicleType" in="${vehicleTypes}">
		<li><a id="vt${vehicleType.id}" href="#" onClick="onNavHeadingClick('vehicleType','${vehicleType.id}')">${vehicleType }</a></li>
		<div id="vehicleType${vehicleType.id}subList"></div>
	</g:each>
	<li><h4><a id="categories" href="#">Categories</a></h4></li>
</ul>

<div id="categoryTag1subList"></div>
<%--<g:render template="/layouts/navigationLink" --%>
<%--								model="['instanceMap':instanceMap,'controller':'make', 'action':'show']"/>--%>
<%--<g:render template="/layouts/navigationLink" --%>
<%--								model="['instanceList':vehicleModel.brands(),'controller':'brand', 'action':'show', 'cssClass':'brands']"/>   --%>