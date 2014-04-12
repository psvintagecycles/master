package com.psvintagecycles

import com.psvintagecycles.part.PartModelYear;

class ModelYear {

    static constraints = {
		value(nullable:false, min:1900, max:9999)
    }
	
	static mapping = {
		table  'model_year'
		version true
		columns {
			id column: 'id'
			value column: 'value'
		}
		sort 'value'
	}
	
	static hasMany = [partModelYears:PartModelYear]
	Integer value
	
	String toString(){
		return value
	}
	
	
}
