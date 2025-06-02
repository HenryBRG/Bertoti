public class CompressaoJPEG implements CompressaoStrategy {
    @Override
    public void comprimir(String arquivo) {
        System.out.println("Comprimindo " + arquivo + " usando JPEG");
    }
}