package basic;

import java.io.*;
import java.util.ArrayList;

public class CompanyList {
    
    // Arrary List of all the companies
    private static ArrayList<Company> companyList = new ArrayList<Company>();

    public static void main(String[] args) throws IOException{
        loadCompanyObjects();
        //System.out.println(companyList.get(246).getCompanyName());

        ArrayList<Company> strSortedDataArray = selectionSort(0);
        for (int check = 0; check < strSortedDataArray.size(); check++) {
            System.out.println(strSortedDataArray.get(check).getCompanyProfit());
        }
    }
    
    

    // Populates the arraylist from the csv
    public static void loadCompanyObjects() throws IOException {
        BufferedReader japanLargestCompanies = new BufferedReader(new FileReader("src/basic/Japan_largest_companies_edited.csv"));
        String strCSVLineReader = "";
        String[] dataReader;
        
        while((strCSVLineReader = japanLargestCompanies.readLine()) != null) {
            // Using regex to make sure the descriptions doesn't get split
            dataReader = strCSVLineReader.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            if (dataReader[0].equals("Global Rank")) {

            } else {
                companyList.add(new Company(dataReader));
            }
        }

        japanLargestCompanies.close();
    }
    


    // Caragory search for bubble chart
    public static ArrayList<Company> sortByCatagory(int indexValue, String catagoryName) {
        ArrayList<Company> newCaragoryCompanyList = new ArrayList<Company>();
        String strElement;

        for(int i = 0; i < companyList.size(); i++) {
            strElement = companyList.get(i).getCompanyType();
            if(strElement.equals(catagoryName)) {
                newCaragoryCompanyList.add(companyList.get(i));
            }
        }

        return newCaragoryCompanyList;
    }



    // selection sort [currently set to getCompanyProfit]
    private static ArrayList<Company> selectionSort(int intArrayIndexValue) throws IOException{
        ArrayList<Company> newSortedCompanyList = companyList;
        int currentMinIndex;
      
        for (int i = 0; i < newSortedCompanyList.size(); i++) {
          currentMinIndex = i; 

          for (int j = i + 1; j < newSortedCompanyList.size(); j++) {
              if(newSortedCompanyList.get(j).getCompanyProfit() <  newSortedCompanyList.get(currentMinIndex).getCompanyProfit()){
                  currentMinIndex = j;
              }
          }
          
          if (i != currentMinIndex) {
              Company tempCompany = newSortedCompanyList.get(currentMinIndex);
              newSortedCompanyList.set(currentMinIndex, newSortedCompanyList.get(i)); 
              newSortedCompanyList.set(i, tempCompany);
          }
      }
      
      return newSortedCompanyList;
  }





}
