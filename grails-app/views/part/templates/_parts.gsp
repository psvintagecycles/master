<table>
<tr>
	<td>
		<table>
			<g:each status="i" var="part" in="${parts}">
				<g:if test="${(i % 2) == 0}">
					<tr>	
						<td><g:render template="/part/templates/part" model="['part':part]"/></td>
					</tr>
				</g:if>
			</g:each>
		</table>
	</td>
	<td>
		<table>
			<g:each status="i" var="part" in="${parts}">
				<g:if test="${(i % 2) != 0}">
					<tr>	
						<td><g:render template="/part/templates/part" model="['part':part]"/></td>
					</tr>
				</g:if>
			</g:each>
			</table>
		</td>	
	</tr>					
</table>