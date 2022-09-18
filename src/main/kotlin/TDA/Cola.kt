package TDA

import interfaces.ICola
import java.util.*

class Cola<T>() : ICola<T> {

     var cola = Stack<T>()

    override fun isEmpty(): Boolean {
        return cola.empty()
    }

    override fun popOrNull(): T? {
       return cola.pop()
    }

    override fun verCasilla(int : Int): T? {
        return cola.get(int)
        //todo no se si quitara o solo
        //falla aqui y no se como hacer que no
    }

    override fun push(entity: T) : Boolean {
       if(entity!=null) {
           cola.add(0,entity)
           return true
       }else{
           return false
       }
    }

    override fun toString(): String {
        return "Cola = $cola)"
    }


}