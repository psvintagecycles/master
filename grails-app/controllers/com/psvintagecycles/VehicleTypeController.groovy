package com.psvintagecycles

import org.springframework.dao.DataIntegrityViolationException

import com.psvintagecycles.VehicleType;

import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class VehicleTypeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [vehicleTypeInstanceList: VehicleType.list(params), vehicleTypeInstanceTotal: VehicleType.count()]
    }

    def create() {
        [vehicleTypeInstance: new VehicleType(params)]
    }

    def save() {
        def vehicleTypeInstance = new VehicleType(params)
        if (!vehicleTypeInstance.save(flush: true)) {
            render(view: "create", model: [vehicleTypeInstance: vehicleTypeInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'vehicleType.label', default: 'VehicleType'), vehicleTypeInstance.id])
        redirect(action: "show", id: vehicleTypeInstance.id)
    }

    def show(Long id) {
        def vehicleTypeInstance = VehicleType.get(id)
        if (!vehicleTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vehicleType.label', default: 'VehicleType'), id])
            redirect(action: "list")
            return
        }

        [vehicleTypeInstance: vehicleTypeInstance]
    }

    def edit(Long id) {
        def vehicleTypeInstance = VehicleType.get(id)
        if (!vehicleTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vehicleType.label', default: 'VehicleType'), id])
            redirect(action: "list")
            return
        }

        [vehicleTypeInstance: vehicleTypeInstance]
    }

    def update(Long id, Long version) {
        def vehicleTypeInstance = VehicleType.get(id)
        if (!vehicleTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vehicleType.label', default: 'VehicleType'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (vehicleTypeInstance.version > version) {
                vehicleTypeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'vehicleType.label', default: 'VehicleType')] as Object[],
                          "Another user has updated this VehicleType while you were editing")
                render(view: "edit", model: [vehicleTypeInstance: vehicleTypeInstance])
                return
            }
        }

        vehicleTypeInstance.properties = params

        if (!vehicleTypeInstance.save(flush: true)) {
            render(view: "edit", model: [vehicleTypeInstance: vehicleTypeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'vehicleType.label', default: 'VehicleType'), vehicleTypeInstance.id])
        redirect(action: "show", id: vehicleTypeInstance.id)
    }

    def delete(Long id) {
        def vehicleTypeInstance = VehicleType.get(id)
        if (!vehicleTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vehicleType.label', default: 'VehicleType'), id])
            redirect(action: "list")
            return
        }

        try {
            vehicleTypeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'vehicleType.label', default: 'VehicleType'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'vehicleType.label', default: 'VehicleType'), id])
            redirect(action: "show", id: id)
        }
    }
	
	def ajaxRenderNavSubList(){
		def vehicleType = VehicleType.get(params.id)
		def makes = Make.findAllByVehicleType(vehicleType)
		def instanceMap = [:]
		instanceMap.putAt(vehicleType, makes)
		
		render(template: "/layouts/navigationLink", model: [instanceMap:instanceMap, controller:'make', action:'show', cssClass:'models'])
		
	}
}
