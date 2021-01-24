package basic;

import java.io.*;
import java.util.ArrayList;

public class CompanyList {
    
    // Arrary List of all the companies
    private static ArrayList<Company> companyList = new ArrayList<Company>();

    /*
    public static void main(String[] args) throws IOException{
        CompanyList Japan = new CompanyList("Japan_largest_companies_edited.csv");
        //System.out.println(companyList.get(246).getCompanyName());

        ArrayList<Company> strSortedDataArray = linearStringSearch("Yusen");
        for (int check = 0; check < strSortedDataArray.size(); check++) {
            System.out.println(strSortedDataArray.get(check).getCompanyName());
        }
    }
    */
    

    // Populates the arraylist from the csv
    public CompanyList(String fileToRead) throws IOException {
        BufferedReader japanLargestCompanies = new BufferedReader(new FileReader("src/basic/" + fileToRead));
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
    
    public static ArrayList<Company> getArrayList() {
        return companyList;
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



    // selection sort for Double variable values
    public static ArrayList<Company> selectionSortDouble(int intArrayIndexValue) throws IOException{
        ArrayList<Company> newSortedCompanyList = companyList;
        int currentMinIndex;
      
        for (int i = 0; i < newSortedCompanyList.size(); i++) {
          currentMinIndex = i; 

          // If it's not global rank, sort from largest to smallest
          if (intArrayIndexValue != 0) {
            for (int j = i + 1; j < newSortedCompanyList.size(); j++) {
                if(newSortedCompanyList.get(j).getCompanyDblParameter(intArrayIndexValue) > newSortedCompanyList.get(currentMinIndex).getCompanyDblParameter(intArrayIndexValue)){
                    currentMinIndex = j;
                }
            }
          } else {
            for (int j = i + 1; j < newSortedCompanyList.size(); j++) {
                if(newSortedCompanyList.get(j).getCompanyDblParameter(intArrayIndexValue) < newSortedCompanyList.get(currentMinIndex).getCompanyDblParameter(intArrayIndexValue)){
                    currentMinIndex = j;
                }
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


  public static ArrayList<Company> linearStringSearch(String strCompanyName) {
    ArrayList<Company> newCompnayListForSearch = new ArrayList<Company>();
    String strElement;

      for(int i = 0; i < companyList.size(); i++){
        strElement = companyList.get(i).getCompanyName(); 
        String[] splitedString = strElement.split(" ");

        if (strElement.equalsIgnoreCase(strCompanyName)) {
            newCompnayListForSearch.add(companyList.get(i));
        } else {
            for (int j = 0; j < splitedString.length; j++) {
                if (strCompanyName.equalsIgnoreCase(splitedString[j])) {
                    newCompnayListForSearch.add(companyList.get(i));
                }
            }
        }
      }

      if (newCompnayListForSearch.isEmpty()) {
        String[] notFound = {"1", "not found", "2", "3", "4", "5", "not found", "not found"};
        newCompnayListForSearch.add(new Company(notFound));
        return newCompnayListForSearch;
      } else {
        return newCompnayListForSearch;
      }
  }


}
