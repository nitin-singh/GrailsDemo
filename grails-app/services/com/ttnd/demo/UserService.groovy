package com.ttnd.demo

import com.ttnd.demo.CO.*
import grails.transaction.Transactional

@Transactional
class UserService {

    void createUsers(RegisterCO registerCO ){
        println "Inside createUser."
        User user = new User()
        user.properties = registerCO.properties
        println "------------------------------------------"
        println registerCO.properties
        println "------------------------------------------"
        println user.properties
        println user.validate()
        if(user.validate()){
            user.save(flush: true)
            println "User saved successfully."
        }else{
            println "Problem in saving user."
        }
    }
}
