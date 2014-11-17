import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ScraperPrintTest {

	public static ArrayList<Company> Companies = new ArrayList<Company>();

	/**
	 * Prints text from the baseURL of EVERY COMPANY in the ArrayList 
	 * Only prints text that satisfies the CSS selector specified in each Company object
	 * @param Companies - ArrayList of Company objects (in main method below)
	 * @return null - method prints text from within the loop
	 */

	public void printAllByClass(ArrayList<Company> Companies) {

		for (Company comp : Companies) {
			String URL = comp.getBaseURL();
			Document doc;
			try {
				doc = Jsoup.connect(URL).get();
				Elements content = doc.getElementsByClass(comp.getCssSelector());
				for (Element e : content) {
					System.out.println(comp.getCompanyName() + e.text());
				}
			}
			catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	} 		

	/**
	 * Prints all text from the baseURL of the named company 
	 * As above, only prints the text that satisfies the CSS selector specified in its object
	 * @param companyName - name of Company object from which to extract text
	 * @return null - method prints text from within the loop
	 */

	public static void printSelectedByClass(Company companyName) {
		Document doc;
		String URL = companyName.getBaseURL();
		try {
			doc = Jsoup.connect(URL).get();
			Elements content = doc.getElementsByClass(companyName.getCssSelector());
			for (Element e : content) {
				System.out.println(companyName.getCompanyName() + " " + e.text());
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

	public static void printPFromSelected(Company companyName) {
		Document doc;
		String URL = companyName.getBaseURL();
		try {
			doc = Jsoup.connect(URL).get();
			Elements content = doc.getElementsByTag("p");
			for (Element e : content) {
				System.out.println(companyName.getCompanyName() + " " + e.text());
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

	public static void printUrlsFromSelected(Company companyName) {
		Document doc;
		String URL = companyName.getBaseURL();
		try {
			doc = Jsoup.connect(URL).get();
			Elements links = doc.getElementsByTag("a");
			for (Element link : links) {
				String linkHref = link.attr("href");
				System.out.println(companyName.getCompanyName() + " " + linkHref);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Prints only the links that match the regex pattern defined in each Company object
	 * @param name of Company object from which to extract links
	 * @return null - method prints links from within the loop
	 */
	
	public static void printCertainUrls(Company companyName) {
		Document doc;
		String URL = companyName.getBaseURL();
		try {
			doc = Jsoup.connect(URL).get();
			Elements links = doc.getElementsByTag("a");
			for (Element link : links) {
				String linkHref = link.attr("href");
				if (linkHref.matches(companyName.getregEx())) {
					System.out.println(companyName.getCompanyName() + " " + linkHref);
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	/**
	 * Prints only the links that match the regex pattern defined in each Company object
	 * @param name of Company object from which to extract links
	 * @return null - method prints links from within the loop
	 * @throws IOException 
	 */

	public static void printUrlsToFile(Company companyName) throws IOException {
		Document doc;
		String URL = companyName.getBaseURL();
		String Name = companyName.getCompanyName();
		File file = new File("/Users/Steve/Workspace/ScraperTest/Filewriter/" + Name + ".txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		try {
			doc = Jsoup.connect(URL).get();
			Elements links = doc.getElementsByTag("a");
			for (Element link : links) {
				String linkHref = link.attr("href");
				if (linkHref.matches(companyName.getregEx())) {
					bw.write(linkHref + "\n");
				}
			}
			bw.close();
			System.out.println("Results printed to" + " " + file.getAbsoluteFile());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {

		Company Samsung = new Company("Samsung", "class", "news_wrap", "http://www.samsung.com/uk/news/local/", "^.*\\/news\\/local\\/.*$");
		Companies.add(Samsung);
		Company Apple = new Company("Apple", "class", "content", "https://www.apple.com/uk/pr/library/", "^.*\\/pr\\/library\\/[0-­9]{4}\\/.*");
		Companies.add(Apple);
		Company HP = new Company("HP", "class", "article", "http://www8.hp.com/uk/en/hp-news/online-news.html", "^.*\\/en\\/hp-news\\/.*$");
		Companies.add(HP);
		Company IBM = new Company("IBM", "class", "ibm-container-body", "https://www-03.ibm.com/press/uk/en/pressreleases/recent.wss", "^.*\\/en\\/pressrelease\\/.*$");
		Companies.add(IBM);
		Company Microsoft = new Company("Microsoft", "class", "entry-content", "http://news.microsoft.com/category/press-releases/", "^.*\\/[0-­9]{4}\\/[0-9]{2}\\/[0-9]{2}\\/.*$");
		Companies.add(Microsoft);
		Company Amazon = new Company("Amazon", "class", "ccbnNewsArticle", "http://phx.corporate-ir.net/phoenix.zhtml?c=251199&p=irol-news&nyo=0", "^.*newsArticle\\&ID\\=.*$");
		Companies.add(Amazon);
		// SONY NOT WORKING - can't parse JS elements 
		//Company Sony = new Company("Sony", "class", "textParagraph", "http://www.sony.net/SonyInfo/News/Press/index.html", "^.*\\/News\\/Press\\/[0-9]{6}\\/.*$");
		//Companies.add(Sony);
		Company Panasonic = new Company("Panasonic", "class", "newsroom-article", "http://news.panasonic.co.uk/pressreleases", "^.*\\/pressreleases\\/.*$");
		Companies.add(Panasonic);
		Company Google = new Company("Google", "class", "post-content", "http://www.googlepress.blogspot.co.uk/", "^.*\\/[0-­9]{4}\\/[0-9]{2}\\/.*$");
		Companies.add(Google);
		Company Dell = new Company("Dell", "class", "uif_maincontent", "http://www.dell.com/learn/uk/en/ukcorp1/viewall/newsroom-press-releases?page=2&pageSize=50", "^.*\\/ukcorp1\\/press-releases\\/.*$");
		Companies.add(Dell);
		Company Toshiba = new Company("Toshiba", "class", "pressReleaseText", "http://www.toshiba.co.uk/press/releases/", "^.*\\/press\\/releases\\/.*$");
		Companies.add(Toshiba);
		Company LG = new Company("LG", "class", "column2", "http://www.lg.com/uk/press-release/", "^.*\\/press-release\\/.*$");
		Companies.add(LG);
		Company Intel = new Company("Intel", "class", "jive-content-body", "http://newsroom.intel.com/community/en_uk/blog/", "^.*\\/en_uk\\/blog\\/[0-­9]{4}\\/[0-9]{2}\\/.*$");
		Companies.add(Intel);
		Company Oracle = new Company("Oracle", "class", "news-details-body", "https://emeapressoffice.oracle.com/Press-Releases/", "^.*\\/Press-Releases\\/.*$");
		Companies.add(Oracle);
		//Company SAP = new Company("SAP", "class", "article", "http://www.news-sap.com/topics/press-release");
		//Companies.add(SAP);
		Company Symantec = new Company("Symantec", "class", "bckPadMedium", "http://www.symantec.com/en/uk/about/news/release/", "^.*\\/news\\/release\\/.*$");
		Companies.add(Symantec);
		Company VMWare = new Company("VMWare", "class", "mw_release", "http://www.vmware.com/uk/company/news/releases/", "^.*\\/news\\/releases\\/.*$");
		Companies.add(VMWare);
		Company CATechnologies = new Company("CATechnologies", "class", "container", "http://www.ca.com/sg/news/press-releases.aspx", "^.*\\/news\\/press-releases\\/.*$");
		Companies.add(CATechnologies);
		//Company Intuit = new Company("Intuit", "id", "pressRelease", "http://about.intuit.com/about_intuit/press_room/");
		//Companies.add(Intuit);
		Company Salesforce = new Company("Salesforce", "class", "category", "http://www.salesforce.com/uk/company/news-press/press-releases/", "^.*\\/news-press\\/press-releases\\/.*$");
		Companies.add(Salesforce);
		Company Cisco = new Company("Cisco", "id", "releasecopy", "http://newsroom.cisco.com/press-release-content?", "^.*\\/press-release-content\\?type\\=webcontent\\&articleId\\=.*$");
		Companies.add(Cisco);
		Company Siemens = new Company("Siemens", "class", "left-content", "http://www.siemens.co.uk/en/news_press/press_releases/", "^.*\\/news_press\\/index\\/news_archive\\/[0-­9]{4}\\/.*$");
		Companies.add(Siemens);
		Company EMC = new Company("EMC", "class", "news-wrapper", "http://uk.emc.com/about/news/index.htm", "^.*\\/news\\/press\\/[0-­9]{4}\\/.*$");
		Companies.add(EMC);
		
		//printUrlsFromSelected(Dell);
		printUrlsToFile(Dell);
		
	}
}



