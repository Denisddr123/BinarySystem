public class ReverseAndAdditional {
    private static int sign;
    public static void main(String[] args) {
        String[] strings;
        Binary.sizeMantissa = 7;
        Binary.order = 4;
        Binary.fractionSize = 8;

        System.out.println(binaryToDouble("-10,1110"));
        strings = Binary.normNumberToBinaryString(binaryToDouble("-10,1110"));
        System.out.println(strings[0]+" "+strings[1]);
        strings = Binary.normNumberToBinaryString(binaryToDouble("111,11101"));
        System.out.println(strings[0]+" "+strings[1]);
        strings = Binary.normNumberToBinaryString(binaryToDouble("0,111101"));
        System.out.println(strings[0]+" "+strings[1]);
        System.out.println("-1110");
        strings = Binary.normNumberToBinaryString(binaryToDouble("-1110"));
        System.out.println(strings[0]+" "+strings[1]);




        System.out.println(binaryToDouble("-1110"));
        strings = Binary.normNumberToBinaryString(binaryToDouble("-0,1110"));
        //incomprehensibleTask(strings);
        System.out.println(strings[0]+" "+strings[1]);
        System.out.println(binaryToDouble("-0,1110"));
        System.out.println(binaryToDouble("0,111101"));
        strings = Binary.normNumberToBinaryString(-0.89);
        System.out.println(strings[0]+" "+strings[1]);
        System.out.println(incomprehensibleTask("-1110")+" Прямой код");
        System.out.println(incomprehensibleTaskReverseCod("-1110")+" Обратный код");
        System.out.println(incomprehensibleTaskAdditionalCode("-1110")+" Дополнительный код");
        System.out.println(incomprehensibleTask("-0,1110")+" Прямой код");
        System.out.println(incomprehensibleTaskReverseCod("-0,1110")+" Обратный код");
        System.out.println(incomprehensibleTaskAdditionalCode("-0,1110")+" Дополнительный код");
        System.out.println(incomprehensibleTask("0,1110")+" Прямой код");
        System.out.println(incomprehensibleTaskReverseCod("0,1110")+" Обратный код");
        System.out.println(incomprehensibleTaskAdditionalCode("0,1110")+" Дополнительный код");
        System.out.println(incomprehensibleTask("1110")+" Прямой код");
        System.out.println(incomprehensibleTaskReverseCod("1110")+" Обратный код");
        System.out.println(incomprehensibleTaskAdditionalCode("1110")+" Дополнительный код");
    }
    public static String incomprehensibleTask(String string) {
        String str = "", str1 = string, str2;
        if (string.startsWith("-")) {
            str +="1";
            str1 = str1.substring(1);
        } else str +="0";
        if (!string.contains(",")) {
            if (str1.length() > Binary.sizeMantissa) {
                throw new RuntimeException("Число не помещается в разрядную сетку.");
            }
            str +=".";
            str +=addZeroString(str1)+str1;
        } else {
            str2 = str1.substring(2);
            if (str2.length() > Binary.sizeMantissa) {
                str2 = str2.substring(0, Binary.sizeMantissa);
            } else str2 = str2 + addZeroString(str2);
            str +=","+str2;
        }
        return str;
    }
    public static String incomprehensibleTaskAdditionalCode(String str) {
        String string = incomprehensibleTask(str), string2;
        if (checkSign(string)) return string;
        int  z= string.lastIndexOf("1");
        string2 = string.substring(z);
        string = reverse(string);
        return string.substring(0, z)+string2;
    }
    public static String incomprehensibleTaskReverseCod(String str) {
        String str2 = incomprehensibleTask(str);
        if (checkSign(str2)) return str2;
        return reverse(str2);
    }
    public static String additionalCode(String str) {
        String string = str, string2;
        if (checkSign(string)) return string;
        int  z= string.lastIndexOf("1");
        string2 = string.substring(z);
        string = reverseForOrder(string);
        return string.substring(0, z)+string2;
    }
    public static String additionalCodeForSubtrahend(String str) {
        String string = str, string2, substring=string.substring(0,1);
        if (substring.equals("0")) {
            string = "1"+str.substring(1);
        } else string = "0"+str.substring(1);
        if (checkSign(string)) return string;
        int  z= string.lastIndexOf("1");
        string2 = string.substring(z);
        string = reverse(string);
        return string.substring(0, z)+string2;
    }
    public static String reverseCode(String str) {
        if (checkSign(str)) return str;
        return reverseForOrder(str);
    }
    public static String reverseCodeForSubtrahend(String str) {
        String substring=str.substring(0,1), string;
        if (substring.equals("0")) {
            string = "1"+str.substring(1);
        } else string = "0"+str.substring(1);
        if (checkSign(string)) return string;
        return reverse(string);
    }
    public static String reverseToDirect(char[] chars) {
        String string1 = String.valueOf(chars);
        if (checkSign(string1)) return string1;
        return reverse(string1);
    }
    private static String reverse(String str2) {
        String str1, str3, str4 ="1", str5 ="0";
        int x = str4.toCharArray()[0], y = str5.toCharArray()[0];
        str3 = str2.substring(0, 2);
        str1 = str2.substring(2);
        char[] chars = str1.toCharArray();
        for (int i =0; i<chars.length; i++) {
            if (( chars[i])==x) {
                chars[i]= (char) y;
            } else chars[i]= (char) x;
        }
        return str3 +
                String.valueOf(chars);
    }
    private static String reverseForOrder(String str2) {
        String str1, str3, str4 ="1", str5 ="0";
        int x = str4.toCharArray()[0], y = str5.toCharArray()[0],
        z = str2.indexOf(","), j=1;
        str3 = str2.substring(0, j);
        if (z!=-1) {
            j=z+1;
            str3 = str2.substring(0, z+1);
        }
        z = str2.indexOf(".");
        if (z!=-1) {
            str3 = str2.substring(0, z+1);
            j=z+1;
        }

        str1 = str2.substring(j);
        char[] chars = str1.toCharArray();
        for (int i =0; i<chars.length; i++) {
            if (( chars[i])==x) {
                chars[i]= (char) y;
            } else if (( chars[i])==y) {
                chars[i]= (char) x;
            }
        }
        return str3 +
                String.valueOf(chars);
    }
    private static boolean checkSign(String str) {
        return !str.startsWith("1");
    }
    private static String addZeroString(String str) {
        String str1 ="";
        for (int i = 1; i<Binary.sizeMantissa-str.length()+1; i++) {
            str1 +="0";
        }
        return str1;
    }
    public static double binaryToDouble(String str) {
        String str2;
        sign = 1;
        double d=0, b;
        int x, y=0;
        if (str.charAt(0) == '-') {
            sign=-1;
            y=1;
        }
        x = str.indexOf(",");
        if (x>=0) {
            str2 = str.substring(x+1);
            d = fractionBinaryToDouble(str2);
            b = numberBinaryToDouble(str.substring(y, x));
        } else {
            b = numberBinaryToDouble(str.substring(y));
        }
        return (b+d)*sign;
    }
    public static int numberBinaryToDouble(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(str, 2);
    }
    public static double fractionBinaryToDouble(String str) {
        String str2;
        str2 = str;
        int d = Integer.parseInt(str2, 2);
        return d/Math.pow(0b10, str2.length());
    }
}
