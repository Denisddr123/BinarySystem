public class SumBinaryCod {
    public static void main(String[] args) {
        Binary.sizeMantissa = 7;
        Binary.order = 4;
        Binary.fractionSize = 8;
    }
    private static String[] formatString(String[] strings) {
        strings[0] = strings[0].substring(1);
        strings[1] = strings[1].charAt(0)+"."+strings[1].substring(1);
        return strings;
    }
    public static String[] sumAdditional(String[] strings1, String[] strings2) {
        char[] chars;
        String[] strings = new String[2];
        String string, mantissa1 = ReverseAndAdditional.additionalCode(strings1[0]),
                mantissa2 = ReverseAndAdditional.additionalCode(strings2[0]),
                order1=ReverseAndAdditional.additionalCode(strings1[1]),
                order2=ReverseAndAdditional.additionalCode(strings2[1]),
                subtrahendOrder=ReverseAndAdditional.additionalCodeForSubtrahend(strings2[1]);
        chars = differenceOrdersOfAdditionCode(order1, subtrahendOrder);
        string = String.valueOf(chars);
        if (string.charAt(0) == '1') {
            mantissa1 = mantissaOfAdditionShiftToRight(mantissa1, string);
            order1=order2;
        } else if (string.charAt(0) == '0') {
            mantissa2 = mantissaOfAdditionShiftToRight(mantissa2, string);
        }
        chars = sumMantissaOfAdditionCode(mantissa1, mantissa2);
        strings[0] = String.valueOf(chars);
        strings[1] = order1;

        return formatString(normalizationOfTheNumberAdditional(strings));
    }
    public static String[] normalizationOfTheNumberAdditional(String[] strings) {
        String[] strings1 = new String[2];
        String mantissa = strings[0], order = strings[1], str3 = "11111111111111111111111111111111111111111111111111111",
                str4 = "0.00000000000000000000000000000000000000000000000000", str5=str3.substring(0, order.length()-1);
        int x = mantissa.indexOf(",");
        char[] chars;
        if (x == -1) {
            mantissa = mantissa.substring(0,2)+","+mantissa.substring(2);
        }
        if (mantissa.charAt(0)!= mantissa.charAt(1)) {
            mantissa = mantissaOfAdditionShiftToRight(mantissa, "01");
            order = String.copyValueOf(orderDifference(order, str4.substring(0, order.length()-1)+"1"));
            order = order.substring(0, order.length()-1);
        }
        while (mantissa.charAt(1) == mantissa.charAt(3)) {
            mantissa = mantissaShiftToLeftForAddition(mantissa, "01");
            chars = orderDifference(order, str5);
            order = String.valueOf(chars);

            order = order.substring(0, order.length()-1);
            str5 = str3.substring(0, order.length());
        }
        strings1[0] = mantissa;
        strings1[1] = order;
        return strings1;
    }
    public static String[] normalizationOfTheNumberReverse(String[] strings) {
        String[] strings1 = new String[2];
        String mantissa = strings[0], order = strings[1], str3 = "11111111111111111111111111111111111111111111111111111",
                str4 = "0.00000000000000000000000000000000000000000000000000", str5=str3.substring(0, order.length()-2)+"0";
        int x = mantissa.indexOf(",");
        char[] chars;
        if (x == -1) {
            mantissa = mantissa.substring(0,2)+","+mantissa.substring(2);
        }
        if (mantissa.charAt(0)!= mantissa.charAt(1)) {
            mantissa = mantissaOfReverseShiftToRight(mantissa, "01");
            order = String.copyValueOf(differenceOrdersOfReverseCode(order, str4.substring(0, order.length()-1)+"1"));
            order = order.substring(0, order.length()-1);
        }
        while (mantissa.charAt(1) == mantissa.charAt(3)) {
            mantissa = mantissaShiftToLeftForReverse(mantissa, "01");
            chars = differenceOrdersOfReverseCode(order, str5);
            order = String.valueOf(chars);
            str5 = str3.substring(0, order.length()-1)+"0";
        }
        strings1[0] = mantissa;
        strings1[1] = order;
        return strings1;
    }
    public static String[] sumReverse(String[] strings1, String[] strings2) {
        char[] chars;
        String[] strings = new String[2];
        String string, mantissa1=ReverseAndAdditional.reverseCode(strings1[0]),
                mantissa2=ReverseAndAdditional.reverseCode(strings2[0]),
                order1=ReverseAndAdditional.reverseCode(strings1[1]),
                order2=ReverseAndAdditional.reverseCode(strings2[1]),
                subtrahendOrder=ReverseAndAdditional.reverseCodeForSubtrahend(strings2[1]);
        chars = differenceOrdersOfReverseCode(order1, subtrahendOrder);
        string = String.valueOf(chars);
        if (string.charAt(0) == '1') {
            mantissa1 = mantissaOfReverseShiftToRight(mantissa1, string);
            order1=order2;
        } else if (string.charAt(0) == '0') {
            mantissa2 = mantissaOfReverseShiftToRight(mantissa2, string);
        }
        chars = sumMantissaOfReverseCode(mantissa1, mantissa2);
        strings[0] = String.valueOf(chars);
        strings[1] = order1;
        return formatString(normalizationOfTheNumberReverse(strings));
    }
    public static String mantissaShiftToLeftForAddition(String mantissa, String order) {
        StringBuilder string1;
        int x = Binary.binaryToDecimal(order), length = mantissa.length(), z = mantissa.indexOf(",");
        if (z==-1) {
            string1 = new StringBuilder(mantissa.substring(1));
            z=0;
        } else {
            string1 = new StringBuilder(mantissa.substring(z + 1));
        }
        for (int i=0; i<x; i++) {
            string1.delete(0, 1);
            string1.append("0");
        }
        string1.insert(0, mantissa.substring(0, z+1));
        return string1.substring(0, length);
    }
    public static String mantissaShiftToLeftForReverse(String mantissa, String order) {
        StringBuilder string1;
        String substring = mantissa.substring(0,1);
        int x = Binary.binaryToDecimal(order), length = mantissa.length(), z = mantissa.indexOf(",");
        if (z==-1) {
            string1 = new StringBuilder(mantissa.substring(1));
            z=0;
        } else {
            string1 = new StringBuilder(mantissa.substring(z + 1));
        }
        for (int i=0; i<x; i++) {
            string1.delete(0, 1);
            string1.append(substring);
        }
        string1.insert(0, mantissa.substring(0, z+1));
        return string1.substring(0, length);
    }
    public static String mantissaOfAdditionShiftToRight(String mantissa, String order) {
        String str = ReverseAndAdditional.additionalCode(order);
        str = "0"+str.substring(1);
        return mantissaShiftToRight(mantissa, str);
    }
    public static String mantissaOfReverseShiftToRight(String mantissa, String order) {
        String str = ReverseAndAdditional.reverseCode(order);
        str = "0"+str.substring(1);
        return mantissaShiftToRight(mantissa, str);
    }
    public static String mantissaShiftToRight(String mantissa, String order) {
        StringBuilder string1;
        String substring = mantissa.substring(0,1), sign = "", strChar1=mantissa.substring(0,1),
                strChar2=mantissa.substring(1, 2);
        int x = Binary.binaryToDecimal(order), length = mantissa.length(),
                z = mantissa.indexOf(",");
        if (z==-1) {
            string1 = new StringBuilder(mantissa.substring(2));
            sign = string1.substring(0, 2);
        } else {
            string1 = new StringBuilder(mantissa.substring(z + 1));
            sign +=mantissa.substring(0, z+1);
        }
        if (sign.length()==3) {
            if (!strChar1.equals(strChar2)) {
                string1.insert(0, strChar2);
                sign = strChar1+strChar1+",";
                x--;
            }
        }
        for (int i=0; i<x; i++) {
            string1.insert(0, substring);
        }
        string1.insert(0, sign);
        return string1.substring(0, length);
    }
    public static char[] sumBinary(char[] a, char[] b) {
        String str1 = "1", str2 = "0";
        int x = str1.toCharArray()[0], y = str2.toCharArray()[0], z=0;
        char[] result = new char[a.length+1];
        for (int i = a.length-1; i>=0; i--) {
            if ((a[i]== (char) x) & (b[i] == (char) x)) {
                if (z==1) {
                    result[i] =(char) x;
                } else {
                    result[i] =(char) y;
                    z=1;
                }
            } else if ((a[i]== (char) x) ^ (b[i] == (char) x)) {
                if (z==1) {
                    result[i] =(char) y;
                } else {
                    result[i] =(char) x;
                }
            } else {
                if (z==1) {
                    result[i] =(char) x;
                    z=0;
                } else {
                    result[i] =(char) y;
                }
            }
        }
        if (z==1) {
            result[result.length-1]=(char) x;
        } else result[result.length-1]=(char) y;
        return result;
    }
    public static char[] orderDifferenceAddition(String str, String str2) {
        String string1, string2, string;
        StringBuilder stringBuilder= new StringBuilder();
        char[] chars;
        string2 = ReverseAndAdditional.additionalCodeForSubtrahend(str2);
        string1 = ReverseAndAdditional.additionalCode(str);
        chars = orderDifference(string1, string2);
        string = String.valueOf(stringBuilder.append(chars).substring(0, chars.length-1));
        return string.toCharArray();
    }
    public static char[] differenceOrdersOfAdditionCode(String str, String str2) {
        String string;
        StringBuilder stringBuilder= new StringBuilder();
        char[] chars;
        chars = orderDifference(str, str2);
        string = String.valueOf(stringBuilder.append(chars).substring(0, chars.length-1));
        return string.toCharArray();
    }
    public static char[] orderDifferenceReverse(String str, String str2) {
        String string, string2;
        char[] chars;

        string2 = ReverseAndAdditional.reverseCodeForSubtrahend(str2);
        string = ReverseAndAdditional.reverseCode(str);
        chars = orderDifference(string, string2);
        return getChars(chars);
    }
    public static char[] differenceOrdersOfReverseCode(String str, String str2) {
        char[] chars;
        chars = orderDifference(str, str2);
        return getChars(chars);
    }
    private static char[] orderDifference(String str, String str2) {
        String string=str, string2=str2;
        int x = str.indexOf(".");
        if (x!=-1) {
            string = str.substring(0, x)+str.substring(x+1);
        }
        x = str2.indexOf(".");
        if (x!=-1) {
            string2 = str2.substring(0, x)+str2.substring(x+1);
        }
        return sumBinary(string.toCharArray(), string2.toCharArray());
    }
    public static char[] sumMantissaInAdditionCode(String str, String str2) {
        String string1, string2, string;
        StringBuilder stringBuilder= new StringBuilder();
        char[] chars;
        string1 = ReverseAndAdditional.additionalCode(str);
        string2 = ReverseAndAdditional.additionalCode(str2);
        chars = sumMantissa(string1, string2);
        string = String.valueOf(stringBuilder.append(chars).substring(0, chars.length-1));
        return string.toCharArray();
    }
    public static char[] sumMantissaOfAdditionCode(String str, String str2) {
        String string;
        StringBuilder stringBuilder= new StringBuilder();
        char[] chars;
        chars = sumMantissa(str, str2);
        string = String.valueOf(stringBuilder.append(chars).substring(0, chars.length-1));
        return string.toCharArray();
    }
    public static char[] sumMantissaInReverseCode(String str, String str2) {
        String string, string2;
        char[] chars;

        string2 = ReverseAndAdditional.reverseCode(str2);
        string = ReverseAndAdditional.reverseCode(str);
        chars = sumMantissa(string, string2);
        return getChars(chars);
    }
    public static char[] sumMantissaOfReverseCode(String str, String str2) {
        char[] chars;
        chars = sumMantissa(str, str2);
        return getChars(chars);
    }

    private static char[] getChars(char[] chars) {
        String string, str4 ="1", str3 = "000000000000000000000000000000000000";
        int x = str4.toCharArray()[0];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(chars);
        if (chars[chars.length-1]== x) {
            chars=orderDifference(stringBuilder.substring(0, chars.length-1), str3.substring(0, chars.length-2)+"1");
        }
        stringBuilder = new StringBuilder();
        string = String.valueOf(stringBuilder.append(chars).substring(0, chars.length-1));
        return string.toCharArray();
    }

    private static char[] sumMantissa(String str, String str2) {
        String string=str, string2=str2;
        int x = str.indexOf(",");
        if (x!=-1) {
            string = str.charAt(0)+str.substring(0, x)+str.substring(x+1);
        }
        x = str2.indexOf(",");
        if (x!=-1) {
            string2 = str2.charAt(0)+str2.substring(0, x)+str2.substring(x+1);
        }
        return sumBinary(string.toCharArray(), string2.toCharArray());
    }
}
