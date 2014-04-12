package com.psvintagecycles.part

class PartFileResource {

    static constraints = {
		fileName(blank:false, nullable:false)
		filePath(blank:false, nullable:false)
		part(nullable:false)
		defaultImage(nullable:false)
    }
	
	static mapping = {
		table 'part_file_resource'
		version true
		columns{
			id column:'id'
			fileName column:'file_name'
			filePath column:'file_path'
			part column:'part_id'
			defaultImage column: 'default_image'
		}
	}
	
	static belongsTo = Part
	
	String fileName
	String filePath
	Part part
	boolean defaultImage = false
	
}
