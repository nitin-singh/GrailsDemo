package com.ttnd.demo

class User {

    String firstName
    String lastName
    String userName
    String email
    String password
    String confirmPassword
    Date dateCreated
    Date lastUpdated
    static transients = ['confirmPassword']

    /*String toString(){
        "${firstName} ${lastName}"
    }*/

    static constraints = {
        userName(nullable: false, blank: false)
        firstName(nullable: false, blank: false)
        lastName(nullable: false, blank: false)
        email(email: true, nullable: false, blank: false)
        password(nullable: false, blank: false)
        /*confirmPassword(bindable: true, nullable: true, blank: true, validator: { val, obj ->
            if (val && obj.password) {
                val.equals(obj.password) ? true : 'password.do.not.match.confirmPassword'
            }
        })*/
    }
}
