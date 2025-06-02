public class Compressor {
    private CompressaoStrategy estrategia;
    
    public void definirEstrategia(CompressaoStrategy estrategia) {
        this.estrategia = estrategia;
    }
    
    public void executarCompressao(String arquivo) {
        estrategia.comprimir(arquivo);
    }
}