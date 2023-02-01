import java.util.ArrayList;
import java.util.Iterator;

public class StringElement {
    private final ArrayList<StringElement> stringElements = new ArrayList<>();
    public Iterator<StringElement> stringElementIterator;
    public String string ="";
    public static boolean x;
    public static boolean y;
    public StringElement(String string) {
        rf(string);
    }
    public void addElement(StringElement stringElement) {
        stringElements.add(stringElement);
    }
    public void rf(String str){
        String string3;
        StringBuilder stringBuilder = new StringBuilder();
        int closeB;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '(') {
                closeB = str.indexOf(")", i+1);
                string3 = findString(str, i, closeB);

                string3=string3.substring(1, string3.length()-1);
                addElement(new StringElement(string3));
                i=i+string3.length()+1;
                stringBuilder.append("e");
            } else stringBuilder.append(str.charAt(i));
        }
        this.string = stringBuilder.toString();
    }
    public String findString(String str,int openB, int closeB) {
        String string;
        int index=openB+1, openA=openB;
        string = str.substring(openB+1, closeB);
        openB = string.indexOf("(");
        while (openB != -1) {
            closeB = str.indexOf(")", closeB+1);
            index +=openB+1;
            string = str.substring(index, closeB);
            openB = string.indexOf("(");
        }
        string = str.substring(openA, closeB+1);
        return string;
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
        stringElementIterator = stringElements.iterator();
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
                z = z & !stringElementIterator.next().plusSeparator();
            }
            if (s.equals("e")) {
                z = z & stringElementIterator.next().plusSeparator();
            }
        }
        System.out.println(string+" multiplication "+z);
        return z;
    }
    public String getString() {
        StringBuilder str= new StringBuilder(" / ");
        stringElementIterator = stringElements.iterator();
        while (stringElementIterator.hasNext()) {
            StringElement stringElement = stringElementIterator.next();
            str.append(" / ").append(stringElement.getString());
        }
        return string+str;
    }
}
