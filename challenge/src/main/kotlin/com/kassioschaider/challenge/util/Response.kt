package com.kassioschaider.challenge.util

class Response<T> (
        val errors: ArrayList<String> = arrayListOf(),
        var data: T? = null
)