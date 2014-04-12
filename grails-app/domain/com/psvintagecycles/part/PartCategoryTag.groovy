package com.psvintagecycles.part

import com.psvintagecycles.ModelYear;

class PartCategoryTag {

    static constraints = {
		part(nullable:false)
		categoryTag(nullable:false, unique:'part')
    }
	
	static mapping = {
		table 'part_category_tag'
		version true
		columns{
			id column:'id'
			part column:'part_id'
			categoryTag column:'category_tag_id'
		}
	}
	
	static belongsTo = [Part,CategoryTag]
	
	Part part
	CategoryTag categoryTag
}
