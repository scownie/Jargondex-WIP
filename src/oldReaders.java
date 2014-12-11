import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;



public class oldReaders {
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

	public static String readFromFile(String filepath, String savepath){
		String line;
		try {
			BufferedReader in = new BufferedReader(new FileReader(filepath + ".txt"));
			BufferedWriter out = new BufferedWriter(new FileWriter(savepath + ".txt"));
			while ((line = in.readLine()) != null) {
				out.write(line.toLowerCase() + ",");
			}
			in.close();
			out.close();
		}
		catch (IOException x) {
			System.out.println("no access to URL: " + filepath);
		}
		System.out.println("Saved to " + savepath + ".txt");
		return savepath;
	}
}
