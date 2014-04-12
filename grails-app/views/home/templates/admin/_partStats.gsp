<div id="baseStats">
	<ul>
		<li>Total: ${partCount}</li>
		<li>Ebay: ${ebayCount }</li>
		<li>Available: ${availableCount }</li>
		<li>Sold: ${soldCount}</li>		
		<li>Sales Total: ${totalSales}</li>
	</ul>
</div>
<g:render template="templates/admin/basicStats" model="['controller':'part']"/>