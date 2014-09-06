package org.kktec.gpool.scheduling

import geb.Page

class SchedulingPage extends Page {
	
	static url = 'scheduling'

	static at = {
		title == 'Scheduling'
	}
	
	static content = {
		types { $('a', text: 'Types') }
		rosters { $('a', text: 'Rosters') }
	}
}
