import java.util.ArrayList;
import java.util.Iterator;

public class Test123 {
        public static void main(String[] args){
            ArrayList<String> dongVat = new ArrayList<>();
            // Thêm phần tử
            dongVat.add("Chó");
            dongVat.add("Mèo");
            dongVat.add("Gà");
            dongVat.set(2,"Ngựa");
            Iterator<String> iterator=dongVat.iterator();
            while(iterator.hasNext()){
                System.out.print(iterator.next());
                System.out.print(", ");
            }
        }
}
