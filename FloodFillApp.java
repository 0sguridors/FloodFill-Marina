import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class FloodFillApp extends JPanel {
    private BufferedImage imagem;
    private BufferedImage imagemOriginal; 
    private FloodFill floodFill;
    private boolean usandoFila = true;
    private JButton toggleButton;
    private JButton resetButton; 

    public FloodFillApp(BufferedImage imagem) {
        this.imagemOriginal = imagem;  
        this.imagem = new BufferedImage(imagem.getWidth(), imagem.getHeight(), imagem.getType());
        this.imagem.getGraphics().drawImage(imagem, 0, 0, null);  
        this.floodFill = new FloodFill(this.imagem);
      
        toggleButton = new JButton("Usar Pilha");
        toggleButton.addActionListener(e -> toggleFloodFillMethod());
        
        resetButton = new JButton("Reiniciar Imagem");
        resetButton.addActionListener(e -> resetImage());

        this.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(toggleButton);
        buttonPanel.add(resetButton);
        this.add(buttonPanel, BorderLayout.NORTH); 
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                System.out.println("Clique detectado em: (" + x + ", " + y + ")");
                
                if (usandoFila) {
                    floodFill.floodFillFila(x, y, Color.RED);  
                } else {
                    floodFill.floodFillPilha(x, y, Color.blue); 
                }
                repaint();
            }
        });
    }

    private void toggleFloodFillMethod() {
        usandoFila = !usandoFila;  
        toggleButton.setText(usandoFila ? "Usar Pilha" : "Usar Fila");
        floodFill = new FloodFill(imagem); 
        repaint();
    }

    private void resetImage() {
        imagem = new BufferedImage(imagemOriginal.getWidth(), imagemOriginal.getHeight(), imagemOriginal.getType());
        imagem.getGraphics().drawImage(imagemOriginal, 0, 0, null);  
        floodFill = new FloodFill(imagem); 
        repaint(); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagem, 0, 0, this);
    }
}
