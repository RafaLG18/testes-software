package cadastro;

import org.example.Usuario;
import org.example.UsuarioNegocio;
import org.example.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class Tests {
    private UsuarioRepository usuarioRep;

    @BeforeEach
    public void CreateRepository(){
        this.usuarioRep=mock(UsuarioRepository.class);
    }
    @Test
    public void cadastroCamposValidos(){
        Usuario u = new Usuario("Usuario da Silva",
                "Rua da Imperatriz,199",
                "20/06/1994",
                "usuario@gmail.com",
                "(81)99999-9999",
                "3xCf%12AkGtUmnhg!@as");
        UsuarioNegocio neg= new UsuarioNegocio(usuarioRep);

        when(usuarioRep.inserir(u)).thenReturn(u);

        Usuario uAdd= neg.adicionar(u);
        Assertions.assertNotNull(uAdd);
    }
    @Test
    public void cadastroTelefoneExistente(){
        Usuario u = new Usuario("Usuario da Silva",
                "Rua da Imperatriz,199",
                "20/06/1994",
                "usuario@gmail.com",
                "(81)99999-9999",
                "3xCf%12AkGtUmnhg!@as");
        UsuarioNegocio neg= new UsuarioNegocio(usuarioRep);
        when(usuarioRep.buscarPorTelefone(u.getTelefone())).thenReturn(true);
        when(usuarioRep.inserir(u)).thenReturn(u);
        Usuario uCad=neg.adicionar(u);
        verify(usuarioRep, times(0)).inserir(u);
        Assertions.assertNull(uCad);
    }
    @Test
    public void cadastroEmailExistente(){
        Usuario u = new Usuario("Usuario da Silva",
                "Rua da Imperatriz,199",
                "20/06/1994",
                "usuario@gmail.com",
                "(81)99999-9991",
                "3xCf%12AkGtUmnhg!@as");
        UsuarioNegocio neg= new UsuarioNegocio(usuarioRep);
        when(usuarioRep.buscarPorEmail(u.getEmail())).thenReturn(true);
        when(usuarioRep.inserir(u)).thenReturn(u);
        Usuario uCad=neg.adicionar(u);
        verify(usuarioRep, times(0)).inserir(u);
        Assertions.assertNull(uCad);
    }
    @Test
    public void cadastroFaltandoNome(){
        Usuario u = new Usuario("",
                "Rua da Imperatriz,199",
                "20/06/1994",
                "usuario-1@gmail.com",
                "(81)99999-9992",
                "3xCf%12AkGtUmnhg!@as");
        UsuarioNegocio neg= new UsuarioNegocio(usuarioRep);
        when(usuarioRep.verificarExistenciaNome()).thenReturn(false);
        when(usuarioRep.inserir(u)).thenReturn(u);
        Usuario uCad=neg.adicionar(u);
        verify(usuarioRep, times(0)).inserir(u);
        Assertions.assertNull(uCad);
    }
    @Test
    public void cadastroFaltandoEndereco(){
        Usuario u = new Usuario("Usuario da Silva",
                "",
                "20/06/1994",
                "usuario-2@gmail.com",
                "(81)99999-9993",
                "3xCf%12AkGtUmnhg!@as");
        UsuarioNegocio neg= new UsuarioNegocio(usuarioRep);
        when(usuarioRep.verificarExistenciaEndereco()).thenReturn(false);
        when(usuarioRep.inserir(u)).thenReturn(u);
        Usuario uCad=neg.adicionar(u);
        verify(usuarioRep, times(0)).inserir(u);
        Assertions.assertNull(uCad);
    }
    @Test
    public void cadastroFaltandoData(){
        Usuario u = new Usuario("Usuario da Silva",
                "Rua da Imperatriz,199",
                "",
                "usuario-3@gmail.com",
                "(81)99999-9994",
                "3xCf%12AkGtUmnhg!@as");
        UsuarioNegocio neg= new UsuarioNegocio(usuarioRep);
        when(usuarioRep.verificarExistenciaDataNascimento()).thenReturn(false);
        when(usuarioRep.inserir(u)).thenReturn(u);
        Usuario uCad=neg.adicionar(u);
        verify(usuarioRep, times(0)).inserir(u);
        Assertions.assertNull(uCad);
    }
    @Test
    public void cadastroFaltandoEmail(){
        Usuario u = new Usuario("Usuario da Silva",
                "Rua da Imperatriz,199",
                "20/06/1994",
                "",
                "(81)99999-9995",
                "3xCf%12AkGtUmnhg!@as");
        UsuarioNegocio neg= new UsuarioNegocio(usuarioRep);
        when(usuarioRep.verificarExistenciaEmail()).thenReturn(false);
        when(usuarioRep.inserir(u)).thenReturn(u);
        Usuario uCad=neg.adicionar(u);
        verify(usuarioRep, times(0)).inserir(u);
        Assertions.assertNull(uCad);
    }
    @Test
    public void cadastroFaltandoTelefone(){
        Usuario u = new Usuario("Usuario da Silva",
                "Rua da Imperatriz,199",
                "20/06/1994",
                "usuario-4@gmail.com",
                "",
                "3xCf%12AkGtUmnhg!@as");
        UsuarioNegocio neg= new UsuarioNegocio(usuarioRep);
        when(usuarioRep.verificarExistenciaTelefone()).thenReturn(false);
        when(usuarioRep.inserir(u)).thenReturn(u);
        Usuario uCad=neg.adicionar(u);
        verify(usuarioRep, times(0)).inserir(u);
        Assertions.assertNull(uCad);
    }
    @Test
    public void cadastroSenhaForte(){
        Usuario u = new Usuario("Usuario da Silva",
                "Rua da Imperatriz,199",
                "20/06/1994",
                "usuario-4@gmail.com",
                "(81)99999-9995",
                "3xCf%12AkGtUmnhg!@as");
    }
    @Test
    public void cadastroSenhaFraca(){
        Usuario u = new Usuario("Usuario da Silva",
                "Rua da Imperatriz,199",
                "20/06/1994",
                "usuario-5@gmail.com",
                "(81)99999-9996",
                "1234");
    }
}
