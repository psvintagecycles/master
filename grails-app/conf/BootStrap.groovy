import com.psvintagecycles.*
import com.psvintagecycles.part.Part
import com.psvintagecycles.part.PartModelYear
import com.psvintagecycles.person.Person;
import com.psvintagecycles.person.PersonRole;
import com.psvintagecycles.person.Role;
import com.psvintagecycles.part.CategoryTag
import com.psvintagecycles.part.PurchaseStatus
import com.psvintagecycles.part.PartCategoryTag

class BootStrap {

    def init = { servletContext ->
		
		def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
		def userRole = new Role(authority: 'ROLE_USER').save(flush: true)
  
		def testUser = new Person(username: 'me', password: 'password')
		def testUser1 = new Person(username: 'test', password: 'test')
		testUser.save(flush: true)
		testUser1.save(flush:true)
		PersonRole.create testUser, adminRole, true
		
		PersonRole.create testUser1, adminRole, true
		PersonRole.create testUser1, userRole, true
  
		assert Person.count() == 2
		assert Role.count() == 2
		assert PersonRole.count() == 3
		
		def pStatus = new PurchaseStatus(status:"Available", code:PurchaseStatus.AVAILABLE).save(flush:true)
		def pStatus1 = new PurchaseStatus(status:"Sold", code:PurchaseStatus.SOLD).save(flush:true)
		def pStatus2 = new PurchaseStatus(status:"Ebay Only", code:PurchaseStatus.EBAY).save(flush:true)
		
		def vehicleType = new VehicleType(createdBy: testUser, dateCreated: new Date(), lastUpdated: new Date(), lastUpdatedBy: testUser, name:'Motor Cycle')
		vehicleType.save(flush:true)
		
		def vehicleType1 = new VehicleType(createdBy: testUser, dateCreated: new Date(), lastUpdated: new Date(), lastUpdatedBy: testUser, name:'Scooter')
		vehicleType1.save(flush:true)
		
		def make = new Make(createdBy: testUser, dateCreated: new Date(), lastUpdated: new Date(), lastUpdatedBy: testUser, name:'Honda', vehicleType:vehicleType)
		make.save(flush: true)
		
		def make1 = new Make(createdBy: testUser, dateCreated: new Date(), lastUpdated: new Date(), lastUpdatedBy: testUser, name:'Harley Davidson', vehicleType:vehicleType)
		make1.save(flush: true)
		
		def vehicleModel = new VehicleModel(createdBy: testUser, dateCreated: new Date(), lastUpdated: new Date(), lastUpdatedBy: testUser, name:'CRV', make: make, vehicleType: vehicleType)
		vehicleModel.save(flush:true)
		
		def vehicleModel1 = new VehicleModel(createdBy: testUser, dateCreated: new Date(), lastUpdated: new Date(), lastUpdatedBy: testUser, name:'Sportster', make: make1, vehicleType: vehicleType)
		vehicleModel1.save(flush:true)
		
		def vehicleModel2 = new VehicleModel(createdBy: testUser, dateCreated: new Date(), lastUpdated: new Date(), lastUpdatedBy: testUser, name:'Rogue', make: make, vehicleType: vehicleType)
		vehicleModel2.save(flush:true)
		
		def vehicleModel3 = new VehicleModel(createdBy: testUser, dateCreated: new Date(), lastUpdated: new Date(), lastUpdatedBy: testUser, name:'Mancycle', make: make1, vehicleType: vehicleType)
		vehicleModel3.save(flush:true)
		
		def brand = new Brand(createdBy: testUser, dateCreated: new Date(), lastUpdated: new Date(), lastUpdatedBy: testUser, name:'Nike')
		brand.save(flush:true)
		
		def brand1 = new Brand(createdBy: testUser, dateCreated: new Date(), lastUpdated: new Date(), lastUpdatedBy: testUser, name:'Adidas')
		brand1.save(flush:true)
		
		def modelYear = new ModelYear(value:2013)
		modelYear.save(flush:true)
		def modelYear1 = new ModelYear(value:2014)
		modelYear1.save(flush:true)
		def modelYear2 = new ModelYear(value:2012)
		modelYear2.save(flush:true)
		def modelYear3 = new ModelYear(value:2011)
		modelYear3.save(flush:true)
		
		def part = new Part(brand:brand, createdBy: testUser, 
			dateCreated: new Date(), lastUpdated: new Date(), 
			lastUpdatedBy: testUser, make: vehicleModel.make, vehicleModel: vehicleModel, 
			name:'Hand Grip', vehicleType: vehicleType, price: 10.02, 
			featured:true, description:"This is desc 1", purchaseStatus:pStatus)
		part.save(flush:true)
		
		def partModelYear = new PartModelYear(part:part, modelYear:modelYear)
		partModelYear.save(flush:true)
		
		def part1 = new Part(brand:brand1, createdBy: testUser,
			dateCreated: new Date(), lastUpdated: new Date(),
			lastUpdatedBy: testUser, make: vehicleModel1.make, vehicleModel: vehicleModel1,
			name:'Coolio', vehicleType: vehicleType, price: 741.02,
			featured:true, description:"This is desc 1",purchaseStatus:pStatus)
		part1.save(flush:true)
		
		def partModelYear1 = new PartModelYear(part:part1, modelYear:modelYear1)
		partModelYear1.save(flush:true)
		
		def part2 = new Part(brand:brand, createdBy: testUser,
			dateCreated: new Date(), lastUpdated: new Date(),
			lastUpdatedBy: testUser, make: vehicleModel2.make, vehicleModel: vehicleModel2,
			name:'Fift Swig', vehicleType: vehicleType, price: 10.02,
			featured:true, description:"This is desc 3",purchaseStatus:pStatus1)
		part2.save(flush:true)
		
		def partModelYear2 = new PartModelYear(part:part2, modelYear:modelYear2)
		partModelYear2.save(flush:true)
		
		def part3 = new Part(brand:brand1, createdBy: testUser,
					dateCreated: new Date(), lastUpdated: new Date(),
					lastUpdatedBy: testUser, make: vehicleModel3.make, vehicleModel: vehicleModel3,
					name:'Whatup', vehicleType: vehicleType, price: 14.02,
					featured:true, description:"This is desc 3",purchaseStatus:pStatus1)
		part3.save(flush:true)
		
		def partModelYear3 = new PartModelYear(part:part3, modelYear:modelYear3)
		partModelYear3.save(flush:true)
		
		def partModelYear4 = new PartModelYear(part:part3, modelYear:modelYear)
		partModelYear4.save(flush:true)
		
		def part4 = new Part(brand:brand1, createdBy: testUser,
			dateCreated: new Date(), lastUpdated: new Date(),
			lastUpdatedBy: testUser, make: vehicleModel3.make, vehicleModel: vehicleModel3,
			name:'sweet', vehicleType: vehicleType, price: 1770.02,
			featured:false, description:"This is desc 3",purchaseStatus:pStatus2)
		part4.save(flush:true)
		
		def partModelYear5 = new PartModelYear(part:part4, modelYear:modelYear3)
		partModelYear5.save(flush:true)
		
		def categoryTag = new CategoryTag(tag_key:'Engine',tag_value:'Carb').save(flush:true)
		def categoryTag1 = new CategoryTag(tag_key:'Body',tag_value:'Panel').save(flush:true)
		def categoryTag2 = new CategoryTag(tag_key:'Muffler',tag_value:'Exhaust').save(flush:true)
		def categoryTag3 = new CategoryTag(tag_key:'Electronics',tag_value:'Fuse').save(flush:true)
		
		new PartCategoryTag(part:part, categoryTag:categoryTag).save(flush:true)
		new PartCategoryTag(part:part2, categoryTag:categoryTag2).save(flush:true)
		new PartCategoryTag(part:part1, categoryTag:categoryTag1).save(flush:true)
		new PartCategoryTag(part:part3, categoryTag:categoryTag3).save(flush:true)
		
    }
    def destroy = {
    }
}
