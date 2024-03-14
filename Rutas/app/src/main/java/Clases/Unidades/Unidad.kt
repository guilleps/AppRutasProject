package Clases.Unidades

import Clases.Choferes.Chofer
import Clases.Rutas.Ruta
import Clases.InterfacesDeGestion.Gestion
import Clases.InterfacesDeListas.ListaInfo


class Unidad : Gestion, ListaInfo {
    private val nro_vehiculo: String? = null
    private val placa: String? = null
    private val capacidad = 0
    var m_ruta: Ruta? = null
    var m_Chofer: Chofer? = null

    constructor() {}

    @Throws(Throwable::class)
    fun finalize() {
    }

    /**
     *
     * @param nro_vehiculo
     * @param placa
     * @param capacidad
     * @param ruta
     * @param chofer
     */
    constructor(
        nro_vehiculo: String?,
        placa: String?,
        capacidad: Int,
        ruta: Ruta?,
        chofer: Chofer?
    ) {
    }

    /**
     *
     * @param unidad
     */
    fun actualizar(unidad: Unidad?) {}

    /**
     *
     * @param nro_vehiculo
     */
    override fun eliminar(nro_vehiculo: String?) {}

    /**
     *
     * @param letra
     */
    fun identificarUnidades(letra: String?): String {
        return ""
    }

    /**
     *
     * @param nro_vehiculo
     */
    fun listar(nro_vehiculo: String?): Unidad? {
        return null
    }

    /**
     *
     * @param String
     */
    fun buscar(String: String?): String {
        return ""
    }

    /**
     *
     * @param nro_vehiculo
     */
    override fun recuperarDatos(nro_vehiculo: String?): Unidad? {
        return null
    }

    /**
     *
     * @param num_vehiculo
     * @param placa
     */
    fun validarUnidad(num_vehiculo: String?, placa: String?): Boolean {
        return false
    }

    override fun mostrar(): Unidad? {
        return null
    }

    /**
     *
     * @param Object
     */
    override fun actualizar(Object: Any?) {}
} //end gestionarUnidades
