package Clases.Rutas

import Clases.InterfacesDeAsignacion.Asignacion
import Clases.InterfacesDeGestion.Gestion
import Clases.InterfacesDeListas.ListaInfo
import Clases.Unidades.Unidad


class Ruta : Gestion, Asignacion, ListaInfo {
    private val letra: String? = null
    private val disponibilidad = false
    private val m_PuntoDeRuta: PuntoDeRuta? = null
    var m_Unidad: Unidad? = null

    constructor() {}

    @Throws(Throwable::class)
    fun finalize() {
    }

    /**
     *
     * @param letra
     */
    constructor(letra: String?) {}

    /**
     *
     * @param ruta
     */
    fun actualizar(ruta: Ruta?) {}

    /**
     *
     * @param cadena
     * @param disponibilidad
     */
    override fun actualizarDisp(cadena: String?, disponibilidad: Boolean) {}

    /**
     *
     * @param letra
     */
    override fun eliminar(letra: String?) {}

    /**
     *
     * @param punto_Destino
     * @param punto_Origen
     */
    fun identificarRutas(punto_Destino: Float, punto_Origen: Float): Ruta? {
        return null
    }

    fun listar(): String {
        return ""
    }

    /**
     *
     * @param disponibilidad
     */
    fun listarRutasDisp(disponibilidad: Boolean): String {
        return ""
    }

    override fun mostrar(): Ruta? {
        return null
    }

    /**
     *
     * @param letra
     */
    override fun recuperarDatos(letra: String?): Ruta? {
        return null
    }

    /**
     *
     * @param letra
     */
    fun validar(letra: String?): Boolean {
        return false
    }

    /**
     *
     * @param Object
     */
    override fun actualizar(Object: Any?) {}
} //end gestionarRutas
