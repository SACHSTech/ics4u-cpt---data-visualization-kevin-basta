package basic;

import java.io.*;
import java.util.Arrays;

public class Search {
    
    // getter method for catagory sort
    public static String[][] getCatagoryArray(int intIndex, String strValueCheck) throws IOException{
        String[][] strDataArray = Data.getData();
        String[][] strSortedDataArray = sortByCatagory(strDataArray, intIndex, strValueCheck);
    
        return strSortedDataArray;
    }

    // Caragory search for bubble chart
    private static String[][] sortByCatagory(String[][] strArray, int indexValue, String catagoryName) {
        int intNumbOfItemsInCatagory = 0;

        for(int k = 0; k < strArray.length; k++) {
            if (catagoryName.equals(strArray[k][indexValue])) {
                intNumbOfItemsInCatagory += 1;
            }
        }
        
        int intNewIndexCounter = -1;
        String[][] finalArray = new String[intNumbOfItemsInCatagory][strArray[1].length];
        String strElement;

        for(int i = 0; i < strArray.length; i++) {
                strElement = strArray[i][indexValue];
                if(strElement.equals(catagoryName)) {
                    intNewIndexCounter += 1;
                    for(int j = 0; j < strArray[1].length; j++) {
                        finalArray[intNewIndexCounter][j] = strArray[i][j];
                    }
                }
            }

        return finalArray;
    }


}
