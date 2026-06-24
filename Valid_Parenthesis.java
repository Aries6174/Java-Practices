import java.util.Stack;
import java.util.Scanner;

public class Valid_Parenthesis{

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }

                char top = stack.pop();

                if(ch == ')' && top != '('){
                    return false;
                }
                if(ch == '}' && top != '{'){
                    return false;
                }
                if(ch == ']' && top != '['){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args){
        Valid_Parenthesis vp = new Valid_Parenthesis();
        Scanner input = new Scanner(System.in);

        System.out.println("Input Brackets: ");
        String s = input.nextLine();

        boolean result = vp.isValid(s);

        System.out.println(result);
    }


}