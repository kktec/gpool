package org.kktec.gpool.scheduling

trait TestSchedulingFactory {
	
	Type validType(Map params) { new Type(params?.type ?: 'nfl') }
	
	Contestant validContestant(Map params) {
		Contestant contestant = new Contestant(firstName: 'Green Bay', lastName: 'Packers')
		contestant.properties = params
		contestant
	}
	
	Roster validRoster(Map params) { 
		Roster roster = new Roster(name: 'a Roster')
		roster.properties = params
		roster
	}

}
