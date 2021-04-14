package ar.edu.unahur.obj2.vendedores

import java.lang.Exception

class CentroDeDistribucion(val ciudad: Ciudad) {
    val vendedoresConLosQueTrabajan = mutableListOf<Vendedor>()
    fun agregarVendedor(vendedor: Vendedor) {
        if (this.estaRegistrado(vendedor)){
            throw Exception("el vendedor está registrado")
        }
        vendedor.add(vendedor)
    }

    fun sacarVendedor(vendedor: Vendedor) = vendedor.remove(vendedor)
}