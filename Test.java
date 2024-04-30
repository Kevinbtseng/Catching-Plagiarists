import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

/**
 * This Test class represents . . .
 *
 * @author  (your name)
 * @version (todays date)
 */
public class Test
{
    public static void main(String[] args) throws FileNotFoundException,InputMismatchException
    { 
        Files file = new Files();
        
        Scanner thing = new Scanner(System.in);
        String path = "./";
        HitCount hc = new HitCount();
        
        System.out.println("Welcome to Catching Plagirists!" + "\n");
        
        System.out.println("To begin, please select (by using the number):" + "\n" + "1. Small Number of Docs" +"\n" + "2. Medium Number of Docs" + "\n" + "3. Large Number of Docs");
        String doc = thing.nextLine();
        while (!(doc.equals("1") || doc.equals("2") || doc.equals("3")))
        {
            System.out.println("Please pick between the numbers 1, 2, or 3");
            doc = thing.nextLine();
        }
        
        if (doc.equals("1"))
        {
            path += "Small number of documents/";
        }
        else if (doc.equals("2"))
        {
            path += "Medium number of documents/";
        }
        else if (doc.equals("3"))
        {
            path += "Large number of documents/";
        }
        
        System.out.println("How many words per phrase?");
        int numPhrase = 0;
        numPhrase = thing.nextInt();


        
        System.out.println("What should the threshold for hits be?");
        
        int TH = thing.nextInt();
        
        ArrayList<String> direct = file.filing(path);
        
        ArrayList<String> file1;
        ArrayList<String> file2;
        int count = 0;
        
        String path2 = path;
        String temp = path;
        
        hc.mHitcount(numPhrase, TH, path, direct);
    }
}
