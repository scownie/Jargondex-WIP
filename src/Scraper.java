import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Scraper {

	private static ArrayList<Company> Companies = new ArrayList<Company>();

	public static ArrayList<Company> getCompanies() {
		return Companies;
	}



	public static void main(String[] args) throws IOException {

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
		Company Panasonic = new Company("Panasonic", "class", "newsroom-article", "http://news.panasonic.co.uk/pressreleases");
		Companies.add(Panasonic);
		Company Google = new Company("Google", "class", "post-content", "http://www.googlepress.blogspot.co.uk/");
		Companies.add(Google);
		Company Dell = new Company("Dell", "class", "uif_maincontent", "http://www.dell.com/learn/uk/en/ukcorp1/newsroom-press-releases");
		Companies.add(Dell);
		Company Toshiba = new Company("Toshiba", "class", "pressReleaseText", "http://www.toshiba.co.uk/press/releases/");
		Companies.add(Toshiba);
		Company LG = new Company("LG", "class", "column2", "http://www.lg.com/uk/press-release");
		Companies.add(LG);
		Company Intel = new Company("Intel", "class", "jive-content-body", "http://newsroom.intel.com/community/en_uk/blog/");
		Companies.add(Intel);	

		// This gets text based on CSS selector defined for one particular Company in Companies ArrayList

		String contenttoPrint = null;

		// This gets text based on CSS selector defined for each Company in Companies ArrayList
		//for (Company comp : Companies) {
		//String URL = comp.getBaseURL();
		Document doc = Jsoup.connect(Microsoft.getBaseURL()).get();
		Elements content = doc.getElementsByTag("p");
		for (Element e : content) {
			contenttoPrint = e.text();
		}
	

	try {

		String content2 = contenttoPrint;

		File file = new File("/Users/Steve/Workspace/ScraperTest/Filewriter/Filewriter.txt");

		// if file doesn't exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(content2);
		bw.close();

		System.out.println("Done");

	} catch (IOException e) {
		e.printStackTrace();
	}

	/**
		Document doc = Jsoup.connect(Companies.get(Companies.indexOf(Intel)).getBaseURL()).get();
		Elements content = doc.getElementsByClass("jive-content-body");

		for (Element e : content) {
			System.out.println(e.text());
		}


		/**
		//This gets all text with a "p" tag
		for (Company comp: Companies) {
			String URL = comp.getBaseURL();
			Document doc = Jsoup.connect(URL).get();
			Elements text = doc.getElementsByTag("p");
			for (Element e : text) {
				System.out.println(comp.getCompanyName() + " " + e.text());
			}
		}



	// This gets all links from the baseURL of each Company in the Companies ArrayList

	 	for (Company comp : Companies) {
			String URL = comp.getBaseURL();
			Document doc2 = Jsoup.connect(URL).get();
			Elements links = doc2.getElementsByTag("a");
				for (Element link : links) {
					String linkHref = link.attr("href");
					System.out.println(comp.getCompanyName() + " " + linkHref);
				}
		}
	 */
}
}





