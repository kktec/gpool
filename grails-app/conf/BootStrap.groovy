import org.kktec.gpool.scheduling.Contestant
import org.kktec.gpool.scheduling.Roster
import org.kktec.gpool.scheduling.Type
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
				initScheduling()
			}
			test {
				initUsers()
				initScheduling()
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
		User ken = new User(
			username: 'ken',
			passwordHash:
			springSecurityService.encodePassword('nekken'),
			email: 'ken@kktec.org',
			enabled: true
		).save(failOnError: true)
		
		User dave = new User(
			username: 'dave',
			passwordHash: springSecurityService.encodePassword('evaddave'),
			email: 'dave@kktec.org',
			enabled: true
		).save(failOnError: true)
		
		User carol = new User(
			username: 'carol',
			passwordHash: springSecurityService.encodePassword('mommom'),
			email: 'carol@kktec.org',
			enabled: true
		).save(failOnError: true)
			
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
	
	private initScheduling() {
		Type baseball = new Type('Baseball')
			.save(failOnError: true)
		Type football = new Type('Football')
			.save(failOnError: true)
		Roster nfl = new Roster(type: football, name: 'NFL')
			.save(failOnError: true)
		Set contestants = [
			new Contestant(firstName: 'Green Bay', lastName: 'Packers'),
			new Contestant(firstName: 'Chicago', lastName: 'Bears'),
			new Contestant(firstName: 'Minnesota', lastName: 'Vikings'),
			new Contestant(firstName: 'Detroit', lastName: 'Lions'),
			new Contestant(firstName: 'Seattle', lastName: 'Seahawks'),
			new Contestant(firstName: 'Saint Louis', lastName: 'Rams'),
		]
		contestants.each { 
			it.type = football
			nfl.addToContestants it
		}
		nfl.save(failOnError: true)
	}

}
