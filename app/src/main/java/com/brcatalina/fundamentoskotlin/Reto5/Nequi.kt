package com.brcatalina.fundamentoskotlin.Reto5

import kotlin.random.Random
import kotlin.system.exitProcess


class Nequi {
}

fun main() {
    println("Bienvenid@ a nequi")

    val nombreUsuario = "Catalina"
    val numeroCelular = 3012016704L
    val clave = 2006
    var saldoActual = 4500.0

    println("Ingrese su numero de telefono")
    val celularUsu = readLine()!!.toLong()
    println("Ingrese su clave de 4 digitos")
    val claveUsu = readLine()!!.toInt()

    if (numeroCelular == celularUsu && clave == claveUsu) {
        println("\nAcceso concedido\nBienvenid@ $nombreUsuario\n")
        println("$nombreUsuario tu saldo actual es: $saldoActual\n")
        println("Tienes acceso a las siguientes funcionalidades, elige la opcion que quieras")
        println("1. Sacar dinero\n2. Enviar dinero\n3. Recargar\n4. Salir de nequi")

        when (val funcionalidad = readLine()!!.toInt()) {
            1 -> {
                println("Sacar dinero:\nEscoge una de estas dos opciones\n1. Cajero\n2. Punto fisico")
                val modalidad = readLine()!!.toInt()

                if (saldoActual > 2000) {
                    println("¿Cuanto dinero desea retirar?")
                    val dinero = readLine()!!.toDouble()

                    when {
                        dinero > saldoActual -> println("Usted no puede retirar un valor mayor a su " +
                                "saldo actual equivalente a $saldoActual")
                        dinero < 0 -> println("Valor no válido")
                        else -> {
                            val numeroAleatorio = Random.nextInt(100000, 999999)
                            println("Su código para retirar es: $numeroAleatorio")
                            print("Digite el código:")
                            val numConfirmacion = readLine()!!.toInt()

                            if (numConfirmacion == numeroAleatorio) {
                                saldoActual -= dinero
                                println("Retiro realizado con éxito")
                                println("Su saldo actual es $saldoActual")
                            } else {
                                println("El número no coincide, acción no válida")
                            }
                        }
                    }
                } else {
                    println("La transacción no se puede realizar, no te alcanza")
                }
            }
            2 -> {
                println("Enviar dinero")
                println("Por favor ingrese el número de teléfono al cual quiere enviar dinero: ")
                val numeroEnvio = readLine()!!.toLong()
                println("Digite el valor de dinero que desea enviar: ")
                val dinero = readLine()!!.toDouble()

                if (dinero < saldoActual) {
                    saldoActual -= dinero
                    println("El envío de dinero se realizó exitosamente")
                    println("Su saldo actual es $saldoActual")
                } else {
                    println("El envío del dinero no se puede llevar a cabo")
                }
            }
            3 -> {
                println("Recargar dinero")
                println("Por favor ingrese la cantidad de dinero que desea ingresar: ")
                val dinero = readLine()!!.toDouble()
                println("¿Usted está seguro de realizar la recarga?\n1. Si\n2. No")
                val decision = readLine()!!.toString().lowercase()

                when (decision) {
                    "si" -> {
                        saldoActual += dinero
                        println("Recarga generada exitosamente")
                        println("Su saldo actual es $saldoActual")
                    }
                    "no" -> println("La recarga se canceló")
                    else -> println("Opción no válida")
                }
            }
            4 -> {
                println("Vuelve pronto $nombreUsuario")
                exitProcess(0)
            }
            else -> println("Opción no válida")
        }
    } else {
        println("Su usuario y contraseña son incorrectos, inténtelo más tarde")
    }
}
