package view;

import model.Usuario;

public class PerfilView {
    public void mostrarPerfil(Usuario usuario) {
        System.out.println("\n=== PERFIL ===");
        System.out.println("Usuário: " + usuario.getNome());
        usuario.exibirPerfil();
        System.out.println("==============");
    }
}