package LeetCode.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 杨帅
 * @description: 841. 钥匙和房间
 * @date： 2021/10/27 10:28
 */
public class Homework04 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list2.add(3);
        list2.add(0);
        list2.add(1);
        list3.add(2);
        list4.add(0);
//        list1.add(1);
//        list2.add(2);
//        list3.add(3);


        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(list1);
        rooms.add(list2);
        rooms.add(list3);
        rooms.add(list4);


        System.out.println(new Solution1().canVisitAllRooms(rooms));



    }

    //采用深度优先搜索 遍历整张图 ，统计可以达到的节点个数  再利用数组vis标记当前节点是否访问过，避免重复访问

}
class Solution1{
    //创建一个布尔类型的数组，用于记录每间屋子的访问权限，避免重复访问
    boolean[] vis;
    //nums为可访问的房间数
    int num = 0;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        //初始化vis,值默认都为false
        vis = new boolean[n];
        //从0号房间开始进行深度优先搜索
        dfs(rooms,0);
        //通过nums可访问的房间数  和 实际房间数 进行比较，得出结果 true 或 false
        return num ==n;
    }

    //x表示可访问的房间号
    public void dfs(List<List<Integer>> rooms, int x){
        //直接赋值为true，因为传进来的房间号x所对应的房间 已经表示可以访问
        vis[x] = true;
        //可访问数 +1
        num++;
        //遍历可访问房间内的钥匙号,即房间号，判断是否为false，如果已为true,则不用调用方法
        // 否则再次进行深度优先搜索
        for (int it : rooms.get(x)) {
            if(!vis[it]){
                dfs(rooms,it);
            }
        }
    }
}
