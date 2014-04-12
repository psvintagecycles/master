package com.psvintagecycles

import com.psvintagecycles.part.Part;
import com.psvintagecycles.person.Person;

class Make {

    static constraints = {
		name(blank:false, nullable:false, unique:true)
    }
	
	static mapping = {
		table  'make'
		version true
		columns {
			id column: 'id'
			name column: 'name'
			dateCreated column:'date_created'
			lastUpdated column: 'last_updated'
			createdBy column: 'created_by_id'
			lastUpdatedBy column: 'last_updated_by_id'
			vehicleType column: 'vehicle_type_id'
			vehicleModels sort: 'name'
		}
		sort 'name'
	}
	
	static hasMany = [vehicleModels:VehicleModel, parts:Part]
	
	String name
	Date dateCreated
	Date lastUpdated
	Person createdBy
	Person lastUpdatedBy
	VehicleType vehicleType
	
	String toString(){
		return name
	}
}
