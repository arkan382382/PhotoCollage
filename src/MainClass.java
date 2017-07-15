import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by arkan on 14.07.2017.
 * pobieranie i wyswietlanie obrazka: https://javastart.pl/static/grafika_awt_swing/pobieranie-i-wyswietlanie-obrazow/
 */
public class MainClass {
    public static void main(String[] argc) {
        System.out.println("test");
        StorageOfSmallPictures smallPictures = new StorageOfSmallPictures();
        smallPictures.readPicturesFromDirectory();
        System.out.println("small pictures: " + smallPictures.getNumberOfLoadedPhotos());

        FinalPicture finallPicture = new FinalPicture();
        finallPicture.setSizeOfFinalPicture(smallPictures.getNumberOfLoadedPhotos());

    /*    int width = 200;
        int height = 150;
        BufferedImage image = null;
        File fileActual = null;
        ArrayList<File> fileTemp = new ArrayList<File>();
        try{
            fileActual = new File("D:\\test.jpg");
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            image = ImageIO.read(fileActual);
            fileTemp.add(fileActual);
            fileTemp.add(fileActual);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        System.out.println("size: " + fileTemp.size());
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
*/

  /*      File directory = new File("D:\\zrodlo\\");
        Map<String, ImageIcon> iconMap = new HashMap<String, ImageIcon>();
        for (File file : directory.listFiles()) {
            if (file.getName().toLowerCase().endsWith(".jpg")) {
                iconMap.put(file.getName(), new ImageIcon(file.getPath()));
            }
        }
*/
      //  System.out.println(iconMap.size());



    }}