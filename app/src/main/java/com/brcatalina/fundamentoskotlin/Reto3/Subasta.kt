package com.brcatalina.fundamentoskotlin.Reto3

class Subasta {
}

fun main() {
    println("¡Bienvenido a la subasta de las pinturas más importantes!")

    val pinturas = listOf("La noche estrellada,1889", "El hombre vitruviano, 1490", "La mona lisa, 1506")
    val precios = listOf(3000000,2000000,1000000)
    val columnas = 2

    var mayor = 0
    var posicion = 0

    for (i in pinturas.indices) {
        println("\nSubasta número${i + 1}\nSe reciben ofertas por la pintura: ${pinturas[i]}\n" +
                "La subasta inicia en un valor de: ${precios[i]}")

        println("Ingrese el número de ofertantes:")
        val numOfe = readLine()!!.toInt()

        if (numOfe > 0) {
            val subasta = Array(numOfe) { Array(columnas) { Any() } }

            for (o in 0 until numOfe) {
                println()
                print("Ingrese el nombre del ofertante #${o + 1}: ")
                val nombre = readLine()!!.toString()
                subasta[o][0] = nombre

                print(": ")
                val oferta = readLine()!!.toInt()
                subasta[o][1] = oferta

                if (oferta > mayor) {
                    mayor = oferta
                    posicion = o
                }
            }

            println()

            if (mayor >= precios[i]) {
                println("El vehiculo ${pinturas[i]} es vendido al ofertante ${subasta[posicion][0]} " +
                        "por un valor de $mayor")
            } else {
                println("Ningun ofertante ha superado el valor base del producto, por lo tanto, " +
                        "este es vendido por su valor base a la casa de subastas")
            }
        } else {
            println("No hay ningun ofertante para este producto, por lo tanto, " +
                    "este es vendido por su valor base a la casa de subastas")
        }
    }

    println("\nFin de la subasta")
}
