<%@ page import="com.psvintagecycles.part.Part" %>

<script type="text/javascript">
  $(document).ready(function(){
    
    $("#make\\.id").live("change", function() {
    	onAfterMakeChange();
    });

    $("#vehicleType\\.id").live("change", function() {
    	onAfterVehicleTypeChange();
    });
    
    function onAfterMakeChange(){
      $.ajax({
        url: "${request.contextPath}/vehicleModel/ajaxRenderModelSelector",
        data: "id=" + $("#make\\.id").val(),
        cache: false,
        success: function(html) {
              $("#modelSelectorContainer").html(html);
        }
      });
    }

    function onAfterVehicleTypeChange(){
        $.ajax({
          url: "${request.contextPath}/make/ajaxRenderMakeSelector",
          data: "id=" + $("#vehicleType\\.id").val(),
          cache: false,
          success: function(html) {
                $("#makeSelectorContainer").html(html);
          }
        });
      }

    $("#addModelYear").click(function() {
        if($("#modelYear\\.id").val() != 'null'){
        	$.ajax({
                url: "${request.contextPath}/part/ajaxAddModelYear",
                data: "modelYearId=" + $("#modelYear\\.id").val()+"&partId=${partInstance.id}",
                cache: false,
                success: function(html) {
                      $("#modelYearContainer").html(html);
                }
              });
        }
        return false
    	
    });

    $("#removeModelYear").click(function() {
        if($("#modelYear\\.id").val() != 'null'){
        	$.ajax({
                url: "${request.contextPath}/part/ajaxRemoveModelYear",
                data: "modelYearId=" + $("#modelYear\\.id").val()+"&partId=${partInstance.id}",
                cache: false,
                success: function(html) {
                      $("#modelYearContainer").html(html);
                }
              });
        }

        return false
    	
    });

    $("#removeCategoryTag").click(function() {
        if($("#categoryTag\\.id").val() != 'null'){
        	$.ajax({
                url: "${request.contextPath}/part/ajaxRemoveCategoryTag",
                data: "categoryTagId=" + $("#categoryTag\\.id").val()+"&partId=${partInstance.id}",
                cache: false,
                success: function(html) {
                      $("#categoryTagContainer").html(html);
                }
              });
        }

        return false
    	
    });

    $("#addCategoryTag").click(function() {
        if($("#categoryTag\\.id").val() != 'null'){
        	$.ajax({
            	
                url: "${request.contextPath}/part/ajaxAddCategoryTag",
                data: "categoryTagId=" + $("#categoryTag\\.id").val()+"&partId=${partInstance.id}",
                cache: false,
                success: function(html) {
                      $("#categoryTagContainer").html(html);
                }
              });
        }

        return false
    	
    });
    
  });
</script>
<table>
	<tr>
		<td>
			<div class="fieldcontain ${hasErrors(bean: partInstance, field: 'name', 'error')} required">
				<label for="name">
					<g:message code="part.name.label" default="Name" />
					<span class="required-indicator">*</span>
				</label>
			</div>
		</td>
		<td>
			<g:textField name="name" required="true" value="${partInstance?.name}" required="true"/>
		</td>
	</tr>
	<tr>
		<td>
			<div class="fieldcontain ${hasErrors(bean: partInstance, field: 'vehicleType', 'error')} required">
				<label for="vehicleType">
					<g:message code="part.vehicleType.label" default="Vehicle Type" />
					<span class="required-indicator">*</span>
				</label>
			</div>
		</td>
		<td>
			<g:select id="vehicleType.id" name="vehicleType.id" from="${vehicleTypes}" optionKey="id" required="true" value="${partInstance?.vehicleType?.id}" class="many-to-one" noSelection="['null':'-Select a Vehicle Type-']" />
		</td>
	</tr>		
	<tr>
		<td>
			<div class="fieldcontain ${hasErrors(bean: partInstance, field: 'make', 'error')}">
				<label for="make">
					<g:message code="part.make.label" default="Make" />
				</label>
			</div>
		</td>	
		<td>
			<div id="makeSelectorContainer">
				<g:if test="${partInstance.make}">
					<g:select id="make.id" name="make.id" from="${makes}" optionKey="id" value="${partInstance?.make?.id}"/>
				</g:if>
				<g:else>
					<span>please select a Vehicle Type...</span>
				</g:else>
		    	
		    </div>
		</td>
	</tr>
	<tr>
		<td>
			<div class="fieldcontain ${hasErrors(bean: partInstance, field: 'vehicleModel', 'error')}">
				<label for="vehicleModel">
					<g:message code="part.vehicleModel.label" default="Vehicle Model" />
				</label>
			</div>
		</td>
		<td>
			<div id="modelSelectorContainer">
		    	<g:if test="${partInstance.vehicleModel}">
					<g:select id="vehicleModel.id" name="vehicleModel.id" from="${vehicleModels}" optionKey="id" value="${partInstance?.vehicleModel?.id}"/>
				</g:if>
				<g:else>
					<span>please select a Make...</span>
				</g:else>
		    </div>
		</td>
	</tr>
	<tr>
		<td>
			<div class="fieldcontain ${hasErrors(bean: partInstance, field: 'brand', 'error')}">
				<label for="brand">
					<g:message code="part.brand.label" default="Brand" />
				</label>
			</div>
		</td>
		<td>
			<g:select id="brand" name="brand.id" from="${brands}" optionKey="id" required="true" value="${partInstance?.brand?.id}" noSelection="['null':'-Select a Brand-']"/>
		</td>
	</tr>	
	<tr>
		<td>
			<div class="fieldcontain ${hasErrors(bean: partInstance, field: 'price', 'error')} required">
				<label for="price">
					<g:message code="part.price.label" default="Price" />
					<span class="required-indicator">*</span>
				</label>
			</div>
		</td>
		<td>
			<g:field name="price" value="${fieldValue(bean: partInstance, field: 'price')}" required="true"/>
		</td>
	</tr>
	<tr>
		<td>
			<div class="fieldcontain ${hasErrors(bean: partInstance, field: 'description', 'error')} ">
				<label for="description">
					<g:message code="part.description.label" default="Description" />
					<span class="required-indicator">*</span>
				</label>
			</div>
		</td>
		<td>
			<g:textArea name="description" value="${partInstance?.description}" rows="5" cols="40" required="true"/>
		</td>
	</tr>	
	<tr>
		<td>
			<div class="fieldcontain ${hasErrors(bean: partInstance, field: 'featured', 'error')} ">
				<label for="featured">
					<g:message code="part.featured.label" default="Featured" />
					
				</label>
			</div>
		</td>
		<td>
			<g:checkBox name="featured" value="${partInstance?.featured}"/>
		</td>
	</tr>		

	<tr>
		<td>
			<div class="fieldcontain ${hasErrors(bean: partInstance, field: 'link', 'error')} ">
				<label for="link">
					<g:message code="part.link.label" default="Link" />
					
				</label>
			</div>
		</td>
		<td>
			<g:textField name="link" value="${partInstance?.link}"/>
		</td>
	</tr>
	<tr>
		<td>
			<div class="fieldcontain ${hasErrors(bean: partInstance, field: 'purchaseStatus', 'error')} required">
				<label for="purchaseStatus">
					<g:message code="part.purchaseStatus.label" default="Purchase Status" />
					<span class="required-indicator">*</span>
				</label>
			</div>
		</td>
		<td>
			<g:select id="purchaseStatus.id" name="purchaseStatus.id" from="${purchaseStatuses}" optionKey="id" required="true" value="${partInstance?.purchaseStatus?.id}"/>
		</td>
	</tr>
	<tr>
		<td>
			<label for="modelYear">
				<g:message code="modelYear.value.label" default="Model Year" />
			</label>
		</td>
		<td>
			<div id="modelYearContainer">
				<g:render template="templates/modelYear" model="['partInstance':partInstance]"/>
			</div>
			<g:select id="modelYear.id" name="modelYear.id" from="${modelYears}" optionKey="id" required="true" noSelection="['null':'-Select a Model Year-']"/>
			<g:if test="${partInstance?.id}">
				<a id="addModelYear" href="#">Add</a>
				<span> : </span>
				<a id="removeModelYear" href="#">Remove</a>
			</g:if>
			
		</td>
	</tr>
	<tr>
		<td>
			<label for="category">
				<g:message code="categoryTag.name.label" default="Categories" />
			</label>
		</td>
		<td>
			<div id="categoryTagContainer">
				<g:render template="templates/categoryTag" model="['partInstance':partInstance]"/>
			</div>
			<g:select id="categoryTag.id" name="categoryTag.id" from="${categoryTags}" optionKey="id" noSelection="['null':'-Select a Category-']"/>
			<g:if test="${partInstance?.id}">
				<a id="addCategoryTag" href="#">Add</a>
				<span> : </span>
				<a id="removeCategoryTag" href="#">Remove</a>
			</g:if>
		</td>
	</tr>
</table>


