import javax.tools.Tool;
import java.awt.*;

/**
 * Created by arkan on 15.07.2017.
 */
public class FinalPicture {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private double widthOfScreenOnPC = screenSize.getWidth();
    private double heightOfScreenOnPC = screenSize.getHeight();
    private double widthOfFinalPicture = (widthOfScreenOnPC * 0.8);
    private double heightOfFinalPicture = (heightOfScreenOnPC * 0.8);

    /*
    na podstawie cells poniżej - okreslić szerokość i wysokość obrazu( przeskalować go)
     */
    int cellsHorizontally = 0;
    int cellsVertically = 0;

    StorageOfSmallPictures smallPicturesTemp = new StorageOfSmallPictures();

    public void setNumberOfPictureInRowsAndColumns(int numberOfTinyPhotos, StorageOfSmallPictures xANDy, FinalPicture toCells) {
        //   numberOfTinyPhotos = smallPicturesTemp.getNumberOfLoadedPhotos();
        System.out.println("from finalClass: " + numberOfTinyPhotos);
        // miejsce na algorytm okreslający rozmiar macieży
        do {
            toCells.cellsVertically++;
            //cellsVertically++;
            {
                if ((toCells.cellsHorizontally * toCells.cellsVertically) < numberOfTinyPhotos) {
                    toCells.cellsHorizontally++;
                }
            }
        } while ((toCells.cellsHorizontally * toCells.cellsVertically) < numberOfTinyPhotos);
    }

    public void prepareFinalBackground(int cellsVertically_pion, int cellsHorizontally_poziom, StorageOfSmallPictures tempSmall){

    }

        /*do{
            row++;
            if((row*column) < size){
                column++;
            }                                       horiz - poziom, vert - pion
        }while((row*column) < size); */

/*
    public void createMatrix(int cellsHorizontally, int cellsVertically, int numberOfTinyPhotos) {
        do {
            cellsHorizontally++;
            if ((cellsHorizontally * cellsVertically) < numberOfTinyPhotos) {
                cellsVertically++;
            }
        } while ((cellsHorizontally * cellsVertically) < numberOfTinyPhotos);
    }
*/
    public double getWidthOfScreenOnPc(){
        return widthOfScreenOnPC;
    }
    public double getWidthOfFinalPicture(){
        return widthOfFinalPicture;
    }
    public double getHeightOfScreenOnPC(){
        return heightOfScreenOnPC;
    }
    public double getHeightOfFinalPicture(){
        return heightOfFinalPicture;
    }
    public int getCellsHorizontally(){
        return cellsHorizontally;
    }
    public int getCellsVertically(){
        return cellsVertically;
    }

}
