/*
Taller #4:

Wilson Andrés Mosquera Zapata <202182116>
Angie Natalia Córdoba Collazos <202124366>

26/10/2023

Archivo: package.scala
*/

package object SubsecuenciaMasLarga {

  type Secuencia = Seq[Int]
  type Subsecuencia = Seq[Int]

//1.1. Solución ingenua usando fuerza bruta.
  def subindices(i: Int, n: Int): Set[Seq[Int]] = {
    // Dados i y n, devuelve todas las posibles secuencias crecientes de enteros entre i y n.

    // Crea una lista de índices en el rango [i, n - 1].
    val indices = (i until n).toList

    // Utiliza una expresión for-comprehension para generar todas las subsecuencias crecientes.
    val subsecuencias = for {
      tamIndice <- 0 to indices.length
      sublista <- indices.combinations(tamIndice)
    } yield sublista

    // Convierte el resultado en un conjunto para eliminar duplicados y devuélvelo.
    subsecuencias.toSet
  }


//1.1.1. Generación de los índices asociados a todas las subsecuencias.
  def subSecuenciaAsoc(s: Secuencia, inds: Seq[Int]): Subsecuencia = {
    // Dadas s, una secuencia, e inds, una secuencia creciente de indices asociada a s,
    // Devuelve la secuencia correspondiente a la secuencia creciente de indices inds
    for {
      indice <- inds // Itera a través de los índices en `inds`.
    } yield s(indice) // Obtiene el elemento correspondiente de la secuencia `s`.
  }


//1.1.2. Generación de todas las subsecuencias de una secuencia.
  def subSecuenciasDe(s: Secuencia): Set[Subsecuencia] = {
    // Dada s , devuelve el conjunto de todas las subsecuencias posibles de s
    val n = s.length
    // Creamos una secuencia de índices desde 0 hasta n - 1.
    val indices = 0 until n

    // Generamos todas las subsecuencias posibles.
    val subsecuencias = (for {
      tamIndice <- 0 to n // Iteramos sobre todas las posibles longitudes de subsecuencias.
      sublistaIndices <- indices.combinations(tamIndice) // Generamos combinaciones de índices para subsecuencias de longitud `tamIndice`.
    } yield subSecuenciaAsoc(s, sublistaIndices)).toSet
    // Luego, aplicamos `subSecuenciaAsoc` para obtener la subsecuencia correspondiente a cada conjunto de índices.
    subsecuencias
  }


//1.1.3. Generación de todas las subsecuencias incrementales de una secuencia.

  def incremental(subsecuencia: Subsecuencia): Boolean = {
    // Utilizamos una expresión for para verificar si la subsecuencia es incremental.
    val resultado = for {
      i <- 1 until subsecuencia.length
      if subsecuencia(i) <= subsecuencia(i - 1) // Comparamos el elemento actual con el anterior.
    } yield i

    resultado.isEmpty // Si no se encontraron elementos en `resultado`, la subsecuencia es incremental.
  }

  def subSecuenciasInc(s: Secuencia): Set[Subsecuencia] = {
    // Utiliza una expresión for para generar todas las subsecuencias de `s` y filtrar las incrementales.
    for {
      subsecuencia <- subSecuenciasDe(s) // Genera todas las subsecuencias de `s`.
      if incremental(subsecuencia) // Filtra solo las subsecuencias que son incrementales.
    } yield subsecuencia
  }


//1.1.4. Hallar la subsecuencia incremental más larga.
  def subsecuenciaIncrementalMasLarga(s: Secuencia): Subsecuencia = {
    val subsecuenciasInc = subSecuenciasInc(s) // Obtenemos todas las subsecuencias incrementales de la secuencia.

    // Utilizamos una expresión for con yield para encontrar la subsecuencia de tamaño máximo.
    val subsecuenciaMaxima = (for {
      subsecuencia <- subsecuenciasInc
    } yield subsecuencia).maxBy(_.length)

    subsecuenciaMaxima
  }


//1.2.1. Calculando SIML(S).
  def ssimlComenzandoEn(i: Int, s: Secuencia): Subsecuencia = {
    // Devuelve la subsecuencia incremental mas larga de s que comienza en s(i)

    val n = s.length

    // Creamos una secuencia de subsecuencias incrementales
    val subsecuencias = for {
      j <- i until n
    } yield {
      s.drop(j).foldLeft((List(s(i)), s(i))) {
        case ((acc, lastElement), s_j) =>
          if (lastElement < s_j) {
            // Si el último elemento es menor que el siguiente elemento, lo agregamos a la subsecuencia
            (acc :+ s_j, s_j)
          } else {
            // Si no es menor, mantenemos la subsecuencia sin cambios y actualizamos el último elemento
            (acc, lastElement)
          }
      }._1 // Extraemos la subsecuencia resultante
    }
    // Elegimos la subsecuencia más larga de todas
    subsecuencias.maxBy(_.length)
  }

  //1.2.2. Calculando una subsecuencia incremental más larga, versión 2.
  def subSecIncMasLargaV2(s: Secuencia): Subsecuencia = {
    val n = s.length // Longitud de la secuencia
    // Creamos una secuencia de subsecuencias incrementales
    val subsecuencias = for {
      i <- 0 until n
    } yield ssimlComenzandoEn(i, s) // Para cada índice, encontramos la subsecuencia incremental más larga

    // Elegimos la subsecuencia más larga de todas
    subsecuencias.maxBy(_.length)
  }

}
