package pojo

import interfaces.IPersonaje
import java.time.LocalDateTime
import java.util.*

class Personaje
    (
    id: String = UUID.randomUUID().toString(),
    fechaCreacion : LocalDateTime = LocalDateTime.now(),
    vida :Int ,     //hay que pasarselo
    nivel: Int = Random().nextInt(3),
    nombre : String,
    vararg item: Item

    ) : IPersonaje
{
    override fun mostrarEstado(): String {
        println("falta por rellenar")
        TODO("Not yet implemented")
    }


}