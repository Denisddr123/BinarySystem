import java.util.ArrayList;
import java.util.Iterator;

public class MyElement {
    public static boolean x;
    public static boolean y;
    public String string ="";
    private final ArrayList<MyElement> myElements;
    private Iterator<MyElement> myElementIterator;
    public MyElement() {
        myElements = new ArrayList<>();
    }
    public String method(String str) {
        MyElement myElement;
        String string3="";
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '(') {

                string3 = string3+str.substring(0, i)+"e";

                myElement = new MyElement();

                myElements.add(myElement);
                System.out.println(string3+" string3 "+i);
                str = myElement.method(str.substring(i+1));
                System.out.println(str+" str ");
                i = -1;


            } else if ((str.charAt(i) == ')')){
                string3 = string3+str.substring(0, i);
                System.out.println(string3+" str.charAt(i) == )");
                string = string3;
                return str.substring(i+1);

            }
        }
        if (!str.isEmpty()) {
            string3 = string3+str;
        }
        string = string3;
        return string3;
    }
    public boolean plusSeparator() {
        String[] strings = this.string.split("[+]");
        boolean z=false;
        System.out.println();
        for (String s : strings) {
            z = z | multiplication(s);
        }
        return z;
    }
    public boolean multiplication(String string) {
        String[] strings = string.split("[*]");
        myElementIterator = myElements.iterator();
        boolean z=true;
        for (String s : strings) {
            if (s.equals("!x")) {
                z = z & !x;
            }
            if (s.equals("!y")) {
                z = z & !y;
            }
            if (s.equals("x")) {
                z = z & x;
            }
            if (s.equals("y")) {
                z = z & y;
            }
            if (s.equals("!e")) {
                z = z & !myElementIterator.next().plusSeparator();
            }
            if (s.equals("e")) {
                z = z & myElementIterator.next().plusSeparator();
            }
        }
        System.out.println(string+" multiplication "+z);
        return z;
    }

    public String getString() {
        StringBuilder str= new StringBuilder(" / ");
        myElementIterator = myElements.iterator();
        while (myElementIterator.hasNext()) {
            MyElement myElement = myElementIterator.next();
            str.append(" / ").append(myElement.getString());
        }
        return string+str;
    }
}
