package org.kktec.gpool.scheduling

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_POOL'])
class SchedulingController {
	
	def index() {
		render view: 'index', model: [title: 'Scheduling']
	}

}
