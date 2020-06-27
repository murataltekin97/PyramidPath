
package pyramidpath;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class CreateNumber {
     HashMap<Integer,ArrayList<Sayi>> sayilar= new HashMap<Integer,ArrayList<Sayi>>();
  
    public  void numbs() throws FileNotFoundException{ //Piramitteki sayıları bir sayi objesine dönüştürür ve HashMap'in içine atar.
        FileOperator fo = new FileOperator("piramit.txt");
        HashMap rows = fo.getRows();      
            for(Object i : rows.keySet()){
            int rowNo = (int)i;         
            ArrayList<Integer> numbers = (ArrayList<Integer>)rows.get(rowNo);
            ArrayList<Sayi> newNumbers = new ArrayList<Sayi>();
            for(int value : numbers ){
                newNumbers.add(new Sayi(value,numbers.indexOf(value)));
                                                                 
            }
            sayilar.put(rowNo, newNumbers);
    }   
}
   
    public HashMap<Integer,ArrayList<Sayi>> getSayilar() throws FileNotFoundException { //Satırların ve Sayi objelerinin bulundugu HashMapi döndürür.
        numbs();  
        return sayilar;
    }


}