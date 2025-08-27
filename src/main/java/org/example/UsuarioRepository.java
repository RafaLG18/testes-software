package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {

    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public Usuario inserir(Usuario u) {
        this.usuarios.add(u);
        return u;
    }

    public boolean buscarPorTelefone(String telefone){
        boolean found = false;
        for (Usuario u:usuarios){
            if(u.getTelefone().equals(telefone)){
                found =true;
                break;
            }
        }
        return found;
    };

    public boolean buscarPorEmail(String email){
        boolean found = false;
        for (Usuario u:usuarios){
            if(u.getEmail().equals(email)){
                found =true;
                break;
            }
        }
        return found;
    };

}
