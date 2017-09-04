/**
 * Created by arkan on 14.07.2017.
 * pobieranie i wyswietlanie obrazka: https://javastart.pl/static/grafika_awt_swing/pobieranie-i-wyswietlanie-obrazow/
 */
public class MainClass {
    public static void main(String[] argc) {

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