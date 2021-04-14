package ar.edu.unahur.obj2.vendedores
//esDeProducto es tipo boleano
//puntaje es tipo numero
class Certificacion(val esDeProducto: Boolean, val puntaje: Int)

abstract class Vendedor {
  // Acá es obligatorio poner el tipo de la lista, porque como está vacía no lo puede inferir.
  // Además, a una MutableList se le pueden agregar elementos
  val certificaciones = mutableListOf<Certificacion>()

  // Definimos el método abstracto.
  // Como no vamos a implementarlo acá, es necesario explicitar qué devuelve.
  abstract fun puedeTrabajarEn(ciudad: Ciudad): Boolean

  // En las funciones declaradas con = no es necesario explicitar el tipo
  //devuelve boleano
  fun esVersatil() =
    certificaciones.size >= 3
      && this.certificacionesDeProducto() >= 1
      && this.otrasCertificaciones() >= 1

  // Si el tipo no está declarado y la función no devuelve nada, se asume Unit (es decir, vacío)
  //certificacion es de tipo certficacion
  //no devuelve nada
  fun agregarCertificacion(certificacion: Certificacion) {
    certificaciones.add(certificacion)
  }

  //no devuelve nada
  fun sacarCertificacion(certificacion: Certificacion) {
    certificaciones.remove(certificacion)
  }

  //devuelve boleano
  fun esFirme() = this.puntajeCertificaciones() >= 30

  //devuelve un numero
  fun certificacionesDeProducto() = certificaciones.count { it.esDeProducto }

  //devuelve un numero
  fun otrasCertificaciones() = certificaciones.count { !it.esDeProducto }

  //devuelve un numero
  fun puntajeCertificaciones() = certificaciones.sumBy { c -> c.puntaje }

  //devuelve boleano
  abstract fun esInfluyente() : Boolean

  //Devuelve boleano
  fun esGenerico() = this.otrasCertificaciones() >= 1
}

// En los parámetros, es obligatorio poner el tipo
class VendedorFijo(val ciudadOrigen: Ciudad) : Vendedor() {

  //devuelve boleano
  override fun puedeTrabajarEn(ciudad: Ciudad): Boolean {
    return ciudad == ciudadOrigen
  }

  //devuelve boleano
  override fun esInfluyente() = false
}

// A este tipo de List no se le pueden agregar elementos una vez definida
class Viajante(val provinciasHabilitadas: List<Provincia>) : Vendedor() {

  //devuelve boleano
  override fun puedeTrabajarEn(ciudad: Ciudad): Boolean {
    return provinciasHabilitadas.contains(ciudad.provincia)
  }
  //devuelve boleano
  override fun esInfluyente() = provinciasHabilitadas.sumBy { it.poblacion } >= 10000000
}

//ciudades es de tipo lista
class ComercioCorresponsal(val ciudades: List<Ciudad>) : Vendedor() {

  //devuelve boleano
  override fun puedeTrabajarEn(ciudad: Ciudad): Boolean {
    return ciudades.contains(ciudad)
  }
  //devuelve un conjunto de listas
  fun provinciasEnDondeHaySucursales() = ciudades.map { it.provincia }.toSet()

  //devuelve boleano
  override fun esInfluyente() = ciudades.toSet().size >= 5 || this.provinciasEnDondeHaySucursales().size >= 3
}
