package TDA

import interfaces.IMatrid
import pojo.Item

class Matriz(tamaño : Int ) : IMatrid<Item?>{



   var m  : Array<Array<Item?>> = Array(tamaño) { Array<Item?>(tamaño) {null} }



    override fun verCasilla(diagonal: Int, horizontal: Int): Item? {
      return m[diagonal][horizontal]

    }

    override fun cojerItemOrNull(diagonal: Int, horizontal: Int): Item? {
        var casilla : Item? = m.get(diagonal)[horizontal]
        m.get(diagonal)[horizontal] = null
        return casilla
    }

    override fun ponerItemOrNull(diagonal: Int, horizontal: Int, item : Item? ) {
        m.get(diagonal)[horizontal] = item
    }


}