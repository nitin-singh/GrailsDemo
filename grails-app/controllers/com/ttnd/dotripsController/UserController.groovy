package com.ttnd.dotripsController

import com.ttnd.demo.User
import com.ttnd.dotripsBindings.RegisterCO
import com.ttnd.dotripsService.UserService
import org.grails.datastore.gorm.GormEntity$Trait$Helper

class UserController {

    def userService

    def index() {}

    def register() {
    }

    def registeration(RegisterCO registerCO) {
        String msg = ""
        println "Inside Register."
        User user = new User()
        user.properties = registerCO.properties
        println "------------------------------------------"
        println registerCO.properties
        println "------------------------------------------"
        println user.properties
        println user.validate()
        if (user.validate()) {
            user.save(flush: true)
            msg = "User saved successfully."
        } else {
            msg = "Problem in saving user."
        }
        render msg
    }

    def view() {
    }

    def viewPage() {
        println "-----------------------------------------------------------------------"
        println "inside view"
        List<User> userList = User.findAll()
        println userList
        render(view: '/user/view', model: [userList: userList])
    }

    def delete(Long userId) {
        User user = User.load(userId)
        println "---------------${user}-----------------"
        if (user) {
            user.delete(flush: true)
            flash.message = "User deleted successfully."
        } else {
            flash.error = "Problem in accessing user."
        }
    }

    def edit() {
    }

    def editPage(Long userId) {
        println "--------------------Inside EditPage------------------"
        User user = User.load(userId as Long)
        println "---------------${user}-----------------"
        println "---------------${userId}-----------------"
        if (user) {
            bindData(user, params, exclude: ['password', 'confirmPassword'])
            if (user.password || user.confirmPassword) {
                user.password = params.password
                user.confirmPassword = params.confirmPassword
            }
            flash.message = "User updated successfully."
        } else {
            flash.error = "Problem in loading user."
        }
    }
}
