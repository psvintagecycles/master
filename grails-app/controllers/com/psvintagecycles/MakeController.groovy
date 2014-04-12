package com.psvintagecycles

import org.springframework.dao.DataIntegrityViolationException

import grails.plugin.springsecurity.annotation.Secured

import com.psvintagecycles.Make;
import com.psvintagecycles.VehicleModel;
import com.psvintagecycles.VehicleType;
import com.psvintagecycles.person.Person

@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class MakeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
		
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		def makeList = Make.list();
        [makeInstanceList: makeList, makeInstanceTotal: Make.count(), navList:makeList]
    }

    def create() {
		def vehicleTypes = VehicleType.list()
		[makeInstance: new Make(params), vehicleTypes:vehicleTypes]
    }
 
    def save() {
        def makeInstance = new Make(params)
		def person = Person.get(1)
		makeInstance.setCreatedBy(person)
		makeInstance.setLastUpdatedBy(person)
		
        if (!makeInstance.save(flush: true)) {
            render(view: "create", model: [makeInstance: makeInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'make.label', default: 'Make'), makeInstance.id])
        redirect(action: "edit", id: makeInstance.id)
    }

    def show(Long id) {
        def makeInstance = Make.get(id)
        if (!makeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'make.label', default: 'Make'), id])
            redirect(action: "list")
            return
        }
		
		
        [makeInstance: makeInstance]
    }

    def edit(Long id) {
        def makeInstance = Make.get(id)
        if (!makeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'make.label', default: 'Make'), id])
            redirect(action: "list")
            return
        }

		def vehicleTypes = VehicleType.list()
        [makeInstance: makeInstance, vehicleTypes:vehicleTypes]
    }

    def update(Long id, Long version) {
        def makeInstance = Make.get(id)
        if (!makeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'make.label', default: 'Make'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (makeInstance.version > version) {
                makeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'make.label', default: 'Make')] as Object[],
                          "Another user has updated this Make while you were editing")
                render(view: "edit", model: [makeInstance: makeInstance])
                return
            }
        }

        makeInstance.properties = params

        if (!makeInstance.save(flush: true)) {
            render(view: "edit", model: [makeInstance: makeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'make.label', default: 'Make'), makeInstance.id])
        redirect(action: "show", id: makeInstance.id)
    }

    def delete(Long id) {
        def makeInstance = Make.get(id)
        if (!makeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'make.label', default: 'Make'), id])
            redirect(action: "list")
            return
        }

        try {
            makeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'make.label', default: 'Make'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'make.label', default: 'Make'), id])
            redirect(action: "show", id: id)
        }
    }
	
	def ajaxRenderMakeSelector(){
		if (params.id.equals('null')){
			render "";
			return;
		}
		
	
		def vehicleType = VehicleType.get(params.id);
		
		if (vehicleType){
			
			def makes = Make.findAllByVehicleType(vehicleType);
			
			render g.select(id:'make.id', name:'make.id', from:makes, value:params.makeId, optionKey:'id', noSelection:[null:'-Select a Make-']);
		   
			
		}else{
			render ":(";
		}
	}
	
	def ajaxRenderNavSubList(){
		def make = Make.get(params.id)
		def vehicleModels = VehicleModel.findAllByMake(make);
		def instanceMap = [:]
		instanceMap.putAt(make.id, vehicleModels)
		render(template: "/layouts/navigationLink", model: [instanceMap:instanceMap, controller:'vehicleModel', action:'show', cssClass:'models'])
	}
	
	def ajaxshow(){
		redirect(action: "show", params: [id: params.id])
	}
}
