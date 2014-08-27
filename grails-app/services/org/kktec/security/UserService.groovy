package org.kktec.security

class UserService {
	
	boolean saveUser(User user) {
		user.save(flush: true)
	}

}
