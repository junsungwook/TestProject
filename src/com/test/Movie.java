package com.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Movie {
	public static void main(String[] args) {
		Document doc;
		try {
			doc = Jsoup.connect("https://search.daum.net/search?nil_suggest=btn&w=tot&DA=SBC&q=%EC%98%81%ED%99%94").get();
			Elements count = doc.select("ol.movie_list li").not("li.hide");
			Elements movie = doc.select("ol.movie_list div.wrap_cont div.info_tit a.tit_main");
			Elements tenten = doc.select("ol.movie_list div.wrap_cont dd.score em.rate");
			System.out.println("실시간 예매율 ");
			for(int i=0; i<count.size(); i++) {
				String m = movie.get(i).text();
				String score = tenten.get(i).text();
				if(i<5) {
					System.out.println((i+1)+"위 : "+m+" 평점 : "+score);
				}
				
			}		
		} catch (IOException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
	}
}
