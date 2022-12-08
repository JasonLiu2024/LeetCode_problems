lass Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        //V3
        Set<List<Integer>> filter = new HashSet<>(); //store triplets
        Map<Integer, Integer> uniq = new HashMap<>(); //store all nums
        List<Integer> addit = new ArrayList<>();
        for(int i = 0; i < len; i++){ //get unique nums
            if(uniq.containsKey(nums[i])){
                int n0 = uniq.get(nums[i]);
                uniq.put(nums[i], n0 + 1);
            }else{
                uniq.put(nums[i], 1);
            }
        }
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                int comp = 0 - nums[i] - nums[j];
                if(uniq.containsKey(comp)){
                    if(comp == nums[i] || comp == nums[j]){
                        if(uniq.get(comp) > 1){
                            if(comp == 0){ 
                                if(uniq.get(comp) >= 3){
                                    addit = Arrays.asList(0, 0, comp);
                                    Collections.sort(addit);
                                    filter.add(addit);
                                }
                            }else{
                                addit = Arrays.asList(nums[i], nums[j], comp);
                                Collections.sort(addit);
                                filter.add(addit);
                            }
                        }
                    }else{
                        addit = Arrays.asList(nums[i], nums[j], comp);
                        Collections.sort(addit);
                        filter.add(addit);
                    }
                    
                }
            }
            if(uniq.size() == 3){
                break;
            }
        }
        result = new ArrayList(filter);
        //V2 too much code. NO work
        /*Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        Set<Integer> c = new HashSet<>();
        int[][] tally = new int[len][3]; //index, #, count
        Set<Integer> got = new HashSet<>();
        for(int i = 0; i < len; i++){ //tally all elements in map. time = n;
            tally[i][0] = i;
            if(got.add(nums[i]) == false){ //# alrd present? increment count
                for(int j = 0; j < len; j++){
                    if(tally[j][1] == nums[i]){
                        tally[j][2]++;
                    }
                }
            }else{
                tally[i][1] = nums[i];
                tally[i][2] = 1;
            }
        }
        int newlen = got.size();
        int x = 0; int y = 0; int z = 0; int comp = 0; int j = 0; int k = 0;
        for(int i = 0; i < newlen; i++){
            x = tally[i][1]; 
            if(tally[i][2] >= 1){
            if(tally[i][2] > 1){ //x is dupe, add {x, x, z}
            if(x == 0 && tally[i][2] == 3){
                List<Integer> addit = new LinkedList<>();
                addit.add(x); addit.add(x); addit.add(x);
                result.add(addit);
                }else{
                comp = 0 - x * 2;
                for(j = i + 1; j < newlen; j++){
                    if(tally[j][2] != 0){
                    z = tally[j][1];
                    if(z == comp){
                        List<Integer> addit = new LinkedList<>();
                        addit.add(x); addit.add(x); addit.add(z);
                        result.add(addit);
                    }} 
                }}
            }//x NO dupe, add {x, y, z}
            comp = 0 - x;
                for(j = i + 1; j < newlen; j++){
                    if(tally[j][2] != 0){
                    y = tally[j][1];
                    for(k = j + 1; k < newlen; k++){
                        if(tally[k][2] != 0){
                        z = tally[k][1];
                        if(y + z == comp){
                            List<Integer> addit = new LinkedList<>();
                            addit.add(x); addit.add(y); addit.add(z);
                            result.add(addit);
                        }}
                    }}
                }
               
            }
        }*/
        //V1 out of time
        /*Set<Set<Integer>> test = new HashSet<>();
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                for(int k = j + 1; k < len; k++){
                    List<Integer> find = new ArrayList<Integer>();
                    if(nums[i] + nums[j] + nums[k] == 0){ 
                        int a = nums[i]; int b = nums[j]; int c = nums[k];
                        Set<Integer> testing = new HashSet<>();
                        testing.add(a); testing.add(b); testing.add(c);
                        if(test.add(testing)){
                            List<Integer> adding = new ArrayList<>();
                            adding.add(a); adding.add(b); adding.add(c);
                            result.add(adding);
                        } 
                    }
                }
            }
        }*/
        return result;
    }
}
