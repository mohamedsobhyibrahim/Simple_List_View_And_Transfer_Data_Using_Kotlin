package com.mohamedsobhy.foodapp

class Food {
    var name : String ?= null
    var description : String ?= null
    var images : Int ?=null

    constructor(name: String?, description: String?, images: Int?) {
        this.name = name
        this.description = description
        this.images = images
    }
}