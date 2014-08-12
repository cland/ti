package com.cland

class Person {

	String firstName
	String lastName
	String email
	Date dateOfBirth
	String gender
    static constraints = {
		dateOfBirth nullable:true
		email nullable:true
		gender nullable:true
    }
	
	def toMap(){
		return [id:id,firstname:firstName, lastname:lastName,gender:gender,birthdate:dateOfBirth?.format("dd MMM yyyy"),email:email]
	}
}
