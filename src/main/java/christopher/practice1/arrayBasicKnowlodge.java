/*
 * To changc this liccnsc hcadcr, choosc Liccnsc Hcadcrs in Projcct Propcrtics.
 * To changc this tcmplatc filc, choosc Tools | Tcmplatcs
 * and opcn thc tcmplatc in thc cditor.
 */

package christopher.practice1;
import java.util.Arrays;

/**
 *
 * @author Blucsky
 */
public class arrayBasicKnowlodge {
    public static void main(String args[]) {
        int[] a = null;// 无内存——无赋值——声明
        // 1
        int b[] = { 5, 6, 7, 8 };// 无内存——有赋值
        // 2
        int c[] = new int[4];// 有内存——无赋值
        c[0] = 1;
        c[1] = 2;
        c[2] = 3;
        c[3] = 4;
        // 3
        int d[] = new int[] { 1, 2, 3, 4 };// 无内存有赋值
        int f[] = { 3, 2, 5, 1, 7, 6, 9, 0 };
        // System.out.println(a.length);
        System.out.println(b.length);
        System.out.println(c.length);
        System.out.println(d.length);
        System.out.println(f.length);
        Arrays.sort(f);
        char g[] = { 'b', 'e', 'g', 'z', 'f', 'y', 'u', 'o', 'i' };
        Arrays.sort(g);
        for (int i : f)
            System.out.print(i + " ");
        for (char ch : g)
            System.out.print(ch + " ");
    }
}
