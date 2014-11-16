
public class Company {
	private String companyName;
	private String cssClassOrID;
	private String cssSelector;
	private String baseURL;
	
	public Company(String companyName, String cssClassOrID, String cssSelector, String baseURL) {
		this.companyName = companyName;
		this.cssClassOrID = cssClassOrID;
		this.cssSelector = cssSelector;
		this.baseURL = baseURL;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String newCompanyName) {
		this.companyName = newCompanyName;
	}

	public String getCssClassOrID() {
		return cssClassOrID;
	}

	public void setCssClassOrID(String cssClassOrID) {
		this.cssClassOrID = cssClassOrID;
	}

	public String getCssSelector() {
		return cssSelector;
	}

	public void setCssSelector(String cssSelector) {
		this.cssSelector = cssSelector;
	}

	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}



	public static void main(String[] args) {
		
		
	}

}
