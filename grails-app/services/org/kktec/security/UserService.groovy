package org.kktec.security

class UserService {
	
	boolean saveUser(User user) {
		boolean newUser = user.id == null 
		def result = user.save(flush: true)
		if (newUser && result) {
			Role role =  Role.findByAuthority('ROLE_USER')
			new UserRole(user: user, role: role).save(flush: true, failOnError: true) 
		}
		result
	}

	List users() { User.list() }
}
