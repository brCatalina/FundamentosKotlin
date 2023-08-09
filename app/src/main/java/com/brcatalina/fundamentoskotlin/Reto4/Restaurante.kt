package com.brcatalina.fundamentoskotlin.Reto4

class Restaurante {
}

fun main() {
    val columnas = 4
    val eliminar = -1

    fun leerMenu(categoria: String, numItems: Int): Array<Array<Any>> {
        val menu = Array(numItems) { Array(columnas) { Any() } }
        println("$categoria:\n")
        for (i in 0 until numItems) {
            println("Digite el código de $categoria ${i + 1}")
            menu[i][0] = readLine()!!.toInt()
            println("Digite el nombre de $categoria ${i + 1}")
            menu[i][1] = readLine()!!.toString()
            println("Digite la descripción de $categoria ${i + 1}")
            menu[i][2] = readLine()!!.toString()
            println("Digite el precio de $categoria ${i + 1}")
            menu[i][3] = readLine()!!.toInt()
            println()
        }
        return menu
    }

    val categorias = listOf("entradas", "platos fuertes", "postres", "bebidas")
    val menus = categorias.map { categoria ->
        println("¿Cuantos elementos desea agregar en $categoria?")
        val numItems = readLine()!!.toInt()
        leerMenu(categoria, numItems)
    }

    do {
        println("Opciones del menú:")
        println("1. Visualizar el menú")
        println("2. Mostrar un plato específico según su código")
        println("3. Modificar el menú")
        println("4. Eliminar un elemento del menú")
        println()
        print("Digite la opción que desea ejecutar: ")
        val opcion = readLine()!!.toInt()

        when (opcion) {
            1 -> {
                for ((index, categoria) in categorias.withIndex()) {
                    println("$categoria:\n")
                    for ((i, item) in menus[index].withIndex()) {
                        if (item[0] != eliminar) {
                            println("$categoria #${i + 1}")
                            println("Código: ${item[0]}")
                            println("Nombre: ${item[1]}")
                            println("Descripción: ${item[2]}")
                            println("Precio: ${item[3]}")
                            println()
                        }
                    }
                }
            }
            2 -> {
                println("En cuál de las siguientes categorías desea buscar el producto:")
                for ((index, categoria) in categorias.withIndex()) {
                    println("${index + 1}. $categoria")
                }
                val categoriaElegida = readLine()!!.toInt() - 1
                println("Digite el código del producto que desea buscar")
                val codigoBuscar = readLine()!!.toInt()
                val item = menus[categoriaElegida].find { it[0] == codigoBuscar }
                if (item != null) {
                    println("El producto que usted busca es ${item[1]} cuyo código es ${item[0]}")
                } else {
                    println("El código no se encuentra registrado")
                }
            }
            3 -> {
                println("En cuál de las siguientes categorías desea modificar el producto:")
                for ((index, categoria) in categorias.withIndex()) {
                    println("${index + 1}. $categoria")
                }
                val categoriaElegida = readLine()!!.toInt() - 1
                println("¿Cuantas modificaciones desea realizar?")
                val modificaciones = readLine()!!.toInt()
                for (i in 0 until modificaciones) {
                    println("Digite el código del producto que desea modificar")
                    val codigoModificar = readLine()!!.toInt()
                    val itemIndex = menus[categoriaElegida].indexOfFirst { it[0] == codigoModificar }
                    if (itemIndex != -1) {
                        println("El producto que usted quiere modificar es ${menus[categoriaElegida][itemIndex][1]} " +
                                "cuyo código es ${menus[categoriaElegida][itemIndex][0]}")
                        println("Digite el nuevo código del producto")
                        menus[categoriaElegida][itemIndex][0] = readLine()!!.toInt()
                        println("Digite el nuevo nombre del producto")
                        menus[categoriaElegida][itemIndex][1] = readLine()!!.toString()
                        println("Digite la nueva descripción del producto")
                        menus[categoriaElegida][itemIndex][2] = readLine()!!.toString()
                        println("Digite el nuevo precio del producto")
                        menus[categoriaElegida][itemIndex][3] = readLine()!!.toInt()
                        println("Producto modificado exitosamente")
                    } else {
                        println("El código no se encuentra registrado")
                    }
                }
            }
            4 -> {
                println("En cuál de las siguientes categorías desea eliminar el producto:")
                for ((index, categoria) in categorias.withIndex()) {
                    println("${index + 1}. $categoria")
                }
                val categoriaElegida = readLine()!!.toInt() - 1
                println("¿Cuantas eliminaciones desea realizar?")
                val eliminaciones = readLine()!!.toInt()
                for (i in 0 until eliminaciones) {
                    println("Digite el código del producto que desea eliminar")
                    val codigoEliminar = readLine()!!.toInt()
                    val itemIndex = menus[categoriaElegida].indexOfFirst { it[0] == codigoEliminar }
                    if (itemIndex != -1) {
                        println("El producto que usted quiere eliminar es ${menus[categoriaElegida][itemIndex][1]} " +
                                "cuyo código es ${menus[categoriaElegida][itemIndex][0]}")
                        menus[categoriaElegida][itemIndex][0] = eliminar
                        println("Producto eliminado exitosamente")
                    } else {
                        println("El código no se encuentra registrado")
                    }
                }
            }
            else -> println("Opción no válida.")
        }

        println("¿Desea ver el menú?\n- Si\n- No")
    } while (readLine()!!.equals("si", ignoreCase = true))
}

