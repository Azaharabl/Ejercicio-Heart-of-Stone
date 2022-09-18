package TDA

import interfaces.ICola
import interfaces.IPila
import java.util.*

class Pila<T>() : IPila<T> {

    var pila = Stack<T>()

    override fun isEmpty(): Boolean {
        return pila.empty()
    }

    override fun popOrNull(): T? {
        return pila.pop()
    }

    override fun push(entity: T): Boolean {
        if (entity != null) {
            pila.push(entity)
            return true
        } else {
            return false
        }
    }
}