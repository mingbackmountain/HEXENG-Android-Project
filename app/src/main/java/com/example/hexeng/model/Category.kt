package com.example.hexeng.model

import java.util.HashMap

class Category {
    var id:String? = null
    var name:String? = null

    constructor(id:String,name:String) {
        this.id = id
        this.name = name
    }

    fun toMap(): Map<String,Any> {
        val result = HashMap<String,Any>()
        result["name"] = name!!
        return result
    }
}