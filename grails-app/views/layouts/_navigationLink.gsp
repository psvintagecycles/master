<script type="text/javascript">

function onNavLinkClick(controller, action, instanceId, parentId){
	
	$( "div[id*="+controller+"]").html('');

	$.ajax({
		url: "${request.contextPath}/" + controller + "/ajaxRenderNavSubList",
	  	data: "id="+instanceId+"&parentId="+parentId,
	  	cache: false,
	  	success: function(html) {
	        $("#"+controller+instanceId+"subList").html(html);
	  	}
	});
	
	$.ajax({
		url: "${request.contextPath}/" + controller + "/ajax" + action,
	    data: "id="+instanceId+"&parentId="+parentId,
	    cache: false,
	    success: function(html) {
	          $("#bodyContainer").html(html);
	    }
	});
};
</script>

<g:if test="${instanceMap}">

	<ul class="${cssClass }">
		<g:each in="${instanceMap}" var="item" >
			<g:each var="instance" in="${item.value}">
				<li>
					<a id="${controller+instance.id}link" href="#" onClick="onNavLinkClick('${controller}','${action}','${instance.id}','${item.key}')">${instance}</a>
				</li>
				<div id="${controller + instance.id}subList">
				</div>
			</g:each>
		</g:each>
	</ul>
</g:if>