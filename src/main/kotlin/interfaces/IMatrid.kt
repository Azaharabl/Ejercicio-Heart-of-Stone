package interfaces

interface IMatrid<T>{

    fun verCasilla (diagonal: Int, horizontal: Int): T?

    fun cojerItem (diagonal: Int, horizontal: Int): T?

    fun crearMatriz (diagonal: Int, horizontal: Int): T


}