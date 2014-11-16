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
		Company HP = new Company("HP", "class", "article", "http://www8.hp.com/uk/en/hp-news/");
		Companies.add(HP);
		Company IBM = new Company("IBM", "class", "ibm-container-body", "https://www-03.ibm.com/press/uk/en/pressrelease/");
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
	/**
		for(Company n : Companies) {
			System.out.print(n.getCompanyName() + " ");
		}
		
		for(int i = 0; i<Companies.size(); i++) {
			System.out.println(Companies.get(i).getCompanyName());
		}
		*/
		Iterator<Company> itr = Companies.iterator();
	      while(itr.hasNext()) {
	         Object element = itr.next().getCssClassOrID();
	         System.out.print(element + " ");
	      }
	}     
}
