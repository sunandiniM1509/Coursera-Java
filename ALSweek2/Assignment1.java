  
import edu.duke.FileResource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class WordFrequencies
        {
         private ArrayList<String> myWords;
         private ArrayList<Integer> myFreqs;
         public WordFrequencies()
         {
             myWords = new ArrayList<String>();
             myFreqs = new ArrayList<Integer>();
         }
         public void findUnique()
         {
             FileResource resource = new FileResource();
            for(String s:resource.words())
            {
                s=s.toLowerCase();
                int index = myWords.indexOf(s);
                if(index==-1)
                {
                    myWords.add(s);
                    myFreqs.add(1);
                }
                else
                {
                    int value = myFreqs.get(index);
                    myFreqs.set(index,value+1);
                }
            }
         }
         public int findIndexOfMax()
         {
             int val= Collections.max(myFreqs);
             int idx=myFreqs.indexOf(val);
             //return Collections.max(myWords);
             String req=myWords.get(idx);
             System.out.println("The word that occurs most oftern is "+ req);
             return val;
         }
         public void tester()
         {
             findUnique();
             for(int k=0;k<myWords.size();k++)
             System.out.println(myFreqs.get(k)+"\t"+myWords.get(k));
             System.out.println("The count of this word is : "+findIndexOfMax());
         }
        }
public class Assignment1 {
    public static void main(String[] args) {
    WordFrequencies freq = new WordFrequencies();
    freq.tester();
    }
}