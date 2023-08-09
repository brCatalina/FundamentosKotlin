package com.brcatalina.fundamentoskotlin.Reto1

class Notificaciones {
}
fun main() {
    val telefonos = mutableListOf<Pair<String, Int>>()

    telefonos.add(Pair("Teléfono 1", 16))
    telefonos.add(Pair("Teléfono 2", 105))
    telefonos.add(Pair("Teléfono 3", 0))

    for (telefono in telefonos) {
        val numTelefono = telefono.first
        val notificacionesCount = telefono.second
        val resumen = when {
            notificacionesCount < 1 -> "No existen mensajes disponibles para el $numTelefono."
            notificacionesCount < 100 -> "Tienes $notificacionesCount notificaciones en $numTelefono."
            else -> "El $numTelefono tiene 99+ notificaciones."
        }
        println(resumen)
    }
}


