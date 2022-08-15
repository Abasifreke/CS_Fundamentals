import java.util.Arrays;
import java.util.Stack;

public class Stacks {

    /**
     * How would you design a stack that returns min in o(1) time
     */
        private Stack<Integer> _min = new Stack<>();
        private Stack<Integer> main = new Stack<>();

        private Integer pop() {
            if (main.empty()) return null;

            int result = main.pop();
            if (result == _min.peek()) {
                _min.pop();
            }

            return result;
        }


        private void push(Integer input) {
            main.push(input);

            if (_min.empty()) {
                _min.push(input);
            } else if
            (input <= _min.peek()) {
                _min.push(input);
            }
        }

        private Integer min() {
            return _min.peek();
        }

        private void sort() {
            Stack<Integer> temp = new Stack<>();

            // [ ]
            // [1]
            // [3,4, 5, 6, 7, 8, 10,]

            while (!main.empty()) {
                int curr = main.pop();

                if (temp.empty()) {
                    temp.push(curr);
                } else if (curr > temp.peek()) {
                    temp.push(curr);
                } else {
                    while (!temp.empty() && temp.peek() > curr) {
                        main.push(temp.pop());
                    }
                    temp.push(curr);
                }
            }
            main = temp;
        }




    public static void main(String[] args) {
        Stacks st = new Stacks();
        st.push(55);
        st.push(9);
        st.push(3);
        st.push(3);
        st.push(5);
        st.push(2);
        st.push(6);
        st.push(18);
        st.push(6);
        st.push(2);

        st.pop();
        st.pop();
        st.pop();

        st.sort();
        System.out.println(Arrays.toString(st.main.toArray()));
        System.out.println(st.min());
    }

}
