  
import java.util.*;

    class WordPlay
    {
        boolean isVowel (char a)
        {
            a = Character.toLowerCase (a);
            //if you don't convert to lowercase you need
            //to check for uppercase alphabets in if case
            if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u')
                return true;
            return false;
        }
        String replaceVowels (String phrase, char ch)//mega m*g*
        {
            StringBuilder sb = new StringBuilder (phrase);
            for (int i = 0; i < phrase.length (); i++)
            {
                if (isVowel (phrase.charAt (i)))	//evaluates true/false as return type is boolean
                    sb.setCharAt(i, ch);
            }
            return sb.toString();
        }
        String emphasize(String phrase,char ch)
        {
            StringBuilder sb = new StringBuilder(phrase);
            //String sb1=sb.toString().toLowerCase();  //    choice of case sensitive
            for(int i=0;i< phrase.length();i++)
            {
                if(phrase.charAt(i)==ch && i%2==0)
                    sb.setCharAt(i,'*');
                else if(phrase.charAt(i)==ch && i%2!=0)
                    sb.setCharAt(i,'+');
            }

            return sb.toString();
        }
        void testPlay()
        {
            //tests for isVowel method
            System.out.println (isVowel ('b'));
            System.out.println (isVowel ('A'));
            System.out.println (isVowel ((char) 101));	//e
            System.out.println (isVowel ('*'));
            //tests for replaceVowels method
            System.out.println (replaceVowels("lowercheck",'*'));
            System.out.println (replaceVowels("uppercheck",'*'));
            System.out.println (replaceVowels("SenteNCECHeck",'*'));
            System.out.println (replaceVowels("num123checkAEipo",'*'));
            //tests for emphasize method
            System.out.println (emphasize("dna ctgaaactga", 'a'));
            System.out.println (emphasize("dna CTgaAactgA", 'a'));//choice of case sensitive
            System.out.println (emphasize("Mary Bella Abracadabra",'r'));
            System.out.println (emphasize("j123lla AbcdareAAAdabra",'A'));
        }
    }

    public class AssignmentOne
    {
        public static void main (String[]args)
        {
            Scanner sc = new Scanner (System.in);
            WordPlay check = new WordPlay ();
            check.testPlay();
        }
    }
