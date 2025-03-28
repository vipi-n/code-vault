// https://leetcode.com/problems/majority-element-ii/


class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        
        int major1= Integer.MAX_VALUE;
        int major2 = Integer.MAX_VALUE;
        int c1= 0;
        int c2= 0;

        for(int num : nums) {

            if(num == major1) {
                c1++;
            } else if(num == major2) {
                c2++;
            } else if(c1 == 0) {
                major1 = num;
                c1 = 1;
            } else if(c2 == 0) {
                major2 = num;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;

        for(int num : nums) {
            if(num == major1) {
                c1++;
            }
            if(num == major2) {
                c2++;
            }
        }
        int n = nums.length / 3;
        
        List<Integer> list =  new ArrayList<Integer>();

        if(c1 > n) {
            list.add(major1);
        }
        if(c2 > n) {
            list.add(major2);
        }
        return list;
    }
}
