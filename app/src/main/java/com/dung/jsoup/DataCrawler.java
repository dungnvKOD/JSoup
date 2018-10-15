package com.dung.jsoup;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//lenh bat dong bo de tra ve data

public class DataCrawler {//di lay data tu tren mang  ve gom 12 doi tuong
    private static final String TAG = "DataCrawler";

    private static List<Holoscop> excote() throws IOException {//muon phan tich ma html thi dung thang jsuop
        String baseUrl = "https://lichngaytot.com";

        String url = baseUrl + "/tu-vi-12-cung-hoang-dao.html";
        Document document = Jsoup.connect(url).get();//chay den va lay du lieu trang web ve(html),documented la nguyen ma ngon 1 trang
        Element element = document.select("div.khungconten").get(0);//element la cac phan tu con trong document
        Elements items = element.select("div.kconten_item");//lay 1 mang cac the con
        List<Holoscop> holoscops = new ArrayList<>();

        for (Element item : items) {
            String holoscop = item.select("div.title_tvi").text();//cho toan bo tect cua the nay
            Elements images = item.select("img");

            String avatarUrl = baseUrl + images.get(0).attr("src");
            Log.d(TAG, "excote: "+avatarUrl);
            String coverUrl = images.get(1).absUrl("src");
            String titleUrl = item.select("h3").text();

            Elements contens = item.select("p");
            String conten = "";
            for (Element e : contens) {
                String paragraph = e.text();
                if (!paragraph.isEmpty()) {
                    conten += paragraph;
                } else {
                    conten += "\n";
                }

            }

            Holoscop holoscop1 = new Holoscop(holoscop, titleUrl, conten.toString(), avatarUrl, coverUrl);
            holoscops.add(holoscop1);
        }

        return holoscops;

    }

    public void crawlerData(final OnResultCallBack onResultCallBack) {//inerfaace lam tham so,xem lai thnag interface nay
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Holoscop> holoscops = excote();
                    onResultCallBack.onSuccess(holoscops);

                } catch (IOException e) {
                    //khong may xay ra loi
                    onResultCallBack.onFailure(e);

                }
            }
        }).start();
    }

    public interface OnResultCallBack {
        void onSuccess(List<Holoscop> holoscops);

        void onFailure(Throwable throwable);//loi tra ve throwable,thnag lay la loi to nhat
    }
}
