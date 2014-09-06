package org.kktec.gpool.scheduling

class Roster {
	
	Type type
	
	String name
	
	static hasMany = [contestants: Contestant]

	static constraints = {
		name blank: false, minSize: 3, maxSize: 25, matches: /[a-zA-Z0-9 ]+/, unique: true
	}
}
