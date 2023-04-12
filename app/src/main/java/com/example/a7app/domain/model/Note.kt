package com.example.a7app.domain.model

class Note(
    val id: Int = DEFAULT_ID,
    var title: String = "",
    var description: String = ""
) : java.io.Serializable {
    companion object {
        const val DEFAULT_ID = 0
    }
}

