package interfaces

interface IPila<T> {

    fun isEmpty():Boolean

    fun popOrNull():T?

    fun push(entity:T) : Boolean
}