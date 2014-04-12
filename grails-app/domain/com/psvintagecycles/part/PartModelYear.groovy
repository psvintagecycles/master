package com.psvintagecycles.part

import com.psvintagecycles.ModelYear;

class PartModelYear {

    static constraints = {
		part(nullable:false)
		modelYear(nullable:false, unique:'part')
    }
	
	static mapping = {
		table 'part_model_year'
		version true
		columns{
			id column:'id'
			part column:'part_id'
			modelYear column:'model_year_id'
		}
		
		modelYear sort: 'value'
	}
	
	static belongsTo = Part
	Part part
	ModelYear modelYear

}
