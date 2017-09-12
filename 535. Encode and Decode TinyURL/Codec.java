public class Codec {
    /*Use a hashMap to act as datebase and stores <shortUrl, longUrl> pairs.
    * the structure of shortUrl is "http://tinyurl.com/identification",
    * and the unique identification for each url is a string made up with [0-9a-z-A-Z] characters.
    * I use an integer to represent each identification, so the integer is 62 hexadecimal number.
    */
    
    
    HashMap<String, String> shortKey = new HashMap<>();
    int counter = 1;
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuilder sb = new StringBuilder();
        
        int temp = counter;
        
        while(temp > 0){
            int k = temp%62;
            if(k>=0 && k <= 9){
                sb.append((char)(k+48));
            }
            else if (k>=10 && k<=35){
                sb.append((char)(k+55));
            }
            else{
                sb.append((char)(k+61));
            }
            temp /= 10;
        }
        counter++;
        String tinyUrl = new String(sb);
        shortKey.put(tinyUrl, longUrl);
        return "http://tinyurl.com/" + tinyUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String tinyUrl = shortUrl.substring("http://tinyurl.com/".length());
        return shortKey.get(tinyUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));