//https://leetcode.com/problems/can-place-flowers/

class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (n == 0)
            return true;
        int len = flowerbed.length;
        int counter = 0;

        for (int i = 0; i < len; i++) {

            if (flowerbed[i] == 0) {
                int leftVal = (i == 0) ? 0 : flowerbed[i - 1];
                int rightVal = (i == len - 1) ? 0 : flowerbed[i + 1];

                if (leftVal == 0 && rightVal == 0) {
                    flowerbed[i] = 1;
                    counter++;
                }
            }
            if (counter >= n) {
                return true;
            }
        }
        return counter >= n;
    }
}
