package TDA

import interfaces.ICola
import java.util.*

class Cola<T>() : ICola<T> {

    lateinit var cola : Stack<T>

    override fun isEmpty(): Boolean {
        return cola.empty()
    }

    override fun popOrNull(): T? {
       return cola.pop()
    }

    override fun push(entity: T) : Boolean {
       if(entity!=null) {
           cola.push(entity)
           return true
       }else{
           return false
       }
    }


}