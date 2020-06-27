
package pyramidpath;

import java.util.ArrayList;

public class Sayi { //Piramitteki sayıların komsularını, indexlerini degerlerini ve toplamlarını bulabilmek icin oluşturuldu
    private ArrayList<Integer> path;
    private int value; // Degeri
    private int index; //Piramitteki indexi
    private int Sum; // Sıra kendine gelirken ve kendinden sonrakilere giderken kullanılacak guncel toplam
     
    public Sayi(int value) {
          this.value= value;
          this.Sum=value;
          this.path.add(215);
    }

    public ArrayList<Integer> getPath() {
        return path;
    }
    public Sayi(int value, int index){
        this.value=value;
        this.index=index;       
    }
    public void setSum(int Sum) {
        this.Sum = Sum;
    }

    public int getSum() {
        return Sum;
    }
    public void addSum(int Sum){
        this.Sum = this.Sum + Sum;
    }
    
    public ArrayList<Integer> getKomsular() {
        return path;
    }
    public int getIndex() {
        return index;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public void addPath(int number){
        this.path.add(number);
    }
      
}