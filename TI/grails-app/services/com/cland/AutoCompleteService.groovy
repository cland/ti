package com.cland

import grails.transaction.Transactional

/**
 * AutoCompleteService
 * A service class encapsulates the core business logic of a Grails application
 */
@Transactional
class AutoCompleteService {

	def complist(params){
	   def query = {
	    or {
	     like("firstName", "${params.term}%") // term is the parameter send by jQuery autocomplete
	     like("lastName", "${params.term}%")
	    }
	  projections { // good to select only the required columns.
	     property("id")
	     property("firstName")
	     property("lastName")
		 property("gender")
	    }
	   }
	   def clist = Person.createCriteria().list(query) // execute  to the get the list of companies
	   def companySelectList = [] // to add each company details
	   clist.each {
	    def companyMap = [:] // add to map. jQuery autocomplete expects the JSON object to be with id/label/value.
	    companyMap.put("id", it[0])
	    companyMap.put("firstName", it[2])
	    companyMap.put("lastName", it[2])
	    companyMap.put("gender", it[1]) // will use this to pre-populate the Emp Id
	    companySelectList.add(companyMap) // add to the arraylist
	 }
	   return companySelectList
	}
}
