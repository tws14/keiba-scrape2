# keiba-scrape2
netkeiba.com様のレース名検索結果の一覧より10レース分のラップタイムをスクレイピングさせて頂き、ラップタイムとそれを合計した総タイムをcsvファイルにします
<br><br>
![ss_2022-03-10_12-30-22](https://user-images.githubusercontent.com/98932123/157604687-ac400554-5204-457c-98ef-7c2a2f0376ce.png)


## 使い方
1. WriteFile.javaのString fp を任意のディレクトリ書き換える
2. カレントディレクトリをプロジェクトに移動したあとターミナルから以下のコマンドを実行
      1. javac -classpath lib/jsoup-1.14.3.jar:lib/commons-lang3-3.12.0.jar -sourcepath src -d classes src/racedata/LapScraper.java<br>
           windowsの場合は : を ; に置き換える
      2. jar cvfm LapScraper.jar META-INF/MANIFEST.MF -C classes .<br>
3. jarファイルを実行します<br>
         java -jar LapScraper.jar
4. URLを入力と出るのでレース名検索結果ページURLを入力
## 使用技術
* 言語　Java 11
* ライブラリ　jsoup, commons-lang
