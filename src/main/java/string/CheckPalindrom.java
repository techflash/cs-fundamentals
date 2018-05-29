package string;

/**
 * Given a string check if it can be made palindrome by swapping only one character.
 */
public class CheckPalindrom {
    public static void main(String[] args) {


        String str = "bbg";

        int mismatchCount = 0;
        for(int i=0, j=str.length()-1; i< str.length()/2; i++, j--){
            if(str.charAt(i) != str.charAt(j)) mismatchCount++;
        }

        if (mismatchCount == 1){
            System.out.println("can be palindrome!");
        }
    }

}
