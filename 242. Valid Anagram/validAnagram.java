public class Solution {
    public boolean isAnagram(String s, String t) {
    	if (s.length() != t.length()) {
			return false;
		}
    	else {
    		ArrayList <Character> help = new ArrayList<Character>();
            for (int i = 0; i < t.length(); i++) {
    			help.add(t.charAt(i));
    		}
            for (int i = 0; i < s.length(); i++) {
    			for (int j = 0; j<help.size(); j++){
    				if (s.charAt(i) == help.get(j)) {
    					help.remove(j);
    					break;
    				}
    				else if (j==help.size()-1 && s.charAt(i) != help.get(j)) {
    					return false;
    				}
    			}
    		}
            if (help.size()==0) {
    			return true;
    		}
            else {
    			return false;
    		}
		}
    }
}