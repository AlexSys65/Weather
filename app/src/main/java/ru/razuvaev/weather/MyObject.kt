package ru.razuvaev.weather

object MyObject {
    val mNameCats = arrayListOf<String>()

    fun callCats(): String {
        var s = ""
        for (cat in mNameCats) {
            s = s + cat + "\n"
        }
        return s
    }

}