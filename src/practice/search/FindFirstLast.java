// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

class FindFirstLast {
    public int[] searchRange(int[] nums, int target) {

        return new int[]{findFirst(nums, target), findSecond(nums, target)};
        
        
    }

    // [5,7,7,8,8,10], target = 8
    public int findFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int first = -1;
    

        while(low <= high) {
            int mid = (low + high) / 2; 

            if(nums[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return first;
    }

    public int findSecond(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int second = -1;
    

        while(low <= high) {
            int mid = (low + high) / 2;

            if(nums[mid] == target) {
                second = mid;
                low = mid + 1;
            }  else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return second;
    }

  // recursive

  public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        
        return new int[]{findFirst(nums, target, 0, n-1), findSecond(nums, target, 0, n-1)};
        
        
    }

    public int findFirst(int[] nums, int target, int low, int high) {
    
       if(low > high) {
        return -1;
       }

       int mid = (low + high) / 2; 

            if(nums[mid] > target) {
               return findFirst(nums, target, low, mid - 1);
            } else if(nums[mid] < target) {
                 return findFirst(nums, target, mid + 1, high);
            }else if(mid == 0 || nums[mid - 1] != nums[mid]) {
                return mid;
            } else {
               return findFirst(nums, target, low, mid - 1);
            }

    }

        public int findSecond(int[] nums, int target, int low, int high) {
    
       if(low > high) {
        return -1;
       }


       int mid = (low + high) / 2; 

            if(nums[mid] > target) {
               return findSecond(nums, target, low, mid - 1);
            } else if(nums[mid] < target) {
                 return findSecond(nums, target, mid + 1, high);
            }else if(mid == nums.length - 1 || nums[mid + 1] != nums[mid]) {
                return mid;
            } else {
               return findSecond(nums, target, mid + 1, high);
            }
    }
  
}
