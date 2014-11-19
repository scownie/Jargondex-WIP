Jargondex
=============

(Will eventually): crawl tech companies' news pages, pull press releases using CSS selectors (via JSoup), and compare the parsed content to a list of predefined jargon words.
<h2> <b> To-do (lots): </b> </h2>

<b> &#9744; Get crawler working </b> <UL>
<LI> &#9744; Use Company.getBaseURL as starting point for crawl, e.g. http://www.samsung.com/uk/news/local/
<LI> &#9744; Test MaxDepth... 1/2?
<LI> &#9745; Add regex field in Company to feed into crawler
<LI> &#9745; Extract all links within a given path, save list in separate file for each Company object
<LI> &#9745; Find a way to feed these into methods in Company (readThenPrint(), saveContent())
</UL>

<b> &#9745; Encapsulate methods in Scraper.java </b> <UL>
<LI> &#9745; Add conditional statements based on whether Company.getCssClassOrID returns "class" or "ID". i.e either doc.getElementsByClass OR doc.getElementsByID
<LI> &#9745; Convert static methods in Scraper to non-static, move to Company class
<LI> &#9744; Finish generalising print/read methods in Company
</UL>

<b> &#9745; Move Companies ArrayList to separate class </b> <UL>
<LI> &#9745; Add getters and setters for Companies ArrayList
<LI> &#9744; Figure out how to access/update Companies from Scraper.java
</UL>

<b> &#9744; Figure out how to parse JS elements in JSoup </b> <UL>
<LI> &#9744; Extract links matching regex from EMC, Oracle, Salesforce and VMWare
<LI> &#9744; Get remaining press releases, add to file
</UL>

<b> &#9744; Start working on compare/rank algorithm </b> <UL>
<LI> &#9744; Use countOccurences as a starter (https://github.com/scownie/JavaWorksheets/blob/master/src/Ex2.java)
<LI> &#9744; Test it out with Jargone wordlist (https://github.com/rooreynolds/jargone/blob/master/jargonlist.txt)
</UL>

<b> &#9744; Start gathering tech jargon list </b> <UL>
<LI> &#9744; Replace Jargone wordlist with new list when ready
</UL>
