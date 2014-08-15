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
		println(params)
        if (personInstance == null) {
            notFound()
            return
        }

        if (personInstance.hasErrors()) {
            respond personInstance.errors, view:'create'
            return
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
		println ("Phone size: " + personInstance?.phones?.size() + " - " + personInstance?.phones)
        respond personInstance
    }

    @Transactional
    def update(Person personInstance) {
		println(params)
		for(itm in params.list("phones")){
			println itm
		}
				
//		Person newPerson = new Person(params)
//		newPerson.firstName="AAChanged1"
//		newPerson.lastName="AAGainyMe1"
//		newPerson.save(flush:true)
//		if(newPerson.hasErrors()){
//			println(newPerson.errors)
//		}else{
//			println("New person: " + newPerson?.phones + " - " + newPerson.phones?.size())
//		}
		
		
		personInstance.phones.clear()		
		int index = 0				
		def pEntry = params.get('phones[' + index + ']')
		while(pEntry != null){
			Phone p = new Phone(pEntry)
			p?.index = index
			personInstance?.addToPhones(p)
			//next p
			index++
			pEntry = params.get('phones[' + index + ']')
			
		}
		
//		p.save(flush:true)
//		if(p.hasErrors()){
//			println(p.errors)
//		}else{
//			println(">>> p[" + p?.id + "]: " + p + " - " + p?.deleted)
//		}
		
        if (personInstance == null) {
            notFound()
            return
        }

        if (personInstance.hasErrors()) {
            respond personInstance.errors, view:'edit'
            return
        }
		
	//	personInstance.properties = params
		
//		personInstance.phones.clear()
//		personInstance?.addToPhones(p)
		println ("B4 save: " + personInstance?.phones)
//		def tmp =params.get('phones[' + someInt + ']')
//		
//		personInstance.phones.clear()
//		personInstance.addToPhones(p)
//		println(">> added: " + tmp)
		
		// find the phones that are marked for deletion
		//def _toBeDeleted = personInstance.phones.findAll {(it?.deleted || (it == null))}
//		def _toBeDeleted = personInstance.phones.findAll {it?.deleted = true}
//		def _new =  personInstance.phones.findAll {it?.new = true}
//		
//		println ("new entries: " + _new)
//		// if there are phones to be deleted remove them all
//		if (_toBeDeleted != null) {
//			println ("!!! deleting phones..." + _toBeDeleted)
//			personInstance.phones.removeAll(_toBeDeleted)
//		}
//		//personInstance.phones.removeAll(it?.deleted)
//		
		//update my indexes
//		personInstance.phones.eachWithIndex(){phn, i ->
//			println("updating index..." + phn)
//			phn?.index = i
//		}
		
//		bindData(personInstance, params, [exclude: 'dateOfBirth'])
//		bindData(personInstance, ['dateOfBirth': params.date('dateOfBirth', ['yyyy-MM-dd'])], [include: 'dateOfBirth'])
		
		
		
        personInstance.save flush:true
		if(personInstance.hasErrors()){
			personInstance.errors
		}else{		
			println ("Final: " + personInstance?.phones)
		}
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
