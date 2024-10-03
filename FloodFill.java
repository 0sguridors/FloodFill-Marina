import java.awt.Color;
import java.awt.image.BufferedImage;

public class FloodFill {

    private BufferedImage imagem;

    public FloodFill(BufferedImage imagem) {
        this.imagem = imagem;
    }

    public void floodFillPilha(int x, int y, Color novaCor) {
        int corAlvo = imagem.getRGB(x, y);  // Cor que será substituída
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

            // Empilha os vizinhos
            pilha.push(px + 1, py); // Direita
            pilha.push(px - 1, py); // Esquerda
            pilha.push(px, py + 1); // Baixo
            pilha.push(px, py - 1); // Cima
        }
    }

    public void floodFillFila(int x, int y, Color novaCor) {
        int corAlvo = imagem.getRGB(x, y);  // Cor que será substituída
        int novaRGB = novaCor.getRGB();

        if (corAlvo == novaRGB) return;  // Já está na cor desejada

        // Usando fila
        Fila fila = new Fila();
        fila.enqueue(x, y);

        while (!fila.isEmpty()) {
            Fila.Ponto ponto = fila.dequeue();
            int px = ponto.x;
            int py = ponto.y;

            if (px < 0 || px >= imagem.getWidth() || py < 0 || py >= imagem.getHeight()) continue;
            if (imagem.getRGB(px, py) != corAlvo) continue;

            imagem.setRGB(px, py, novaRGB);

            // Enfileira os vizinhos
            fila.enqueue(px + 1, py); // Direita
            fila.enqueue(px - 1, py); // Esquerda
            fila.enqueue(px, py + 1); // Baixo
            fila.enqueue(px, py - 1); // Cima
        }
    }
}
