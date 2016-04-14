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
        User user = new User()
        user.properties = registerCO.properties
        if (user.validate()) {
            user.save(flush: true)
            msg = "User saved successfully."
        } else {
            msg = "Problem in saving user."
        }
        flash.message = msg
        redirect(controller: "user", action: "viewPage")
    }

    def view() {
    }

    def viewPage() {
        List<User> userList = User.findAll()
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
        redirect(controller: 'user', action: 'viewPage')
    }

    def edit(Long userId) {
        println userId
        User user = User.findById(userId as Long)
        println "-----------------${user}-------------------"
        render(view: '/user/edit', model: [user: user])
    }

    def editPage(Long userId) {
        println "--------------------Inside EditPage------------------"
        println "---------------${params}-----------------"
        println "---------------${userId}-----------------"
        User user = User.load(userId as Long)
        println "---------------${user}-----------------"
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
