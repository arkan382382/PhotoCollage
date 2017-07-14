import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by arkan on 14.07.2017.
 * pobieranie i wyswietlanie obrazka: https://javastart.pl/static/grafika_awt_swing/pobieranie-i-wyswietlanie-obrazow/
 */
public class MainClass {
    public static void main(String[] argc){
        System.out.println("test");

        int width = 200;
        int height = 150;
        BufferedImage image = null;
        File file = null;

        Image[] temp = new Image[10]; // or list of image (try to use different structure)

        try{
            file = new File("D:\\test.jpg");
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            image = ImageIO.read(file);
            System.out.println("Reading complete.");
        }catch(IOException e){
            System.out.println("Error: " + e);
        }

    }
}
