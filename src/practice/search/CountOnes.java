// https://www.geeksforgeeks.org/problems/count-1s-in-binary-array-1587115620/1

class CountOnes{
    // Function to count number of ones in the binary array
    // N: size of array
    // arr[]: input array
    public static int countOnes(int arr[], int N){
        
        // Your code here
		int low = 0, high = N - 1;

		while(low <= high) {
		    
			int mid = (low + high) / 2;

			if(arr[mid] == 1) {
				
				if(mid == N - 1 || arr[mid + 1] == 0) { // just to improve execution speed
				    return mid + 1;
				}else {
				    low = mid + 1;
				}
			}
			else{
			    if(mid == 0 || arr[mid - 1] == 1) {
			        return mid;
			    }
	        	high = mid - 1;
			}
		}

		return 0;
        
    }
}
