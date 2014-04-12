<head>
	<meta name="layout" content="main"/>
</head>
<body>
<script type="text/javascript">
$(document).ready(function() {
	showStats("partStats","PartStats");
	showStats("makeStats","MakeStats");
	showStats("modelStats","ModelStats");
	showStats("brandStats","BrandStats")
	showStats("categoryStats","CategoryStats")
	showStats("modelYearStats","ModelYearStats")

});

function showStats(divId, action){
	showSpinner(divId);
	
	$.ajax({
		url: "${request.contextPath}/home/ajax"+action,
	  	data: "",
	  	cache: false,
	  	success: function(html) {
	        $("#"+divId).html(html);
	  	}
	});
};

function showSpinner(divId){
    document.getElementById(divId).innerHTML = "<img src='${request.contextPath}/images/spinner.gif' alt='Loading' />";
};

</script>
	<div id="page-body" role="main">
		<h1>Setup</h1>
	</div>
	<h4 class="stats">Parts</h4>	
	<div id="partStats"></div>
	<h4 class="stats">Make</h4>	
	<div id="makeStats"></div>
	<h4 class="stats">Model</h4>	
	<div id="modelStats"></div>
	<h4 class="stats">Category</h4>	
	<div id="categoryStats"></div>
	<h4 class="stats">Brand</h4>	
	<div id="brandStats"></div>
	<h4 class="stats">Model Years</h4>
	<div id="modelYearStats"></div>
</body>