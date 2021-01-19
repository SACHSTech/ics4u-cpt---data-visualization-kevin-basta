package basic;

import java.io.*;

public class Data {
    
    private static String[][] dataArray;

    private static void loadArray() throws IOException {
        // intGlobalRank strCompanyName intCompanySales intCompanyProfits intCompanyAssets intCompanyMarketValue strTypeOfCompany strCompanyDescription
        BufferedReader japanLargestCompanies = new BufferedReader(new FileReader("src/basic/Japan_largest_companies_edited.csv"));
        int intCounter1 = 0;
        int intCounter2 = 0;
        
        String[] dataReader;
        dataArray = new String[248][8];
        String strCSVLineReader = "";

        while((strCSVLineReader = japanLargestCompanies.readLine()) != null) {
            // Using regex to make sure the descriptions doesn't get split
            dataReader = strCSVLineReader.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            
            // Switching the order of the global rank and name
            dataArray[intCounter1][0] = dataReader[1];
            dataArray[intCounter1][1] = dataReader[0];

            // Populating rest of the data array
            for (intCounter2 = 2; intCounter2 <= 7; intCounter2++) {
                dataArray[intCounter1][intCounter2] = dataReader[intCounter2];
            }
            intCounter1 += 1;
        }

        japanLargestCompanies.close();
        //System.out.println(dataArray[247][0]);
    }


    // To fetch from other classes use String[][] testArray = Data.getData();
    public static String[][] getData() throws IOException {
        loadArray();
        //System.out.println(dataArray[1].length);
        return dataArray;
    }


}
