import TDA.Cola
import TDA.Matriz
import TDA.Pila
import pojo.*
import java.util.logging.Logger
import kotlin.random.Random
import kotlin.system.exitProcess

fun main() {

    val logger: Logger = Logger.getLogger(" Log")
    logger.info("comienza el juego")


    //pedir Matriz
    val tamaño: Int? = pedirTamañoDeMatriz()

    println("tamaño pedido : $tamaño")

    var matriz: Matriz

    if (tamaño != null) {
        matriz = Matriz(tamaño)
    } else {
        println("fallo de juego por error de elecion de tamaño")
        exitProcess(1);
    }

    println("matriz construida:  $matriz")


    //pedir tiempo
    var tiempo: Int = pedirTiempo()

    println("tiempo pedido : $tiempo")


    //pila de 200 items
    var items: Pila<Item> = crearPilaDeItems()

    println("Itemas contruidos : ${items.toString()}")

    //hacer dos equipos cola o fifois

    var equipo1: Cola<Personaje> = crearEquipo()
    println("creado el equipo “Amazonas de Isengard”  : $equipo1")

    var equipo2: Cola<Personaje> = crearEquipo()
    println("creado el equipo “Caballeros de Elrond”  : $equipo2")

    //loop de juego que comienza
    println("juego comienza")


    do {

        //matriz se llena y rellena cada 5 seg (tiempo)

        if (tiempo != 0 && tiempo % 5 == 0) {
            //recorremos las casillas
            for (i in 0 until tamaño) {
                for (j in 0 until tamaño) {

                    //comprobamos si está vacia
                    if (matriz.verCasilla(i, j) == null && !items.isEmpty()) {
                        //si hay items ponerlo en la casilla
                        matriz.ponerItemOrNull(i, j, items.popOrNull())
                    }
                }
            }
            println("matriz rellenada correctamente")
            println("matriz: $matriz")
        }

        //cada segundo sale un jugador  y pasa la logical y se comprueva que nadie haya ganado

        var equipo1Ganado: Boolean = sacarJugador(equipo1, tamaño, matriz)
        var equipo2Ganado: Boolean = false

        if (!equipo1Ganado) {
            equipo2Ganado = sacarJugador(equipo2, tamaño, matriz)

        }

        //para un segundo en el contador
        tiempo--

        println("matriz: ${matriz}")
        println("el tiempo restante son  $tiempo segundos")

        //QUE HA PASADO
        if(tiempo>=0){ println("EL TIEMPO SE HA ACABADO") }
        if(equipo1Ganado){ println("EL El EQUIPO “Amazonas de Isengard” HA GANADO ") }
        if(equipo2Ganado){ println("EL El EQUIPO “Caballeros de Elrond” HA GANADO ") }
        if(items.isEmpty()){println("YA NO HAY MAS ITEMA ") }

        //se acaba si un el tiempo se acaba, un equipo gana o no hay mas items
    } while(tiempo >= 1 && !equipo2Ganado && !equipo1Ganado && !items.isEmpty())



    //se imprime el resultado ordenado

    imprimir(equipo1, equipo2, matriz, items)
}



fun imprimir(equipo1: Cola<Personaje> , equipo2 : Cola<Personaje> , matriz: Matriz, items:Pila<Item>) {
    println("\n \n \n LA MATRIZ FINAL HA SIDO !!!: ")
    println(matriz.toString())

    println("EQUIPO “Amazonas de Isengard”: ")
    imprimirDetalle(equipo1)
    println("EQUIPO “Caballeros de Elrond”: ")
    imprimirDetalle(equipo2)

    println("EL REPOSITORIO HA QUEDADO CON  ${items.size()} ITEMS")






}

fun imprimirDetalle(e: Cola<Personaje>) {
    for(i in 0 until 3){
        var p = e.verCasilla(i)
        if (p != null) {
            println("el jugador $i")
            println(p.mostrarEstado())
        }
        var items2 =  p?.items?.stream()?.toList()
        if (items2 != null) {
            for (j in 0 until items2.size)
                println(items2[j].imprimirDetalle())
        }
    }
}


fun sacarJugador(equipo: Cola<Personaje>, tamaño : Int, matriz : Matriz): Boolean {

    //cojer casilla a suerte

    var horizontalAleatoria = Random.nextInt(tamaño)
    var verticalAleatoria = Random.nextInt(tamaño)
    var personaje= equipo.popOrNull()

    println("empieza turno")
    println("el equipo saca a  $personaje , y va a la casilla $horizontalAleatoria, $verticalAleatoria")

    //ver si puede cojer items
    var item : Item? = matriz.verCasilla(horizontalAleatoria, verticalAleatoria)

    if(item != null){
        println("la casilla tiene un item")
        when(item.tipo){
            Tipo.comida -> if (personaje != null) {
                personaje.items.add(item)
                matriz.cojerItemOrNull(horizontalAleatoria,verticalAleatoria)
                println("el Item es comida")
                println("asi que se añade")
            }
            Tipo.material -> if (personaje != null) {
                // y humano escudo 5
                println("el Item es material")

                if (personaje::class == Humano::class) {
                    personaje.items.add(item)
                    personaje as Humano
                    personaje.escudo = personaje.escudo + 5
                    matriz.cojerItemOrNull(horizontalAleatoria, verticalAleatoria)
                    println("como es humano se añade")
                }
            }
            Tipo.pocion -> if (personaje != null) {
                // trasgos maldad 2
                println("el tipo es pocion")
                if (personaje::class == Trasgo::class) {
                    personaje.items.add(item)
                    personaje as Trasgo
                    personaje.maldad = personaje.maldad + 2
                    matriz.cojerItemOrNull(horizontalAleatoria, verticalAleatoria)
                    println("como es trasgo se añade")
                }
            }
            Tipo.hechizo -> if (personaje != null) {
                // elfo inmortalidad 7
                println("el tipo es hechizo")
                if (personaje::class == Elfo::class) {
                    personaje.items.add(item)
                    personaje as Elfo
                    personaje.inmortalidad = personaje.inmortalidad + 7
                    matriz.cojerItemOrNull(horizontalAleatoria, verticalAleatoria)
                    println("como es elfo se añade")
                }
            }
        }

    } else{
        println("la casilla estaba vacia")
    }
    if (personaje != null) {
        println("el personaje se queda de la siguinete forma: $personaje")
        equipo.push(personaje)
    }

    //comprobar si el equipo ha ganado

    var conseguidos : Int = 0
    for (i in 0 until 3) {

        var p = equipo.verCasilla(i) as Personaje
        if(p?.items?.size!! >4){conseguidos++}
    }
    println("el equipo tiene $conseguidos integrantes del equipo con 5 items")
    return conseguidos==3
}

fun crearEquipo(): Cola<Personaje> {
    var equipo : Cola<Personaje> = Cola()
    for(i in 0 until 3){
        equipo.push(crearPersonaje())
    }
    return equipo
}

fun crearPersonaje(): Personaje {

    var personaje1 : Personaje

    var elecion : Int = Random.nextInt(2)
    when(elecion){
         0->personaje1 =  Elfo()
         1->personaje1 = Trasgo()
         else-> personaje1 = Humano()
    }
    return personaje1;
}

fun crearPilaDeItems(): Pila<Item> {
    var pila : Pila<Item> = Pila()
    for (i in 0 until 200){
        pila.push(Item())
    }
    return pila
}

fun pedirTiempo(): Int {

    var correcto : Boolean = false
    do {
        println("dime cuantos segundos quieres jugar , recuerda entre 30 y 100")
        var numero : Int? = readLine()?.toIntOrNull()
        if (numero in 30..100){
            correcto=true
            if(numero!= null){ return numero}

        }
    }while (correcto!= true)

    exitProcess(1)
    println("fallo en el loop del tirmpo")
    return 0
}

fun pedirTamañoDeMatriz(): Int ?{

    var numero :Int?
    var correcto : Boolean = false
    do {
        println("dime de que tamaño vas a querer tu matriz, recuerda que los valores aceptados son 6 ,8 ,10")
        numero = readLine()?.toIntOrNull()
        if (numero==6 || numero==8 || numero==10){
            correcto=true
        }
    }while (!correcto)
    println("perfecto tu tablero sera de $numero casillas de alto y ancho")

    //logger.info("tamaño de tablero elegigo")
    return numero
    }




