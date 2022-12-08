class Solution {
    public String longestPalindrome(String s) {
    String result = ""; int len = s.length(); int count = 1; int j = 0; int k = 0;
    int lo = 0; int hi = 0; int tempCt = 1; int mid1 = 0; int mid2 = 0;
    //want: range (start & end index) of longest substring.
    //know its longest using count aka its length
    for(int i = 0; i < len; i++){
        j = i;
        while(j < len && s.charAt(i) == s.charAt(j)){//hit the aaaaaa clip
                tempCt++; j++;
        }
        j--; tempCt--;
        if(tempCt > count){ //ONLY update bounds IF got BIGGER substring
            count = tempCt; lo = i; hi = j;
        }
        //finished aaaaaa clip? //while loop RUN 1st B1 checking condition
        //we know from i to j, tis SAME entry <== aaa vs aa BOTH palindrom.
        mid1 = i; mid2 = j; //now, check all entries OTHER than aaaaaa clip
        while(mid1 >= 0 && mid2 < len){
            if(s.charAt(mid1) != s.charAt(mid2)){
                break;
            }
            if(s.charAt(mid1) == s.charAt(mid2)){
                tempCt = tempCt + 2;
                if(tempCt > count){ //ONLY update bounds IF got BIGGER substring
                    count = tempCt; lo = mid1; hi = mid2;
                }
            }
            mid1--; mid2++;
        }
        tempCt = 1; //reset tempCt to 1;
    }
    for(int x = lo; x <= hi; x++){ //turn bounds into actual substring
        result = result + s.charAt(x);
    }
    return result;
    }
}
