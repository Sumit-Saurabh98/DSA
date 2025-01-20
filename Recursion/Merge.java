import java.util.*;
public class Merge{

    // merge sort

    public static void merge(int [] arr, int low, int mid, int high){

        List<Integer> list = new ArrayList<>();

        int left = low;
        int right = mid+1;

        while(left <= mid && right <= high){

            if(arr[left] <= arr[right]){
                list.add(arr[left]);
                left++;
            }else{
                list.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            list.add(arr[left]);
            left++;
        }

        while (right <= high) {
            list.add(arr[right]);
            right++;
        }

        for(int i = 0; i < list.size(); i++){
            arr[low+i] = list.get(i);
        }

    }

    public static void mergeSort(int [] arr, int low, int high){

        if(low >= high) return;

        int mid = (low + high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    public static void main(String[] args) {

        int [] arr = {3, 2, 8, 1, 4, 9, 4, 2};

        mergeSort(arr, 0, arr.length-1);

        for(int it:arr){
            System.out.print(it + " ");
        }

        System.out.println();
        
    }
}