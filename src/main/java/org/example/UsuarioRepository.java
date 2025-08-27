package org.example;

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
    public boolean verificarExistenciaNome(){
        boolean found = false;
        for (Usuario u:usuarios){
            if(!u.getNome().isEmpty()){
                found =true;
                break;
            }
        }
        return found;
    }

    public boolean verificarExistenciaEndereco(){
        boolean found = false;
        for (Usuario u:usuarios){
            if(!u.getEndereco().isEmpty()){
                found =true;
                break;
            }
        }
        return found;
    }

    public boolean verificarExistenciaDataNascimento(){
        boolean found = false;
        for (Usuario u:usuarios){
            if(u.getDataNascimento()!=null){
                found =true;
                break;
            }
        }
        return found;
    }
    public boolean verificarExistenciaEmail(){
        boolean found = false;
        for (Usuario u:usuarios){
            if(!u.getEmail().isEmpty()){
                found =true;
                break;
            }
        }
        return found;
    }

    public boolean verificarExistenciaTelefone(){
        boolean found = false;
        for (Usuario u:usuarios){
            if(!u.getTelefone().isEmpty()){
                found =true;
                break;
            }
        }
        return found;
    }

}
