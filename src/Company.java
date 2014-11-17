
public class Company {
	private String companyName;
	private String cssClassOrID;
	private String cssSelector;
	private String baseURL;
	private String regEx;
	private String domain;

	public Company(String companyName, String cssClassOrID, String cssSelector, String baseURL, String regEx, String domain) {
		this.companyName = companyName;
		this.cssClassOrID = cssClassOrID;
		this.cssSelector = cssSelector;
		this.baseURL = baseURL;
		this.regEx = regEx;
		this.domain = domain;
	}
	
	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getregEx() {
		return regEx;
	}

	public void setregEx(String newregEx) {
		this.regEx = newregEx;
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
