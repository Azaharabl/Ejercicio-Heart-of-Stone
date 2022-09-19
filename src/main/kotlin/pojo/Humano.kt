package pojo

import Enums.NombreHumano
import kotlin.random.Random
import kotlin.random.nextInt

class Humano (

    vida: Int = 60,
    caballo : Boolean = Random.nextInt(1)==0,
    nombre : String = "Humano",
    ):Personaje(vida = vida, nombre = nombre ){

    var escudo : Int = Random.nextInt(100)

    }
