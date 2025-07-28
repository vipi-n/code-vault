// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/

class FindKSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> allPairs = new ArrayList<>();

        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                allPairs.add(new int[]{nums1[i], nums2[j]});
            }
        }

        allPairs.sort((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        for(int i = 0; i < Math.min(k, allPairs.size()); i++) {

            int[] arr = allPairs.get(i);
            result.add(Arrays.asList(arr[0], arr[1]));
        }
        return result;
    }
}

class FindKSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        for(int i = 0; i < nums1.length && i < k; i++) {
            minheap.offer(new int[]{nums1[i], nums2[0], 0}); 
        }
        while(k-- > 0 && !minheap.isEmpty()) { 
            int[] pair = minheap.poll();
            int j = pair[2];
            int u = pair[0];
            int v = pair[1];
            result.add(Arrays.asList(u, v));
            
            if(j + 1 < nums2.length) {
                minheap.offer(new int[]{u, nums2[j + 1], j + 1}); 
            }
        }
        return result;
    }
}
