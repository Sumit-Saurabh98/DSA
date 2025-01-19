public class Palindrome {
    
    public static boolean check(int i, String s) {
        
        if(i >= s.length()/2) return true;

        if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;

        return true;

    }
    public static void main(String[] args) {

        String s = "madam";

        
        System.out.println(check(0, s));

    }
}
