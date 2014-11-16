Jargondex - WIP
=============

Crawls tech companies' news pages, pulls press releases using CSS selectors (via JSoup), and compares the parsed content to a list of predefined jargon words. 

To-do (lots):

<b> Get crawler4j working </b> <UL>
<LI> Use Company.getBaseURL as starting point for crawl, e.g. http://www.samsung.com/uk/news/local/
<LI> Test MaxDepth... 1/2?
<LI> Extract all links within that subdomain/path, save list in separate file for each Company object
<LI> Find a way to feed these into Scraper.java

<b> Encapsulate methods in Scraper.java </b>
<LI> Add conditional statements based on whether Company.getCssClassOrID returns "class" or "ID"
<LI> i.e either doc.getElementsByClass OR doc.getElementsByID

<b> Move Companies ArrayList to separate class </b>
<LI> Add getters and setters for Companies ArrayList
<LI> Figure out how to access/update Companies from Scraper.java

<b> Start working on compare/rank algorithm </b>
<LI> Use countOccurences as a starter (https://github.com/scownie/JavaWorksheets/blob/master/src/Ex2.java)
<LI> Test it out with Jargone wordlist (https://github.com/rooreynolds/jargone/blob/master/jargonlist.txt)

<b> Start gathering tech jargon list </b>
<LI> Replace Jargone wordlist with new list when ready
