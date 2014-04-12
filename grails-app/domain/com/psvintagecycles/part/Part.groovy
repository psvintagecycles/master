package com.psvintagecycles.part

import com.psvintagecycles.Brand;
import com.psvintagecycles.Make;
import com.psvintagecycles.VehicleModel;
import com.psvintagecycles.VehicleType;
import com.psvintagecycles.person.Person;

class Part {

    static constraints = {
		name(blank:false, nullable:false)
		make(nullable:true)
		description(blank:false, nullable:false)
		vehicleModel(nullable:true)
		vehicleType(nullable:false)
		price(nullable:false, min: 0d)
		link(blank:true, nullable:true)
		featured(nullable:false)
		purchaseStatus(nullable:false)
		brand(nullable:true)
		createdBy(nullable:true)
		lastUpdatedBy(nullable:true)
    }
	
	static mapping = {
		table 'part'
		version true
		columns{
			id column:'id'
			name column: 'name'
			description column:'description'
			make column: 'make_id'
			vehicleModel column: 'vehicle_model_id'
			vehicleType column:'vehicle_type_id'
			price column:'price'
			dateCreated column:'date_created'
			createdBy column:'created_by_id'
			lastUpdated column: 'last_updated'
			lastUpdatedBy column:'last_updated_by_id'
			link column: 'link'
			featured column: 'featured'
			purchaseStatus column:'purchase_status_id'
		}
		
		fileResources cascade:'all-delete-orphan'
		partModelYears cascade:'all-delete-orphan'
		partCategoryTags cascade:'all-delete-orphan'
		
	}
	
	static hasMany = [fileResources:PartFileResource, partModelYears:PartModelYear, partCategoryTags:PartCategoryTag]
	
	String name
	String description
	Make make
	VehicleModel vehicleModel
	VehicleType vehicleType
	Brand brand
	Double price
	Date dateCreated
	Date lastUpdated
	Person createdBy
	Person lastUpdatedBy
	String link
	boolean featured = false
	PurchaseStatus purchaseStatus
	
	String toString(){
		return name;
	}
	
	static def queryByPurchaseStatusCode(String purchaseStatusCode){
		return Part.executeQuery(
			"""SELECT
            DISTINCT 
                count(p)
            FROM
                Part p
                join 
				p.purchaseStatus ps
            WHERE
                ps.code= :purchaseStatusCode
            """,[purchaseStatusCode:purchaseStatusCode]
			)
	}
	
	static def totalSales(){
		return 50.00
	}
		
}
