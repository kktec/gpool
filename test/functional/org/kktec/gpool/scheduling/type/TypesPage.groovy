package org.kktec.gpool.scheduling.type

import geb.Page

class TypesPage extends Page {

	static url = 'type/types'
	
	static at = {
		title == 'Types'
	}
	
	static content = {
		types { $('#types') }
		addNew { $('a', text: 'Add New Type') }
	}
}
