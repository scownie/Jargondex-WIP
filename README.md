Jargondex
=============

(Will eventually):  crawl tech companies' news pages, pull press releases using CSS selectors (via JSoup), and compare the parsed content to a list of predefined jargon words.  

<h2> <b> To-do (lots): </b> </h2>

<b> &#9744; Get crawler working </b>
&#9744; Use Company.getBaseURL as starting point for crawl, e.g. http://www.samsung.com/uk/news/local/
&#9744; Test MaxDepth... 1/2?
&#9745; Add regex field in Company to feed into crawler
&#9745; Extract all links within a given path, save list in separate file for each Company object
&#9745; Find a way to feed these into methods in Company (readThenPrint(), saveContent())


<b> Encapsulate methods in Scraper.java </b>
&#9745; Add conditional statements based on whether Company.getCssClassOrID returns "class" or "ID". i.e either doc.getElementsByClass OR doc.getElementsByID
&#9745; Convert static methods in Scraper to non-static, move to Company class
&#9744; Finish generalising print/read methods in Company


<b> &#9745; Move Companies ArrayList to separate class </b>
&#9745; Add getters and setters for Companies ArrayList
&#9744; Figure out how to access/update Companies from Scraper.java


<b> &#9744; Figure out how to parse JS elements in JSoup </b>
&#9744; Extract links matching regex from EMC, Oracle, Salesforce and VMWare
&#9744; Get remaining press releases, add to file 


<b> &#9744; Start working on compare/rank algorithm </b>
&#9744; Use countOccurences as a starter (https://github.com/scownie/JavaWorksheets/blob/master/src/Ex2.java)
&#9744; Test it out with Jargone wordlist (https://github.com/rooreynolds/jargone/blob/master/jargonlist.txt)


<b> &#9744; Start gathering tech jargon list </b>
&#9744; Replace Jargone wordlist with new list when ready

