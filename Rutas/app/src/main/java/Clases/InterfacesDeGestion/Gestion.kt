package Clases.InterfacesDeGestion

interface Gestion {
    /**
     *
     * @param cadena
     */
    fun recuperarDatos(cadena: String?): Any?

    /**
     *
     * @param Object
     */
    fun actualizar(Object: Any?)

    /**
     *
     * @param cadena
     */
    fun eliminar(cadena: String?)
}