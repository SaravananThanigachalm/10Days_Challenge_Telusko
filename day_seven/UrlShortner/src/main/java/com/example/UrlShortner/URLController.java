package com.example.UrlShortner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class URLController {
    @Autowired
    URLService service;

    @PostMapping("/url")
    public String getShortUrl(@RequestBody String oUrl){
        return service.generateUrl(oUrl);
    }

}
