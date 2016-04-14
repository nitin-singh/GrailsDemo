package com.ttnd.demo

import com.ttnd.demo.RegisterCO

class UserController {

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

        User user = User.findById(userId as Long)
        println "---------------${user}-----------------"
        if (user) {
            bindData(user, params, exclude: ['password'])
            if (user.password) {
                user.password = params.password
            }
            flash.message = "User updated successfully."
        } else {
            flash.error = "Problem in loading user."
        }
        redirect(controller: 'user', action: 'viewPage')
    }
}
