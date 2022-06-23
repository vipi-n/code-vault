package practice.sorting.mergesort;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {

        merge(new int[]{1,2,3,4,5}, new int[]{3,4,7,8});
    }

    private static void merge(int[] arr1, int[] arr2){
        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length){

            if (arr1[i] <= arr2[j]){
                System.out.print(" "+arr1[i]);
                i++;
            }else{
                System.out.print(" "+arr2[j]);
                j++;
            }
        }
        while (i < arr1.length){
            System.out.print(" "+arr1[i]);
            i++;
        }
        while (j < arr2.length){
            System.out.print(" "+arr2[j]);
            j++;
        }

    }
}
