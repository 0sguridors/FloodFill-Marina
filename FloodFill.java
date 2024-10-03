import java.awt.Color;
import java.awt.image.BufferedImage;

public class FloodFill {

    private BufferedImage imagem;

    public FloodFill(BufferedImage imagem) {
        this.imagem = imagem;
    }

    public void floodFillPilha(int x, int y, Color novaCor) {
        int corAlvo = imagem.getRGB(x, y);  
        int novaRGB = novaCor.getRGB();

        if (corAlvo == novaRGB) return;  

        // Usando pilha
        Pilha pilha = new Pilha();
        pilha.push(x, y);

        while (!pilha.isEmpty()) {
            Pilha.Ponto ponto = pilha.pop();
            int px = ponto.x;
            int py = ponto.y;

            if (px < 0 || px >= imagem.getWidth() || py < 0 || py >= imagem.getHeight()) continue;
            if (imagem.getRGB(px, py) != corAlvo) continue;

            imagem.setRGB(px, py, novaRGB);

            pilha.push(px + 1, py); 
            pilha.push(px - 1, py); 
            pilha.push(px, py + 1); 
            pilha.push(px, py - 1); 
        }
    }

    public void floodFillFila(int x, int y, Color novaCor) {
        int corAlvo = imagem.getRGB(x, y); 
        int novaRGB = novaCor.getRGB();

        if (corAlvo == novaRGB) return;

        Fila fila = new Fila();
        fila.enqueue(x, y);

        while (!fila.isEmpty()) {
            Fila.Ponto ponto = fila.dequeue();
            int px = ponto.x;
            int py = ponto.y;

            if (px < 0 || px >= imagem.getWidth() || py < 0 || py >= imagem.getHeight()) continue;
            if (imagem.getRGB(px, py) != corAlvo) continue;

            imagem.setRGB(px, py, novaRGB);

            fila.enqueue(px + 1, py); 
            fila.enqueue(px - 1, py); 
            fila.enqueue(px, py + 1); 
            fila.enqueue(px, py - 1); 
        }
    }
}
