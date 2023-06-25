package DSA;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("Borderlands");
        stack.push("God of war");
        stack.push("RDR 2");
        stack.push("GOT");
        stack.push("SFV");

        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.search("God of war"));
        System.out.println(stack.pop());

        System.out.println(stack);



    }
}
