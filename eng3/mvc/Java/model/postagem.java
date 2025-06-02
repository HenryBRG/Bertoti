public class Postagem implements Componente {
    private String conteudo;
    
    public Postagem(String conteudo) {
        this.conteudo = conteudo;
    }
    
    @Override
    public void exibir() {
        System.out.println("Postagem: " + conteudo);
    }
}