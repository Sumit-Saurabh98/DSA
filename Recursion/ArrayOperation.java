public class ArrayOperation {
    
    // reverse an array unoptimized version
    public static void reverse(int [] arr, int start, int end) {

        if(start >= end){
            return;
        }

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverse(arr, start+1, end-1);
    }

    // reverse an array optimized version

    public static void reverseOptimized(int [] arr, int i) {

        if(i >= arr.length/2){
            return;
        }

        int temp = arr[i];
        arr[i] = arr[arr.length-i-1];
        arr[arr.length-i-1] = temp;

        reverseOptimized(arr, i+1);
    }
    public static void main(String[] args){

        int arr [] = {1,2,3,4,5,6,7,8};

        // reverse(arr, 0, arr.length-1);

        reverseOptimized(arr, 0);

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
