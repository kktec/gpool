package org.kktec.security

import grails.validation.Validateable
import groovy.transform.ToString

@Validateable
@ToString
class PasswordCommand {
	
	String newPassword
	
	String repeatPassword
	
	// TODO: file a JIRA, constraints must be explicit for mockCommandObject
	static constraints = {
		newPassword blank: false, minSize: 6
		repeatPassword validator: { value, command ->
			if (value != command.newPassword) { return 'nonIdentical' }
		}
	}

}
