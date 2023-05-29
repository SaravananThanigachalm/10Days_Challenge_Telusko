package com.example.UrlShortner;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

@Service
public class URLService {
//    String chars = "abcdefg";
    Random random = new Random();

    public String generateUrl(String oUrl) {
        String stUrl = spiltUrl(oUrl);
        String chars = getChars(oUrl);
        String sUrl = "";
        StringBuilder sb = new StringBuilder();
        sb.append(stUrl);
        sb.append(".com/");
        int index;
        for (int i = 0; i < 6; i++) {
            index = random.nextInt(6);
            sb.append(chars.charAt(index));
        }
        sUrl = sb.toString();

        return sUrl;
    }

    private String spiltUrl(String oUrl) {
        String[] arrUrl = oUrl.split(".com/",2);
        return arrUrl[0];
    }
    private String getChars(String oUrl) {
        oUrl = oUrl.replaceAll("[^a-zA-Z]", "");
        return oUrl;
    }
}
