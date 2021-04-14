package ar.edu.unahur.obj2.vendedores

import java.lang.Exception
//ciudad actual es de tipo ciudad
class CentroDeDistribucion(val ciudadActual: Ciudad) {
    //vendedoresConLosQueTrabajan es de tipo lista
    val vendedoresConLosQueTrabajan = mutableListOf<Vendedor>()

    //no devuelve nada
    fun agregarVendedor(vendedor: Vendedor) {
        if (this.estaRegistrado(vendedor)){
            throw Exception("el vendedor está registrado")
        }
        vendedoresConLosQueTrabajan.add(vendedor)
    }
    //No devuelve nada
    fun sacarVendedor(vendedor: Vendedor) = vendedoresConLosQueTrabajan.remove(vendedor)

    //devuelve boleano
    fun estaRegistrado(vendedor: Vendedor) = vendedoresConLosQueTrabajan.contains(vendedor)
}