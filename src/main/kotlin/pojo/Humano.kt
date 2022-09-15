package pojo

import kotlin.random.Random

class Humano (
    escudos : Int = Random.nextInt(100),
    vida: Int = 60,
    caballo : Boolean = Random.nextInt(1)==0,
    id : String,
    fechaCreacion : String,
    nivel : Int,
    nombre : String = "Humano",
    ):Personaje(id, fechaCreacion ,vida, nivel, nombre  ){

}