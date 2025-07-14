//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

class MaximumPointsFromCards {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;
        int maxScore = 0, leftSum = 0, rightSum = 0;
        
        for(int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }
        maxScore = leftSum;
        int rightInd = n - 1;

        for(int i = k - 1; i >= 0; i--) {
            leftSum -= cardPoints[i];
            rightSum += cardPoints[rightInd];
            rightInd--;

           maxScore = Math.max(maxScore, leftSum + rightSum);
        }
    
        return maxScore;
    }
}
