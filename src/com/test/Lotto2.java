package com.test;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Lotto2 {
	public static void main(String[] args) {
		Document doc;
		try {
			doc = Jsoup.connect("https://www.daum.net/").get();
			Elements count = doc.select("ol.list_mini li");
			Elements iss = doc.select("ol.list_mini div.roll_txt div.rank_cont");
			Elements hot = iss.select("span.txt_issue a.link_issue");
			for(int i=0; i<count.size(); i++) {
				String who = hot.get(i).text();
				System.out.println(who);
			}		
		} catch (IOException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
	}
}
