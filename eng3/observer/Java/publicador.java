import java.util.ArrayList;
import java.util.List;

public class Publicador {
    private List<Observador> observadores = new ArrayList<>();
    
    public void adicionarObservador(Observador o) {
        observadores.add(o);
    }
    
    public void removerObservador(Observador o) {
        observadores.remove(o);
    }
    
    public void notificarObservadores(String mensagem) {
        for (Observador o : observadores) {
            o.atualizar(mensagem);
        }
    }
}