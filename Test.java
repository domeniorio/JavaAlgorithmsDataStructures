
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class Test{

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            String stringa = scan.nextLine();
            String[] parole = stringa.split(" ");
            HashMap<String,Boolean> res = new HashMap<>();

            for(String parola: parole){
                checkRepetitions(parola,res);
            }

            for(String key : res.keySet()){
                if(res.get(key)) System.out.println(key);
            }

        }

        public static void checkRepetitions(String s, HashMap<String,Boolean> res){

            HashSet<Character> set = new HashSet<>();

            for(char c : s.toCharArray()){
                set.add(c);
            }

            if(set.size() == s.length()){
                res.put(s, true);
                return;
            }

            res.put(s,false);
        }

}