package org.kktec.security

class User {
	
	String username
	
	String passwordHash
	
	boolean enabled
	
	boolean accountExpired
	
	boolean accountLocked
	
	boolean passwordExpired
	
	String email
	
	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this)*.role as Set
	}
	
	String toString() {
		username
	}

	static constraints = {
		username blank: false, minSize: 3, maxSize: 20, unique: true
		passwordHash blank: false, maxSize: 60
		email blank: false, email: true, maxSize: 50
	}
}
