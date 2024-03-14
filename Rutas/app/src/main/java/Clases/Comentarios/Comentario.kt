package Clases.Comentarios

import Clases.Rutas.Ruta
import Clases.Usuarios.Usuario

class Comentario {
    private val comentario: String? = null
    var m_Usuario: Usuario? = null
    var m_Ruta: Ruta? = null

    constructor() {}

    @Throws(Throwable::class)
    fun finalize() {
    }

    /**
     *
     * @param descripcion
     */
    constructor(descripcion: String?) {}

    /**
     *
     * @param letra_asign
     */
    fun filtrar(letra_asign: String?): Comentario? {
        return null
    }

    fun listarComentarios(): Comentario? {
        return null
    }

    /**
     *
     * @param Comentario
     */
    fun publicarComentario(Comentario: Comentario?) {}
} //end Foro
