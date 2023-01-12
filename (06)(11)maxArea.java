class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int result = 0; int temp = 0;
        //V2: start from BOTH ends
        int lo = 0; int hi = len - 1;
        while(lo < hi){
            int multiple = (hi - lo) * Math.min(height[hi], height[lo]);
            result = Math.max(multiple, result);
            if(height[lo] >= height[hi]){
                hi--;
            }else{lo++;}
        }
        //V1: took too long
        /*for(int i = 0; i < height.length; i++){
            for(int j = i + 1; j < height.length; j++){
                int multiple = (j - i) * Math.min(height[i], height[j]);
                result = Math.max(result, multiple);
            }
        }*/
        return result;
    }
}
