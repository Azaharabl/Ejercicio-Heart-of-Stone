import TDA.Cola
import TDA.Matriz
import TDA.Pila
import pojo.*
import java.util.logging.Logger
import kotlin.random.Random
import kotlin.system.exitProcess

fun main() {

    val logger : Logger = Logger.getLogger(" Log")
    logger.info("comienza el juego")


   //pedir Matriz
    var tamaño : Int? = pedirTamañoDeMatriz()
    if(tamaño !=null){
        var matriz : Matriz<Item?> = Matriz(tamaño)
    }else{
        println("fallo de juego por error de elecion de tiempo")
        exitProcess(1);
    }


    //pedir tiempo
    var tiempo : Int = pedirTiempo()


    //pila de 200 items
     var items : Pila<Item> = crearPilaDeItems()

    //hacer dos equipos cola o fifois

    var equipo1 : Cola<Personaje> = crearEquipo()
    var equipo2 : Cola<Personaje> = crearEquipo()

    //constructor de personajes a parte y llamar al contructor aleatorio

    //loop de juego que comienza que

    //se inicia la matriz y se rrellename

    //cada 5 se repone

    //cada segundo sale un jugador  y pasa la logical y se comprueva que nadie haya ganado

    //se imprime el resultado







}

fun crearEquipo(): Cola<Personaje> {
    var equipo : Cola<Personaje> = Cola()
    for(i in 0 until 3){
        equipo.push(crearPersonaje())
    }
return equipo!!
}

fun crearPersonaje(): Personaje {

    var personaje1 : Personaje

    var elecion : Int = Random.nextInt(3)
    when(elecion){
        is 1 ->personaje1 =  Elfo( )
        is 2 ->personaje1 = Trasgo()
        else 3 -> personaje1 = Humano()
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
    }while (correcto)
    println("perfecto tu tablero sera de $numero casillas de alto y ancho")

    //logger.info("tamaño de tablero elegigo")
    return numero
}
