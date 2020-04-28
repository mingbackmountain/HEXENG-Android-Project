package com.example.hexeng.model

class Vocab {
    var id:String? = null
    var word:String? = null
    var meaning:String? = null

    constructor(id:String,word:String,meaning:String) {
        this.id = id
        this.word = word
        this.meaning = meaning
    }
}