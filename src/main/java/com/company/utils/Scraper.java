package com.company.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Scraper {

    private final String url;
    private Document document;
    private final ArrayList<String> links = new ArrayList<>();
    private final HashMap<String, String> immagini = new HashMap<>();

    public Scraper(final String url) throws IOException {
        if(url != null && !url.isBlank()){
            this.url = url;
            this.document = Jsoup.connect(this.url).get();
        }else{
            throw new IOException("URL vuoto o null");
        }
    }


    public ArrayList<String> getLinks() {
        return links;
    }

    public HashMap<String, String> getImmagini() {
        return immagini;
    }

    //Scraping dei link
    public void scrapingLinks(){
        Elements elements = document.select("a[href]");
        for(Element element : elements){
            String url = element.attr("abs:href");
            links.add(url);
        }
    }


    public void scrapingImg(){
        Elements elements = document.select("img[src]");
        for(Element element : elements){
            String urlImmagine = element.attr("src");
            String[] urlSplittato = urlImmagine.split("/");
            String nomeImmagine = urlSplittato[urlImmagine.length() - 1];
            immagini.put(urlImmagine, nomeImmagine);
        }
    }














}
