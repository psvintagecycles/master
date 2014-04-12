package com.psvintagecycles

import com.psvintagecycles.part.Part;
import com.psvintagecycles.person.Person;

class VehicleModel {

    static constraints = {
		name(blank:false, nullable:false, unique:true)
    }
	
	static mapping = {
		table 'model'
		version true
		columns{
			id column:'id'
			name column:'name'
			dateCreated column:'date_created'
			lastUpdated column:'last_updated'
			createdBy column:'created_by_id'
			lastUpdatedBy column:'last_updatde_by_id'
		}
	}
	
	static belongsTo = [make:Make]
	static hasMany = [parts:Part]
	
	
	String name
	Date dateCreated
	Date lastUpdated
	Person createdBy
	Person lastUpdatedBy
	
	String toString(){
		return name
	}
	
	def brands(){
		return Brand.createCriteria().listDistinct() {
			parts{
				eq("vehicleModel",this)
			}
			cache:true
        }
	}
	
	def modelYears(){
		def modelYears = []
		this.parts.each{ p ->
			p.partModelYears.each{ pm ->
				
				if(!modelYears.contains(pm.modelYear)){
					modelYears.add(pm.modelYear)
				}
			}
			
		}
		
		return modelYears
	}
}
