package interfaces

interface IPila<T> {

    fun isEmpty():Boolean

    fun pop():T

    fun push(entity:T)
}