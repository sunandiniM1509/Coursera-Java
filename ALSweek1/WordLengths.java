import edu.duke.FileResource;
import java.util.*;
class WordLengths
{

    void countWordLengths(FileResource resource, int[] counts)
    {
        for(String s : resource.words()) {
           int sum=0;
            for(int i=0;i<s.length();i++)
            {if(Character.isLetter(s.charAt(i)))
                    sum+=1;}
              counts[sum]++;}
            for(int i=1;i<counts.length;i++)
            {
                if(counts[i]!=0)
                System.out.println(counts[i]+" words of length "+i);
            }
        }
    void indexOfMax(int[] values)
    {
       // System.out.println("The maximum repeated word is of length : "+ Arrays.stream(values).max().getAsInt());
        int max=values[0],index=0;
        for(int i=1;i<values.length;i++)
            if(values[i]>max)
            {max=values[i];index=values[i];}
            System.out.println(index);
    }
    void testcountWordLengths()
    {
        FileResource resource = new FileResource();
       // String[] common = getCommon();
        int[] counts = new int[31];
        countWordLengths(resource,counts);
        indexOfMax(counts);
    }
}
public class Assignment1 {
    public static void main(String[] args) {
        WordLengths wl = new WordLengths();
        wl.testcountWordLengths();
    }
}
