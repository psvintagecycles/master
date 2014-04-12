package com.psvintagecycles

import com.psvintagecycles.person.Person;

class VehicleType {

    static constraints = {
        name(blank:false, nullable:false, unique:true, size:1..50)

    }
	
    static mapping ={
        table 'vehicle_type'
        version true
        columns {
            id column : 'id'
            name column : 'name'
            createdBy column : 'created_by_id'
            dateCreated column : 'date_created'
			lastUpdatedBy column: 'last_updated_by_id'
			lastUpdated column:'last_updated'
            
        }

    }
	
	String name
	Date dateCreated
	Date lastUpdated	
	Person createdBy
	Person lastUpdatedBy
	
	String toString(){
		return name
	}

}
