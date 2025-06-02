public class NotificacaoController {
    private Publicador publicador;
    private NotificacaoView view;
    
    public NotificacaoController(Publicador publicador, NotificacaoView view) {
        this.publicador = publicador;
        this.view = view;
    }
    
    public void enviarNotificacao(String mensagem) {
        publicador.notificarObservadores(mensagem);
        view.mostrarNotificacao("Notificação enviada com sucesso");
    }
}