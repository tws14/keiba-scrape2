package racedata;

import java.util.ArrayList;
import java.util.Arrays;

public class LapCalc {
		
	public ArrayList<String> lapcalc (String race, String lapt) {
		
		ArrayList<String> array = null;
		
		String laptime = lapt.trim().replace("-", ",");
		
		array = new ArrayList<String>(Arrays.asList(laptime.split(",")));
		
		
		//合計タイム
		String[] laptime2 = laptime.split(",");
		int leng = laptime2.length;
		
		double sum = 0;
		double[] lapt2 = new double[leng];
	
	if (laptime2 != null && leng > 0) {
		//ダブル型の配列に変換
		for ( int i = 0; i < leng; i++) {
			lapt2[i] = Double.parseDouble(laptime2[i]);
			
		}
		
		//合計
		for (int u = 0; u < lapt2.length; u++) {
			sum += lapt2[u];
		}
		
		String sumSt = String.valueOf((Math.floor(sum*10))/10);
		
		array.add(0, race);
		array.add(" ," + sumSt);
		
		return array;
	} else {
		
		return null;
	}
	}
}
