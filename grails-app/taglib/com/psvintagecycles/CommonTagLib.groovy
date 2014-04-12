package com.psvintagecycles

class CommonTagLib {
	
	static namespace = "psv"
	
	def editTextField = {attrs, body ->
		
	def instance 	= attrs['instance']
	def field		= attrs['field']
	def required	= attrs['required']
	def value 		= attrs['value']
	def defaultField = attrs['default']
	
	required = required ? required : "false"
	defaultField = defaultField ? defaultField : field[0].toUpperCase() + field.substring(1)
	
	def code = instance.class.simpleName[0].toLowerCase() + instance.class.simpleName.substring(1)
	def errors = hasErrors('bean': attrs.bean, field: field, 'errors') 
	def label = g.message(code:code, default:defaultField)
	def requiredSpan = required.equals("true") ? "<span class='required-indicator'>*</span>" : ""
	def textField = g.textField(name:field, required:required, value:value)
	
	def returnValue =	"""<tr>
					<td>
						<div class="fieldcontain ${errors} required">
							<label for="${field}">
								${label}
								${requiredSpan}
							</label>
						</div>
					</td>
					<td>
						${textField}
					</td>
				</tr>"""
	
	out << returnValue
		
	}
	
	def editSelect = {attrs, body ->
		
	def instance 	= attrs['instance']
	def field		= attrs['field']
	def required	= attrs['required']
	def value 		= attrs['value']
	def instanceList	= attrs['instanceList']
	def defaultField = attrs['default']
	def noSelection = attrs['noSelection']
	
	noSelection = noSelection ? noSelection : "['null':'-Select One-']"
	required = required ? required : "false"
	
	defaultField = defaultField ? defaultField : field[0].toUpperCase() + field.substring(1)
	def code = instance.class.simpleName[0].toLowerCase() + instance.class.simpleName.substring(1)
	def errors = hasErrors('bean': attrs.bean, field: field, 'errors')
	def label = g.message(code:code, default:defaultField)
	def requiredSpan = required.equals("true") ? "<span class='required-indicator'>*</span>" : ""
	def selectName = instance.class.simpleName[0].toLowerCase() + instance.class.simpleName.substring(1)
	def select = g.select(id:selectName, name:"${field}.id", from:instanceList, optionKey:"id", required:required, value:value, noSelection:noSelection)

	def returnValue =	"""<tr>
					<td>
						<div class="fieldcontain ${errors} required">
							<label for="name">
								${label}
								${requiredSpan}
							</label>
						</div>
					</td>
					<td>
						${select}
					</td>
				</tr>"""
	
	out << returnValue
		
	}

}
