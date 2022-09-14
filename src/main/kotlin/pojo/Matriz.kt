package pojo

import interfaces.IMatrid

//pongo object porque quiero que sea singleton
object Matriz : IMatrid {
    lateinit var matriz :ArrayList<ArrayList<Item>>

    init {

        //pedir el tamaño

        val tamaño:Int? = pedirElTamaño()
        var  matriz : ArrayList<ArrayList<Item>>

        //inicializar matriz
        iniciarMatriz(tamaño)

    }

    private fun iniciarMatriz(tamaño: Int?) {
        ArrayList
        for (i in tamaño until){
            ArrayList
        }
    }

    

    ///// llevo dos horas, me falta media, voy por aqui

    private fun pedirElTamaño() : Int? {
       var tamanio : Int?
       var esCorrecto : Boolean = false
        do {
            println("elige el tamaño del tablero entre 6 ,8 o 10")
            tamanio = readLine()?.toIntOrNull()
            if(tamanio ==6 || tamanio==8 || tamanio==10){ esCorrecto=true}
        }while (!esCorrecto)

        return tamanio

    }


    override fun verCasilla(diagonal: Int, horizontal: Int): Item? {
        TODO("Not yet implemented")
    }

    override fun cojerItem(diagonal: Int, horizontal: Int): Item {
        TODO("Not yet implemented")
    }

    override fun crearMatriz(diagonal: Int, horizontal: Int): Matriz {
        TODO("Not yet implemented")
    }

}