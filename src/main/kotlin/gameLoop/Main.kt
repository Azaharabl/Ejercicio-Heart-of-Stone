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
    println("creado el equipo 1  : $equipo1")

    var equipo2: Cola<Personaje> = crearEquipo()
    println("creado el equipo 2  : $equipo2")

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

        //se acaba si un el tiempo se acaba, un equipo gana o no hay mas items
    } while(tiempo >= 1 && !equipo2Ganado && !equipo1Ganado && !items.isEmpty())


    //se imprime el resultado ordenado

    imprimir(equipo1, equipo2, matriz)
}



fun imprimir(equipo1: Cola<Personaje> , equipo2 : Cola<Personaje> , matriz: Matriz) {
    println("la matriz final ha sido: ")
    println(matriz.toString())
    println("El equipo 1 con los participantes: ")
    println(equipo1.toString())
    println("El equipo 2 con los participantes: ")
    println(equipo2.toString())




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




