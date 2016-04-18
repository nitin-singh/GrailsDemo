package com.ttnd.demo

import com.ttnd.demo.VO.*
import com.ttnd.demo.CO.*

class User {

    String firstName
    String lastName
    String userName
    String email
    String password
    Date dateCreated
    Date lastUpdated

    String toString() {
        "${firstName} ${lastName}"
    }

    static constraints = {
        userName(nullable: false, blank: false)
        firstName(nullable: false, blank: false)
        lastName(nullable: false, blank: false)
        email(email: true, nullable: false, blank: false)
        password(nullable: false, blank: false)
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
