package com.psvintagecycles

import com.psvintagecycles.part.PartFileResource
import com.psvintagecycles.part.Part

class RemoteImageService {

	def grailsApplication
	
	def save(Part part, def file, boolean defaultImage = false){
		def filePath = "${grailsApplication.config.absoluteDir}/parts/${part.vehicleType}/${part.id}"
		def dir = new File(filePath)
		if(!dir.exists()){
			dir.mkdirs()
		}
		
		def partFileResource = new PartFileResource(part:part, fileName:"${part.name}.jpg", filePath:filePath, defaultImage:defaultImage)
		def image = new File("${filePath}/${part}.jpg")
		if(!image.exists()){
			image.createNewFile()
		}
		file.transferTo(image)
		partFileResource.save(flush:true)
	}
}
