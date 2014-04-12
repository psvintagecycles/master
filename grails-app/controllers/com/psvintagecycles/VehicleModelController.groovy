package com.psvintagecycles

import org.springframework.dao.DataIntegrityViolationException

import grails.plugin.springsecurity.annotation.Secured

import com.psvintagecycles.Make;
import com.psvintagecycles.VehicleModel;
import com.psvintagecycles.person.Person

@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class VehicleModelController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [vehicleModelInstanceList: VehicleModel.list(params), vehicleModelInstanceTotal: VehicleModel.count()]
    }

    def create() {
		def makes = Make.list()
        [vehicleModelInstance: new VehicleModel(params), makes:makes]
    }

    def save() {
        def vehicleModelInstance = new VehicleModel(params)
		def person = Person.get(1)
		vehicleModelInstance.setCreatedBy(person)
		vehicleModelInstance.setLastUpdatedBy(person)
		
        if (!vehicleModelInstance.save(flush: true)) {
			def makes = Make.list()
            render(view: "create", model: [vehicleModelInstance: vehicleModelInstance, makes:makes])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'vehicleModel.label', default: 'VehicleModel'), vehicleModelInstance.id])
        redirect(action: "edit", id: vehicleModelInstance.id)
    }

    def show(Long id) {
        def vehicleModelInstance = VehicleModel.get(id)
        if (!vehicleModelInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vehicleModel.label', default: 'VehicleModel'), id])
            redirect(action: "list")
            return
        }

        [vehicleModelInstance: vehicleModelInstance, navList:Make.list()]
    }

    def edit(Long id) {
        def vehicleModelInstance = VehicleModel.get(id)
        if (!vehicleModelInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vehicleModel.label', default: 'VehicleModel'), id])
            redirect(action: "list")
            return
        }
		def makes = Make.list()
        [vehicleModelInstance: vehicleModelInstance, makes:makes]
    }

    def update(Long id, Long version) {
        def vehicleModelInstance = VehicleModel.get(id)
        if (!vehicleModelInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vehicleModel.label', default: 'VehicleModel'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (vehicleModelInstance.version > version) {
                vehicleModelInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'vehicleModel.label', default: 'VehicleModel')] as Object[],
                          "Another user has updated this VehicleModel while you were editing")
                render(view: "edit", model: [vehicleModelInstance: vehicleModelInstance])
                return
            }
        }

        vehicleModelInstance.properties = params

        if (!vehicleModelInstance.save(flush: true)) {
            render(view: "edit", model: [vehicleModelInstance: vehicleModelInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'vehicleModel.label', default: 'VehicleModel'), vehicleModelInstance.id])
        redirect(action: "show", id: vehicleModelInstance.id)
    }

    def delete(Long id) {
        def vehicleModelInstance = VehicleModel.get(id)
        if (!vehicleModelInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vehicleModel.label', default: 'VehicleModel'), id])
            redirect(action: "list")
            return
        }

        try {
            vehicleModelInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'vehicleModel.label', default: 'VehicleModel'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'vehicleModel.label', default: 'VehicleModel'), id])
            redirect(action: "show", id: id)
        }
    }
	
	def ajaxRenderModelSelector(){
		if (params.id.equals('null')){
			render "";
			return;
		}
		
		
		def make = Make.get(params.id);
		
		if (make){
			
			def vehicleModels = VehicleModel.findAllByMake(make);
			
			render g.select(id:'vehicleModel.id', name:'vehicleModel.id', from:vehicleModels, value:params.vehicleModelId, optionKey:'id', noSelection:[null:'-Select a Model-']);
		   
			
		}else{
			render ":(";
		}
	}
	
	def ajaxRenderNavSubList(){
		def vehicleModel = VehicleModel.get(params.id)
		def modelYears = vehicleModel.modelYears();
		def instanceMap = [:]
		instanceMap.put(vehicleModel.id, modelYears)
		render(template: "/layouts/navigationLink", model: [instanceMap:instanceMap, controller:'modelYear', action:'show', cssClass:'modelYears'])
	}
	
	def ajaxshow(){
		redirect(action: "show", params: [id: params.id])
	}
}
