import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.lang.*;

import org.apache.commons.lang3.StringUtils;

public class Counter {

	public static String readFromURL(String url, String savepath){
		String line;
		try {
			URL toRead = new URL(url);
			BufferedReader in = new BufferedReader(new InputStreamReader(toRead.openStream()));
			BufferedWriter out = new BufferedWriter(new FileWriter(savepath + ".txt"));
			while ((line = in.readLine()) != null) {
				out.write(line.toLowerCase() + "\n");
			}
			in.close();
			out.close();
		}
		catch (IOException x) {
			System.out.println("no access to URL: " + url);
		}
		System.out.println("Saved to " + savepath + ".txt");
		return savepath;
	}

	public static void checkFile(String companyName, String filename) {
		String[] jargon = new String[]{"oracle", "technology", "efficiency", "unrivalled", "unparalleled", "leverage", "innovative", "paradigm", "business", "high-performance", "disruptive", "amazing"};
		long[] jargonCount = new long[jargon.length];
		String line;
		try {
			BufferedReader in = new BufferedReader(new FileReader("/Users/Steve/Workspace/ScraperTest/Filewriter/" + companyName + "/" + filename));
			while ((line = in.readLine()) != null) {
				line.toLowerCase();
				for (int j = 0; j < jargon.length; j++) {
					jargonCount[j] += StringUtils.countMatches(line, jargon[j]);
				}
			}
			in.close();
		}
		catch (IOException x) {
			System.out.println("ya doofus, no access to file: " + filename);
		}
		for (int i = 0; i < jargon.length; i++) {
			System.out.println("Occurences of " + jargon[i] + " = " + jargonCount[i]);
		}
	}

public static void listFilesForFolder(String companyName) {
	final File folder = new File("/Users/Steve/Workspace/ScraperTest/Filewriter/" + companyName);
    for (final File fileEntry : folder.listFiles()) {
    	System.out.println(fileEntry.getName());
        checkFile(companyName, fileEntry.getName());    
    }
}

public static String listFilesForFolder2(String companyName) {
	final File folder = new File("/Users/Steve/Workspace/ScraperTest/Filewriter/" + companyName);
	String files = null;
    for (final File fileEntry : folder.listFiles()) {
    	files += fileEntry.getName() + "\n";
    	System.out.println(fileEntry.getName());
        checkFile(companyName, fileEntry.getName());    
    }
	return files;
    
}

public static void checkForJargon(String companyName) {
	listFilesForFolder2(companyName);
	
}

	public static void main(String[] args) {
		//readFromURL("http://www.cs.bham.ac.uk/internal/courses/java/msc/handouts/exercises/DonQuixote.txt", "DonQuixote");
		//checkFile("SamsungPRscrape4");
		for (Company x : Scraper.Companies) {
			listFilesForFolder(x.getCompanyName());
		}
		//listFilesForFolder("Intel");

		//fileList2();
	}

}
