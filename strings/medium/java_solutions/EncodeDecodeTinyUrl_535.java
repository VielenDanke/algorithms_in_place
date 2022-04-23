package strings.medium.java_solutions;

import java.util.HashMap;
import java.util.Map;

public class EncodeDecodeTinyUrl_535 {

    private Map<String, String> shortLongUrls = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        return shortLongUrls.put(longUrl, longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortLongUrls.get(shortUrl);
    }
}
