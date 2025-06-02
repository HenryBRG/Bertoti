import java.util.ArrayList;
import java.util.List;

public class Usuario implements Observador {
    private String nome;
    private List<Componente> componentes = new ArrayList<>();
    
    public Usuario(String nome) {
        this.nome = nome;
    }
    
    public void adicionarComponente(Componente c) {
        componentes.add(c);
    }
    
    @Override
    public void atualizar(String mensagem) {
        System.out.println(nome + " recebeu: " + mensagem);
    }
    
    public void exibirPerfil() {
        System.out.println("Perfil de " + nome + ":");
        for (Componente c : componentes) {
            c.exibir();
        }
    }
}