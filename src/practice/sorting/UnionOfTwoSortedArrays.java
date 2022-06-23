package practice.sorting;

public class UnionOfTwoSortedArrays {
    public static void main(String[] args) {

        union(new int[]{1,2,2,3,4}, new int[]{2,3,5,6});
    }

    private static void union(int[] arr1, int[] arr2) {

        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length){
            if (i > 0 && arr1[i] == arr1[i - 1]){
                i++;
                continue;
            }
            if (j > 0 && arr2[j] == arr2[j - 1]){
                j++;
                continue;
            }
            if (arr1[i] < arr2[j]){
                System.out.println(arr1[i]);
                i++;
            }
            else if (arr1[i] > arr2[j]){
                System.out.println(arr2[j]);
                j++;
            }else {
                System.out.println(arr1[i]);
                i++;
                j++;
            }
        }
        while (i < arr1.length){
            if (i == 0 || arr1[i] != arr1[i -1])
            System.out.println(arr1[i++]);
        }
        while (j < arr2.length ){
            if (j == 0 || arr2[j] != arr2[j -1])
            System.out.println(arr2[j++]);
        }
    }
}
