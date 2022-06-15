import java.util.*;
import java.io.*;

public class PrefixCalculator{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File(args[0]));
        try{
            while(sc.hasNextLine()){
                String s = sc.nextLine();
                System.out.println(s + " = " + calculate(s.split(" ")));
            }
        } catch(CalculatorException e){
            System.out.println(e.getMessage());
        }
        sc.close();
    }

    public static int calculate(String[] ex) throws CalculatorException{
        Stack<Integer> st = new Stack<>();
        for(int i = ex.length-1; i >= 0; i--){
            if(Character.isDigit(ex[i].charAt(0))){
                st.push(Integer.parseInt(ex[i]));
            } else if(ex[i].equals("+")){
                st.push(st.pop() + st.pop());
            } else if(ex[i].equals("-")){
                st.push(st.pop()-st.pop());
            } else if(ex[i].equals("*")){
                st.push(st.pop() * st.pop());
            } else if(ex[i].equals("/")){
                st.push(st.pop()/st.pop());
            } else if(ex[i].equals("^")){
                st.push((int)(Math.pow(st.pop(), st.pop())));
            } else if(ex[i].equals("%")){
                int var1 = st.pop();
                int var2 = st.pop();
                if(var2 == 0){
                    throw new CalculatorException(0);
                }
                st.push(var1 % var2);
            } else if(ex[i].equals("@")){
                st.push(st.pop() * (-1));
            } else if(ex[i].equals("#")){
                int var = st.pop();
                if(var < 0){
                    throw new CalculatorException(1);
                }
                st.push((int)(Math.sqrt(var)));
            } else if(ex[i].equals("$")){
                int answer = st.pop();
                if(!st.isEmpty()){
                    throw new CalculatorException(2);
                }
                return answer;
            } else {
                throw new CalculatorException(3);
            }
        }
        return -1;
    }
}



