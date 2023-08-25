import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class AccessorExample {

    // This private field is only accessible in the AccessorExample class and by
    // it's nested class
    private int counter;

    public AccessorExample(int counter) {
        this.counter = counter;
    }

    // public int getCounter() { // this is the right way to provide access to a
    // private variable.
    // return counter;
    // }

    public class InnerClass {
        private int innerCounter = counter;

        private void printInnerClassCounter() {
            System.out.println(innerCounter);
        }
    }

    public interface PersonInterface {

        static String getName() {
            return "";
        }
    }

    public abstract class Person implements PersonInterface {
        private String name;

        public abstract String getNames();
    }

    public static void main(String[] args) {
        // AccessorExample example = new AccessorExample(1);

        // AccessorExample.InnerClass inner = example.new InnerClass();
        // inner.printInnerClassCounter();

        // AccessorExample example2 = new AccessorExample(2);

        LinkedList<Integer> arrList = new LinkedList();
        List<Integer> list = new ArrayList<>();

        int size = list.size();
       

    }
}
