package pojo

import Enums.NombreHumano
import kotlin.random.Random

class Trasgo(
     vida: Int = 40,
     nombre : String = "Trasgo",
    nombreDePila : String = NombreHumano
):Personaje(vida = vida, nombre = nombre  ){

    var maldad : Int = 15
    }

