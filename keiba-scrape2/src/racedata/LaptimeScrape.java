package racedata;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class LaptimeScrape {
		
	private LapCalc lapC;

	public LaptimeScrape() {
		LapCalc lapC = new LapCalc();
		this.lapC = lapC;
	}


	public ArrayList<ArrayList<String>> lapScr (ArrayList<String> urls) throws Exception {
		
		ArrayList<ArrayList<String>> arrays = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> array = new ArrayList<>();
		
		
		for (int i = 0; i < urls.size(); i++) {
			
			long start = System.currentTimeMillis();
			
			Document document
						= Jsoup.connect(urls.get(i)).timeout(5000).get();
			
			Elements elements1 = document.select("#main > div > div > div > diary_snap > div > div > dl > dd > h1");
			Elements elements2 = document.select("#contents > div.result_info.box_left > table:nth-child(4) > tbody > tr:nth-child(1) > td");
			String race = elements1.text();
			String laptm = elements2.text();
			
			array = lapC.lapcalc(race, laptm);
			
			arrays.add(array);
			
			//thread間隔
			 try {
					long time = 2000;
			    	Random random = new Random();
						 time += random.nextInt(300);
				   Thread.sleep(time);
			
		     } catch (InterruptedException e) {
			    System.out.println("割り込みが発生しました");
		     }
			 
			 long end = System.currentTimeMillis();
			 System.out.println((end - start) + "ms");
			 System.out.println((end - start)/1000 + "秒");
		
	
	}
	
		return arrays;
	}
}
