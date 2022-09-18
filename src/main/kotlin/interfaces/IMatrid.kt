package interfaces

import pojo.Item

interface IMatrid<T>{

    fun verCasilla (diagonal: Int, horizontal: Int): T?

    fun cojerItemOrNull (diagonal: Int, horizontal: Int): T?

    fun ponerItemOrNull (diagonal: Int, horizontal: Int, item : Item?)




}