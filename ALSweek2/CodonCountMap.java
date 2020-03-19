import java.util.*;

public class CodonCountMap {
    private HashMap<String,Integer> codonsMap;
    public CodonCountMap()
    {
        codonsMap=new HashMap<String,Integer>();
    }
    public void buildCodonMap(int start,String dna){
       // codonsMap.clear();
        for(int i=start;i+3<=dna.length();i+=3){
            String codon=dna.substring(i,i+3);
            if(codonsMap.containsKey(codon))
                codonsMap.put(codon,codonsMap.get(codon)+1);
            else
                codonsMap.put(codon,1);
        }
    }
    public String getMostCommonCodon(){
        String s="";
        int maxval=0;
        for (Map.Entry<String, Integer> entry : codonsMap.entrySet())
        {
            int count=entry.getValue();
            if(maxval<count){
                maxval=count;
                s=entry.getKey();
            }
        }
       //codonsMap.clear();
        return s;
    }
    public void printCodons(int start,int end){
        for (Map.Entry<String, Integer> entry : codonsMap.entrySet())
            if(entry.getValue()>=start && entry.getValue()<=end)
                System.out.println(entry.getKey()+ " "+entry.getValue());
    }
    public void testing(){
        buildCodonMap(0, "CGTTCAAGTTCAAA");
        System.out.println(getMostCommonCodon());
        printCodons(1, 5);
        codonsMap.clear();
        buildCodonMap(1, "CGTTCAAGTTCAAA");
        System.out.println(getMostCommonCodon());
        printCodons(1, 5);
        codonsMap.clear();
        buildCodonMap(2, "CGTTCAAGTTCAAA");
        System.out.println(getMostCommonCodon());
        printCodons(1, 5);
        codonsMap.clear();
    }

    public static void main(String[] args) {
        CodonCountMap c=new CodonCountMap();
        c.testing();
    }
}
