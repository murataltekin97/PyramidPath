
package pyramidpath;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class Piramit { // Sayiların bulundugu HashMap veri tipinden piramit olusturmak icin olusturuldu.
    Sayi tepe=null;
    CreateNumber numbers = new CreateNumber();
    
     
    public void PyramidPathCalculator() throws FileNotFoundException { //Piramidi olusturur ve icinde gezinerek yol haritasını cıkarır.
        System.out.println("--- BÜTÜN YOL SEÇENEKLERİ ---");
        HashMap<Integer,ArrayList<Sayi>> sayilar = numbers.getSayilar();
        int i=0,j=1;
        int toplam=0;
        LinkedHashSet<Integer> highestPath = new LinkedHashSet<Integer>();
        highestPath.add(sayilar.get(0).get(0).getValue());
        
        while(i<sayilar.keySet().size()-1 && j <sayilar.keySet().size()){
                for (Sayi s : sayilar.get(i)) {
                    ArrayList<Integer> path = new ArrayList<Integer>();
                    TreeMap<Integer,ArrayList<Integer>> currentSum = new TreeMap<Integer,ArrayList<Integer>>();
                    for (Sayi s2: sayilar.get(j)) {
      
                        int subindex=sayilar.get(i).indexOf(s)-sayilar.get(j).indexOf(s2);
                        if(subindex==-1 || subindex ==0 || subindex==1){
                            if(subindex==-1 || subindex==1){
                               System.out.println("ÇAPRAZ: "+s.getValue()+"-->"+s2.getValue());
                            }
                            else{
                                System.out.println("ASAGI: "+s.getValue()+"-->"+s2.getValue());
                            }                           
                                                  
                            toplam= s.getValue() + s2.getValue();
                            path.add(s.getValue());
                            path.add(s2.getValue());
                            s2.setSum(toplam); 
                            s2.addSum(s.getSum());                                      
                            currentSum.put(toplam,path);                           
                                                     
                        }                       
                    }
                    int maxSum =currentSum.lastKey();
                    highestPath.add(currentSum.get(maxSum).get(1)); 
                    currentSum.clear();
                    
                    System.out.println("Current Max Sum: "+maxSum); // Bulundugu yol uzerindeki guncel toplam
                    System.out.println("***********************");                                                       
                }
                i++;
                j++;                
        }
        System.out.println("--- YOL TOPLAMLARI --- "); //En son ulasılan yerlerdeki toplamlar
        int maxValue=0;
        for(Sayi s : sayilar.get(sayilar.size()-1)){
            System.out.print(s.getSum()+" | ");
            if(maxValue<s.getSum()){
                maxValue=s.getSum();
            }           
        }
        System.out.println("\nEN FAZLA BULUNAN YOL TOPLAMI: "+ maxValue); // Maksimum toplam
               
    }
            
}