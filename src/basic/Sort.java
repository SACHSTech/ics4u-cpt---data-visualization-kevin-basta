package basic;

import java.io.*;

public class Sort {

    //public class
    public static void main(String[] args) throws IOException {
        String[][] strDataArray = Data.getData();
        String[][] strSortedDataArray = selection_sort(strDataArray, 4);

        for (int check = 0; check < strSortedDataArray.length; check++) {
            System.out.println(strSortedDataArray[check][4]);
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

}
