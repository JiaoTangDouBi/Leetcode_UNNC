public class Solution {
    public String reverseVowels(String s) {
        ArrayList<Character> vowels = new ArrayList<Character>();
        ArrayList<Integer> position = new ArrayList<Integer>();
		StringBuilder strb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'
					||s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U') {
				vowels.add(s.charAt(i));
				position.add(i);
			}
		}
        for (int i = 0; i < position.size(); i++) {
        	String character = String.valueOf(vowels.get(vowels.size()-1));
        	vowels.remove(vowels.size()-1);
        	strb.replace(position.get(i), position.get(i)+1, character);
		}
        s = strb.toString();
        return s;
    }
}