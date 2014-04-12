<div id="page-body" role="main">
	<h1>Featured</h1>
	<div id="controller-list" role="navigation">
		<h2>Parts</h2>
		<ul>
			<g:each var="part" in="${parts}">
				<g:render template="/part/templates/part" model="['part':part]"/>
			</g:each>
		</ul>
	</div>
</div>
