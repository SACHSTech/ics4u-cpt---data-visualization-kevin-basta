package basic;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // intGlobalRank strCompanyName intCompanySales intCompanyProfits intCompanyAssets intCompanyMarketValue strTypeOfCompany strCompanyDescription
        BufferedReader japanLargestCompanies = new BufferedReader(new FileReader("src/basic/Japan_largest_companies_edited.csv"));
        int intCounter1 = 0;
        int intCounter2 = 0;
        
        String[] dataReader;
        String data[][] = new String[248][8];
        String strCSVLineReader = "";

        while((strCSVLineReader = japanLargestCompanies.readLine()) != null) {
            // Using regex to make sure the descriptions doesn't get split
            dataReader = strCSVLineReader.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            
            // Switching the order of the global rank and name
            data[intCounter1][0] = dataReader[1];
            data[intCounter1][1] = dataReader[0];

            // Populating rest of the data array
            for (intCounter2 = 2; intCounter2 <= 7; intCounter2++) {
                data[intCounter1][intCounter2] = dataReader[intCounter2];
            }
            intCounter1 += 1;
        }

        japanLargestCompanies.close();

    }
}
