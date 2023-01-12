class Solution {
    public List<String> letterCombinations(String digits) {
        int len = digits.length(); List<String> result = new ArrayList<>();
        char[] letter = new char[0];
        Map<Character, char[]> button = new HashMap<>();
        char[] b2 = {'a', 'b', 'c'}; char[] b3 = {'d', 'e', 'f'}; char[] b4 = {'g', 'h', 'i'}; 
        char[] b5 = {'j', 'k', 'l'}; char[] b6 = {'m', 'n', 'o'}; char[] b7 = {'p', 'q', 'r', 's'}; 
        char[] b8 = {'t', 'u', 'v'}; char[] b9 = {'w', 'x', 'y', 'z'};
        button.put('2', b2); button.put('3', b3); button.put('4', b4); button.put('5', b5); 
        button.put('6', b6); button.put('7', b7); button.put('8', b8); button.put('9', b9);
        if(len >= 1){//ONLY 1 LETTER
            char[] letter1 = button.get(digits.charAt(0));
            for(int a = 0; a < letter1.length; a++){
                String comb1 = "" + letter1[a];
                if(len >= 2){//GOT 2 LETTERS
                    char[] letter2 = button.get(digits.charAt(1));
                    for(int b = 0; b < letter2.length; b++){
                        char temp2 = letter2[b]; String comb2 = comb1 + temp2;
                        if(len >= 3){//GOT 3 LETTERS
                            char[] letter3 = button.get(digits.charAt(2));
                            for(int c = 0; c < letter3.length; c++){
                                char temp3 = letter3[c]; String comb3 = comb2 + temp3;
                                if(len == 4){//GOT 4 LETTERS
                                    char[] letter4 = button.get(digits.charAt(3));
                                    for(int d = 0; d < letter4.length; d++){
                                    char temp4 = letter4[d]; String comb4 = comb3 + temp4;
                                    result.add(comb4);
                                    }
                                }else{result.add(comb3);}
                            }
                        }else{result.add(comb2);}
                    }
                }else{result.add(comb1);}
            }
        }
    return result;
    }
}
