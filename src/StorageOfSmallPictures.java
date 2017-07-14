import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by arkan on 14.07.2017.
 */

public class StorageOfSmallPictures{
    private int numberOfLoadedPictures = 0;
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
    public int howManyPictures(){
        /*
        *for loop, value in loop, has next,
        *
         */
        return 0;
    }
    public int getNumberOfLoadedPhotos(){
        return this.numberOfLoadedPictures;
    }
}
