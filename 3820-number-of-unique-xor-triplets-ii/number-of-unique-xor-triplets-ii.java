class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] uSet = new boolean[2048];
        int[] uniqueVals = new int[nums.length];
        int uCount = 0;
        
        for (int num : nums) {
            if (!uSet[num]) {
                uSet[num] = true;
                uniqueVals[uCount++] = num;
            }
        }
        boolean[] r2 = new boolean[2048];
        for (int i = 0; i < uCount; i++) {
            for (int j = i; j < uCount; j++) {
                r2[uniqueVals[i] ^ uniqueVals[j]] = true;
            }
        }
        boolean[] r3 = new boolean[2048];
        int uniqueTripletsCount = 0;
        
        for (int i = 0; i < 2048; i++) {
            if (r2[i]) {
                for (int j = 0; j < uCount; j++) {
                    int tripletXor = i ^ uniqueVals[j];
                    if (!r3[tripletXor]) {
                        r3[tripletXor] = true;
                        uniqueTripletsCount++;
                    }
                }
            }
        }
        
        return uniqueTripletsCount;
    }
}