package com.cland

/**
 * Office
 * A domain class describes the data object and it's mapping to the database
 */
class Office {
	String name
	String code
	String status
	String contactNumber
	String email
	/* Default (injected) attributes of GORM */
//	Long	id
//	Long	version
	
	/* Automatic timestamping of GORM */
//	Date	dateCreated
//	Date	lastUpdated
	
//	static	belongsTo	= []	// tells GORM to cascade commands: e.g., delete this object if the "parent" is deleted.
//	static	hasOne		= []	// tells GORM to associate another domain object as an owner in a 1-1 mapping
	static	hasMany		= [staff:Person,affiliates:Organisation]	// tells GORM to associate other domain objects for a 1-n or n-m mapping
//	static	mappedBy	= []	// specifies which property should be used in a mapping 
	
    static	mapping = {
    }
    
	static	constraints = {
    }
	def toAutoCompleteMap(){
		return [id:id,
			label:name + " (" + Status + ") | " + contactNumber + " | " + email,
			value:id,
			phoneno:contactNumber,
			email:email,
			status:status]
	}
	/*
	 * Methods of the Domain Class
	 */
//	@Override	// Override toString for a nicer / more descriptive UI 
//	public String toString() {
//		return "${name}";
//	}
}
