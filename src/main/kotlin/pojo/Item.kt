package pojo

import java.time.LocalDateTime
import java.util.*

class Item
     (
    /* cambiado para poder llamar desde main
        id: String = UUID.randomUUID().toString(),
        fechaCreacion : LocalDateTime = LocalDateTime.now(),
        nivel: Int = Random().nextInt(3),
        tipo : Tipo = Tipo.values().get(Random().nextInt(4)),
        */
        ){
        val id: String = UUID.randomUUID().toString()
        val fechaCreacion : LocalDateTime = LocalDateTime.now()
        val nivel: Int = Random().nextInt(3)
        val tipo : Tipo = Tipo.values().get(Random().nextInt(4))


    override fun toString(): String {
        return " [$tipo]"
    }

    fun imprimirDetalle(): String{
        return  "[Item de $tipo de nivel $nivel creado en $fechaCreacion]. "
    }

}
