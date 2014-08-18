package org.kktec.security

import org.kktec.security.Role;
import org.kktec.security.User;

trait TestUserFactory {
	
	User validUser(String username) {
		new User(username: username, passwordHash: username.reverse())
	}
	
	Role validRole() {
		new Role(authority: 'ROLE_USER')
	}

}
