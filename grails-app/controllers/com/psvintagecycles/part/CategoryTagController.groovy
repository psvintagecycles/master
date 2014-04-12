package com.psvintagecycles.part

import org.springframework.dao.DataIntegrityViolationException
import grails.plugin.springsecurity.annotation.Secured

import com.psvintagecycles.person.Person


@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class CategoryTagController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [categoryTagInstanceList: CategoryTag.list(params), categoryTagInstanceTotal: CategoryTag.count()]
    }

    def create() {
        [categoryTagInstance: new CategoryTag(params)]
    }

    def save() {
        def categoryTagInstance = new CategoryTag(params)
		
        if (!categoryTagInstance.save(flush: true)) {
            render(view: "create", model: [categoryTagInstance: categoryTagInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'categoryTag.label', default: 'CategoryTag'), categoryTagInstance.id])
        redirect(action: "edit", id: categoryTagInstance.id)
    }

    def show(Long id) {
        def categoryTagInstance = CategoryTag.get(id)
        if (!categoryTagInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'categoryTag.label', default: 'CategoryTag'), id])
            redirect(action: "list")
            return
        }

        [categoryTagInstance: categoryTagInstance]
    }

    def edit(Long id) {
        def categoryTagInstance = CategoryTag.get(id)
        if (!categoryTagInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'categoryTag.label', default: 'CategoryTag'), id])
            redirect(action: "list")
            return
        }

        [categoryTagInstance: categoryTagInstance]
    }

    def update(Long id, Long version) {
        def categoryTagInstance = CategoryTag.get(id)
        if (!categoryTagInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'categoryTag.label', default: 'CategoryTag'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (categoryTagInstance.version > version) {
                categoryTagInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'categoryTag.label', default: 'CategoryTag')] as Object[],
                          "Another user has updated this CategoryTag while you were editing")
                render(view: "edit", model: [categoryTagInstance: categoryTagInstance])
                return
            }
        }

        categoryTagInstance.properties = params

        if (!categoryTagInstance.save(flush: true)) {
            render(view: "edit", model: [categoryTagInstance: categoryTagInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'categoryTag.label', default: 'CategoryTag'), categoryTagInstance.id])
        redirect(action: "show", id: categoryTagInstance.id)
    }

    def delete(Long id) {
        def categoryTagInstance = CategoryTag.get(id)
        if (!categoryTagInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'categoryTag.label', default: 'CategoryTag'), id])
            redirect(action: "list")
            return
        }

        try {
            categoryTagInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'categoryTag.label', default: 'CategoryTag'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'categoryTag.label', default: 'CategoryTag'), id])
            redirect(action: "show", id: id)
        }
    }
	
	def ajaxRenderNavSubList(){
		
		def instanceMap = [:]
		instanceMap.putAt(1, CategoryTag.list())
		
		render(template: "/layouts/navigationLink", model: [instanceMap:instanceMap, controller:'categoryTag', action:'show', cssClass:'models'])
		
	}
}
