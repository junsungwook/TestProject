package com.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Exam01 {

	public static void main(String[] args) {
		Document doc;
		try {
			doc = Jsoup.connect("http://m.exchange.daum.net/mobile/exchange/exchangeMain.daum").get();
			//Elements asiabody =  doc.select("div#asiaBody");
			Elements tr = doc.select("tr.link");
			for(int i=0; i<tr.size();i++) {
				String name = tr.get(i).select("td.name").text();
				String idx = tr.get(i).select("td.idx").text();
				String idxFluc = tr.get(i).select("td.idx_fluc").text();
				String rate = tr.get(i).select("td.rate_fluc").text();
				System.out.println(name +"\t"+idx+"\t"+idxFluc+"\t"+rate);

			}
			
			
			
			System.out.println("--중동지역--");
			Elements mideastBody = doc.select("div#mideastBody");
			Elements mTr = mideastBody.select("tr.link");
			for(int i=0; i<mTr.size();i++) {
				String name = mTr.get(i).select("td.name").text();
				String idx = mTr.get(i).select("td.idx").text();
				String idxFluc = mTr.get(i).select("td.idx_fluc").text();
				String rate = mTr.get(i).select("td.rate_fluc").text();
				System.out.println(name +"\t"+idx+"\t"+idxFluc+"\t"+rate);

			}
		} catch (IOException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
	}
}
