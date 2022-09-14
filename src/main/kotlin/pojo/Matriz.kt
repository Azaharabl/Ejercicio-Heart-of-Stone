package pojo

import interfaces.IMatrid

//pongo object porque quiero que sea singleton
object Matriz : IMatrid {
    init {

        val tamaño:Int =
        var  matriz : MutableList<MutableList<Item>>

    }


    override fun verCasilla(diagonal: Int, horizontal: Int): Item? {
        TODO("Not yet implemented")
    }

    override fun cojerItem(diagonal: Int, horizontal: Int): Item {
        TODO("Not yet implemented")
    }

    override fun crearMatriz(diagonal: Int, horizontal: Int): Matriz {
        TODO("Not yet implemented")
    }

}