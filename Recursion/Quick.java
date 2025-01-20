

public class Quick {

    // quick sort

    public static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int findPivot(int [] arr, int low, int high) {

        int pivot = arr[low];

        int i = low+1;
        int j = high;

        while(true){

            while(i <= j && arr[i] <= pivot){
                i++;
            }

            while(i <= j && arr[j] > pivot){
                j--;
            }

            if(i >= j){
                break;
            }

            swap(arr, i, j);
        }

        swap(arr, low, j);
        return j;
    }

    public static void quickSort(int [] arr, int low, int high){

        if(low < high){

            int pivotIndex = findPivot(arr, low, high);

            quickSort(arr, low, pivotIndex-1);
            quickSort(arr, pivotIndex+1, high);
        }

    }

    public static void main(String[] args) {

        int [] arr = {3, 2, 6, 4, 7, 9, 5, 1, 9, 5, 4, 6, 2, 1};

        quickSort(arr, 0, arr.length-1);

        for(int it : arr){
            System.out.print(it+" ");
        }

        System.out.println();
        
    }
}
