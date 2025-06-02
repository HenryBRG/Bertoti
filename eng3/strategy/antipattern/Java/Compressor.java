public class Compressor {
    public void comprimirJPEG(String arquivo) {
        System.out.println("Comprimindo " + arquivo + " usando JPEG");
    }
    
    public void comprimirPNG(String arquivo) {
        System.out.println("Comprimindo " + arquivo + " usando PNG");
    }
    
    public void comprimir(String formato, String arquivo) {
        if (formato.equals("JPEG")) {
            comprimirJPEG(arquivo);
        } else if (formato.equals("PNG")) {
            comprimirPNGUGFdss
        }
    }
}