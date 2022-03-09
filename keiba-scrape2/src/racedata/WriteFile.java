package racedata;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class WriteFile {
		
	public void write (ArrayList<ArrayList<String>> lists) throws Exception {
		
		BufferedWriter bw = null;
	
	try {
		//書き込み用ファイル作成（任意のパス)
		String fp = "/home/use/ドキュメント/lapdata.csv";
		File file = new File(fp);
		
		bw = new BufferedWriter(new FileWriter(file, true));
		bw.write("レース名,ラップ");
		bw.newLine();
		
		
		for(int i = 0; i < lists.size(); i++) {
			
			ArrayList list = lists.get(i);
			
				for(int u = 0; u < list.size(); u++) {
						if(u == (list.size() - 1)) {
							bw.write(lists.get(i).get(u));
							
						} else {
							bw.write(lists.get(i).get(u) + ",");
						}
				}
				bw.newLine();
		}
	} finally {
		try {
					if(bw != null) {
							bw.close();
					} 
		   } catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
  }

