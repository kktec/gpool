package org.kktec.security

class Role {

	String authority
	
	String toString() {
		authority
	}

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, maxSize: 50, unique: true
	}
}
