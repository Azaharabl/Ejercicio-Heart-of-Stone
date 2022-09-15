package interfaces

interface ICola<T> {

    fun isEmpty():Boolean

    fun pop():T

    fun push(entity:T)
}