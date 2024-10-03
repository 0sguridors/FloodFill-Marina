import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class FloodFillApp extends JPanel {

    private BufferedImage imagem;
    private FloodFill floodFill;
    private boolean usarPilha;

    public FloodFillApp(BufferedImage imagem, boolean usarPilha) {
        this.imagem = imagem;
        this.floodFill = new FloodFill(imagem);
        this.usarPilha = usarPilha;

        // Adiciona um listener para capturar cliques do mouse
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                System.out.println("Clique detectado em: (" + x + ", " + y + ")");
                if (usarPilha) {
                    floodFill.floodFillPilha(x, y, Color.red);  // Aplicar o Flood Fill com a cor vermelha
                } else {
                    floodFill.floodFillFila(x, y, Color.blue);  // Aplicar o Flood Fill com a cor azul
                }
                repaint();  // Atualiza a tela para refletir as mudanças
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagem, 0, 0, this);  // Desenha a imagem
    }
}
