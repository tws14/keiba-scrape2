package racedata;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class UrlScrape {

	public ArrayList<String> urlScr(String url) throws Exception {
		
		Document document
					= Jsoup.connect(url).timeout(7000).get();
		
		ArrayList<String> urls = new ArrayList<>();
		
		Elements elements = document.select("#contents_liquid > table > tbody > tr > td:nth-child(5) > a");
		
		
				for(Element element : elements) {
						urls.add("https://db.netkeiba.com/" + element.attr("href"));
						if(urls.size() == 10) {
							break;
						}
				}
		
		
		return urls;
	}
	
}
