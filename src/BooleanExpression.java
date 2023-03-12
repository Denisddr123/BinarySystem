public class BooleanExpression {
    public static void main(String[] args) {
        String str1, str2;
        str1 = "(x*!y+!x*y+x*!y+!x*y)*!(x*!y+!x*y+x*!y+!x*y)+x";
        str2 = "x";
        System.out.println(equalsExpression(str1, str2));
        System.out.println(equalsExpressionTwo(str1, str2));
    }
    public static boolean equalsExpression(String str1, String str2) {
        StringElement stringElement = new StringElement(str1);
        StringElement stringElement2 = new StringElement(str2);
        System.out.println(stringElement.getString()+" stringElement");
        System.out.println(stringElement2.getString()+" stringElement2");
        boolean[] booleans = {true, false};
        boolean z=false, k, h;
        for (boolean aBoolean : booleans) {
            for (boolean b : booleans) {
                StringElement.x = aBoolean;
                StringElement.y = b;
                System.out.println("x = " + aBoolean + " y = " + b);
                k = stringElement.plusSeparator();
                h = stringElement2.plusSeparator();
                System.out.println("stringElement = " + k + " stringElement2 = " + h);
                z = k == h;
            }
        }
        return z;
    }
    public static boolean equalsExpressionTwo(String str1, String str2) {
        MyElement myElement = new MyElement();
        myElement.method(str1);
        MyElement myElement2 = new MyElement();
        myElement2.method(str2);
        System.out.println(myElement.getString()+" myElement");
        System.out.println(myElement2.getString()+" myElement2");
        boolean[] booleans = {true, false};
        boolean z=false, k, h;
        for (boolean aBoolean : booleans) {
            for (boolean b : booleans) {
                MyElement.x = aBoolean;
                MyElement.y = b;
                System.out.println("x = " + aBoolean + " y = " + b);
                k = myElement.plusSeparator();
                h = myElement2.plusSeparator();
                System.out.println("myElement = " + k + " myElement2 = " + h);
                z = k == h;
            }
        }
        return z;
    }
}
