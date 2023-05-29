import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        String oUrl = "https://www.youtube.com/playlist?list=PLsyeobzWxl7odnI5wl4LvRl6C0bn1Jg7B";
        String sUrl;
        HashMap<String,String> cache = new HashMap<>();

        URLService service = new URLService();

//        sUrl = service.generateUrl(oUrl);
        sUrl = service.generateUrlUsingHash(oUrl, cache);
        System.out.println(sUrl);
        sUrl = service.generateUrlUsingHash(oUrl, cache);
        System.out.println(sUrl);
    }
}