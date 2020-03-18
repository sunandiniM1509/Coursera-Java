import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class babyNames {
    public static void main(String[] args) {

    }
    public static void totalBirths(FileResource fr){
        int totalBirths = 0;
        int totalBoys = 0, totalGirls = 0;
        int boyNames = 0, girlNames = 0;

        for(CSVRecord record: fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(record.get(2));         //gets the number of babies born with the name
            totalBirths += numBorn;
            if(record.get(1).equals("M")){
                totalBoys += numBorn;
                boyNames++;
            }else{
                totalGirls += numBorn;
                girlNames++;
            }
        }
        System.out.println("Total births: " + totalBirths + " Total names: " + boyNames+girlNames);
        System.out.println("Total boys: " + totalBoys + " Total boy names: " + boyNames);
        System.out.println("Total girls: " + totalGirls + " Total girl names: " + girlNames);
    }

    //TEST method for totalBirths
    public static void testTotalBirths(){
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
    public static int getRank(Integer year, String name, String gender){
        FileResource fr = new FileResource("yob" + year + ".csv");
        int rank = 0;

        for(CSVRecord rec: fr.getCSVParser(false)){
            if(rec.get(1).equals(gender)){ rank++; }
            if(rec.get(0).equals(name) && rec.get(1).equals(gender)){
                return rank;
            }
        }
        return -1;
    }

    //TEST method for getRank
    public static void testGetRank(){
        System.out.println(getRank(2012, "Mason", "M"));    //2
        System.out.println(getRank(2012, "Mason", "F"));    //-1
        System.out.println(getRank(2012, "Ava", "F"));    //5
    }

    //then “NO NAME” is returned.
    public static String getName(Integer year, Integer rank, String gender){
        FileResource fr = new FileResource("yob" + year + ".csv");
        int nameRank = 0;

        for(CSVRecord rec: fr.getCSVParser(false)){
            if(rec.get(1).equals(gender)){ nameRank++; }

            if(nameRank == rank && rec.get(1).equals(gender)){
                return rec.get(0);
            }
        }
        return "NO NAME";
    }

    //TEST method for getName
    public static void testGetName(){
        System.out.println(getName(2012, 2, "M"));    //Mason
        System.out.println(getName(2012, 5, "M"));    //NO NAME
        System.out.println(getName(2012, 5, "F"));    //Ava
    }
    public static void whatIsNameInYear(String name, Integer year, Integer newYear, String gender){
        int oldRank = getRank(year, name, gender);
        String newName = getName(newYear, oldRank, gender);

        System.out.println(name + "born in " + year + " would be " + newName + " if he/she was born in " + newYear);
    }

    public static void testWhatIsNameInYear(){
        whatIsNameInYear("Isabella", 2012, 2014, "F");      //Sophia
        whatIsNameInYear("Noah", 2013, 2012, "M");          //Jacob
    }
    //If the name and gender are not in any of the selected files, it should return -1
    public static int yearOfHighestRank(String name, String gender){
        DirectoryResource dr = new DirectoryResource();
        int highestRank = 0;
        int highestYear = -1;

        for(File f: dr.selectedFiles()){
            int currYear = Integer.parseInt(f.getName().replaceAll("[^\\d]", ""));
            int currRank = getRank(currYear, name, gender);

            if(highestRank == 0 && currRank != -1){
                highestRank = currRank;
                highestYear = currYear;
            }
            if(currRank < highestRank && currRank != -1){
                highestRank = currRank;
                highestYear = currYear;
            }
        }
        return highestYear;
    }

    //TEST method for yearOfHighestRank
    public static void testYearOfHighestRank(){
        System.out.println(yearOfHighestRank("Isabella", "F"));     //2012
        System.out.println(yearOfHighestRank("Lee", "M"));          //-1
        System.out.println(yearOfHighestRank("Emma", "F"));         //2014
        System.out.println(yearOfHighestRank("Emma", "M"));         //-1
    }

    public static double getAverageRank(String name, String gender){
        DirectoryResource dr = new DirectoryResource();
        int totalRank = 0, countedYears = 0;

        for(File f: dr.selectedFiles()){
            int currYear = Integer.parseInt(f.getName().replaceAll("[^\\d]", ""));
            int currRank = getRank(currYear, name, gender);

            if(currRank != -1){
                totalRank += currRank;
                countedYears++;
            }
        }
        double result = (double)totalRank/countedYears;
        if(result > 0){ return result; }
        return -1;
    }
    public static void testGetAverageRank(){
        System.out.println(getAverageRank("Sophia", "F"));      //1.66
        System.out.println(getAverageRank("Mason", "M"));       //3.0
    }
    public static int getTotalBirthsRankedHigher(Integer year, String name, String gender){
        FileResource fr = new FileResource("yob" + year + ".csv");
        int births = 0;
        int personsRank = getRank(year, name, gender);         //given persons rank in the given year

        for(CSVRecord rec: fr.getCSVParser(false)){
            if(rec.get(1).equals(gender)){
                if(personsRank  > getRank(year, rec.get(0), gender)){
                    births += Integer.parseInt(rec.get(2));
                }
            }
        }
        return births;
    }

    //TEST method for getTotalBirthsRankedHigher
    public static void testGetTotalBirthsRankedHigher(){
        System.out.println(getTotalBirthsRankedHigher(2012, "Ethan", "M"));     //15
        System.out.println(getTotalBirthsRankedHigher(2012, "Emma", "F"));      //10
      
    }

}