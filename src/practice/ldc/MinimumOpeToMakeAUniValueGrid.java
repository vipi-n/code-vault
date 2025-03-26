// https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/

class MinimumOpeToMakeAUniValueGrid {
  
    public int minOperations(int[][] grid, int x) {
        
        int[] arr = new int[grid.length * grid[0].length];
        int temp = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
              arr[temp++] = grid[i][j];   
            }
        }
        Arrays.sort(arr);

        int median = arr[arr.length / 2];
        int rem = arr[0] % x;
        int minOp = 0;

        for(int i = 0; i < arr.length; i++) {

            if(arr[i] % x != rem) {
                return -1;
            } else {
                int count = Math.abs(arr[i] - median) / x;
                minOp += count;
            }
        }
        return minOp;
    }

  //
      public int minOperations_2(int[][] grid, int x) {
        
        ArrayList<Integer> arr = new ArrayList<>();
    
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
              arr.add(grid[i][j]);   
            }
        }
        Collections.sort(arr);
        int median = arr.get(arr.size() / 2);
        int rem = arr.get(0) % x;
        int minOp = 0;

        for(int i = 0; i < arr.size(); i++) {

            if(arr.get(i) % x != rem) {
                return -1;
            } else {
                int count = Math.abs(arr.get(i) - median) / x;
                minOp += count;
            }
        }
        return minOp;
    }
}
