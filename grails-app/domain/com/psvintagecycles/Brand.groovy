package com.psvintagecycles

import com.psvintagecycles.part.Part;
import com.psvintagecycles.person.Person;

class Brand {

    static constraints = {
    }
	
	static mapping ={
		table 'brand'
		version true
		columns{
			id column:'id'
			name column:'name'
			dateCreated column:'date_created'
			createdBy column:'created_by_id'
			lastUpdated column:'last_updated'
			lastUpdatedBy column:'last_updated_by_id'
		}
	}
	
	static hasMany = [parts:Part]
	
	String name
	Date dateCreated
	Person createdBy
	Date lastUpdated
	Person lastUpdatedBy
	
	String toString(){
		return name
	}
}
