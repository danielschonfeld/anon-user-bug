import com.bug.Role

class BootStrap {

    def init = { servletContext ->
        def r = Role.findOrCreateByAuthority("ROLE_ADMIN")
        r.save(flush: true)
    }

    def destroy = {
    }
}
