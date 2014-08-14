package com.cland
import org.apache.commons.collections.list.LazyList;
import org.apache.commons.collections.FactoryUtils;
class Person {

	String firstName
	String lastName
	String email
	Date dateOfBirth
	String gender
	List phones // = new ArrayList()
	static hasMany = [phones:Phone]
    static constraints = {
		dateOfBirth nullable:true
		email nullable:true
		gender nullable:true
    }
	static mapping = {
		phones cascade:"all-delete-orphan"
	}
	def getPhonesList() {
		return LazyList.decorate(
			  phones,
			  FactoryUtils.instantiateFactory(Phone.class))
	}
	boolean isStaff(){
		//work out if this person has a user account
		return (getUser() != null?true:false)
	}
	User getUser(){
		return User.findByPerson(this)
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
