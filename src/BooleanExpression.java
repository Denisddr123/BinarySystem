public class BooleanExpression {
    public static void main(String[] args) {
        String str1, str2;
        str1 = "(x*!y+!x*y+x*!y+!x*y)*!(x*!y+!x*y+x*!y+!x*y)+x";
        str2 = "x";
        System.out.println(equalsExpression(str1, str2));
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
}
