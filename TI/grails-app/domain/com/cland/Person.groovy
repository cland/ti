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
}
