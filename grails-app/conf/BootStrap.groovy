import org.kktec.security.Role
import org.kktec.security.User
import org.kktec.security.UserRole

class BootStrap {
	
	def springSecurityService
	
	Role user
	Role pool
	Role admin
	
    def init = { servletContext ->
		initRoles()
		
		environments {
			development {
				initUsers()
			}
			test {
				initUsers()
			}
		}
    }
	
    def destroy = {
    }
	
	private initRoles() {
		if (Role.count() < 3) {
			user = new Role(authority: 'ROLE_USER').save(failOnError: true)
			pool = new Role(authority: 'ROLE_POOL').save(failOnError: true)
			admin = new Role(authority: 'ROLE_ADMIN').save(failOnError: true)
		}
	}
	
	private initUsers() {
		User ken = new User(username: 'ken', passwordHash: springSecurityService.encodePassword('nek'), enabled: true)
			.save(failOnError: true)
		User dave = new User(username: 'dave', passwordHash: springSecurityService.encodePassword('evad'), enabled: true)
			.save(failOnError: true)
		User carol = new User(username: 'carol', passwordHash: springSecurityService.encodePassword('mom'), enabled: true)
			.save(failOnError: true)
		new UserRole(user: ken, role: user)	
			.save(failOnError: true)
		new UserRole(user: ken, role: pool)	
			.save(failOnError: true)
		new UserRole(user: ken, role: admin)	
			.save(failOnError: true)
		new UserRole(user: dave, role: user)	
			.save(failOnError: true)
		new UserRole(user: dave, role: pool)	
			.save(failOnError: true)
		new UserRole(user: carol, role: user)	
			.save(failOnError: true)
	}
}
