class Basic{
    // print 5 5 times
    public static void print5(int i, int n){
        if(i>n){
            return;
        }

        System.out.println(n);
        print5(i+1, n);
    }

    // print from 1 to 5

    public static void print1to5(int i, int n){

        if(i>n){
            return;
        }

        System.out.println(i);

        print1to5(i+1, n);
    }
    
    // print from 5 to 1

    public static void print5to1(int i, int n){

        if(i<1){
            return;
        }

        System.out.println(i);

        print5to1(i-1, n);
    }

    // backtrack 1 to n;

    public static void backtrack1ton(int i, int n){

        if(i < 1){
            return;
        }

        backtrack1ton(i-1, n);

        System.out.println(i);
    }

    // backtrack from n to 1

    public static void backtrackNto1(int i, int n){

        if(i > n){
            return;
        }

        backtrackNto1(i+1, n);

        System.out.println(i);

    }

    // sum of n numbers

    // parameterized way
    public static int sumOfNParameterized(int n, int sum){
        
        if(n<1){
            return sum;
        }

        return sumOfNParameterized(n-1, sum+n);
    }

    // without parameter

    public static int sumOfNWithoutParameter(int n){

        if(n == 0){
            return 0;
        }

        return n + sumOfNWithoutParameter(n-1);
    }


    public static void main(String[] args){
        
        // print5(1, 5);

        // print1to5(1, 5);

        // print5to1(5, 5);

        // backtrack1ton(5, 5);

        // backtrackNto1(1, 5);  

        // System.out.println(sumOfNParameterized(5, 0));

        System.out.println(sumOfNWithoutParameter(5));
    }
}