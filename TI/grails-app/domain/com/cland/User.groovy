package com.cland

class User {

	transient springSecurityService

	String username
	String password
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
	Person person
	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true
		password blank: false
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
	def toAutoCompleteMap(){
		return [id:id,
			label:person?.firstName + " " + person?.lastName + "(" + username + ") | " + person?.gender + " | " + person?.dateOfBirth?.format("dd MMM yyyy"),
			value:id,
			gender:person?.gender,
			email:person?.email]
	}
}
