package org.kktec.gpool.scheduling

class SchedulingService {
	
	List types() { Type.list() }
	
	Type type(Long id) { Type.get id }
	
	Type saveType(Type type) { type.save(flush: true) }
	
	void deleteType(Long id) {
		Type type = Type.get id
		type?.delete(flush: true)
	}
	
	List rosters() { Roster.list() }
	
	Roster saveRoster(Roster roster) { roster.save(flush: true) }
	
	void deleteRoster(Long id) {
		Roster roster = Roster.get id
		roster?.delete(flush: true)
	}

}
