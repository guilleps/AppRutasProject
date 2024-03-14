package Clases.Usuarios

class Usuario {
    private val nombre: String? = null
    private val apellido: String? = null
    private val correo: String? = null
    private val contrasena: String? = null
    private val celular: String? = null
    private val tipoUsuario: String? = null

    constructor() {}

    @Throws(Throwable::class)
    fun finalize() {
    }

    /**
     *
     * @param contrasena
     * @param correo
     * @param apellido
     * @param nombre
     */
    constructor(contrasena: String?, correo: String?, apellido: String?, nombre: String?) {}

    /**
     *
     * @param usuario
     */
    fun actualizar(usuario: Usuario?) {}

    /**
     *
     * @param correo
     */
    fun buscarCorreo(correo: String?): Boolean {
        return false
    }

    fun mostrar(): Usuario? {
        return null
    }

    /**
     *
     * @param correo
     */
    fun validar(correo: String?): Boolean {
        return false
    }

    /**
     *
     * @param contrasena
     * @param correo
     */
    fun validarCredenciales(contrasena: String?, correo: String?): Boolean {
        return false
    }

    /**
     *
     * @param correo
     * @param celular
     */
    fun validarRepetidos(correo: String?, celular: String?): Boolean {
        return false
    }

    /**
     *
     * @param String
     */
    fun validarTipo(String: String?): String {
        return ""
    }

    /**
     *
     * @param String
     */
    fun validarNuevaContrasena(String: String?): Boolean {
        return false
    }

    /**
     *
     * @param String
     */
    fun actualizarContrasena(String: String?) {}
} //end Usuario
