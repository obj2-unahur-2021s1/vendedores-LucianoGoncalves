package ar.edu.unahur.obj2.vendedores
//provincia es de tipo provincia
class Ciudad(val provincia: Provincia)

//poblacion es de tipo numero
class Provincia(val poblacion: Int)

//nombre es de tipo string
class Pais(val nombre: String, val provincia: Provincia )
