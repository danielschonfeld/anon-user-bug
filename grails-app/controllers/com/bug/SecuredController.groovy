package com.bug

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class SecuredController {

    def index() { 
	    render(text: "Test")
    }
}
