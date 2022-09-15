package TDA

import interfaces.IMatrid
import pojo.Item

class Matriz(tamaño : Int ) : IMatrid{

    var matrid = ArrayList<ArrayList<Item>>()

    init {

            for (i in 0 until tamaño) {
                var fila : ArrayList<Item?>
                for (j in 0 until tamaño) {
                    fila.add(null)
                }
            matrid.add(fila);
        }

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