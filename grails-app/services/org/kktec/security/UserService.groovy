package org.kktec.security

class UserService {
	
	/**
	 * Saves a new or existing User. A new User will be provided with ROLE_USER
	 * 
	 * @param user
	 * 
	 * @return user on success or null
	 */
	User saveUser(User user) {
		boolean newUser = user.id == null 
		def result = user.save(flush: true)
		if (newUser && result) {
			Role role =  Role.findByAuthority('ROLE_USER')
			new UserRole(user: user, role: role).save(flush: true, failOnError: true) 
		}
		result
	}

	/**
	 * @return List of all Users
	 */
	List users() { User.list() }
}
