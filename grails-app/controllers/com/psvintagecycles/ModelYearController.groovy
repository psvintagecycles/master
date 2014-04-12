package com.psvintagecycles

import org.springframework.dao.DataIntegrityViolationException

import com.psvintagecycles.ModelYear;
import com.psvintagecycles.VehicleModel;
import com.psvintagecycles.part.Part;

import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class ModelYearController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [modelYearInstanceList: ModelYear.list(params), modelYearInstanceTotal: ModelYear.count()]
    }

    def create() {
        [modelYearInstance: new ModelYear(params)]
    }

    def save() {
        def modelYearInstance = new ModelYear(params)
        if (!modelYearInstance.save(flush: true)) {
            render(view: "create", model: [modelYearInstance: modelYearInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'modelYear.label', default: 'ModelYear'), modelYearInstance.id])
        redirect(action: "edit", id: modelYearInstance.id)
    }

    def show(Long id) {
        def modelYearInstance = ModelYear.get(id)
        if (!modelYearInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'modelYear.label', default: 'ModelYear'), id])
            redirect(action: "list")
            return
        }

        [modelYearInstance: modelYearInstance]
    }

    def edit(Long id) {
        def modelYearInstance = ModelYear.get(id)
        if (!modelYearInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'modelYear.label', default: 'ModelYear'), id])
            redirect(action: "list")
            return
        }

        [modelYearInstance: modelYearInstance]
    }

    def update(Long id, Long version) {
        def modelYearInstance = ModelYear.get(id)
        if (!modelYearInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'modelYear.label', default: 'ModelYear'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (modelYearInstance.version > version) {
                modelYearInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'modelYear.label', default: 'ModelYear')] as Object[],
                          "Another user has updated this ModelYear while you were editing")
                render(view: "edit", model: [modelYearInstance: modelYearInstance])
                return
            }
        }

        modelYearInstance.properties = params

        if (!modelYearInstance.save(flush: true)) {
            render(view: "edit", model: [modelYearInstance: modelYearInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'modelYear.label', default: 'ModelYear'), modelYearInstance.id])
        redirect(action: "show", id: modelYearInstance.id)
    }

    def delete(Long id) {
        def modelYearInstance = ModelYear.get(id)
        if (!modelYearInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'modelYear.label', default: 'ModelYear'), id])
            redirect(action: "list")
            return
        }

        try {
            modelYearInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'modelYear.label', default: 'ModelYear'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'modelYear.label', default: 'ModelYear'), id])
            redirect(action: "show", id: id)
        }
    }
	
	def ajaxRenderNavSubList(){

	}
	
	def ajaxshow(){
		def vehicleModel = VehicleModel.get(params.parentId)
		def modelYear = ModelYear.get(params.id)
		
		def partsList = Part.withCriteria {
			eq('vehicleModel',vehicleModel)
			partModelYears{
				eq('modelYear',modelYear)
			}
		}
		
		render(view: "show", model: [modelYearInstance:modelYear, partsList:partsList])
		
	}
}
