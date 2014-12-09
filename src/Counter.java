import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.lang.*;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
	
	public static ArrayList<String> totals = new ArrayList<String>();
	public static long runningTotal = 0;
	public static String runningTotalName = null;
	
	
	public static void checkFile(String companyName, String filename) {
		String[] jargon = new String[]{"oracle", "technology", "efficiency", "unrivalled", "unparalleled", "leverage", "innovative", "paradigm", "business", "high-performance", "disruptive", "amazing"};
		String[] jargonnew = new String[]{"a depressive","a diabetic","a number of","able-bodied","abundance","accede to","accelerate","accentuate","accompany","accomplish","accorded","accrue","acid test","acquiesce","acquire","across the piece","across-the-piece","actioned","actively contemplating","additional","adjacent to","adjustment","admissible","advancing","advantageous","adversely impact","advocate","aforementioned","against the grain","agencies","agenda","aggregate","all of","alleviate","allocate","along the lines of","alternatively","ambassador","ameliorate","an epileptic","anticipate","apparent","apportionment","appreciable","approximately","area based","area-based","area focused","area-focused","as a means of","as of yet","as to","as yet","ascertain","assailant","assist","assistance","assisted","assisting","at this time","attain","attributable to","authorize","autonomous","axe to grind","back to square one","baseline","beacon","because of the fact that","beggars belief","beggars description","being done","belated","benchmarking","benefit from","best practice","best-practice","bestial atrocities","bestow","bitter row","bitter row","blind drunk","bloodstained tyranny","blue sky thinking","bonanza","bottom-up","brain dump","brought to a satisfactory conclusion","burning issue","by dint of","by examination","by virtue of","caas","can do culture","can-do culture","capabilities","capacity","capacity building","capturing","cascading","cashable","catalysts","categorical","cautiously welcome","cautiously welcome","cease","centricity","challenge","champion","citizen empowerment","citizen touchpoints","clampdown","clash","client","clienting","close proximity","cohesive communities","cohesiveness","cold comfort","collaborate","collaborated","collaborating","collaboration","combating","coming home to roost","coming home to roost","commence","commissioning","commit","committing","community engagement","compact","compendium","comply with","comprehensive area assessment","concerning","conditionality","confined to a wheelchair","connectedness","consensual","consequently","consolidate","constitutes","contestability","contextual","core developments","core message","core principles","core value","coterminosity","coterminous","countering","crackdown","cripple","cross-cutting","cross-fertilisation","cross-sectoral","crucial new","curb growing menaces","customer","customer insight","customer journey","deaf and dumb","deaf mute","deaf to our pleas","death toll","deep dive","deliver","delivery chain","democratic legitimacy","democratic mandate","demonstrate","depart","deploy","deserved serious consideration","deserves serious consideration","deserving serious consideration","designate","deus ex machine","development to be expected","dialogue","direction of travel","disbenefits","discontinue","discourse","disincentivise","disincentivised","disincentivising","distorts spending priorities","do well to bear in mind","double devolution","downstream","drive forward","drive out","drive","driven forward","driven out","driving forward","driving out","dropped a clanger","due to the fact that","dwarf","each and every","early win","econometric","economical","edge-fit","eliminate","elucidate","embedded","employ","empower","empowerment","enabler","end user","end-user","endeavor","engagement","engaging users","enhance","enumerate","epic","epoch-making","equitable","equivalent","evaluate","evidence base","evidenced","exclusively","exemplar","exhibit","expected in the near future","expedite","expend","expiration","explore every avenue","extensible","external challenge","externalities","face time","facilitate","facilitating","facing broadsides","factual evidence","faq","fast track","fast-track","feasible","feathers really flew","finalize","first and foremost","flex","flexibilities and freedoms","focusing","for the purpose of","forfeit","formulate","foster","fostering","framework","free peoples of the world","front door","fulcrum","functionality","fundamental restructuring","funding streams","future of place","future proofing","future-proofing","game plan","game-plan","gateway review","gave rise to","give rise to","given rise to","given the go ahead","given the go-ahead","go forward","going forward","gold plating","goldfish bowl facilitated conversation","good practice","good-practice","governance","greatly to be desired","grist to the mill","guidelines","having regard to","head on","head-on","headroom for change","hereditament","holistic","holistic governance","honest truth","horizon scanning","hotbed","however","hurdle","if and when","impact","impacted","implement","improvement levers","in a timely manner","in accordance with","in addition","in all likelihood","in an effort to","in between","in excess of","in lieu of","in light of the fact that","in many cases","in order to","in regard to","in some instances","in terms of","in the interests of","in the near future","in the process of","incentivise","incentivise","incentivised","incentivising","incentivising","inception","income streams","incumbent upon","indicate","indication","indicators","informatics","initiate","initiating","initiative","innovative capacity","inspectorates","interactivity","interdepartmental","interdependencies","interface","iron heel","iron resolution","is applicable to","is authorized to","is responsible for","it is essential","iteration","jackboot","joined up","joined-up","joint working","key","key asks","knowledge bite","knowledge hub","laas","land","landed","landing","lay the foundations","learning outcome","learnings","leave much to be desired","leave no stone unturned","leaves much to be desired","leaving no stone unturned","leaving no stone unturned","left no stone unturned","level playing field","lever","leverage","leveraging","liaise","liaising","lifetime neighbourhood","limped into port","living in a dream world","local area agreements","local strategic partnerships","localities","low hanging fruit","low-hanging fruit","lowlights","maas","magnitude","mainstreaming","make itself felt","management capacity","maximum","meaningful consultation","meaningful dialogue","meaningful dialogue","meaningful reusable interactivity","mechanisms","melting pot","mental patient","mentally defective","mentally handicapped","menu of options","methodology","midget","minimize","minimum","mobilise","modify","monitor","moving forward","moving toward","multi-agency","multi-area agreements","multidisciplinary","multi-disciplinary","multiple","municipalities","necessitate","neither confirm nor deny","network model","never-never land","nevertheless","new controls","no wrong door","normalising","not certain","not many","not often","not un","notwithstanding","null and void","numerous","objective","obligate","obtain","on the contrary","on the hypothesis that","on the other hand","one front door","one particular","one stop shop","one-stop shop","optimum","order of the day","outcomes","output","outrage","outsourced","overall","overarching","owing to the fact that","paradigm","parameter","participate","participatory","particulars","partnership working","partnerships","pass away","passed away","pathfinder","peer","peer challenge","performance network","pertaining to","place shaping","play a leading part","play into the hands","played a leading part","played into the hands","pledge","pledging","point in time","poised","pooled budgets","pooled resources","pooled risk","populace","portion","possess","potentialities","practitioners","preclude","predictors of beaconicity","preventative services","previously","prior to","prioritisation","prioritization","prioritize","priority","proactive","process driven","procure","procurement","proficiency","progress","progressed","promote","promoted","promoting","promulgate","proportionality","protocol","provided that","provider","provider vehicles","public sphere","pump priming","purchase", "put simply","quantum","quick hit","quick win","radical change","radical transformation","rationalisation","reablement","reach epidemic proportions","reach out to","reached out to","readily apparent","rebaselining","reconfigured","refer back","regarding","relocate","remainder","remuneration","render inoperative","rendered inoperative","require","requirement","reside","residence","resource allocation","resource efficient","retain","retarded","revenue streams","re-weaving","ride roughshod over","ride roughshod","riding roughshod","ring fence","ring fenced","ring fencing","ring the changes","ringed the changes","ringfence","ringfenced","ringing the changes","risk based","robust","safeguarding","satisfy","scaled-back","scoping","sector wise","seedbed","self-aggrandisement","self-aggrandizement","serve no good purpose","service users","set ablaze","set to","shake up","shake-up","shall","shared priority","shared priority","shell developments","should you wish","signpost","similar to","single conversations","single point of contact","situational","slim down","slimmed down","slimming down","slippage","social contracts","social exclusion","solicit","span across","spark off","spastic","spatial","speculation was rife","spelled out","stakeholder","stand shoulder to shoulder","standing shoulder to shoulder","status quo","step change","stood shoulder to shoulder","strategic","strategic priorities","strategize","streamline","streamlined","streamlined","streamlining","strengthened","strengthening","sub-regional","subnormal","subsequent","subsidiarity","subsidiary","substantial","successfully complete","such as","sufficient","sustainable","sustainable communities","swan song","sweet smell of success","symposium","synergies","synergy","systematics","tackle","tackled","tackling","takes the biscuit","tasked","taxonomy","terminate","tested for soundness","the blind","the disabled","the disabled","the fact that","the handicapped","the month of","thematic","thinking outside of the box","thinking outside the box","third sector","thought shower","time period","toe the line”,”tonality","took advantage of","toolkit","top down","top-down","tow the line","tragedy struck","trajectory","tranche","transactional","transform","transformational","transformed","transforming","transmit","transparency","transpire","trialogue","triumphant","troubled waters","under-capacitated","unforgettable","unprecedented move","until such time as","uplifting","upstream","upward trend","user friendly","utilise","utilised","utilising","utilization","utilize","validate","value-added","various different","very","very different","very many","vision","visionary","waiting game","wash-up session","webinar","wellbeing","wellderly","wheelchair-bound","whether or not","who blinks first","wicked issues","with respect to","with the exception of","witnessed","worklessness","world cafe","writing is on the wall","writing on the wall"};
		long[] jargonCount = new long[jargon.length];
		long[] jargonCountnew = new long[jargonnew.length];
		long totalJargon = 0;
		String line;
		try {
			BufferedReader in = new BufferedReader(new FileReader("/Users/Steve/Workspace/ScraperTest/Filewriter/" + companyName + "/" + filename));
			while ((line = in.readLine()) != null) {
				line = line.toLowerCase();
				for (int j = 0; j < jargonnew.length; j++) {
					jargonCountnew[j] += StringUtils.countMatches(line, jargonnew[j]);
				}
			}
			in.close();
		}
		catch (IOException x) {
			System.out.println("ya doofus, no access to file: " + filename);
		}
		for (int i = 0; i < jargonnew.length; i++) {
			if (jargonCountnew[i] > 0) {
				totalJargon += jargonCountnew[i];
				System.out.println("Occurences of " + "\"" + jargonnew[i] + "\"" + " = " + jargonCountnew[i]);
			}
		}
		System.out.println("Total jargon count = " + totalJargon);
		totals.add(filename + " total jargon count = " + totalJargon);
		if (totalJargon > runningTotal) {
			runningTotal = totalJargon;
			runningTotalName = filename;
		}
		//totals.add("The worst offender is...\"" + runningTotalName + "\" with " + runningTotal + " jargon words");
	}

	public static void checkSavedPRs(String companyName) {
		final File folder = new File("/Users/Steve/Workspace/ScraperTest/Filewriter/" + companyName);
		for (final File fileEntry : folder.listFiles()) {
			System.out.println("Checking press release: \"" + fileEntry.getName() + "\" for horrid jargon... found:");
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
/**
 * Returns number of occurrences of each jargon word
 * @param url
 */
	

	public static void checkURLForJargon(String url) {
		String line;
		String[] jargonnew = new String[]{"a depressive","a diabetic","a number of","able-bodied","abundance","accede to","accelerate","accentuate","accompany","accomplish","accorded","accrue","acid test","acquiesce","acquire","across the piece","across-the-piece","actioned","actively contemplating","additional","adjacent to","adjustment","admissible","advancing","advantageous","adversely impact","advocate","aforementioned","against the grain","agencies","agenda","aggregate","all of","alleviate","allocate","along the lines of","alternatively","ambassador","ameliorate","an epileptic","anticipate","apparent","apportionment","appreciable","approximately","area based","area-based","area focused","area-focused","as a means of","as of yet","as to","as yet","ascertain","assailant","assist","assistance","assisted","assisting","at this time","attain","attributable to","authorize","autonomous","axe to grind","back to square one","baseline","beacon","because of the fact that","beggars belief","beggars description","being done","belated","benchmarking","benefit from","best practice","best-practice","bestial atrocities","bestow","bitter row","bitter row","blind drunk","bloodstained tyranny","blue sky thinking","bonanza","bottom-up","brain dump","brought to a satisfactory conclusion","burning issue","by dint of","by examination","by virtue of","caas","can do culture","can-do culture","capabilities","capacity","capacity building","capturing","cascading","cashable","catalysts","categorical","cautiously welcome","cautiously welcome","cease","centricity","challenge","champion","citizen empowerment","citizen touchpoints","clampdown","clash","client","clienting","close proximity","cohesive communities","cohesiveness","cold comfort","collaborate","collaborated","collaborating","collaboration","combating","coming home to roost","coming home to roost","commence","commissioning","commit","committing","community engagement","compact","compendium","comply with","comprehensive area assessment","concerning","conditionality","confined to a wheelchair","connectedness","consensual","consequently","consolidate","constitutes","contestability","contextual","core developments","core message","core principles","core value","coterminosity","coterminous","countering","crackdown","cripple","cross-cutting","cross-fertilisation","cross-sectoral","crucial new","curb growing menaces","customer","customer insight","customer journey","deaf and dumb","deaf mute","deaf to our pleas","death toll","deep dive","deliver","delivery chain","democratic legitimacy","democratic mandate","demonstrate","depart","deploy","deserved serious consideration","deserves serious consideration","deserving serious consideration","designate","deus ex machine","development to be expected","dialogue","direction of travel","disbenefits","discontinue","discourse","disincentivise","disincentivised","disincentivising","distorts spending priorities","do well to bear in mind","double devolution","downstream","drive forward","drive out","drive","driven forward","driven out","driving forward","driving out","dropped a clanger","due to the fact that","dwarf","each and every","early win","econometric","economical","edge-fit","eliminate","elucidate","embedded","employ","empower","empowerment","enabler","end user","end-user","endeavor","engagement","engaging users","enhance","enumerate","epic","epoch-making","equitable","equivalent","evaluate","evidence base","evidenced","exclusively","exemplar","exhibit","expected in the near future","expedite","expend","expiration","explore every avenue","extensible","external challenge","externalities","face time","facilitate","facilitating","facing broadsides","factual evidence","faq","fast track","fast-track","feasible","feathers really flew","finalize","first and foremost","flex","flexibilities and freedoms","focusing","for the purpose of","forfeit","formulate","foster","fostering","framework","free peoples of the world","front door","fulcrum","functionality","fundamental restructuring","funding streams","future of place","future proofing","future-proofing","game plan","game-plan","gateway review","gave rise to","give rise to","given rise to","given the go ahead","given the go-ahead","go forward","going forward","gold plating","goldfish bowl facilitated conversation","good practice","good-practice","governance","greatly to be desired","grist to the mill","guidelines","having regard to","head on","head-on","headroom for change","hereditament","holistic","holistic governance","honest truth","horizon scanning","hotbed","however","hurdle","if and when","impact","impacted","implement","improvement levers","in a timely manner","in accordance with","in addition","in all likelihood","in an effort to","in between","in excess of","in lieu of","in light of the fact that","in many cases","in order to","in regard to","in some instances","in terms of","in the interests of","in the near future","in the process of","incentivise","incentivise","incentivised","incentivising","incentivising","inception","income streams","incumbent upon","indicate","indication","indicators","informatics","initiate","initiating","initiative","innovative capacity","inspectorates","interactivity","interdepartmental","interdependencies","interface","iron heel","iron resolution","is applicable to","is authorized to","is responsible for","it is essential","iteration","jackboot","joined up","joined-up","joint working","key","key asks","knowledge bite","knowledge hub","laas","land","landed","landing","lay the foundations","learning outcome","learnings","leave much to be desired","leave no stone unturned","leaves much to be desired","leaving no stone unturned","leaving no stone unturned","left no stone unturned","level playing field","lever","leverage","leveraging","liaise","liaising","lifetime neighbourhood","limped into port","living in a dream world","local area agreements","local strategic partnerships","localities","low hanging fruit","low-hanging fruit","lowlights","maas","magnitude","mainstreaming","make itself felt","management capacity","maximum","meaningful consultation","meaningful dialogue","meaningful dialogue","meaningful reusable interactivity","mechanisms","melting pot","mental patient","mentally defective","mentally handicapped","menu of options","methodology","midget","minimize","minimum","mobilise","modify","monitor","moving forward","moving toward","multi-agency","multi-area agreements","multidisciplinary","multi-disciplinary","multiple","municipalities","necessitate","neither confirm nor deny","network model","never-never land","nevertheless","new controls","no wrong door","normalising","not certain","not many","not often","not un","notwithstanding","null and void","numerous","objective","obligate","obtain","on the contrary","on the hypothesis that","on the other hand","one front door","one particular","one stop shop","one-stop shop","optimum","order of the day","outcomes","output","outrage","outsourced","overall","overarching","owing to the fact that","paradigm","parameter","participate","participatory","particulars","partnership working","partnerships","pass away","passed away","pathfinder","peer","peer challenge","performance network","pertaining to","place shaping","play a leading part","play into the hands","played a leading part","played into the hands","pledge","pledging","point in time","poised","pooled budgets","pooled resources","pooled risk","populace","portion","possess","potentialities","practitioners","preclude","predictors of beaconicity","preventative services","previously","prior to","prioritisation","prioritization","prioritize","priority","proactive","process driven","procure","procurement","proficiency","progress","progressed","promote","promoted","promoting","promulgate","proportionality","protocol","provided that","provider","provider vehicles","public sphere","pump priming","purchase", "put simply","quantum","quick hit","quick win","radical change","radical transformation","rationalisation","reablement","reach epidemic proportions","reach out to","reached out to","readily apparent","rebaselining","reconfigured","refer back","regarding","relocate","remainder","remuneration","render inoperative","rendered inoperative","require","requirement","reside","residence","resource allocation","resource efficient","retain","retarded","revenue streams","re-weaving","ride roughshod over","ride roughshod","riding roughshod","ring fence","ring fenced","ring fencing","ring the changes","ringed the changes","ringfence","ringfenced","ringing the changes","risk based","robust","safeguarding","satisfy","scaled-back","scoping","sector wise","seedbed","self-aggrandisement","self-aggrandizement","serve no good purpose","service users","set ablaze","set to","shake up","shake-up","shall","shared priority","shared priority","shell developments","should you wish","signpost","similar to","single conversations","single point of contact","situational","slim down","slimmed down","slimming down","slippage","social contracts","social exclusion","solicit","span across","spark off","spastic","spatial","speculation was rife","spelled out","stakeholder","stand shoulder to shoulder","standing shoulder to shoulder","status quo","step change","stood shoulder to shoulder","strategic","strategic priorities","strategize","streamline","streamlined","streamlined","streamlining","strengthened","strengthening","sub-regional","subnormal","subsequent","subsidiarity","subsidiary","substantial","successfully complete","such as","sufficient","sustainable","sustainable communities","swan song","sweet smell of success","symposium","synergies","synergy","systematics","tackle","tackled","tackling","takes the biscuit","tasked","taxonomy","terminate","tested for soundness","the blind","the disabled","the disabled","the fact that","the handicapped","the month of","thematic","thinking outside of the box","thinking outside the box","third sector","thought shower","time period","toe the line”,”tonality","took advantage of","toolkit","top down","top-down","tow the line","tragedy struck","trajectory","tranche","transactional","transform","transformational","transformed","transforming","transmit","transparency","transpire","trialogue","triumphant","troubled waters","under-capacitated","unforgettable","unprecedented move","until such time as","uplifting","upstream","upward trend","user friendly","utilise","utilised","utilising","utilization","utilize","validate","value-added","various different","very","very different","very many","vision","visionary","waiting game","wash-up session","webinar","wellbeing","wellderly","wheelchair-bound","whether or not","who blinks first","wicked issues","with respect to","with the exception of","witnessed","worklessness","world cafe","writing is on the wall","writing on the wall"};
		int totaljargon = 0;
		long[] jargonCountnew = new long[jargonnew.length];
		try {
			Document doc = Jsoup.connect(url).get();
			Elements content = doc.getElementsByTag("p");
			for (Element e : content) {
				line = e.text().toLowerCase();
				for (int j = 0; j < jargonnew.length; j++) {
					jargonCountnew[j] += StringUtils.countMatches(line, jargonnew[j]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Checking " + url + " for horrid jargon... found:");
		for (int i = 0; i < jargonnew.length; i++) {
			if (jargonCountnew[i] > 0) {
				totaljargon += jargonCountnew[i];
				System.out.println("Occurences of " + "\"" + jargonnew[i] + "\"" + " = " + jargonCountnew[i]);
			}
		}
		System.out.println("Total jargon count = " + totaljargon);
	
	}

	
	
	public static void main(String[] args) {
		//readFromURL("http://www.cs.bham.ac.uk/internal/courses/java/msc/handouts/exercises/DonQuixote.txt", "DonQuixote");
		//checkFile("SamsungPRscrape4");
		//readFromFile("jargonshite", "jargonshiteNEW");

		for (Company x : Company.getCompanies()) {
			System.out.println(x.getCompanyName());
		}
		//checkSavedPRs("IBM");
	
		
		//checkSavedPRs("Samsung");

		//checkURLForJargon("https://gds.blog.gov.uk/2014/12/08/code-club-at-gds/");
		//fileList2();
	}

}
