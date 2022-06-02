package javagenericity;

import java.util.ArrayList;
import java.util.List;

public class Testgenericity<T> {
    public <E>List<E> copyfromArraytolist(E[]arr){
        ArrayList <E> list = new ArrayList<>();
        for(E e : arr){
            list.add(e);
        }
        return list;
    }

    public static void main(String[] args) {
        Testgenericity <String> test = new Testgenericity<>();
        Integer [] arr = new Integer[]{1,2,3,4};
        List <Integer> list = test.copyfromArraytolist(arr);
        System.out.println(list);

    }
}
