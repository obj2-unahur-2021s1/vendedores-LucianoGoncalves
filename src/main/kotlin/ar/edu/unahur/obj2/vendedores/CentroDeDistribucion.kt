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

    //devuelve el vendedor con mayor puntaje
    fun vendedorEstrella() = vendedoresConLosQueTrabajan.maxBy { vendedores -> vendedores.puntajeCertificaciones()}

    //devuelve boleano
    fun puedeCubrir(ciudad: Ciudad) = vendedoresConLosQueTrabajan.any{vendedores -> vendedores.puedeTrabajarEn(ciudad)}

    //Devuelve una coleccion de vendedores que son genericos
    fun vendedoresGenericos() = vendedoresConLosQueTrabajan.filter { vendedores -> vendedores.esGenerico() }.toSet()

    //devuelve boleano
    fun esRobusto() = vendedoresConLosQueTrabajan.count{it.esFirme()} >= 3
}