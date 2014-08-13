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
	boolean isStaff(){
		//work out if this person has a user account
		return false
	}
	User getUser(){
		return null
	}
	
	Office primaryOffice(){
		//The office that this person belongs to
		return null
	}
	def toAutoCompleteMap(){
		return [id:id,
			label:firstName + " " + lastName + " | " + gender + " | " + dateOfBirth?.format("dd MMM yyyy"),
			value:id,
			gender:gender,
			email:email]
	}
}
