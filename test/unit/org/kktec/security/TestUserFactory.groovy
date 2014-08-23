package org.kktec.security

trait TestUserFactory {
	
	User validUser(String username) {
		new User(username: username, passwordHash: username.reverse())
	}
	
	Role validRole() {
		new Role(authority: 'ROLE_USER')
	}

}
