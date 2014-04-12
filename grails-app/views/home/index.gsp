<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
	</head>
	<body>
		<div id="page-body" role="main">
			<h1>Featured</h1>
			<div id="controller-list" role="navigation">
				<g:render template="/part/templates/parts" model="['parts':partsList]"/>
			</div>
		</div>	
	</body>
</html>