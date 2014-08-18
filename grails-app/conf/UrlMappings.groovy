class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(redirect: "/guest/welcome")
		"/signOut"(redirect: '/j_spring_security_logout')
        "/denied"(view: '/denied')
        "500"(view: '/error')
	}
}
