import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class main {

    public static void main(String[] args) {
        try {
            // Carrega a imagem de arquivo
            BufferedImage imagem = ImageIO.read(new File("C:/Users/pohers/Desktop/flood fill/image.jpg"));

            // Configura a janela (JFrame) para pilha
            JFrame framePilha = new JFrame("Flood Fill com Pilha");
            FloodFillApp floodFillAppPilha = new FloodFillApp(imagem, true);
            framePilha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            framePilha.setSize(800, 600);  // Ajuste o tamanho da janela conforme necessário
            framePilha.add(floodFillAppPilha);
            framePilha.setVisible(true);

            // Configura a janela (JFrame) para fila
            JFrame frameFila = new JFrame("Flood Fill com Fila");
            FloodFillApp floodFillAppFila = new FloodFillApp(imagem, false);
            frameFila.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameFila.setSize(800, 600);  // Ajuste o tamanho da janela conforme necessário
            frameFila.add(floodFillAppFila);
            frameFila.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
