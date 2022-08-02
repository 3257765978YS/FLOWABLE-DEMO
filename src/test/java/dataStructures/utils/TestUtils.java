package dataStructures.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/26 10:48
 */
public class TestUtils {
    //生成一个随机值列表，其中每个数字介于
    //[min，max]并且可能存在重复。
    public static List<Integer> randomIntegerList(int sz, int min, int max) {
        List<Integer> lst = new ArrayList<>(sz);
        for (int i = 0; i < sz; i++) lst.add(randInt(min, max));
        return lst;
    }

    // 生成一个无序值列表，其中数组中的每个数字
    //在[0，sz）的范围内
    public static List<Integer> randomUniformUniqueIntegerList(int sz) {
        List<Integer> lst = new ArrayList<>(sz);
        for (int i = 0; i < sz; i++) lst.add(i);
        Collections.shuffle(lst);
        return lst;
    }

    public static List<Integer> randomUniformUniqueIntegerList(int min, int max) {
        List<Integer> lst = new ArrayList<>(max - min);
        for (int i = min; i < max; i++) lst.add(i);
        Collections.shuffle(lst);
        return lst;
    }

    // 在[min，max]之间生成一个随机整数
    public static int randInt(int min, int max) {
        return min + (int) (Math.random() * ((max - min)));
    }

    // 生成介于[最小值，最大值]之间的随机长值
    public static long randLong(long min, long max) {
        return min + (long) (Math.random() * ((max - min)));
    }

    // 生成[min，max]范围内的排序数据
    public static List<Integer> sortedIntegerList(int min, int max) {
        List<Integer> lst = new ArrayList<>(max - min);
        for (int i = min; i < max; i++) lst.add(i);
        return lst;
    }
}
