import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class main {

    public static void main(String[] args) {
        try {
            BufferedImage imagem = ImageIO.read(new File("C:/Users/pohers/Desktop/flood fill/image.jpg"));

            JFrame frame = new JFrame("Flood Fill App");
            FloodFillApp floodFillApp = new FloodFillApp(imagem);
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 500);
            frame.add(floodFillApp);
            frame.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
