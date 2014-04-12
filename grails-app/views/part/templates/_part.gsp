<script>
$(document).ready(function() {

    $("#part${part.id}").click(function() {

    	alert('hi')

    });

});
</script>

<table id="part${part.id}" class="gray">
	<tr>
	  <td width="110" valign="top"><img src="${resource(dir: 'images', file: 'prod1.jpg')}" alt="chair" width="100" height="127" /></td>
	  <td valign="top">
	  	<h2>${part.name}</h2>
	 	<strong>Make: 	${part.make}</strong><br/>
	 	<strong>Model: 	${part.vehicleModel}</strong><br/>
	 	<strong>Brand:	${part.brand}</strong><br/>
	 	<strong><g:render template="/part/templates/categoryTag" model="['partInstance':part]"/></strong>
	 	<strong><g:render template="/part/templates/modelYear" model="['partInstance':part]"/></strong>
	    <span>${part.description}</span><br/>
	    <strong>Price: ${part.price}</strong>
	</tr>
</table>

