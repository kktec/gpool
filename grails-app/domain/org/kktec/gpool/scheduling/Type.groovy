package org.kktec.gpool.scheduling

class Type {
	
	String name
	
	Type(String name) { this.name = name }
	
	String toString() { name }
	
	static constraints = {
		name blank: false, minSize: 3, maxSize: 10, matches: /[a-zA-Z]+/, unique: true
	}

}
