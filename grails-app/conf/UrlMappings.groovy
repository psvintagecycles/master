class UrlMappings {

	static mappings = {
		

		"/admin"(controller:"home", action:"admin")
		"/part/show/$id"(controller:"part", action:"edit")
		"/make/show/$id"(controller:"make", action:"edit")
		"/vehicleType/show/$id"(controller:"vehicleType", action:"edit")
		"/vehicleModel/show/$id"(controller:"vehicleModel", action:"edit")
		"/categoryTag/show/$id"(controller:"categoryTag", action:"edit")
		"/brand/show/$id"(controller:"brand", action:"edit")
		"/modelYear/show/$id"(controller:"modelYear", action:"edit")
		"/"{
			controller = "home"
		}
		"500"(view:'/error')
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		
	}
}
