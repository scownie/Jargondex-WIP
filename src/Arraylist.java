import java.util.ArrayList;
import java.util.Iterator;

public class Arraylist {

	private static ArrayList<Company> Companies = new ArrayList<Company>();
	
	public static ArrayList<Company> getCompanies() {
		return Companies;
	}

	public static void main(String[] args) {
		Company Samsung = new Company("Samsung", "class", "news_wrap", "http://www.samsung.com/uk/news/local/");
		Companies.add(Samsung);
		Company Apple = new Company("Apple", "class", "content", "https://www.apple.com/uk/pr/library/");
		Companies.add(Apple);
		Company HP = new Company("HP", "class", "article", "http://www8.hp.com/uk/en/hp-news/online-news.html");
		Companies.add(HP);
		Company IBM = new Company("IBM", "class", "ibm-container-body", "https://www-03.ibm.com/press/uk/en/pressreleases/recent.wss");
		Companies.add(IBM);
		Company Microsoft = new Company("Microsoft", "class", "entry-content", "http://news.microsoft.com/");
		Companies.add(Microsoft);
		Company Amazon = new Company("Amazon", "class", "ccbnNewsArticle", "http://phx.corporate-ir.net/phoenix.zhtml?c=176060&p=irol-newsArticle&ID=");
		Companies.add(Amazon);
		Company Sony = new Company("Sony", "class", "textParagraph", "http://www.sony.net/SonyInfo/News/Press/");
		Companies.add(Sony);
		Company Panasonic = new Company("Panasonic", "class", "newsroom-article", "http://news.panasonic.co.uk/pressreleases/");
		Companies.add(Panasonic);
		Company Google = new Company("Google", "class", "post-content", "http://www.googlepress.blogspot.co.uk/");
		Companies.add(Google);
		Company Dell = new Company("Dell", "class", "uif_maincontent", "http://www.dell.com/learn/uk/en/ukcorp1/newsroom-press-releases/");
		Companies.add(Dell);
		Company Toshiba = new Company("Toshiba", "class", "pressReleaseText", "http://www.toshiba.co.uk/press/releases/");
		Companies.add(Toshiba);
		Company LG = new Company("LG", "class", "column2", "http://www.lg.com/uk/press-release/");
		Companies.add(LG);
		Company Intel = new Company("Intel", "class", "jive-content-body", "http://newsroom.intel.com/community/en_uk/blog/");
		Companies.add(Intel);	
		Company Oracle = new Company("Oracle", "class", "news-details-body", "https://emeapressoffice.oracle.com/Press-Releases/");
		Companies.add(Oracle);
		Company SAP = new Company("SAP", "class", "article", "http://www.news-sap.com/topics/press-release/");
		Companies.add(SAP);
		Company Symantec = new Company("Symantec", "class", "bckPadMedium", "http://www.symantec.com/en/uk/about/news/release/");
		Companies.add(Symantec);
		Company VMWare = new Company("VMWare", "class", "mw_release", "http://www.vmware.com/uk/company/news/releases/");
		Companies.add(VMWare);
		Company CATechnologies = new Company("CATechnologies", "class", "container", "http://www.ca.com/sg/news/press-releases/");
		Companies.add(CATechnologies);
		Company Intuit = new Company("Intuit", "id", "pressRelease", "http://about.intuit.com/about_intuit/press_room/");
		Companies.add(Intuit);
		Company Salesforce = new Company("Salesforce", "class", "category", "http://www.salesforce.com/uk/company/news-press/press-releases/");
		Companies.add(Salesforce);
		Company Cisco = new Company("Cisco", "id", "releasecopy", "http://newsroom.cisco.com/press-release-content?");
		Companies.add(Cisco);
		Company Siemens = new Company("Siemens", "class", "left-content", "http://www.siemens.co.uk/en/news_press/index/news_archive/");
		Companies.add(Siemens);
		Company EMC = new Company("EMC", "class", "news-wrapper", "http://uk.emc.com/about/news/press/");
		Companies.add(EMC);
	
		Iterator<Company> itr = Companies.iterator();
	      while(itr.hasNext()) {
	         Object element = itr.next().getCompanyName();
	         System.out.print(element + " ");
	      }
	}     
}
