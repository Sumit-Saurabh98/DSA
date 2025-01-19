import java.util.*;
public class Subsequence {
    
    public static void printSubsequence(int idx, int [] arr, List<Integer> current){

        if(idx == arr.length){
            for(int it : current){
                System.out.print(it);
            }

            System.out.println();

            return;
        }

        current.add(arr[idx]);
        printSubsequence(idx+1, arr, current);
        current.remove(current.size()-1);
        printSubsequence(idx+1, arr, current);
    }

    public static void subsequenceSum(int idx, List<Integer> list, int [] arr, int currSum, int sum){

        if(idx == arr.length){

            if(currSum == sum){

                for(int it : list){
                System.out.print(it);
                }
                System.out.println();

            }

            return;
        }

        list.add(arr[idx]);
        subsequenceSum(idx+1, list, arr, currSum+arr[idx], sum);
        list.remove(list.size()-1);
        subsequenceSum(idx+1, list, arr, currSum, sum);
    }

    // print any one subsequence whose sum is equal to sum;

    public static boolean isSubsequence(int idx, List<Integer> current, int[] arr, int currSum, int sum) {

        if (idx == arr.length) {
            if (currSum == sum) {
                for (int it : current) {
                    System.out.print(it + " ");
                }
                System.out.println();
                return true;
            }
            return false;
        }

        // Include current element
        current.add(arr[idx]);
        if (isSubsequence(idx + 1, current, arr, currSum + arr[idx], sum)) {
            return true;
        }

        // Exclude current element
        current.remove(current.size() - 1);
        return isSubsequence(idx + 1, current, arr, currSum, sum);

        
    }    

    // return the total number of subsequence which sum is equal to k;
    public static int sumEqualToK(int idx, List<Integer> current, int arr[], int currSum, int k) {

        if(idx == arr.length){
            if(currSum == k){
                return 1;
            }
            return 0;
        }

        current.add(arr[idx]);
        int left = sumEqualToK(idx+1, current, arr, currSum+arr[idx], k);
        current.remove(current.size()-1);
        int right = sumEqualToK(idx+1, current, arr, currSum, k);
        return left + right;
    }
    
    
    public static void main(String[] args) {
        
        int [] arr = {3, 1, 2};

        List<Integer> current = new ArrayList<>();

        // printSubsequence(0, arr, current);

        // subsequenceSum(0, current, arr, 0, 3);

        // isSubsequence(0, current, arr, 0, 3);

        System.out.println(sumEqualToK(0, current, arr, 0, 3));
    }
}
