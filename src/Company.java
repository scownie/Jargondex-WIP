import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
	void readThenPrint(String readPathAppend, String savePathAppend) {
		StringBuffer stringBuffer = null;	
		String name = this.getCompanyName();
		int counter = 0;
		try {
				File file = new File("/Users/Steve/Workspace/ScraperTest/Filewriter/" + name + "/" + name  + readPathAppend + ".txt");
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				stringBuffer = new StringBuffer();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					this.saveContent(line.toString(), counter, savePathAppend);
					stringBuffer.append(line);
					stringBuffer.append("\n");
					counter++;
				}
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	 void saveContent(String currentURL, int counter, String savePathAppend) throws IOException {
		Document doc;
		String name = this.getCompanyName();
		String css = this.getCssClassOrID();
		File file = new File("/Users/Steve/Workspace/ScraperTest/Filewriter/" + name + "/" + name + savePathAppend + counter + ".txt");
		if (!file.exists()) { 
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		try {
			doc = Jsoup.connect(currentURL).get();
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

	

	public static void main(String[] args) {
		
		
		
	}

}
