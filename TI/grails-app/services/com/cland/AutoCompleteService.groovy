package com.cland

import grails.transaction.Transactional

/**
 * AutoCompleteService
 * A service class encapsulates the core business logic of a Grails application
 */
@Transactional
class AutoCompleteService {

	def personList(params){			
		def term = params?.term + "%"
		println (term)
	   def query = {
		    or {
		     ilike("firstName", term ) 
		     ilike("lastName", term)
		    }
	   }
	   def clist = Person.createCriteria().list(query) 

	   def selectList = [] 
	   clist.each {
		   selectList.add(it.toAutoCompleteMap()) // add to the arraylist
	   }
	   
	   return selectList
	}
}
