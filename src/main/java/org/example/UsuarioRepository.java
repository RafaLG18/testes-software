package org.example;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {

    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public Usuario inserir(Usuario u) {
        this.usuarios.add(u);
        return u;
    }

}
