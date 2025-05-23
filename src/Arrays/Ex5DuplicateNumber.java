package Arrays;


import java.util.Arrays;

public class Ex5DuplicateNumber {

    public static void main(String[] args) {
        System.out.println((Arrays.toString(removeDuplicatesFast(new int[]{0,0,1,1,1,2,2,3,3,4}))));
    }

    // Time complexity = O(n^2)
    // The following code also assumes that input is sorted
    /** The following nested loop works this way:
     * I take the first element as duplicate
     * and assign it to the unique array only when
     * I find number other than duplicate variable
     * then after assignment to unique, I assign to i a new value
     * so that in the next outer iteration i begins with our new value
     * kinda with new duplicate value other than the previous, good luck!
     */
    public static int[] removeDuplicatesSlowMine(int[] arr) {
        //   TODO
        int n = arr.length;
        int[] uniqueElements = new int[n];
        int index = 0;

        for(int i = 0; i < arr.length; i++){
            int duplicate = arr[i];
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] != duplicate){
                    i = j-1;
                    break;
                }
            }
            uniqueElements[index++] = duplicate;
        }

        return Arrays.copyOf(uniqueElements, index);
    }


    // Time complexity O(n^2)
    // It takes the number and checks other occurrences
    // It adds to unique if it is last occurrence,
    // if it's not last occurrence than we skip current
    // because we're gonna meet it again in the loop, hoping that next time it will be the last one
    // [1,1,3,3,4,10]
    public static int[] removeDuplicatesNotMine(int[] array){
        int n = array.length;
        int[] uniqueArray = new int[n];
        int index = 0;

        for (int i = 0; i < n; i++) {
            boolean isDuplicate = false;
            for (int j = i + 1; j < n; j++) {
                if (array[i] == array[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                uniqueArray[index++] = array[i];
            }
        }

        return Arrays.copyOf(uniqueArray, index);
    }


    // Time Complexity O(n)
    // 0,0,1,1,1,2,2,3,3,4
    public static int[] removeDuplicatesFast(int[] nums) {
        int index = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i]!=nums[index-1]){
                nums[index++] = nums[i];
            }
        }
        return Arrays.copyOf(nums, index);
    }


}
