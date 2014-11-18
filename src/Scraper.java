import java.io.IOException;
import java.util.ArrayList;

public class Scraper {
	
	public static ArrayList<Company> Companies = new ArrayList<Company>();
		
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
		Company VMWare = new Company("VMWare", "class", "mw_release", "http://www.vmware.com/company/news/releases/2014.html", "^.*\\/releases\\/vmw-newsfeed\\/.*$", "http://www.vmware.com");
		Companies.add(VMWare);
		Company CATechnologies = new Company("CATechnologies", "class", "container", "http://www.ca.com/sg/news/press-releases.aspx?prodCat=-1&date=All", "^.*\\/news\\/press-releases\\/.*$", "http://www.ca.com");
		Companies.add(CATechnologies);
		//Company Intuit = new Company("Intuit", "id", "pressRelease", "http://about.intuit.com/about_intuit/press_room/");
		//Companies.add(Intuit);
		Company Salesforce = new Company("Salesforce", "class", "category", "http://www.salesforce.com/uk/company/news-press/press-releases/#cursor=0&sort=desc", "^.*\\/news-press\\/press-releases\\/.*$", "http://www.salesforce.com");
		Companies.add(Salesforce);
		Company Cisco = new Company("Cisco", "id", "press_release", "http://newsroom.cisco.com/all-news/-/articles/archive?_AllContent_WAR_AllContentportlet_INSTANCE_S8dk_windowState=maximized", "^.*\\/press-release-content\\?type\\=webcontent\\&articleId\\=.*$", "");
		Companies.add(Cisco);
		Company Siemens = new Company("Siemens", "class", "left-content", "http://www.siemens.co.uk/en/news_press/press_releases/", "^.*\\/news_press\\/index\\/news_archive\\/[0-­9]{4}\\/.*$", "http://www.siemens.co.uk/");
		Companies.add(Siemens);
		Company EMC = new Company("EMC", "class", "news-wrapper", "http://uk.emc.com/about/news/index.htm", "^.*\\/news\\/press\\/[0-­9]{4}\\/.*$", "http://uk.emc.com");
		Companies.add(EMC);
		
		//printUrlsFromSelected(Dell);
		//printSelectedByClass(Google);
		//printUrlsToFile(EMC);
		//printCertainUrls(HP);
		for (Company x : Companies) {
			x.showUrls();
		}
		;
		
	}
}



