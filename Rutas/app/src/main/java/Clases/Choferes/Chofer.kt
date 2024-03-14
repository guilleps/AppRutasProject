package Clases.Choferes
import Clases.InterfacesDeAsignacion.Asignacion
import Clases.InterfacesDeGestion.Gestion


class Chofer : Gestion, Asignacion {
    private val nombre: String? = null
    private val apellido: String? = null
    private val DNI: String? = null
    private val num_licencia: String? = null
    private val categoria: String? = null
    private val disponibilidad = false

    constructor() {}

    @Throws(Throwable::class)
    fun finalize() {
    }

    /**
     *
     * @param apellido
     * @param categoria
     * @param disponibilidad
     * @param DNI
     * @param nombre
     * @param num_licencia
     */
    constructor(
        apellido: String?,
        categoria: String?,
        disponibilidad: Boolean,
        DNI: String?,
        nombre: String?,
        num_licencia: String?
    ) {
    }

    /**
     *
     * @param chofer
     */
    fun actualizar(chofer: Chofer?) {}

    /**
     *
     * @param String
     * @param disponibilidad
     */
    override fun actualizarDisp(String: String?, disponibilidad: Boolean) {}

    /**
     *
     * @param String
     */
    fun buscar(String: String?): String {
        return ""
    }

    /**
     *
     * @param DNI
     */
    override fun eliminar(DNI: String?) {}
    fun mostrar(): String {
        return ""
    }

    /**
     *
     * @param DNI
     */
    override fun recuperarDatos(DNI: String?): Chofer? {
        return null
    }

    /**
     *
     * @param num_licencia
     * @param DNI
     */
    fun validarChofer(num_licencia: String?, DNI: String?) {}

    /**
     *
     * @param Object
     */
    override fun actualizar(Object: Any?) {}
} //end Clases.Choferes.Chofer
