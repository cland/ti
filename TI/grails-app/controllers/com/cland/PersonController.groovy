package com.cland


import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.transaction.Transactional

/**
 * PersonController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 * 
 * http://omarello.com/2010/08/grails-one-to-many-dynamic-forms/
 */
@Transactional(readOnly = true)
class PersonController {
	def autoCompleteService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		params.sort = 'firstName'
        respond Person.list(params), model:[personInstanceCount: Person.count()]
    }

	def list(Integer max) {		
        params.max = Math.min(max ?: 10, 100)
		params.sort = 'firstName'
       respond Person.list(params), model:[personInstanceCount: Person.count()]
    }

    def show(Person personInstance) {
		println ("Phone size: " + personInstance?.phones?.size())
        respond personInstance
    }

    def create() {
        respond new Person(params)
    }

    @Transactional
    def save(Person personInstance) {

        if (personInstance == null) {
            notFound()
            return
        }

        if (personInstance.hasErrors()) {
            respond personInstance.errors, view:'create'
            return
        }
		
		//personInstance.phones.clear()
		int index = 0
		int cnt = 0
		def pEntry = params.get('phones[' + index + ']')
		while(pEntry != null){
			println(pEntry)
			Phone p = new Phone(pEntry)
			if(pEntry?.deleted=='false'){
				p?.index = cnt
				personInstance?.addToPhones(p)
				cnt++
			}
			//next p
			index++
			pEntry = params.get('phones[' + index + ']')
		}
//		def _toBeRemoved = personInstance.phones.findAll {!it}
//		
//		// if there are phones to be removed
//		if (_toBeRemoved) {
//			personInstance.phones.removeAll(_toBeRemoved)
//		 }
//		
//		//update my indexes
//		personInstance.phones.eachWithIndex(){phn, i ->
//			if(phn)	phn.index = i
//		}
		
        personInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'personInstance.label', default: 'Person'), personInstance.id])
                redirect personInstance
            }
            '*' { respond personInstance, [status: CREATED] }
        }
    }

    def edit(Person personInstance) {
        respond personInstance
    }

    @Transactional
    def update(Person personInstance) {	
		
		personInstance.phones.clear()		
		int index = 0
		int cnt = 0
		def pEntry = params.get('phones[' + index + ']')
		while(pEntry != null){
			println(pEntry)
			Phone p = new Phone(pEntry)
			if(pEntry?.deleted=='false'){
				p?.index = cnt
				personInstance?.addToPhones(p)
				cnt++
			}
			//next p
			index++
			pEntry = params.get('phones[' + index + ']')			
		}
		
        if (personInstance == null) {
            notFound()
            return
        }

        if (personInstance.hasErrors()) {
            respond personInstance.errors, view:'edit'
            return
        }
		
		
//		bindData(personInstance, params, [exclude: 'dateOfBirth'])
//		bindData(personInstance, ['dateOfBirth': params.date('dateOfBirth', ['yyyy-MM-dd'])], [include: 'dateOfBirth'])
		
		
		
        personInstance.save flush:true
		
        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Person.label', default: 'Person'), personInstance.id])
                redirect personInstance
            }
            '*'{ respond personInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Person personInstance) {

        if (personInstance == null) {
            notFound()
            return
        }

        personInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Person.label', default: 'Person'), personInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'personInstance.label', default: 'Person'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
	def personlist = {
		Person person = Person.get(1)
		if(person){
		}
		render autoCompleteService.personList(params) as JSON
		}
		def getAllPeople(){
		def data = Person.list()
		def response = []
		data.each{
		response << "${it.toAutoCompleteMap()}"
		}
		render data as JSON
		}
}
