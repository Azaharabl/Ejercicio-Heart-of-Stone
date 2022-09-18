package TDA

import interfaces.IMatrid
import pojo.Item
import java.lang.StringBuilder

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

    override fun toString(): String {
        var matrizToString = StringBuilder()
        matrizToString.append("\n \n")
        for (i in 0 until m.size) {
            matrizToString.append( " [")
            for (j in 0 until m.size) {
                var h : Item?= m[i][j]
                matrizToString.append(  " ( ${h} )")
            }
            matrizToString.append( " ] \n")
        }
        return matrizToString.toString()
    }


}