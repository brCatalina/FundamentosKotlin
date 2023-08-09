package com.brcatalina.fundamentoskotlin.Reto2

class Album {
}

fun main() {
    println("¿Cuantas canciones tiene el Album?")
    val numCanciones = readLine()!!.toInt()

    var tituloPopular = ""
    var artistaPopular = ""
    var reproduccionesPopular = Int.MIN_VALUE

    var tituloImpopular = ""
    var artistaImpopular = ""
    var reproduccionesImpopular = Int.MAX_VALUE

    val canciones = mutableListOf<String>()

    println("\nIngresando canciones")
    for (i in 1..numCanciones) {
        println("Canción número $i")

        println("Ingrese el título de la canción: ")
        val titulo = readLine()!!

        println("Ingrese el nombre del artista: ")
        val artista = readLine()!!

        println("Ingrese el año de publicación: ")
        val publicacion = readLine()!!.toInt()

        println("Ingrese el número de reproducciones: ")
        val reproducciones = readLine()!!.toInt()

        if (reproducciones > reproduccionesPopular) {
            tituloPopular = titulo
            artistaPopular = artista
            reproduccionesPopular = reproducciones
        }

        else if (reproducciones < reproduccionesImpopular) {
            tituloImpopular = titulo
            artistaImpopular = artista
            reproduccionesImpopular = reproducciones
        }

        val descripcion = "La canción $titulo, se encuentra interpretada por $artista, " +
                "su lanzamiento se dio en el año $publicacion y cuenta con $reproducciones reproducciones"
        canciones.add(descripcion)

        val popularidad = if (reproducciones >= 1000) "popular" else "poco popular"
        println("La canción $titulo tiene $reproducciones reproducciones, por ende, es $popularidad\n")
    }

    println("La canción más popular del álbum es $tituloPopular. " +
            "Esta cuenta con $reproduccionesPopular reproducciones.")

    println("La canción menos popular del álbum es $tituloImpopular." +
            " Esta cuenta con $reproduccionesImpopular reproducciones.")

    println("\nDescripción de cada canción")
    for (descripcion in canciones) {
        println(descripcion)
    }
}



