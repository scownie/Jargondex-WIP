import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.*;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Counter {

	public static HashMap<String, ArrayList<String>> mapTest = new HashMap<String, ArrayList<String>>();
	public static String[] jargon = new String[]{"a depressive","a diabetic","a number of","able-bodied","abundance","accede to","accelerate","accentuate","accompany","accomplish","accorded","accrue","acid test","acquiesce","acquire","across the piece","across-the-piece","actioned","actively contemplating","additional","adjacent to","adjustment","admissible","advancing","advantageous","adversely impact","advocate","aforementioned","against the grain","agencies","agenda","aggregate","all of","alleviate","allocate","along the lines of","alternatively","ambassador","ameliorate","an epileptic","anticipate","apparent","apportionment","appreciable","approximately","area based","area-based","area focused","area-focused","as a means of","as of yet","as to","as yet","ascertain","assailant","assist","assistance","assisted","assisting","at this time","attain","attributable to","authorize","autonomous","axe to grind","back to square one","baseline","beacon","because of the fact that","beggars belief","beggars description","being done","belated","benchmarking","benefit from","best practice","best-practice","bestial atrocities","bestow","bitter row","bitter row","blind drunk","bloodstained tyranny","blue sky thinking","bonanza","bottom-up","brain dump","brought to a satisfactory conclusion","burning issue","by dint of","by examination","by virtue of","caas","can do culture","can-do culture","capabilities","capacity","capacity building","capturing","cascading","cashable","catalysts","categorical","cautiously welcome","cautiously welcome","cease","centricity","challenge","champion","citizen empowerment","citizen touchpoints","clampdown","clash","client","clienting","close proximity","cohesive communities","cohesiveness","cold comfort","collaborate","collaborated","collaborating","collaboration","combating","coming home to roost","coming home to roost","commence","commissioning","commit","committing","community engagement","compact","compendium","comply with","comprehensive area assessment","concerning","conditionality","confined to a wheelchair","connectedness","consensual","consequently","consolidate","constitutes","contestability","contextual","core developments","core message","core principles","core value","coterminosity","coterminous","countering","crackdown","cripple","cross-cutting","cross-fertilisation","cross-sectoral","crucial new","curb growing menaces","customer","customer insight","customer journey","deaf and dumb","deaf mute","deaf to our pleas","death toll","deep dive"," deliver ","delivery chain","democratic legitimacy","democratic mandate","demonstrate","depart","deploy","deserved serious consideration","deserves serious consideration","deserving serious consideration","designate","deus ex machine","development to be expected","dialogue","direction of travel","disbenefits","discontinue","discourse","disincentivise","disincentivised","disincentivising","distorts spending priorities","do well to bear in mind","double devolution","downstream","drive forward","drive out","drive","driven forward","driven out","driving forward","driving out","dropped a clanger","due to the fact that","dwarf","each and every","early win","econometric","economical","edge-fit","eliminate","elucidate","embedded","employ","empower","empowerment","enabler","end user","end-user","endeavor","engagement","engaging users","enhance","enumerate","epic","epoch-making","equitable","equivalent","evaluate","evidence base","evidenced","exclusively","exemplar","exhibit","expected in the near future","expedite","expend","expiration","explore every avenue","extensible","external challenge","externalities","face time","facilitate","facilitating","facing broadsides","factual evidence","faq","fast track","fast-track","feasible","feathers really flew","finalize","first and foremost","flex","flexibilities and freedoms","focusing","for the purpose of","forfeit","formulate","foster","fostering","framework","free peoples of the world","front door","fulcrum","functionality","fundamental restructuring","funding streams","future of place","future proofing","future-proofing","game plan","game-plan","gateway review","gave rise to","give rise to","given rise to","given the go ahead","given the go-ahead","go forward","going forward","gold plating","goldfish bowl facilitated conversation","good practice","good-practice","governance","greatly to be desired","grist to the mill","guidelines","having regard to","head on","head-on","headroom for change","hereditament","holistic","holistic governance","honest truth","horizon scanning","hotbed","however","hurdle","if and when","impact","impacted","implement","improvement levers","in a timely manner","in accordance with","in addition","in all likelihood","in an effort to","in between","in excess of","in lieu of","in light of the fact that","in many cases","in order to","in regard to","in some instances","in terms of","in the interests of","in the near future","in the process of","incentivise","incentivise","incentivised","incentivising","incentivising","inception","income streams","incumbent upon","indicate","indication","indicators","informatics","initiate","initiating","initiative","innovative capacity","inspectorates","interactivity","interdepartmental","interdependencies","interface","iron heel","iron resolution","is applicable to","is authorized to","is responsible for","it is essential","iteration","jackboot","joined up","joined-up","joint working","key","key asks","knowledge bite","knowledge hub","laas","land","landed","landing","lay the foundations","learning outcome","learnings","leave much to be desired","leave no stone unturned","leaves much to be desired","leaving no stone unturned","leaving no stone unturned","left no stone unturned","level playing field","lever","leverage","leveraging","liaise","liaising","lifetime neighbourhood","limped into port","living in a dream world","local area agreements","local strategic partnerships","localities","low hanging fruit","low-hanging fruit","lowlights","maas","magnitude","mainstreaming","make itself felt","management capacity","maximum","meaningful consultation","meaningful dialogue","meaningful dialogue","meaningful reusable interactivity","mechanisms","melting pot","mental patient","mentally defective","mentally handicapped","menu of options","methodology","midget","minimize","minimum","mobilise","modify","monitor","moving forward","moving toward","multi-agency","multi-area agreements","multidisciplinary","multi-disciplinary","multiple","municipalities","necessitate","neither confirm nor deny","network model","never-never land","nevertheless","new controls","no wrong door","normalising","not certain","not many","not often","not un","notwithstanding","null and void","numerous","objective","obligate","obtain","on the contrary","on the hypothesis that","on the other hand","one front door","one particular","one stop shop","one-stop shop","optimum","order of the day","outcomes","output","outrage","outsourced","overall","overarching","owing to the fact that","paradigm","parameter","participate","participatory","particulars","partnership working","partnerships","pass away","passed away","pathfinder","peer","peer challenge","performance network","pertaining to","place shaping","play a leading part","play into the hands","played a leading part","played into the hands","pledge","pledging","point in time","poised","pooled budgets","pooled resources","pooled risk","populace","portion","possess","potentialities","practitioners","preclude","predictors of beaconicity","preventative services","previously","prior to","prioritisation","prioritization","prioritize","priority","proactive","process driven","procure","procurement","proficiency","progress","progressed","promote","promoted","promoting","promulgate","proportionality","protocol","provided that","provider","provider vehicles","public sphere","pump priming","purchase", "put simply","quantum","quick hit","quick win","radical change","radical transformation","rationalisation","reablement","reach epidemic proportions","reach out to","reached out to","readily apparent","rebaselining","reconfigured","refer back","regarding","relocate","remainder","remuneration","render inoperative","rendered inoperative","require","requirement","reside","residence","resource allocation","resource efficient","retain","retarded","revenue streams","re-weaving","ride roughshod over","ride roughshod","riding roughshod","ring fence","ring fenced","ring fencing","ring the changes","ringed the changes","ringfence","ringfenced","ringing the changes","risk based","robust","safeguarding","satisfy","scaled-back","scoping","sector wise","seedbed","self-aggrandisement","self-aggrandizement","serve no good purpose","service users","set ablaze","set to","shake up","shake-up","shall","shared priority","shared priority","shell developments","should you wish","signpost","similar to","single conversations","single point of contact","situational","slim down","slimmed down","slimming down","slippage","social contracts","social exclusion","solicit","span across","spark off","spastic","spatial","speculation was rife","spelled out","stakeholder","stand shoulder to shoulder","standing shoulder to shoulder","status quo","step change","stood shoulder to shoulder","strategic","strategic priorities","strategize","streamline","streamlined","streamlined","streamlining","strengthened","strengthening","sub-regional","subnormal","subsequent","subsidiarity","subsidiary","substantial","successfully complete","such as","sufficient","sustainable","sustainable communities","swan song","sweet smell of success","symposium","synergies","synergy","systematics","tackle","tackled","tackling","takes the biscuit","tasked","taxonomy","terminate","tested for soundness","the blind","the disabled","the disabled","the fact that","the handicapped","the month of","thematic","thinking outside of the box","thinking outside the box","third sector","thought shower","time period","toe the line”,”tonality","took advantage of","toolkit","top down","top-down","tow the line","tragedy struck","trajectory","tranche","transactional","transform","transformational","transformed","transforming","transmit","transparency","transpire","trialogue","triumphant","troubled waters","under-capacitated","unforgettable","unprecedented move","until such time as","uplifting","upstream","upward trend","user friendly","utilise","utilised","utilising","utilization","utilize","validate","value-added","various different"," very ","very different","very many","vision","visionary","waiting game","wash-up session","webinar","wellbeing","wellderly","wheelchair-bound","whether or not","who blinks first","wicked issues","with respect to","with the exception of","witnessed","worklessness","world cafe","writing is on the wall","writing on the wall"};

	/**
	 * Reads a file from ScraperTest/Filewriter/...(companyName).../...(filename)...
	 * Checks each line in file against each word in jargon String array
	 * Adds the number of matches for each word to jargonCount at the same array index, and to mapTest HashMap 
	 * @param companyName - name of company (folder in ScraperTest/Filewriter/) as String
	 * @param filename - filename in folder as String
	 */

	public static void checkFile(String companyName, String filename) {
		ArrayList<String> jargontotals = new ArrayList<String>();
		long filesize = 0;
		long[] jargonCount = new long[jargon.length];
		int totalJargon = 0;
		String line;
		try {
			BufferedReader in = new BufferedReader(new FileReader("/Users/Steve/Workspace/ScraperTest/Filewriter/" + companyName + "/" + filename));
			while ((line = in.readLine()) != null) {
				line = line.toLowerCase();
				filesize += line.length();
				for (int j = 0; j < jargon.length; j++) {
					jargonCount[j] += StringUtils.countMatches(line, jargon[j]);
				}
			}
			in.close();
		}
		catch (IOException x) {
			System.out.println("ya doofus, no access to file: " + filename);
		}
		
		/**
		 * Adds any jargon matches (String and its number of matches, comma separated) to jargonTotals arraylist
		 * For each file, add filesize and total to jargonTotals arraylist
		 */
		for (int i = 0; i < jargon.length; i++) {
			if (jargonCount[i] > 0) {
				totalJargon += jargonCount[i];
				jargontotals.add(jargon[i] + " , " + jargonCount[i] + "\n");
				System.out.println("Occurences of " + "\"" + jargon[i] + "\"" + " = " + jargonCount[i]);
			}
		}
		System.out.println("Total jargon count for " + filename + " = " + totalJargon);
		filename = filename.replace(",", ""); //remove commas (helpful for CSV export) 
		jargontotals.add(filename + " total" + " , " + totalJargon + " , " + filesize + "\n");
		mapTest.put(filename, jargontotals);		
	}
	/**
	 * Finds relevant company folder saved in ScraperTest/Filewriter/...(companyName)...
	 * Sends each file to checkFile method
	 * @param companyName String - name of the company to be checked (must already have a folder in ScraperTest/Filewriter/..
	 */

	public static void checkSavedPRs(String companyName) {
		final File folder = new File("/Users/Steve/Workspace/ScraperTest/Filewriter/" + companyName);
		for (final File fileEntry : folder.listFiles()) {
			System.out.println("Checking press release: \"" + fileEntry.getName() + "\" for horrid jargon... found:");
			checkFile(companyName, fileEntry.getName());    
		}
	}


	/**
	 * Prints number of occurrences of each jargon word in a given URL
	 * 
	 * @param url
	 */


	public static void checkURL(String url) {
		String line;
		int totaljargon = 0;
		long[] jargonCount = new long[jargon.length];
		try {
			Document doc = Jsoup.connect(url).get();
			Elements content = doc.getElementsByTag("p");
			for (Element e : content) {
				line = e.text().toLowerCase();
				for (int j = 0; j < jargon.length; j++) {
					jargonCount[j] += StringUtils.countMatches(line, jargon[j]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Checking " + url + " for horrid jargon... found:");
		for (int i = 0; i < jargon.length; i++) {
			if (jargonCount[i] > 0) {
				totaljargon += jargonCount[i];
				System.out.println("Occurences of " + "\"" + jargon[i] + "\"" + " = " + jargonCount[i]);
			}
		}
		System.out.println("Total jargon count = " + totaljargon);

	}



	public static void main(String[] args) {
		checkFile("Amazon", "AmazonPRscrape25");
		//checkURL("http://www.salesforce.com/uk/company/news-press/press-releases/2014/05/140522.jsp");
	}

}
