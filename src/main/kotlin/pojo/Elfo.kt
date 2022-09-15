package pojo

import java.time.LocalDateTime

class Elfo (vida : Int = 50,
            inmortalidad : Int = 10,
            id: String ,
            fechaCreacion: String ,
            nivel: Int,
            nombre: String = "Elfo",
            vararg item: Item

): Personaje(id,fechaCreacion,nivel,nombre = "Elfo") {


}