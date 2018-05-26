package app;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by diogo on 26/05/2018.
 */
public class Utils {

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }

    public static <E> List<E> addAll(E... elems) {
        List<E> list = new LinkedList<>();

        for (E e : elems) {
            list.add(e);
        }
        return list;
    }


}
