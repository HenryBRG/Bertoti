public class Main {
    public static void main(String[] args) {
        // Model
        Publicador publicador = new Publicador();
        Usuario usuario = new Usuario("Maria");
        usuario.adicionarComponente(new Postagem("Minha primeira postagem"));
        
        // View
        NotificacaoView view = new NotificacaoView();
        
        // Controller
        NotificacaoController controller = new NotificacaoController(publicador, view);
        
        publicador.adicionarObservador(usuario);
        controller.enviarNotificacao("Novo seguidor!");
        
        usuario.exibirPerfil();
    }
}