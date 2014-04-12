package com.psvintagecycles.part



import org.junit.*
import grails.test.mixin.*

@TestFor(CategoryTagController)
@Mock(CategoryTag)
class CategoryTagControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/categoryTag/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.categoryTagInstanceList.size() == 0
        assert model.categoryTagInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.categoryTagInstance != null
    }

    void testSave() {
        controller.save()

        assert model.categoryTagInstance != null
        assert view == '/categoryTag/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/categoryTag/show/1'
        assert controller.flash.message != null
        assert CategoryTag.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/categoryTag/list'

        populateValidParams(params)
        def categoryTag = new CategoryTag(params)

        assert categoryTag.save() != null

        params.id = categoryTag.id

        def model = controller.show()

        assert model.categoryTagInstance == categoryTag
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/categoryTag/list'

        populateValidParams(params)
        def categoryTag = new CategoryTag(params)

        assert categoryTag.save() != null

        params.id = categoryTag.id

        def model = controller.edit()

        assert model.categoryTagInstance == categoryTag
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/categoryTag/list'

        response.reset()

        populateValidParams(params)
        def categoryTag = new CategoryTag(params)

        assert categoryTag.save() != null

        // test invalid parameters in update
        params.id = categoryTag.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/categoryTag/edit"
        assert model.categoryTagInstance != null

        categoryTag.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/categoryTag/show/$categoryTag.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        categoryTag.clearErrors()

        populateValidParams(params)
        params.id = categoryTag.id
        params.version = -1
        controller.update()

        assert view == "/categoryTag/edit"
        assert model.categoryTagInstance != null
        assert model.categoryTagInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/categoryTag/list'

        response.reset()

        populateValidParams(params)
        def categoryTag = new CategoryTag(params)

        assert categoryTag.save() != null
        assert CategoryTag.count() == 1

        params.id = categoryTag.id

        controller.delete()

        assert CategoryTag.count() == 0
        assert CategoryTag.get(categoryTag.id) == null
        assert response.redirectedUrl == '/categoryTag/list'
    }
}
