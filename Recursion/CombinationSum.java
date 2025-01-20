import java.util.*;
public class CombinationSum {
    
    public static void combinationSum(int idx, int [] arr, int target, List<List<Integer>> result, List<Integer> curr) {

        if(idx == arr.length){
            if(target == 0){
                result.add(new ArrayList<>(curr));
            }

            return;
        }

        if(arr[idx] <= target){

            curr.add(arr[idx]);
            combinationSum(idx, arr, target-arr[idx], result, curr);
            curr.remove(curr.size()-1);
        }

        combinationSum(idx+1, arr, target, result, curr);

    }
    
    public static void main(String[] args) {

        int [] arr = {2, 4, 3, 6};

        List<List<Integer>> result = new ArrayList<>();

        combinationSum(0, arr, 6, result, new ArrayList<>());

        for(List<Integer> it : result){
            System.out.println(it + " ");
        }

        System.out.println();
        
    }
}
