import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class FloodFillApp extends JPanel {
    private BufferedImage imagem;
    private BufferedImage imagemOriginal;  // Para armazenar a imagem original
    private FloodFill floodFill;
    private boolean usandoFila = true;
    private JButton toggleButton;
    private JButton resetButton;  // Botão para reiniciar a imagem

    public FloodFillApp(BufferedImage imagem) {
        this.imagemOriginal = imagem;  // Armazena a imagem original
        this.imagem = new BufferedImage(imagem.getWidth(), imagem.getHeight(), imagem.getType());
        this.imagem.getGraphics().drawImage(imagem, 0, 0, null);  // Copia a imagem original
        this.floodFill = new FloodFill(this.imagem);
        
        // Botão para alternar entre fila e pilha
        toggleButton = new JButton("Usar Pilha");
        toggleButton.addActionListener(e -> toggleFloodFillMethod());
        
        // Botão para reiniciar a imagem
        resetButton = new JButton("Reiniciar Imagem");
        resetButton.addActionListener(e -> resetImage());

        this.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(toggleButton);
        buttonPanel.add(resetButton);
        this.add(buttonPanel, BorderLayout.NORTH); // Adiciona painel de botões na parte superior
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                System.out.println("Clique detectado em: (" + x + ", " + y + ")");
                
                if (usandoFila) {
                    floodFill.floodFillFila(x, y, Color.RED);  // Usando fila
                } else {
                    floodFill.floodFillPilha(x, y, Color.blue); // Usando pilha
                }
                repaint();
            }
        });
    }

    private void toggleFloodFillMethod() {
        usandoFila = !usandoFila;  // Alterna o estado
        toggleButton.setText(usandoFila ? "Usar Pilha" : "Usar Fila");
        floodFill = new FloodFill(imagem);  // Reinicia o FloodFill
        repaint();
    }

    private void resetImage() {
        imagem = new BufferedImage(imagemOriginal.getWidth(), imagemOriginal.getHeight(), imagemOriginal.getType());
        imagem.getGraphics().drawImage(imagemOriginal, 0, 0, null);  // Reinicia a imagem com a original
        floodFill = new FloodFill(imagem);  // Reinicia o FloodFill
        repaint();  // Atualiza a tela
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagem, 0, 0, this);
    }
}
