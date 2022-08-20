package com.pyxlab.cetus.modules.address

import java.io.Serializable

data class Address (
    val cep: String,
    val state: String,
    val city: String,
    val neighborhood: String,
    val street: String,
    val number: String
    ): Serializable
