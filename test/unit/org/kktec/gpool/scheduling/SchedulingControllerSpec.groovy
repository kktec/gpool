package org.kktec.gpool.scheduling

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(SchedulingController)
class SchedulingControllerSpec extends Specification {

	def 'can view the Scheduling page'() {
		when:
		controller.index()
		
		then:
		view == '/scheduling/index'
		model.title == 'Scheduling'
	}
	
}
