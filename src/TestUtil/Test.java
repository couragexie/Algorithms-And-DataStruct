package TestUtil;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: Algorithms
 * @description:
 * @author: Jay
 * @create: 2020-04-21 17:26
 **/

public class Test {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(20);
        Map<String, Integer> current = new ConcurrentHashMap<>();
        System.out.println("hello" );
    }
}
