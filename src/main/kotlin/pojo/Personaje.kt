package pojo

import interfaces.IPersonaje
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

open class Personaje(vida: Int, nombre: String) : IPersonaje
{
    var vida : Int = vida
    var nombre : String = nombre
    var id: String = UUID.randomUUID().toString()
    var fechaCreacion: String = LocalDateTime.now().toString()
    var nivel: Int = Random().nextInt(3)
    var items = ArrayList<Item>()

    override fun mostrarEstado(): String {
        var listaOrdenada : List<Item> = items.sortedBy { T -> T.fechaCreacion }

        return "Personaje(vida=$vida, nombre='$nombre', id='$id', fechaCreacion='$fechaCreacion', nivel=$nivel," +
                " items=$listaOrdenada})"
    }





}