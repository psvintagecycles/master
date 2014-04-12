package com.psvintagecycles.part

import org.springframework.dao.DataIntegrityViolationException
import com.psvintagecycles.part.Part;
import grails.plugin.springsecurity.annotation.Secured
import com.psvintagecycles.VehicleType
import com.psvintagecycles.Brand
import com.psvintagecycles.Make
import com.psvintagecycles.VehicleModel
import com.psvintagecycles.part.PurchaseStatus
import com.psvintagecycles.ModelYear
import com.psvintagecycles.part.CategoryTag
import com.psvintagecycles.part.PartModelYear


@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class PartController {

	def remoteImageService
	
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [partInstanceList: Part.list(params), partInstanceTotal: Part.count()]
    }

    def create() {
		def vehicleTypes = VehicleType.list()
		def brands = Brand.list()
		def purchaseStatuses = PurchaseStatus.list()
		def modelYears = ModelYear.list()
		def categoryTags = CategoryTag.list()
		
        [partInstance: new Part(params), vehicleTypes:vehicleTypes, brands:brands, 
				purchaseStatuses:purchaseStatuses, modelYears:modelYears, categoryTags:categoryTags]
    }

    def save() {
		println("Params: ${params}")
        def partInstance = new Part(params)
        if (!partInstance.save(flush: true)) {
			def vehicleTypes = VehicleType.list()
			def brands = Brand.list()
			def purchaseStatuses = PurchaseStatus.list()
			def modelYears = ModelYear.list()
			def categoryTags = CategoryTag.list()
            render(view: "create", model: [partInstance: partInstance, vehicleTypes:vehicleTypes, brands:brands, 
				purchaseStatuses:purchaseStatuses, modelYears:modelYears, categoryTags:categoryTags])
            return
        }
		
		def f = request.getFile('myFile')
		if (f.empty) {
			flash.message = 'file cannot be empty'
		}
		
		remoteImageService.save(partInstance, f)

        flash.message = message(code: 'default.created.message', args: [message(code: 'part.label', default: 'Part'), partInstance.id])
        redirect(action: "show", id: partInstance.id)
    }

    def show(Long id) {
        def partInstance = Part.get(id)
        if (!partInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'part.label', default: 'Part'), id])
            redirect(action: "list")
            return
        }

        [partInstance: partInstance]
    }

    def edit(Long id) {
        def partInstance = Part.get(id)
        if (!partInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'part.label', default: 'Part'), id])
            redirect(action: "list")
            return
        }

		def vehicleTypes = VehicleType.list()
		def brands = Brand.list()
		def makes = Make.findAllByVehicleType(partInstance.vehicleType)
		def vehicleModels = VehicleModel.findAllByMake(partInstance.make)
		def purchaseStatuses = PurchaseStatus.list()
		def modelYears = ModelYear.list()
		def categoryTags = CategoryTag.list()
        [partInstance: partInstance, vehicleTypes:vehicleTypes, 
			brands:brands, makes:makes, vehicleModels:vehicleModels,
			purchaseStatuses:purchaseStatuses, modelYears:modelYears,
			categoryTags:categoryTags]
    }

    def update(Long id, Long version) {
		println("Params: ${params}")
        def partInstance = Part.get(id)
        if (!partInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'part.label', default: 'Part'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (partInstance.version > version) {
                partInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'part.label', default: 'Part')] as Object[],
                          "Another user has updated this Part while you were editing")
                render(view: "edit", model: [partInstance: partInstance])
                return
            }
        }

        partInstance.properties = params

        if (!partInstance.save(flush: true)) {
            render(view: "edit", model: [partInstance: partInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'part.label', default: 'Part'), partInstance.id])
        redirect(action: "show", id: partInstance.id)
    }

    def delete(Long id) {
        def partInstance = Part.get(id)
        if (!partInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'part.label', default: 'Part'), id])
            redirect(action: "list")
            return
        }

        try {
            partInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'part.label', default: 'Part'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'part.label', default: 'Part'), id])
            redirect(action: "show", id: id)
        }
    }
	
	def ajaxAddModelYear(){
		
		def partInstance = Part.get(params.partId)
		def modelYear = ModelYear.get(params.modelYearId)
		
		def partModelYear = new PartModelYear(part: partInstance, modelYear: modelYear)
		if (!partModelYear.save(flush: true)){
			render(template: "templates/modelYear", model: [partInstance: partInstance])
			return
		}
		
		partInstance.refresh()
		render(template: "templates/modelYear", model: [partInstance: partInstance])	
	}
	
	def ajaxRemoveModelYear(){
		def partInstance = Part.get(params.partId)
		def modelYear = ModelYear.get(params.modelYearId)
		
		def partModelYear = PartModelYear.findByPartAndModelYear(partInstance, modelYear)
		partModelYear?.delete(flush:true)
		
		
		partInstance.refresh()
		render(template: "templates/modelYear", model: [partInstance: partInstance])
	}
	
	def ajaxAddCategoryTag(){
		
		def partInstance = Part.get(params.partId)
		def category = CategoryTag.get(params.categoryTagId)
		
		new PartCategoryTag(part:partInstance, categoryTag:category).save(flush:true)
		
		partInstance.refresh()
		render(template: "templates/categoryTag", model: [partInstance: partInstance])
	}
	
	def ajaxRemoveCategoryTag(){
		
		def partInstance = Part.get(params.partId)
		def category = CategoryTag.get(params.categoryTagId)
		
		def partCategoryTag = PartCategoryTag.findByPartAndCategoryTag(partInstance, category)
		partCategoryTag?.delete(flush:true)
		
		
		partInstance.refresh()
		render(template: "templates/categoryTag", model: [partInstance: partInstance])
		

	}
	
	def upload() {
		println("Params: ${params}")
		
		redirect(action: "edit", params:params)

	}
}
