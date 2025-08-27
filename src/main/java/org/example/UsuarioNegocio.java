package org.example;

public class UsuarioNegocio {
    private UsuarioRepository rep;
    public UsuarioNegocio(UsuarioRepository repo){
        this.rep=repo;
    }

    public Usuario adicionar(Usuario u){
        if(this.rep.buscarPorTelefone(u.getTelefone())){
            return null;
        }

        if(this.rep.buscarPorEmail(u.getEmail())){
            return null;
        }
        if(u.getNome() == null || u.getNome().trim().isEmpty()){
            return null;
        }

        if(u.getEndereco() == null || u.getEndereco().trim().isEmpty()){
            return null;
        }

        if(u.getDataNascimento() == null ){
            return null;
        }

        if(u.getEmail() == null || u.getEmail().trim().isEmpty()){
            return null;
        }

        if(u.getTelefone() == null || u.getTelefone().trim().isEmpty()){
            return null;
        }

        if(verificarSenhaForte(u.getSenha())){
            return null;
        }
        return this.rep.inserir(u);
    }

    private boolean verificarSenhaForte(String senha){
        int upper=0;
        int lower=0;
        int digit=0;
        int especial=0;

        if(senha.length()>=14){
            for (int i = 0; i < senha.length(); i++) {
                char c=senha.charAt(i);
                if (Character.isUpperCase(c)){
                    upper++;
                } else if (Character.isLowerCase(c)) {
                    lower++;

                } else if (Character.isDigit(c)) {
                    digit++;
                } else if (!Character.isLetterOrDigit(c)) {
                    especial++;
                }

            }
        }

        if (upper>0 && lower>0 && digit>0 && especial>0){
            return  false;
        }
        return true;
    }
}
