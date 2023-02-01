public class Binary {
    public static int sizeMantissa;
    public static int order;
    public static int fractionSize;
    public static void main(String[] args) {
        sizeMantissa = 8;
        order = 4;
        fractionSize = 6;
        String[] strings;
        System.out.println(numberToBinaryString(-265.431));
        System.out.println(binaryToDecimal(Integer.toBinaryString(0b10111111)));
        System.out.println(Integer.toBinaryString(0b10111111));

        strings = normNumberToBinaryString(265.4);
        System.out.println(strings[0]+" "+strings[1]);
        strings = normNumberToBinaryString(-438.332);
        System.out.println(strings[0]+" "+strings[1]);
        strings = normNumberToBinaryString(-0.332);
        System.out.println(strings[0]+" "+strings[1]);
        strings = normNumberToBinaryString(-0.532);
        System.out.println(strings[0]+" "+strings[1]);
        strings = normNumberToBinaryString(-23);
        System.out.println(strings[0]+" "+strings[1]);
        strings = normNumberToBinaryString(2.332);
        System.out.println(strings[0]+" "+strings[1]);
        strings = normNumberToBinaryString(-14);

        System.out.println(Integer.parseInt("10111", 2));
    }
    public static String[] normNumberToBinaryString(double x) {
        String str1, signOrder = "1";
        String[] strings = new String[2];
        int i, i1;
        if (x<0) {
            i=-1;
        } else i=1;

        double j = (x*i);
        int y = (int) j;
        double z = j-y;
        if (y>0) {
            str1 = integerToBinaryString(y);
            i1 = str1.length();
            strings[0] = sigNum(i)+","+stringSizeMantissa(str1+fractionToBinaryString(z));
            strings[1] = "0."+stringSizeOrder(i1);
        } else {
            str1 = fractionToBinaryString(z);
            i1 = str1.indexOf("1");
            if (i1 == -1) throw new RuntimeException("Выбрано слишком маленькое число");
            if (i1==0) signOrder = "0";
            strings[0] = sigNum(i)+","+stringSizeMantissa(str1.substring(i1));
            strings[1] = signOrder+"."+stringSizeOrder(i1);
        }
        return strings;
    }
    private static String stringSizeOrder(int i) {
        int x = (int) (Math.pow(2, order)-1)-i, y;
        String str;
        if (x<0) {
            throw new RuntimeException("Перполнение разрядов порядка");
        }
        str = integerToBinaryString(i);
        y = order - str.length();
        while (y != 0) {
            str = "0"+str;
            y--;
        }
        return str;
    }
    private static String stringSizeMantissa(String str) {
        int x = str.length() - sizeMantissa;
        StringBuilder strBuilder = new StringBuilder(str);
        while (x != 0) {
            if (x < 0) {
                strBuilder.append("0");
                x++;
            } else {
                strBuilder = new StringBuilder(strBuilder.substring(0, sizeMantissa));
                x = 0;
            }
        }
        str = strBuilder.toString();
        return str;
    }
    public static String numberToBinaryString(double x) {
        String str;
        int i = Integer.signum((int) x);
        double j = (x*i);
        int y = (int) j;
        double z = j-y;
        str = integerToBinaryString(y)+"."+fractionToBinaryString(z);
        return sigNum(i)+str;
    }
    private static String fractionToBinaryString(double x) {
        StringBuilder str = new StringBuilder();
        double c = x;
        for (int i=0; i<fractionSize; i++) {
            if ((c *=2)>=1) {
                str.append("1");
                c -= 1;
            } else str.append("0");
        }
        return str.toString();
    }
    private static String integerToBinaryString(int x) {
        StringBuilder str = new StringBuilder();
        int c = x;
        while (c>0) {
            str.insert(0, c%2);
            c /=2;
        }
        return str.toString();
    }
    public static int binaryToDecimal(String binaryNumber) {
        int x = 0, z = 0, length = binaryNumber.length();
        while (length>0) {
            x = (int) (x+Character.digit(binaryNumber.charAt(z++), 2)*Math.pow(2, --length));
        }
        return x;
    }
    private static String sigNum(int x) {
        int i = Integer.signum(x);
        if (i == -1) {
            return "1";
        } else {
            return "0";
        }
    }
}