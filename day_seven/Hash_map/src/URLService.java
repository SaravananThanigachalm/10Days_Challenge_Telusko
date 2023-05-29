import java.util.HashMap;
import java.util.Random;

public class URLService {
    String chars = "abcdefg";
    Random random = new Random();
    public String generateUrl(String oUrl) {
        String sUrl = "";
        StringBuilder sb = new StringBuilder();
        int index;
        for (int i = 0; i < 6; i++) {
                index = random.nextInt(6);
                sb.append(chars.charAt(index));
        }
        sUrl = sb.toString();

        return sUrl;
    }
    public String generateUrlUsingHash(String oUrl, HashMap<String, String> cache) {
        if (cache.containsKey(oUrl)){
            System.out.println("Already Exist");
            return cache.get(oUrl);
        }
        String sUrl = "";
        StringBuilder sb = new StringBuilder();
        int index;
        for (int i = 0; i < 6; i++) {
            index = random.nextInt(6);
            sb.append(chars.charAt(index));
        }
        sUrl = sb.toString();
        cache.put(oUrl,sUrl);
        return sUrl;
    }
}
