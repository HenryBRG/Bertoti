package controller;

import model.Usuario;
import view.PerfilView;

public class PerfilController {
    private Usuario usuario;
    private PerfilView view;
    
    public PerfilController(Usuario usuario, PerfilView view) {
        this.usuario = usuario;
        this.view = view;
    }
    
    public void exibirPerfil() {
        view.mostrarPerfil(usuario);
    }
    
    public void adicionarPostagem(String conteudo) {
        usuario.adicionarComponente(new Postagem(conteudo));
    }
}