package com.psvintagecycles

import com.psvintagecycles.part.Part
import com.psvintagecycles.person.Person
import com.psvintagecycles.part.PurchaseStatus
import com.psvintagecycles.part.CategoryTag
import com.psvintagecycles.part.PartModelYear
import com.psvintagecycles.ModelYear

import grails.plugin.springsecurity.annotation.Secured


class HomeController {

	@Secured('permitAll')
    def index() {
		def users = Person.list()
		users.each{u ->
			println("User: ${u.username}")
		}
		def vehicleTypes = VehicleType.list()
		def partsList = Part.findAllByFeatured(true)
		render(view: "index", model:[partsList: partsList, vehicleTypes:vehicleTypes])
	}
	
	@Secured('permitAll')
	def aboutUs(){
		getDefaultNavModel()
	}
	
	@Secured('permitAll')
	def contactUs(){
		getDefaultNavModel()
	}
	
	@Secured('permitAll')
	def shipping(){
		getDefaultNavModel()
	}
	
	@Secured('permitAll')
	def returns(){
		getDefaultNavModel()
	}
	
	@Secured('permitAll')
	def faq(){
		getDefaultNavModel()
	}
	
	@Secured('permitAll')
	def payment(){
		getDefaultNavModel()
	}
	
	@Secured('permitAll')
	def admin(){
		getDefaultNavModel()
	}
	
	@Secured('permitAll')
	def ajaxPartStats(){
		def partCount = Part.count();
		def ebayCount = Part.queryByPurchaseStatusCode(PurchaseStatus.EBAY)
		def availableCount = Part.queryByPurchaseStatusCode(PurchaseStatus.AVAILABLE)
		def soldCount = Part.queryByPurchaseStatusCode(PurchaseStatus.SOLD)
		def totalSales = Part.totalSales()
		
		render(template:"templates/admin/partStats", 
				model:[partCount:partCount, ebayCount:ebayCount, availableCount:availableCount, soldCount:soldCount, totalSales:totalSales])
	}
	
	@Secured('permitAll')
	def ajaxMakeStats(){
		def makeCount = Make.count()
		def modelCount = Make.withCriteria{
			projections{
				countDistinct "vehicleModels"
			}
		}
		
		def partCount = Part.where{make != null}?.count()
		
		render(template:"templates/admin/makeStats", model:[makeCount:makeCount, modelCount:modelCount, partCount:partCount])
	}
	
	@Secured('permitAll')
	def ajaxModelStats(){
		def modelCount = VehicleModel.count()
		
		def partCount = Part.where{vehicleModel != null}?.count()
		
		render(template:"templates/admin/modelStats", model:[modelCount:modelCount, partCount:partCount])
	}
	
	@Secured('permitAll')
	def ajaxBrandStats(){
		def brandCount = Brand.count()
		
		def partCount = Part.where{brand != null}?.count()
		
		render(template:"templates/admin/brandStats", model:[brandCount:brandCount, partCount:partCount])
	}
	
	@Secured('permitAll')
	def ajaxCategoryStats(){
		def categoryCount = CategoryTag.count()
		
		def partCount = CategoryTag.withCriteria{
			partCategoryTags{
				projections{
					countDistinct "part"
				}
			}
		}
		
		render(template:"templates/admin/categoryStats", model:[categoryCount:categoryCount, partCount:partCount])
	}
	
	@Secured('permitAll')
	def ajaxModelYearStats(){
		def modelYearCount = ModelYear.count()
		def partCount = PartModelYear.count()
		
		render(template:"templates/admin/modelYearStats", model:[modelYearCount:modelYearCount, partCount:partCount])
	}
	
	
	private def getDefaultNavModel(){
		def makeList = Make.list()
		def instanceMap = [:]
		instanceMap.put(null, makeList)
		return [instanceMap:instanceMap]
	}
	
	
	
}