package Arrays;


import java.util.Arrays;

public class Ex5DuplicateNumber {

    public static void main(String[] args) {
        System.out.println((Arrays.toString(removeDuplicatesSlowMine(new int[]{1, 1, 10}))));
        System.out.println((Arrays.toString(removeDuplicatesFast(new int[]{1, 1, 10}))));
    }

    // Time complexity = O(n^2)
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



    // Time Complexity O(n)
    public static int[] removeDuplicatesFast(int[] nums) {
        int index = 1;
        int number = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i]!=number){
                nums[index++] = nums[i];
                number = nums[i];
            }
        }
        return Arrays.copyOf(nums, index);
    }


}
