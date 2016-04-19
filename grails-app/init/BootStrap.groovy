import com.ttnd.demo.Role
import com.ttnd.demo.User
import com.ttnd.demo.UserRole

class BootStrap {

    def init = { servletContext ->
        def adminRole = new Role('ROLE_ADMIN').save()
        def userRole = new Role('ROLE_USER').save()

        User adminUser = new User(email: "admin@gmail.com", firstName: "Normal", lastName: "User", username: "admin", password: "admin")
        adminUser.save(flush: true)

        User normalUser = new User(email: "normal@gmail.com", firstName: "Admin", lastName: "User", username: "normal", password: "normal")
        normalUser.save(flush: true)

        UserRole.create(adminUser, adminRole, true)
        UserRole.create(normalUser, userRole, true)
    }
    def destroy = {
    }
}
