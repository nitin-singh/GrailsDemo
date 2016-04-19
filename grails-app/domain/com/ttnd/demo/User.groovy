package com.ttnd.demo

import com.ttnd.demo.CO.*
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes = 'username')
@ToString(includes = 'username', includeNames = true, includePackage = false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    transient springSecurityService

    String username
    String password
    String firstName
    String lastName
    String email
    Date dateCreated
    Date lastUpdated

    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    User(String username, String password) {
        this()
        this.username = username
        this.password = password
    }

    Set<Role> getAuthorities() {
        UserRole.findAllByUser(this)*.role
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
    }

    static transients = ['springSecurityService']

    static constraints = {
        password blank: false, password: true
        username blank: false, unique: true
        firstName(nullable: false, blank: false)
        lastName(nullable: false, blank: false)
        email(email: true, nullable: false, blank: false)

    }

    static mapping = {
        password column: '`password`'
    }

    String toString() {
        "${firstName} ${lastName}"
    }


    static namedQueries = {
        search { SearchCO searchCO ->
            if (searchCO.fetchSearchValue()) {
                or {
                    ilike("firstName", searchCO.fetchSearchValue())
                    ilike("lastName", searchCO.fetchSearchValue())
                    ilike("userName", searchCO.fetchSearchValue())
                    ilike("email", searchCO.fetchSearchValue())
                }
            }
        }
    }

}














