package interfaces

interface ICola<T> {

    fun isEmpty():Boolean

    fun popOrNull():T?

    fun push(entity:T): Boolean

    fun verCasilla(int : Int) : T?

}