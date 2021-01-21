package basic;

public class Company {
    
    private String strCompanyName;
    private String strTypeOfCompany;
    private String strCompanyDescription;

    private int intGlobalRank;
    private Double dblCompanySales;
    private Double dblCompanyProfits;
    private Double dblCompanyAssets; 
    private Double dblCompanyMarketValue;

    //String newCompanyName, int newGlobalRank, Double newCompanySales, Double newCompanyProfits, Double newCompanyAssets, Double newCompanyMarketValue, String newTypeOfCompany, String newCompanyDescription
    // Constructor method
    public Company(String[] newCompanyData) {
        this.intGlobalRank = Integer.parseInt(newCompanyData[0]);
        this.strCompanyName = newCompanyData[1];
        this.dblCompanySales = Double.parseDouble(newCompanyData[2]);
        this.dblCompanyProfits = Double.parseDouble(newCompanyData[3]);
        this.dblCompanyAssets = Double.parseDouble(newCompanyData[4]);
        this.dblCompanyMarketValue = Double.parseDouble(newCompanyData[5]);
        this.strTypeOfCompany = newCompanyData[6];
        this.strCompanyDescription = newCompanyData[7];
    }

    // Getter methods for each parameter a company has
    public String getCompanyName() {
        return this.strCompanyName;
    }

    public String getCompanyType() { 
        return this.strTypeOfCompany;
    }

    public String getCompanyDescription() {
        return this.strCompanyDescription;
    }

    public int getCompanyRank() {
        return this.intGlobalRank;
    }

    public double getCompanySales() {
        return this.dblCompanySales;
    }

    public double getCompanyProfit() {
        return this.dblCompanyProfits;
    }

    public double getCompanyAssets() {
        return this.dblCompanyAssets;
    }

    public double getCompanyMarketValue() {
        return this.dblCompanyMarketValue;
    }


}
