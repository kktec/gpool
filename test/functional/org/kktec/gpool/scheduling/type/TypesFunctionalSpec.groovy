package org.kktec.gpool.scheduling.type

import org.kktec.gpool.GPoolFunctionalSpec

class TypesFunctionalSpec extends GPoolFunctionalSpec {

	def 'a pool user can see a list of Types'() {
		given:
		signInWithRolePool()
		
		when:
		to TypesPage
		
		then:
		at TypesPage
		types()
		addNew()
	}
	
	def 'a pool user can add a new Type'() {
		given:
		signInWithRolePool()
		
		when:
		go 'type/addNew'
		
		then:
		title == 'Add New Type'
		
		when:
		name().value('Basketball')
		saveType().click()

		then:
		at TypesPage
	}

	def 'a pool user can edit a Type'() {
		given:
		signInWithRolePool()
		
		when:
		go 'type/edit/1'
		
		then:
		title == 'Edit Type'
		id().value() == '1'
		
		when:
		name().value('Soccer')
		saveType().click()

		then:
		at TypesPage
	}
	
	static content = {
		name { $('input', name: 'name') }
		saveType { $('input', type: 'submit') }
		id { $('input', name: 'id') }
	}

}
