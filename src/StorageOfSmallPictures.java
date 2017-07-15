import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.Image;
import java.awt.font.ImageGraphicAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by arkan on 14.07.2017.
 */

public class StorageOfSmallPictures {
    private int numberOfLoadedPictures = 0;

    private double[] widthOfSmallPicture;
    private double[] heightOfSmallPicture;
    private double[] finalWidthOfSmallPicture;
    private double[] finalHeightOfSmallPicture;
    public StorageOfSmallPictures(){

    }
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

    public void setHeightAndWidthOfSmallPicture(){// do konstruktora
        /*for(int i=0; i<numberOfLoadedPictures; i++){
            this.heightOfSmallPicture[i] = iconMap.get(i).getIconHeight();
        }*/
        heightOfSmallPicture = new double [getNumberOfLoadedPhotos()];
        widthOfSmallPicture = new double [getNumberOfLoadedPhotos()];
        int i=0;
        Iterator it = iconMap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, ImageIcon> pair = (Map.Entry)it.next();
         //   System.out.println("key: " + pair.getKey() + "value: " + pair.getValue())
            heightOfSmallPicture[i] = (pair.getValue().getIconHeight());
            widthOfSmallPicture[i] = (pair.getValue().getIconWidth());
            i++;
            it.remove();
        }
    }
/*
    public void setFinalWidthAndHeightOfSmallPicture(FinalPicture temporary){
        finalHeightOfSmallPicture = new double[getNumberOfLoadedPhotos()];
        finalWidthOfSmallPicture = new double[getNumberOfLoadedPhotos()];
        int i = 0;

    }
    */
  /*  public void setWidthOfSmallPicture(){
        widthOfSmallPicture = new double [getNumberOfLoadedPhotos()];
        int i=0;
        Iterator it2 = iconMap.entrySet().iterator();
        while(it2.hasNext()){
            Map.Entry<String, ImageIcon> pair2 = (Map.Entry)it2.next();
            //   System.out.println("key: " + pair.getKey() + "value: " + pair.getValue())
            widthOfSmallPicture[i] = (pair2.getValue().getIconWidth());
            i++;
            it2.remove();
        }
    }
*/
    public double getHeightOfSmallPicture(int whichOnePicture){
        return heightOfSmallPicture[whichOnePicture];
    }

    public double getWidthOfSmallPicture(int whichOnePicture){
        return widthOfSmallPicture[whichOnePicture];
    }
}