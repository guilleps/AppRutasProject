package Clases.Horarios

import Clases.InterfacesDeGestion.Gestion
import Clases.InterfacesDeListas.ListaInfo
import Clases.Rutas.Ruta

class Horario : Gestion, ListaInfo {
    private val frecuencia = 0
    private val hora_priBus: String? = null
    private val hora_ultBus: String? = null
    var m_Ruta: Ruta? = null

    constructor() {}

    @Throws(Throwable::class)
    fun finalize() {
    }

    /**
     *
     * @param hora_ultBus
     * @param hora_priBus
     * @param frecuencia
     */
    constructor(hora_ultBus: String?, hora_priBus: String?, frecuencia: Int) {}

    /**
     *
     * @param horario
     */
    fun actualizar(horario: Horario?) {}

    /**
     *
     * @param letra
     */
    override fun eliminar(letra: String?) {}
    fun listar(): Int {
        return 0
    }

    override fun mostrar(): Horario? {
        return null
    }

    /**
     *
     * @param letra
     */
    override fun recuperarDatos(letra: String?): Horario? {
        return null
    }

    /**
     *
     * @param Object
     */
    override fun actualizar(Object: Any?) {}
} //end gestionarHorarios
