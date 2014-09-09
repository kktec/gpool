package org.kktec.gpool.scheduling.roster

import geb.Page

class RostersPage extends Page {

	static url = 'roster/rosters'
	
	static at = {
		title == 'Rosters'
	}
	
	static content = {
		rosters { $('#rosters') }
		addNew { $('a', text: 'Add New Roster') }
	}
}
