package racedata;

import java.util.ArrayList;
import java.util.Scanner;

public class LapScraper {

	public static void main(String[] args) {
		
		UrlScrape us = new UrlScrape();
		LaptimeScrape ls = new LaptimeScrape();
		WriteFile wf = new WriteFile();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("URLを入力");
		
		String input = scanner.nextLine();
	
	try {
		ArrayList<String> urls = us.urlScr(input);
		
		ArrayList<ArrayList<String>> laplist = ls.lapScr(urls);
		
		wf.write(laplist);
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		System.out.println("完了");
	}

}
