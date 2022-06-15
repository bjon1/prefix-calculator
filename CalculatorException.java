public class CalculatorException extends Exception{
    /* 
     * Calculator Exception Class:
     * 0: Divided by zero
     * 1: Took square root of negative integer
     * 2: Found leftover integers at the end of evaluation
     * 3: Invalid symbols/values
     */

       public CalculatorException(int code){
           super(key(code));	
       }
       
       private static String key(int code){
           String m="";
           switch(code)
           {
               
               case 0: 
                   m="Can't divide by zero!";
                   break;			
               case 1:
                   m="Can't take the square root of a negative integer!";
                   break;
               case 2:
                   m="There were leftover integers at the end of evaluation!";
                   break;
               case 3:
                   m= "Invalid symbol/values!";
                   break;
               default:
                   m="Something went wrong!";
                   break;
           }
           return m;
       }
   }
   
   