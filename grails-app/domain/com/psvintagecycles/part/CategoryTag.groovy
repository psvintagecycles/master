package com.psvintagecycles.part

class CategoryTag {

    static constraints = {
		tagKey(nullable:false)
		tagValue(nullable:false, blank:false, unique:'tagKey')
    }
	
	static mapping ={
		table 'category_tag'
		version true
		columns{
			id column:'id'
			tagKey column:'tag_key'
			tagValue column:'tag_value'
		}
		
		partCategoryTags cascade:'all-delete-orphan'
	}
	
	static hasMany = [partCategoryTags:PartCategoryTag]
	
	String tagKey
	String tagValue
	
	String toString(){
		return tagKey + ":" + tagValue
	}
}
