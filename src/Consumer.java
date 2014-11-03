import java.io.IOException;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Consumer {

	public void start(){
		crawl();
	}
	
	private void crawl() {
		String crawlUrl = this.getCrawlURL();
		HashSet<String> anchors = new HashSet<String>();
		
		try {
			Document doc = Jsoup.connect(crawlUrl).get();
			Elements hrefs = doc.select("a");
			for (Element e: hrefs) {
				String anchor = e.attr("href").trim();
				anchors.add(anchor);
				System.out.println(anchor);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("=====");
		for (String s:anchors) {
			System.out.println(s);
		}

	}
	
	private String getCrawlURL() {
		String url = "http://newsroom.cisco.com/pressreleases";
		return url;
	}
}
