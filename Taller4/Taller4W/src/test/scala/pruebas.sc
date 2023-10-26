/*
Taller #4:

Wilson Andrés Mosquera Zapata <202182116>
Angie Natalia Córdoba Collazos <202124366>

26/10/2023

Archivo: pruebas.sc
*/

import SubsecuenciaMasLarga._

subindices(2,3)
subindices(0,3)
subindices(1,4)
subindices(4,8)
subindices(9,9)

val s = Seq(20,30,10,40,15,16,17)
subSecuenciaAsoc(s,Seq())
subSecuenciaAsoc(s,Seq(0,2,4))
subSecuenciaAsoc(s,Seq(1,2,4,6))
subSecuenciaAsoc(s,Seq(0,6))
subSecuenciaAsoc(s,Seq(2,4,6))

subSecuenciasDe(Seq(20,30,10))
subSecuenciasDe(Seq(2, 3, 1))
subSecuenciasDe(Seq(1,5,3,7,9))
subSecuenciasDe(Seq(15,20,5,25))
subSecuenciasDe(Seq(10,10000,1000,100))

val s1 = Seq(1,2,3,4,5)
val s2 = Seq(2,4,8,6)
val s3 = Seq(2,2,2,2,1)
val s4 = Seq(10,5,15)
val s5 = Seq()

incremental(s1)
incremental(s2)
incremental(s3)
incremental(s4)
incremental(s5)

subSecuenciasInc(s)
subSecuenciasInc(Seq(20,30,10))
subSecuenciasInc(Seq(1,2,6,5))
subSecuenciasInc(Seq(10,1000,100,10000))
subSecuenciasInc(Seq(2,4,6,8))
subSecuenciasInc(Seq())

subsecuenciaIncrementalMasLarga(s)
subsecuenciaIncrementalMasLarga(Seq(20,30,10))
subsecuenciaIncrementalMasLarga(Seq(100,1000,10000,1,10))
subsecuenciaIncrementalMasLarga(Seq(1,2,3,4,5,100,2,4,6))

ssimlComenzandoEn(4, Seq(10,9,8,7,6,5,4,3,2,1,22,21,20,19,18,17,16,15,14,13,12,11))
ssimlComenzandoEn(12, Seq(10,9,8,7,6,5,4,3,2,1,22,21,20,19,18,17,16,15,14,13,12,11))
ssimlComenzandoEn(0, Seq(7,6,5,4,3,2,1))
ssimlComenzandoEn(2, Seq(1,2,3,4,5,6,7))
ssimlComenzandoEn(0, Seq(1,1,1,1,1,1,1))

subSecIncMasLargaV2(Seq(20,30,10,40,15,16,17))
subSecIncMasLargaV2(Seq(20,30,10))
subSecIncMasLargaV2(Seq(10,20,30))
subSecIncMasLargaV2(Seq(20,30,10,40,15,16,17,11))
subSecIncMasLargaV2(Seq(14,10,15,20))
