import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by arkan on 14.07.2017.
 * pobieranie i wyswietlanie obrazka: https://javastart.pl/static/grafika_awt_swing/pobieranie-i-wyswietlanie-obrazow/
 */
public class MainClass {
    public static void main(String[] argc) throws IOException {

        StorageOfSmallPictures smallPictures = new StorageOfSmallPictures();
        smallPictures.readPicturesFromDirectory();

     //   System.out.println("small pictures: " + smallPictures.getNumberOfLoadedPhotos());

        FinalPicture finalPicture = new FinalPicture();
      //  finalPicture.setNumberOfPictureInRowsAndColumns(smallPictures.getNumberOfLoadedPhotos());
       // finalPicture.createMatrix();

         System.out.println( smallPictures.getNumberOfLoadedPhotos() );

        smallPictures.setHeightAndWidthOfSmallPicture();

        for(int i=0; i<(smallPictures.getNumberOfLoadedPhotos()); i++){
            System.out.print(smallPictures.getHeightOfSmallPicture(i) + "  ");
            System.out.print(smallPictures.getWidthOfSmallPicture(i) + " \n");
        }

        System.out.println("Screen width: " + finalPicture.getWidthOfScreenOnPc());
        System.out.println("FinalPicture width: " + finalPicture.getWidthOfFinalPicture());

        finalPicture.setNumberOfPictureInRowsAndColumns(smallPictures.getNumberOfLoadedPhotos(), smallPictures, finalPicture);
        System.out.println(finalPicture.getCellsHorizontally() + " " + finalPicture.getCellsVertically());
        System.out.println("Final picture cells: " + finalPicture.cellsVertically + " " + finalPicture.cellsHorizontally); //chyba zyebałem - podwojony dostęp

        finalPicture.prepareFinalBackground(finalPicture.cellsVertically, finalPicture.cellsHorizontally, smallPictures, finalPicture);
        //1. skalowanie pobranych obrazów do otrzymanej wartości (finalWidthOfSmallPicture)
        //2. Upakowanie obrazów w wierszach i kolumnach ( tyle w wierszu ile cellsVertically, tyle w kolumnie ile w horizontally)
        //3. Wyświetlenie otrzymanego obrazu
        //4. Pobranie adresów plików do programu i wklejenie ich do nowego obszaru roboczego

        smallPictures.readPictureForMainClass(smallPictures.iconMap);

        System.out.println("isempty: " + smallPictures.iconMap.size());

        System.out.println("isempty: " + smallPictures.sendMap().size());

        //finalPicture.BackgroudForEndPicture();

        Map<String, ImageIcon> iconMap = new HashMap<String, ImageIcon>();
        File directory = new File("D:\\zrodlo\\");
        for (File file : directory.listFiles()) {
            if (file.getName().toLowerCase().endsWith(".jpg")) {
                iconMap.put(file.getName(), new ImageIcon(file.getPath()));
            }
        }

        //test <String BufferedImage> lub <String, IO>
        Map<String, BufferedImage> iconMap2 = new HashMap<String, BufferedImage>();
        File dir = new File("D:\\zrodlo\\");
        for (File file : dir.listFiles()) {
            if (file.getName().toLowerCase().endsWith(".jpg")) {
                iconMap2.put(file.getName(), new BufferedImage(200, 200, BufferedImage.TYPE_3BYTE_BGR));
            }
        }
        BufferedImage bibi = iconMap2.get(0);
        BufferedImage bibi2 = iconMap2.get(1);
        BufferedImage bibi3 = iconMap2.get(2);
        BufferedImage bibi4 = iconMap2.get(3);
        BufferedImage RESULT = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
        Graphics gg = RESULT.getGraphics();
        gg.drawImage(bibi, 0, 0, null);
        gg.drawImage(bibi2, 200, 0, null);
        gg.drawImage(bibi3, 80, 0, null);
        gg.drawImage(bibi4, 20, 20, null);
        ImageIO.write(RESULT, "jpg", new File("D:\\zrodlo\\result.jpg"));
// nie działa;(
        System.out.println("HOW MANY? " + iconMap2.size());

        //Tworzenie finalnego miejsca na obrazy
        int width, height;
        width = (int) (smallPictures.getWidthOfSmallPicture(0) * finalPicture.cellsHorizontally);
        height = (int) (smallPictures.getHeightOfSmallPicture(0) * finalPicture.cellsVertically);
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = result.getGraphics();

        System.out.println("width: " + width);
        System.out.println("height: " + height);

        // buffered image - wczytanie wszystkich obrazów pojedynczo
        // łączenie ich względem zmiennych ze starego programu
        /* poniżej działające pobieranie i zapisywanie nowego

        BufferedImage result = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
        Graphics g = result.getGraphics();

        BufferedImage bi = ImageIO.read(new File("D:\\zrodlo\\test.jpg"));
        g.drawImage(bi, 0, 0, null);
        g.drawImage(bi, bi.getWidth(), 0, null);
        g.drawImage(bi, 0, bi.getHeight(), null);
        g.drawImage(bi, bi.getWidth(), bi.getHeight(), null);

        ImageIO.write(result, "jpg", new File("D:\\zrodlo\\result.jpg"));

         */




        // https://javastart.pl/static/iv-grafika-awt-i-swing/rozwiazanie-4-1/ -- zapis kilku obrazów  drawimage xy
        //if x == szerokosc (x=0; y++)  <== aby zaczęło wstawiać obrazki poniżej. X i Y muszą być szerokościami obrazu. Uwzględnić też ilość w pionie i poziomie


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

/*
        int size = 12;
        int row = 1;
        int column = 1;

        do{
            row++;
            if((row*column) < size){
                column++;
            }
        }while((row*column) < size);

        System.out.println("Column: " + column + "row: " + row);
        */
    }}