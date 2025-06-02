public class Main {
    public static void main(String[] args) {
        Publicador publicador = new Publicador();
        
        Usuario u1 = new Usuario("Ana");
        Usuario u2 = new Usuario("Carlos");
        
        publicador.adicionarObservador(u1);
        publicador.adicionarObservador(u2);
        
        publicador.notificarObservadores("Nova postagem disponível!");
    }
}