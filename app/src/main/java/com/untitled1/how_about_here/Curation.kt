package com.untitled1.how_about_here

class Curation(_img: Int, _text: String, _time: String) {

    val img = _img
    val tmp = _text
    val text = tmp.replace(" ", "\n")
    val time = _time
}