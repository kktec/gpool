package org.kktec.security

class UserRole implements Serializable {
	
	private static final long serialVersionUID = 1

	User user
	Role role
	
	static mapping = {
		id composite: ['role', 'user']
		version false
	}
}
