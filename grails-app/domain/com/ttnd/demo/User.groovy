package com.ttnd.demo

class User {

    String firstName
    String lastName
    String userName
    String email
    String password
    Date dateCreated
    Date lastUpdated

    String toString(){
        "${firstName} ${lastName}"
    }

    static constraints = {
        userName(nullable: false, blank: false)
        firstName(nullable: false, blank: false)
        lastName(nullable: false, blank: false)
        email(email: true, nullable: false, blank: false)
        password(nullable: false, blank: false)
    }
}
