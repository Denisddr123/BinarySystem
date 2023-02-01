import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        Binary.sizeMantissa = 7;
        Binary.order = 4;
        Binary.fractionSize = 8;
        double x, y;

        /*StringElement.x=true; StringElement.y=false;
        StringElement stringElement = new StringElement("(x*!y+!x*y+x*!y+!x*y)*!(x*!y+!x*y+x*!y+!x*y)+x");
        System.out.println(stringElement.getString());
        System.out.println(stringElement.plusSeparator());*/

        /*String[] strings1, strings2, strings3;
        x=ReverseAndAdditional.binaryToDouble("-1110");
        y=ReverseAndAdditional.binaryToDouble("11101");
        strings1 = Binary.normNumberToBinaryString(x);
        strings2 = Binary.normNumberToBinaryString(y);
        strings3 = SumBinaryCod.sumReverse(strings1, strings2);
        System.out.println("Сложение в обратном коде "+"мантисса: "+strings3[0]+" порядок: "+strings3[1]);
        strings3 = SumBinaryCod.sumAdditional(strings1, strings2);
        System.out.println("Сложение в дополнительном коде "+"мантисса: "+strings3[0]+" порядок: "+strings3[1]);*/

        /*System.out.println("мантисса: "+strings1[0]+" порядок: "+strings1[1]);
        System.out.println("мантисса: "+strings2[0]+" порядок: "+strings2[1]);*/
        /*System.out.println(ReverseAndAdditional.incomprehensibleTask("-1110")+" Прямой код");
        System.out.println(ReverseAndAdditional.incomprehensibleTaskReverseCod("-1110")+" Обратный код");
        System.out.println(ReverseAndAdditional.incomprehensibleTaskAdditionalCode("-1110")+" Дополнительный код");
        System.out.println(ReverseAndAdditional.incomprehensibleTask("-0,1110")+" Прямой код");
        System.out.println(ReverseAndAdditional.incomprehensibleTaskReverseCod("-0,1110")+" Обратный код");
        System.out.println(ReverseAndAdditional.incomprehensibleTaskAdditionalCode("-0,1110")+" Дополнительный код");
        System.out.println(ReverseAndAdditional.incomprehensibleTask("0,1110")+" Прямой код");
        System.out.println(ReverseAndAdditional.incomprehensibleTaskReverseCod("0,1110")+" Обратный код");
        System.out.println(ReverseAndAdditional.incomprehensibleTaskAdditionalCode("0,1110")+" Дополнительный код");
        System.out.println(ReverseAndAdditional.incomprehensibleTask("1110")+" Прямой код");
        System.out.println(ReverseAndAdditional.incomprehensibleTaskReverseCod("1110")+" Обратный код");
        System.out.println(ReverseAndAdditional.incomprehensibleTaskAdditionalCode("1110")+" Дополнительный код");
        String[] strings;*/
        /*strings = Binary.normNumberToBinaryString(265.4);
        System.out.println(strings[0]+" "+strings[1]);*/

        /*System.out.println(Binary.numberToBinaryString(265.431));
        System.out.println(Binary.binaryToDecimal("10111111"));*/
        /*System.out.println("Number 1110: "+integerToBinaryString(Integer.parseInt("1110", 2)));*/

    }
    public static String integerToBinaryString(int i) {
        String str;
        int sigNum, numberOfLeadingZeros;
        numberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
        sigNum = Integer.signum(i);
        str = Integer.toBinaryString(i);
        if (sigNum==1) {
            StringBuilder stringBuilder = new StringBuilder();
            while (numberOfLeadingZeros>0) {
                stringBuilder.append("0");
                numberOfLeadingZeros--;
            }
            stringBuilder.append(str);
            str = stringBuilder.toString();
        }
        return str;
    }
}
