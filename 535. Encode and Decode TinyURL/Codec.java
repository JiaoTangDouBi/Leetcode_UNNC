public class Codec {
    /*Use a hashMap to act as datebase and stores <shortUrl, longUrl> pairs.
    * the structure of shortUrl is "http://tinyurl.com/identification",
    * and the unique identification for each url is a string made up with [0-9a-z-A-Z] characters.
    * I use an integer to represent each identification, so the integer is 62 hexadecimal number.
    */
    
    HashMap<String, String> map = new HashMap<String, String>();
    int identification=1;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int digit = (int)(Math.log(identification)/Math.log(62));
        char[] rep = new char[digit+1];
        int held = identification;
        while(digit >= 0){
            int temp = held - (int)(Math.pow(62,digit));
            if(temp<=9){
                rep[rep.length-1-digit]=(char)(temp+48);
            }
            else if(temp<=35){
                rep[rep.length-1-digit]=(char)(temp+55);
            }
            else{
                rep[rep.length-1-digit]=(char)(temp+61);
            }
            digit--;
        }
        String tinyUrl = "http://tinyurl.com/"+String.valueOf(rep);
        map.put(tinyUrl,longUrl);
        return tinyUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));