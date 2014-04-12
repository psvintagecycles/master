<script type="text/javascript">
  $(document).ready(function(){
    
    $("#${controller}find").click(function() {
    	alert("Coming Soon!")
    });
  });
</script>

<div id="statsNav">
	<ul>
		<li><a href="${createLink(controller:controller, action:"list")}">List</a></li>
		<li><a href="${createLink(controller:controller, action:"create")}">Create</a></li>
		<li><a id="${controller}find" href="#">Find</a></li>
	</ul>
</div>