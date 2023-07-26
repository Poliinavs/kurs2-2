/**
 * @author Polina_Avs
 * @version 1.0
 */
package bstu.it.Avs.basejava;
import static java.lang.Math.*;
import java.util.Arrays;
public class JavaTest {
    static int sint;
    final int fint = 5;
    public final int fint2 = 5;
    public static final int sint2 = 5;
    public static void main(String[] args) {
        /**
         * Точка входа в программу
         * @param args получаем аргументы командной строки
         * @return void
         * @throws java.lang.Exception
         */
        char symbol = 's';
        int number = 5;
        /**
         * Текстовое поле
         * @value 5
         * @see local
         */
        short shortNumber = 10;
        byte byteNumber = 20;
        long longNumber = 100000000L;
        boolean isTrue = true;
        String text = "Hello World!";
        double doubleNumber = 5.5;

        System.out.println(text + number);
        System.out.println(text + symbol);
        System.out.println(text + doubleNumber);

        byteNumber = (byte)(byteNumber + number);
        number = (int)(doubleNumber + longNumber);
        longNumber = (long)(number + 10);

        System.out.println(sint);

        boolean res1 = true && false;
        boolean res2 = true ^ false;

        // System.out.println(true + true); нельзя

        var var1 = 9223372036854775807L;
        var var2 = 0x7fff_ffff_fffL;

        char ch1 = 'a',
                ch2 = '\u0061',
                ch3 = 97;
        System.out.println(ch1 + ch2 + ch3);
        System.out.println("3.45 % 2.4 = " + 3.45 % 2.4);
        System.out.println("1.0 / 0.0 = " + 1.0 / 0.0);
        System.out.println("0.0 / 0.0 = " + 0.0 / 0.0);
        System.out.println("log(-345) = " + Math.log(-345));
        System.out.println("Float.intBitsToFloat(0x7F800000) = " + Float.intBitsToFloat(0x7F800000));
        System.out.println("Float.intBitsToFloat(0xFF800000) = " + Float.intBitsToFloat(0xFF800000));

        System.out.println("PI = " + PI);
        System.out.println("E = " + E);
        System.out.println("round(PI) = " + round(PI));
        System.out.println("round(E) = " + round(E));
        System.out.println("min(PI, E) = " + min(PI, E));
        System.out.println("Рандомное число [0; 1] = " + random());

        Boolean b1 = true;
        Character c1 = 'a';
        Integer i1 = 5;
        Long l1 = 100000L;
        Short s1 = 10;
        Byte by1 = 20;
        Double d1 = 5.5;

        l1 += (i1 * 1) + s1 << 5;
        System.out.println("l1 = " + l1);

        System.out.println("MIN_LONG = " + Long.MIN_VALUE);
        System.out.println("MAX_LONG = " + Long.MAX_VALUE);
        System.out.println("MIN_DOUBLE = " + Double.MIN_VALUE);
        System.out.println("MAX_DOUBLE = " + Double.MAX_VALUE);

        int int1 = 23;
        Integer int2 = int1;
        int1 = int2;

        byte byte1 = 127;
        Byte byte2 = byte1;
        byte1 = byte2;

        String text1 = "51";
        int1 = Integer.parseInt(text1);
        System.out.println("int1 = " + int1);
        System.out.println("Integer.toHexString(255) = " + Integer.toHexString(12));
        System.out.println("Integer.compare(1, 2) = " + Integer.compare(9, 2));
        System.out.println("Integer.toString(255) = " + Integer.toString(12));
        System.out.println("Integer.bitCount(255) = " + Integer.bitCount(255));
        System.out.println("Double.isNaN(0.0 / 0.0) = " + Double.isNaN(0.0 / 0.0));

        String s34 = "2341";

        var NB_1 = new Integer(s34);
        var NB_2 = Integer.parseInt(s34);
        var NB_3 = Integer.valueOf(s34);

        System.out.println("NB_1= " + NB_1);
        System.out.println("NB_2= " + NB_2);
        System.out.println("NB_3= " + NB_3);

        byte[] bytes = s34.getBytes();
        String s34_b = new String(bytes);
        System.out.println("s34_b = " + s34_b);


        String s = "true";
        boolean b = Boolean.parseBoolean(s);
        System.out.println("b = " + b);

        boolean b_2 = new Boolean(s);
        System.out.println("b_2 = " + b_2);

        String str1 = "Hello";
        String str2 = "Hello"; // = null

        System.out.println("str1 == str2 = " + (str1 == str2));
        System.out.println("str1.equals(str2) = " + str1.equals(str2));
        System.out.println("str1.compareTo(str2) = " + str1.compareTo(str2));

        String str3 = "Hello, world,Java!";
        String[] str3_split = str3.split(",");
        System.out.println("str3_split = " + Arrays.toString(str3_split));
        System.out.println("str3.contains(world) = " + str3.contains("world"));
        System.out.println("str3.hashCode() = " + str3.hashCode());
        System.out.println("str3.indexOf(world) = " + str3.indexOf("world"));
        System.out.println("str3.length() = " + str3.length());
        System.out.println("str3.replace(world, java) = " + str3.replace("world", "java"));

        char[][] c11;
        char[] c2[];
        char c3[][];

        c11 = new char[3][];
        c2 = new char[3][];
        c3 = new char[3][];
        System.out.println("c11.length() = " + c11.length);
        for(int i = 0; i < c11.length; i++) {
            c11[i] = new char[i + 1];

            System.out.println("c11[" + i + "].length() = " + c11[i].length);
        }

        int[][] array = {{1,2}, {3,4}};

        boolean Rez = c2 == c3;
        System.out.println("comRez = " + Rez);
        c2 = c3;
        Rez = c2 == c3;
        System.out.println("comRez = " + Rez);

        for(var arr : array) {
            for(var el : arr) {
                System.out.print(el + " ");
            }
            System.out.println();
        }


        WrapperString wr= new WrapperString("Hello");
        wr.replace('e','1');
        System.out.println("WrapperString = " + wr.getStr1());

        WrapperString wrapper1 = new WrapperString("Hello"){
            @Override
            public void replace(char oldchar, char newchar) {
                super.replace(oldchar, newchar);
            }
            public void delete(char newchar) {
                super.replace(newchar, ' ');
            }
        };

    }


}
