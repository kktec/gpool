package org.kktec.gpool.scheduling

class Contestant {
	
	Type type
	
	String firstName
	
	String lastName
	
	String getFullName() { "$firstName $lastName" }
	
	static belongsTo = Roster
	
	static hasMany = [rosters: Roster]

	static constraints = {
		firstName blank: false, minSize: 3, maxSize: 25, matches: /[a-zA-Z0-9 ]+/
		lastName blank: false, minSize: 3, maxSize: 25, matches: /[a-zA-Z0-9 ]+/
	}
}
