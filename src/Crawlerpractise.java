import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;


public class Crawlerpractise {

	public static void main(String[] args) {
        CrawlConfig crawlConfig = new CrawlConfig();
        crawlConfig.setCrawlStorageFolder("/Users/Steve/Workspace/ScraperTest/Crawler");
        System.out.println(crawlConfig.toString());
        PageFetcher pageFetcher = new PageFetcher(crawlConfig);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        try {
                CrawlController crawlController = new CrawlController(crawlConfig,
                        pageFetcher, robotstxtServer);
        }
}
