package com.cland

public enum PhoneType{
	H("Home"),
	M("Mobile"),
	W("Work"),
	F("Fax"),
	O("Other")
	final String value;
	PhoneType(String value) {
		this.value = value;
	}
	String toString(){
		value;
	}
	String getKey(){
		name()
	}
	static list() {
		[H.toString(), M.toString(), W.toString(), F.toString(),O.toString()]
	}
}
