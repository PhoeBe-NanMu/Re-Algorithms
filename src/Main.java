import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case

            int num = in.nextInt();
            int day = in.nextInt();

            int[][] action = new int[num][2];
            for (int i = 0; i < num; i++) {
                int a1 = in.nextInt();
                int a2 = in.nextInt();
                action[i][0] = a1;
                action[i][1] = a2;
            }

            if (num == 0){
                System.out.println(0);
                continue;
            }

            int[] dayC = new int[day];
            for (int i = 0; i < day; i++) {
                dayC[i] = in.nextInt();
            }
            int[] dayAll = new int[day];
            for (int i = 0; i < day; i++) {
                dayAll[i] = dayC[i];
            }
            for (int i = 0; i < day-1; i++) {
                dayAll[i+1] += dayAll[i];
            }

            SortedMap sortedMap = new TreeMap();
            for (int i = 0; i < num; i++) {
                sortedMap.put(action[i][0],action[i][1]);
            }

            int allC = 0;
            int tag = day;
            for (int i = 0; i < num && tag>0; i++) {
                int lastC = (int) sortedMap.lastKey();
                int deadDay = (int)sortedMap.get(sortedMap.lastKey());
                sortedMap.remove(sortedMap.lastKey());
                //System.out.println(lastC);
                int finish = 0;
                for (int j = deadDay-1; j > 0 && finish == 0 ; j--) {
                    if (deadDay>=day){
                        dayAll[tag-1] --;
                        tag--;
                        allC += lastC;
                        finish =1;
                        continue;
                    }else{
                        if (dayAll[j]>0){
                            allC += lastC;
                            for (int k = j; k < dayAll.length; k++) {
                                dayAll[k]--;
                            }
                            tag--;
                            finish =1;
                        }
                    }

                }

            }
            
            System.out.println(allC);
        }
    }
}