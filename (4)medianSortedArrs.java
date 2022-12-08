lass Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //nums1 arr LONGER than nums2 arr
        if(nums1.length < nums2.length){return findMedianSortedArrays(nums2, nums1);}
        double left1 = 0; double right1 = 0; double left2 = 0; double right2 = 0;
        int partLine1 = 0; int partLine2 = 0;
        if(nums1.length == 0){nums1 = nums2;}
        if(nums2.length == 0){nums2 = nums1;}
        int len1 = nums1.length; int len2 = nums2.length;
        int tot = len1 + len2;
        //1. put 1/2 of nums1 to LEFT of tru median
        int lo = 0; int hi = len1; double result = 0;
        while(lo <= hi){//default Binary Search while condition
        partLine1 = (hi + lo)/2; //1st 1/2 of nums1
        //Parting Line is B4 entry w/ partLine index
        partLine2 = (tot + 1)/2 - partLine1; //EQUAL # of # on BOTH sides of median
        //git left1, right1, left2, right2
        if(partLine1 == 0){left1 = Double.NEGATIVE_INFINITY; /*dummy var*/}
        else{left1 = nums1[partLine1 - 1];}

        if(partLine1 == len1){right1 = Double.POSITIVE_INFINITY;}
        else{right1 = nums1[partLine1];}

        if(partLine2 <= 0){left2 = Double.NEGATIVE_INFINITY;}
        else{
            if(partLine2 > len2){left2 = Double.POSITIVE_INFINITY;}
            else{left2 = nums2[partLine2 - 1];}
        }

        if(partLine2 >= len2){
            right2 = Double.POSITIVE_INFINITY;
        }else{
            if(partLine2 < 0){right2 = Double.NEGATIVE_INFINITY;}
            else{right2 = nums2[partLine2];}
        }

        //update hi & lo
        if(left1 > right2){hi = partLine1 - 1;} //whichever OTR half we take...
        else if(left2 > right1){lo = partLine1 + 1;} //it NO contain partLine entry no more
        else{
            if((tot)%2 == 0){
                return (Math.max(left1, left2) + Math.min(right1, right2))/2.0;}
            else{
                return Math.max(left1, left2);
            }
        }
        }
        return -1;
    } 
}
