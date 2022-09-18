package pojo

import kotlin.random.Random

class Humano (
    escudos : Int = Random.nextInt(100),
    vida: Int = 60,
    caballo : Boolean = Random.nextInt(1)==0,
    nombre : String = "Humano",
    ):Personaje(vida = vida, nombre = nombre ){

}