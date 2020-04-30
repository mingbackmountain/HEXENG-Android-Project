package com.example.hexeng.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


class Vocab() : Parcelable {
    var id:String? = null
    var word:String? = null
    var meaning:String? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        word = parcel.readString()
        meaning = parcel.readString()
    }

    constructor(id:String,word:String,meaning:String) : this() {
        this.id = id
        this.word = word
        this.meaning = meaning
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(word)
        parcel.writeString(meaning)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Vocab> {
        override fun createFromParcel(parcel: Parcel): Vocab {
            return Vocab(parcel)
        }

        override fun newArray(size: Int): Array<Vocab?> {
            return arrayOfNulls(size)
        }
    }
}