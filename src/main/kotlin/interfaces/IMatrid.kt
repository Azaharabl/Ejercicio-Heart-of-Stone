package interfaces

interface IMatrid<T>{

    fun verCasilla (diagonal: Int, horizontal: Int): T?

    fun cojerItemOrNull (diagonal: Int, horizontal: Int): T?



}