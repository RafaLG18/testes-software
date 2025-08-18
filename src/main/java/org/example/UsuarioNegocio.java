package org.example;

public class UsuarioNegocio {
    private UsuarioRepository rep;
    public UsuarioNegocio(UsuarioRepository repo){
        this.rep=repo;
    }

    public Usuario adicionar(Usuario u){
        return this.rep.inserir(u);
    }
}
