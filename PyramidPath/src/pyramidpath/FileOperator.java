
package pyramidpath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileOperator {  //Dosyadaki piramiti okuyup bütün sayıları integer veri tipine dönüştüren sınıftır.
    File file;
    Scanner reader;
    HashMap<Integer,ArrayList<Integer>> rows = new HashMap<>();
          
     public FileOperator(String s) throws FileNotFoundException {
        this.file = new File(s);              
    }
    public void readFile() throws FileNotFoundException{
        this.reader = new Scanner(this.file);
             
    }
    public HashMap getRows() throws FileNotFoundException{ //Satir indexini ve piramitteki sayıları tutan HashMap veri tipini döndürür.
        readFile();
        int index=0;       
        while(reader.hasNextLine()){           
            String row = reader.nextLine();
            ArrayList<Integer> intList = new ArrayList<>();
            String[] sArray = row.split(" ");
            for(String s: sArray){
                intList.add(Integer.parseInt(s));               
            }
            rows.put(index, intList);
            index++;           
        }
        return rows;
    }
                
}