package pojo

import interfaces.IPersonaje
import java.time.LocalDateTime
import java.util.*

open class Personaje(
    id: String = UUID.randomUUID().toString(),
    fechaCreacion: String = LocalDateTime.now().toString(),
    vida:Int,     //hay que pasarselo
    nivel: Int = Random().nextInt(3),
    nombre: String,    //hay que pasarselo
    vararg item: Item,

    ) : IPersonaje
{


    override fun mostrarEstado(): String {
        println("falta por rellenar")
        TODO("Not yet implemented")
    }


}