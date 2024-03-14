package Clases.Tarifas

import Clases.InterfacesDeGestion.Gestion
import Clases.InterfacesDeListas.ListaInfo

class Tarifa : Gestion, ListaInfo {
    private val descripcion: String? = null
    private val precio = 0f
    private val tipo_tarifa: String? = null
    private val restriccion: String? = null

    constructor() {}

    @Throws(Throwable::class)
    fun finalize() {
    }

    /**
     *
     * @param tipo_tarifa
     * @param precio
     * @param descripcion
     * @param restriccion
     */
    constructor(tipo_tarifa: String?, precio: Float, descripcion: String?, restriccion: String?) {}

    /**
     *
     * @param tarifa
     */
    fun actualizar(tarifa: Tarifa?) {}

    /**
     *
     * @param tipo_tarifa
     */
    override fun eliminar(tipo_tarifa: String?) {}
    override fun mostrar(): Tarifa? {
        return null
    }

    fun listar(): String {
        return ""
    }

    /**
     *
     * @param tipo_tarifa
     */
    override fun recuperarDatos(tipo_tarifa: String?): Tarifa? {
        return null
    }

    /**
     *
     * @param tipo_tarifa
     */
    fun validar(tipo_tarifa: String?): Boolean {
        return false
    }

    /**
     *
     * @param Object
     */
    override fun actualizar(Object: Any?) {}
} //end gestionarTarifa
