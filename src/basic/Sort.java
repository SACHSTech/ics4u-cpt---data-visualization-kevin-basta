package basic;

import java.io.*;
import java.util.Arrays;

public class Sort {

    //public clas
    public static void main(String[] args) throws IOException {
        String[][] strDataArray = Data.getData();
        String[][] strSortedDataArray = sortByCatagory(strDataArray, 6, "Cars");

        for (int check = 0; check < strSortedDataArray.length; check++) {
            System.out.println(strSortedDataArray[check][6]);
        }
    }

    // getter method for selection sort
    public static String[][] getSortedArray(int intIndex) throws IOException{
        String[][] strDataArray = Data.getData();
        String[][] strSortedDataArray = selection_sort(strDataArray, intIndex);

        return strSortedDataArray;
    }

    // selection sort
    private static String[][] selection_sort(String[][] strArray, int intArrayIndexValue) throws IOException{
      int currentMinIndex;
      for (int i = 1; i < strArray.length - 1; i++) {
          currentMinIndex = i; 

          for (int j = i + 1; j < strArray.length; j++) {
              if(Double.parseDouble(strArray[j][intArrayIndexValue]) <  Double.parseDouble(strArray[currentMinIndex][intArrayIndexValue])){
                  currentMinIndex = j;
              }
          }
          
          // swap numbers if needed
          if (i != currentMinIndex) {
              String temp = strArray[currentMinIndex][intArrayIndexValue];
              strArray[currentMinIndex][intArrayIndexValue] = strArray[i][intArrayIndexValue];
              strArray[i][intArrayIndexValue] = temp;
          }
      }
      
      return strArray;
  }

  // Caragory sort for bubble chart
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
                finalArray = new String[intNewIndexCounter][strArray[1].length];
                for(int j = 0; j < strArray[1].length; j++) {
                    finalArray[intNewIndexCounter][j] = strArray[i][j];
                }
            }
        }

    return finalArray;
  }
    
}
