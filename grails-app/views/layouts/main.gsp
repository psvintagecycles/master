
	
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><g:layoutTitle default="PS Vintage Cycles"/></title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon"/>
	<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'style.css')}" />
	<g:javascript library="jquery" plugin="jquery"/>
	<g:javascript src="jquery/jquery-1.11.0.min.js" />
	<g:javascript src="jquery/colorbox/jquery.colorbox-min.js" />
	
	<link rel="stylesheet" type="text/css" href="${resource(dir: 'js/jquery/colorbox/', file: 'colorbox.css')}" />
<%--	<g:javascript src="navigation.js"/>--%>
	<g:layoutHead/>
	<r:layoutResources />
</head>

<body>
<div style="width:900px; margin:0 auto;">
<table width="900" border="0" align="center" cellpadding="0" cellspacing="1">
  <tr>
    <td rowspan="2"><a href="${createLink(uri: '/')}">
	<img src="${resource(dir: 'images', file: 'logo3.png')}" alt="Logo" width="280" height="70" border="0" /></a></td>
    <td align="right"><a href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></td>
    <td align="right"><a href="${createLink(uri: '/admin') }">Admin</a></td>
  </tr>
  <tr>
    <td align="right" colspan="2"><script language="JavaScript" type="text/JavaScript">
<!-- Begin
d = new Array(
"Sunday",
"Monday",
"Tuesday",
"Wednesday",
"Thursday",
"Friday",
"Saturday"
);
m = new Array(
"January",
"February",
"March",
"April",
"May",
"June",
"July",
"August",
"September",
"October",
"November",
"December"
);

today = new Date();
day = today.getDate();
year = today.getYear();

if (year < 2000)    
year = year + 1900; 

end = "th";
if (day==1 || day==21 || day==31) end="st";
if (day==2 || day==22) end="nd";
if (day==3 || day==23) end="rd";
day+=end;

document.write(" ");
document.write(d[today.getDay()]+" "+m[today.getMonth()]+" ");
document.write(day+" " + year);
document.write(" ");
// End -->
</script></td>
  </tr>
  <tr>
    <td colspan="3" class="searchtd">
	<g:render template="/layouts/navMenu" />
	</td>
  </tr>
</table>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="4">
  <tr>
    <td colspan="5" class="gray">
	<img src="${resource(dir: 'images', file: 'clearpixel.gif')}" width="1" height="1" alt="" /></td>
  </tr>
  <tr>
    <td class="gray" width="1" height="400">
	<img src="${resource(dir: 'images', file: 'clearpixel.gif')}" width="1" height="1" alt="" /></td>
     <td width="140" valign="top" class="leftSide">
     <div style="height: 350px;">
     	<g:render template="/layouts/navigation"/>
     </div>
     
	 <g:render template="/layouts/companyNews"/>
	 </td>
	 <td class="gray" width="1">
	<img src="${resource(dir: 'images', file: 'clearpixel.gif')}" width="1" height="1" alt="" /></td>
    <td width="757" valign="top"><!-- #BeginEditable "body" -->
    	<div id="bodyContainer">
    		<g:layoutBody/>
    	</div>        
        
        <!-- #EndEditable --></td>
    <td class="gray" width="1">
	<img src="${resource(dir: 'images', file: 'clearpixel.gif')}" width="1" height="1" alt="" /></td>
  </tr>
  <tr>
   <td colspan="5" class="gray">
	<img src="${resource(dir: 'images', file: 'clearpixel.gif')}" width="1" height="1" alt="" /></td>
  </tr>
</table>
<g:render template="/layouts/footer" />
</div>

</body>
</html>
