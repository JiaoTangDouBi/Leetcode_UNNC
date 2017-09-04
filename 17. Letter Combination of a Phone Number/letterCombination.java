class Solution {
    //This is a combination question
    /*I first list all the possibilities of the first digit.
      Then combine this with the second digit and get a new output.
      Then use this new output combining with the third digit.
      Don't stop doing so until all the digits have been tried.
    */
    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<String>();
        if (digits.length() == 0){
            return output;
        }
        switch (digits.charAt(0)){
            case '0':
                output.add(" ");
                break;
            case '2':
                output.add("a");
                output.add("b");
                output.add("c");
                break;
            case '3':
                output.add("d");
                output.add("e");
                output.add("f");
                break;
            case '4':
                output.add("g");
                output.add("h");
                output.add("i");
                break;
            case '5':
                output.add("j");
                output.add("k");
                output.add("l");
                break;
            case '6':
                output.add("m");
                output.add("n");
                output.add("o");
                break;
            case '7':
                output.add("p");
                output.add("q");
                output.add("r");
                output.add("s");
                break;
            case '8':
                output.add("t");
                output.add("u");
                output.add("v");
                break;
            case '9':
                output.add("w");
                output.add("x");
                output.add("y");
                output.add("z");
                break;
            default:
                break;
        }
        for(int i = 1; i < digits.length(); i++){
            ArrayList<String> ele  = new ArrayList<String>();
            for(String s : output){
                ArrayList<String> temp = new ArrayList<String>();
                switch (digits.charAt(i)){
                    case '0':
                        temp.add(" ");
                        break;
                    case '2':
                        temp.add("a");
                        temp.add("b");
                        temp.add("c");
                        break;
                    case '3':
                        temp.add("d");
                        temp.add("e");
                        temp.add("f");
                        break;
                    case '4':
                        temp.add("g");
                        temp.add("h");
                        temp.add("i");
                        break;
                    case '5':
                        temp.add("j");
                        temp.add("k");
                        temp.add("l");
                        break;
                    case '6':
                        temp.add("m");
                        temp.add("n");
                        temp.add("o");
                        break;
                    case '7':
                        temp.add("p");
                        temp.add("q");
                        temp.add("r");
                        temp.add("s");
                        break;
                    case '8':
                        temp.add("t");
                        temp.add("u");
                        temp.add("v");
                        break;
                    case '9':
                        temp.add("w");
                        temp.add("x");
                        temp.add("y");
                        temp.add("z");
                        break;
                    default:
                        break;
                }
                for(String t : temp){
                    String sAndt = s + t;
                    ele.add(sAndt);
                }
            }
            output = ele;
        }
        return output;
    }
}