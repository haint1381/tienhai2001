package bai_hoc.string_regex.bai_tap.crawl_tin_tuc;

import java.net.MalformedURLException;
import java.net.URL;

public class CrawlNews {
    public static void main(String[] args) {
        try {
            URL url=new URL("https://dantri.com.vn/the-gioi.htm");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
