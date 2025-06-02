public class Main {
    public static void main(String[] args) {
        Compressor compressor = new Compressor();
        
        compressor.definirEstrategia(new CompressaoJPEG());
        compressor.executarCompressao("foto1.jpg");
        
        compressor.definirEstrategia(new CompressaoPNG());
        compressor.executarCompressao("foto2.png");
    }
}