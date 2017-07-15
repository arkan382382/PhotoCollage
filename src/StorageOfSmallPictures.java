import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Image;
import java.awt.font.ImageGraphicAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by arkan on 14.07.2017.
 */

public class StorageOfSmallPictures {
    private int numberOfLoadedPictures = 0;
    private double[] widthOfSmallPicture = new double[getNumberOfLoadedPhotos()];
    private double[] heightOfSmallPicture = new double[getNumberOfLoadedPhotos()];
    /*
        int width = 200;
        int height = 150;
        BufferedImage image = null;
        File file = null;

        try{
            file = new File("D:\\test.jpg");
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            image = ImageIO.read(file);
            System.out.println("Reading complete.");
        }catch(IOException e){
            System.out.println("Error: " + e);
        }
    */
    Map<String, ImageIcon> iconMap = new HashMap<String, ImageIcon>();

    public void readPicturesFromDirectory() {
        File directory = new File("D:\\zrodlo\\");

        for (File file : directory.listFiles()) {
            if (file.getName().toLowerCase().endsWith(".jpg")) {
                iconMap.put(file.getName(), new ImageIcon(file.getPath()));
            }
        }
        this.setNumberOfLoadedPictures();
    }

/*    Map<String, ImageGraphicAttribute> sizeSingleSmallPhotos = new HashMap<String, ImageGraphicAttribute>();
    public void setSizeOfSinglePicture(){
        iconMap.get(1).getIconHeight();
    }

*/
    /*   public void setNumberOfLoadedPictures(int numberOfLoadedPictures) {
           this.numberOfLoadedPictures = howManyPictures();
       }   */
    private void setNumberOfLoadedPictures() {
        numberOfLoadedPictures = iconMap.size();
    }

    public int getNumberOfLoadedPhotos() {
        return numberOfLoadedPictures;
    }

    public void setHeightOfSmallPicture(){                  // do konstruktora
        for(int i=1; i<numberOfLoadedPictures; i++){
            heightOfSmallPicture[i] = iconMap.get(i).getIconHeight();
        }
    }
    public void setWidthOfSmallPicture(){
        for(int i=0; i<numberOfLoadedPictures; i++){        // do konstruktora
            widthOfSmallPicture[i] = iconMap.get(i).getIconWidth();
        }
    }
    public double getHeightOfSmallPicture(int whichOnePicture){
        return heightOfSmallPicture[whichOnePicture];
    }
    public double getWidthOfSmallPicture(int whichOnePicture){
        return widthOfSmallPicture[whichOnePicture];
    }
}