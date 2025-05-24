import java.util.Scanner;

public class Palindrome{

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        System.out.println(isPalindrome(s));


    }

    public static boolean isPalindrome(String s1){

        String reverseS1 = "";

        char[] s1Array = s1.toLowerCase().toCharArray();

        for(int i = s1.length() - 1; i >= 0; i--){
            reverseS1 += s1Array[i];
        }

        return s1.equals(reverseS1);
    }

}