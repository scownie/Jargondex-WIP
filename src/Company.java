import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


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
	public static ArrayList<Company> Companies = new ArrayList<Company>();

	/**
	 * Prints all links from the baseURL of the named company 
	 * @param companyName - name of Company object from which to extract links
	 * @return null - method prints links from within the loop
	 */
	void printUrlsFromSelected() {
		Document doc;
		String url = this.getBaseURL();
		try {
			doc = Jsoup.connect(url).get();
			Elements links = doc.getElementsByTag("a");
			for (Element link : links) {
				String linkHref = link.attr("href");
				System.out.println(linkHref);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Prints only the links that match the regex pattern defined in each Company object, prepends the domain where necessary
	 * @param name of Company object from which to extract links
	 * @return null - method prints links from within the loop
	 * @throws IOException 
	 */
	void printUrlsToFile() throws IOException {
		Document doc;
		String url = this.getBaseURL();
		String name = this.getCompanyName();
		File file = new File("/Users/Steve/Workspace/ScraperTest/Filewriter/" + name + ".txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		try {
			doc = Jsoup.connect(url).get();
			Elements links = doc.getElementsByTag("a");
			for (Element link : links) {
				String linkHref = link.attr("href");
				if (linkHref.matches(this.getregEx())) {
					bw.write(this.getDomain() + linkHref + "\n");
				}
			}
			bw.close();
			System.out.println("Printed to" + " " + file.getAbsoluteFile() + ", nice work m8!");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Prints only the links that match the regex pattern defined in each Company object
	 * @param name of Company object from which to extract links
	 * @return null - method prints links from within the loop
	 */
	void printCertainUrls() {
		Document doc;
		String url = this.getBaseURL();
		String name = this.getCompanyName();
		String regex = this.getregEx();
		try {
			doc = Jsoup.connect(url).get();
			Elements links = doc.getElementsByTag("a");
			for (Element link : links) {
				String linkHref = link.attr("href");
				if (linkHref.matches(regex)) {
					System.out.println(name + " " + linkHref);
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	/**
	 * Prints all links from the baseURL of the named company 
	 * @param companyName - name of Company object from which to extract links
	 * @return null - method prints links from within the loop
	 */
	void showUrls() {
		Document doc;
		String url = this.getBaseURL();
		try {
			doc = Jsoup.connect(url).get();
			Elements links = doc.getElementsByTag("a");
			for (Element link : links) {
				String linkHref = link.attr("href");
				System.out.println(linkHref);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Prints anything contained in "p" tags text from the baseURL of the named company 
	 * @param companyName - name of Company object from which to extract text
	 * @return null - method prints text from within the loop
	 */
	void showAllText() {
		Document doc;
		String url = this.getBaseURL();
		try {
			doc = Jsoup.connect(url).get();
			Elements content = doc.getElementsByTag("p");
			for (Element e : content) {
				System.out.println(this.getCompanyName() + " " + e.text());
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Reads URLs from saved .txt file for each Company, sends each line to saveContent 
	 * @param readPathAppend - 
	 * @param savePathAppend
	 */
	void readThenPrint(String readPathAppend) {
		//	StringBuffer stringBuffer = null;	
		String name = this.getCompanyName();
		int counter = 0;
		try {
			File file = new File("/Users/Steve/Workspace/ScraperTest/Filewriter/" + name + "/" + name  + readPathAppend + ".txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			//	stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				this.saveContent(line.toString(), counter);
				//stringBuffer.append(line);
				//stringBuffer.append("\n");
				counter++;
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void saveContent(String currentURL, int counter) throws IOException {
		Document doc;
		String name = this.getCompanyName();
		String css = this.getCssClassOrID();
		try {
			doc = Jsoup.connect(currentURL).get();
			File file = new File("/Users/Steve/Workspace/ScraperTest/Filewriter/" + name + "/" + doc.title() + ".txt");
			if (!file.exists()) { 
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			if (css.equals("class")) {
				Elements contentMatchingClass = doc.getElementsByClass(this.getCssSelector());
				for (Element e : contentMatchingClass) {
					bw.write(e.text() + "\n");
				}
			}
			else { Element contentMatchingID = doc.getElementById(this.getCssSelector());
			bw.write(contentMatchingID.text());
			}
			bw.close();
			fw.close();
			System.out.println("Printed to" + " " + file.getAbsoluteFile() + ", nice work m8!");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Reads URLs from saved .txt file for each Company, sends each line to saveContent 
	 * @param readPathAppend - 
	 * @param savePathAppend
	 */
	void readThenPrintLinks(String readPathAppend, String savePathAppend) {
		StringBuffer stringBuffer = null;	
		String name = this.getCompanyName();
		try {
			File file = new File("/Users/Steve/Workspace/ScraperTest/Filewriter/" + name + "/" + name  + readPathAppend + ".txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				this.saveLinks(line.toString(), savePathAppend);
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void saveLinks(String currentURL, String savePathAppend) throws IOException {
		Document doc;
		String name = this.getCompanyName();
		File file = new File("/Users/Steve/Workspace/ScraperTest/Filewriter/" + name + "/" + name + savePathAppend + ".txt");
		if (!file.exists()) { 
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
		BufferedWriter bw = new BufferedWriter(fw);
		try {
			doc = Jsoup.connect(currentURL).get();
			Elements links = doc.getElementsByTag("a");
			for (Element link : doc.select("a")) {
				if (link.absUrl("href").matches(this.getregEx())) {
					bw.write(this.getDomain() + link.absUrl("href") + "\n");
				}
			}
			bw.close();
			fw.close();
			System.out.println("Printed to" + " " + file.getAbsoluteFile() + ", nice work m8!");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
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




	public static void main(String[] args) throws IOException {
		Company Samsung = new Company("Samsung", "class", "news_wrap", "http://www.samsung.com/uk/news/local/", "^.*\\/news\\/local\\/.*$", "http://www.samsung.com");
		Companies.add(Samsung);
		Company Apple = new Company("Apple", "class", "content", "https://www.apple.com/uk/pr/library/", "^.*\\/pr\\/library\\/[0-­9]{4}\\/.*", "https://www.apple.com");
		Companies.add(Apple);
		Company HP = new Company("HP", "class", "article", "http://www8.hp.com/uk/en/hp-news/online-news.html#/facet=press-release|2014", "^.*\\/en\\/hp-news\\/.*$", "http://www8.hp.com/uk/en/hp-news/");
		Companies.add(HP);
		Company IBM = new Company("IBM", "class", "ibm-container-body", "https://www-03.ibm.com/press/uk/en/pressreleases/recent.wss", "^.*\\/en\\/pressrelease\\/.*$", "https://www-03.ibm.com");
		Companies.add(IBM);
		Company Microsoft = new Company("Microsoft", "class", "entry-content", "http://news.microsoft.com/category/press-releases/", "^.*\\/[0-­9]{4}\\/[0-9]{2}\\/[0-9]{2}\\/.*$", "");
		Companies.add(Microsoft);
		Company Amazon = new Company("Amazon", "class", "ccbnBgTxt", "http://phx.corporate-ir.net/phoenix.zhtml?c=251199&p=irol-news&nyo=0", "^.*newsArticle\\&ID\\=.*$", "http://phx.corporate-ir.net/");
		Companies.add(Amazon);
		// SONY NOT WORKING - can't parse JS elements 
		//Company Sony = new Company("Sony", "class", "textParagraph", "http://www.sony.net/SonyInfo/News/Press/index.html", "^.*\\/News\\/Press\\/[0-9]{6}\\/.*$");
		//Companies.add(Sony);
		Company Panasonic = new Company("Panasonic", "class", "newsroom-article", "http://news.panasonic.co.uk/pressreleases", "^.*\\/pressreleases\\/.*$", "http://news.panasonic.co.uk");
		Companies.add(Panasonic);
		Company Google = new Company("Google", "class", "press-content-section", "http://www.googlepress.blogspot.co.uk/", "^.*\\/[0-­9]{4}\\/[0-9]{2}\\/.*$", "");
		Companies.add(Google);
		Company Dell = new Company("Dell", "class", "uif_maincontent", "http://www.dell.com/learn/uk/en/ukcorp1/viewall/newsroom-press-releases?page=2&pageSize=50", "^.*\\/ukcorp1\\/press-releases\\/.*$", "http://www.dell.com");
		Companies.add(Dell);
		Company Toshiba = new Company("Toshiba", "class", "pressReleaseText", "http://www.toshiba.co.uk/press/releases/?pg=5&cf1=&kw=&sd=2014%2F01%2F01&ed=Date+to", "^.*\\/press\\/releases\\/.*$", "");
		Companies.add(Toshiba);
		Company LG = new Company("LG", "class", "column2", "http://www.lg.com/uk/press-release/", "^.*\\/press-release\\/.*$", "http://www.lg.com");
		Companies.add(LG);
		Company Intel = new Company("Intel", "class", "jive-content-body", "http://newsroom.intel.com/community/en_uk/blog/", "^.*\\/en_uk\\/blog\\/[0-­9]{4}\\/[0-9]{2}\\/.*$", "");
		Companies.add(Intel);
		Company Oracle = new Company("Oracle", "class", "news-details-body", "https://emeapressoffice.oracle.com/content/default.aspx?NewsAreaId=2", "^.*\\/Press-Releases\\/.*$", "https://emeapressoffice.oracle.com");
		Companies.add(Oracle);
		//Company SAP = new Company("SAP", "class", "article", "http://www.news-sap.com/topics/press-release");
		//Companies.add(SAP);
		Company Symantec = new Company("Symantec", "class", "bckPadMedium", "http://www.symantec.com/en/uk/about/news/release/", "^.*\\/news\\/release\\/article.*$", "http://www.symantec.com");
		Companies.add(Symantec);
		//Company VMWare = new Company("VMWare", "class", "mw_release", "http://www.vmware.com/company/news/releases/2014.html", "^.*\\/releases\\/vmw-newsfeed\\/.*$", "http://www.vmware.com");
		//Companies.add(VMWare);
		Company CATechnologies = new Company("CATechnologies", "class", "container", "http://www.ca.com/sg/news/press-releases.aspx?prodCat=-1&date=All", "^.*\\/news\\/press-releases\\/.*$", "http://www.ca.com");
		Companies.add(CATechnologies);
		//Company Intuit = new Company("Intuit", "id", "pressRelease", "http://about.intuit.com/about_intuit/press_room/");
		//Companies.add(Intuit);
		//Company Salesforce = new Company("Salesforce", "class", "category", "http://www.salesforce.com/uk/company/news-press/press-releases/#cursor=0&sort=desc", "^.*\\/news-press\\/press-releases\\/.*$", "http://www.salesforce.com");
		//Companies.add(Salesforce);
		Company Cisco = new Company("Cisco", "id", "press_release", "http://newsroom.cisco.com/all-news/-/articles/archive?_AllContent_WAR_AllContentportlet_INSTANCE_S8dk_windowState=maximized", "^.*\\/press-release-content\\?type\\=webcontent\\&articleId\\=.*$", "");
		Companies.add(Cisco);
		Company Siemens = new Company("Siemens", "class", "left-content", "http://www.siemens.co.uk/en/news_press/press_releases/", "^.*\\/news_press\\/index\\/news_archive\\/[0-­9]{4}\\/.*$", "http://www.siemens.co.uk/");
		Companies.add(Siemens);
		//Company EMC = new Company("EMC", "class", "title", "http://uk.emc.com/about/news/index.htm", "^.*\\/news\\/press\\/[0-­9]{4}\\/.*$", "http://uk.emc.com");
		//Companies.add(EMC);

		for (Company x : Companies) {
			Counter.checkSavedPRs(x.getCompanyName());
		}
		BufferedWriter newcsv = new BufferedWriter(new FileWriter("NewTable.csv"));
		for (Entry<String, ArrayList<String>> entry : Counter.mapTest.entrySet()) {
			String pressreleasetitle = entry.getKey();
			String jargoncount = "";
			for (String count : entry.getValue()) {
				jargoncount += count;
			}
			System.out.println(pressreleasetitle + " , " + jargoncount);
			newcsv.write(pressreleasetitle + " , " + " , " + " " + "\n" + jargoncount + "\n");
		}
		newcsv.close();

		//System.out.println("The worst offender is...\"" + Counter.runningTotalName + "\" with " + Counter.runningTotal + " jargon words");
	}

	public static ArrayList<Company> getCompanies() {
		return Companies;
	}

	public static void setCompanies(ArrayList<Company> companies) {
		Companies = companies;
	}

}
