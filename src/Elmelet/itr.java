package Elmelet;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class itr {
    public static void main(String[] args) {
        List<Integer> tempArr = new ArrayList<>();
        tempArr.add(1);
        tempArr.add(2);
        tempArr.add(3);
        tempArr.add(4);
        tempArr.add(5);
        ListIterator<Integer> temp = tempArr.listIterator();
        while (temp.hasNext()) {
            if (temp.next().equals(3)){
                temp.remove();
            }
        }
        System.out.println(tempArr);
    }
}
