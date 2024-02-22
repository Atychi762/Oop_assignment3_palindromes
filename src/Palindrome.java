import java.sql.Array;
import java.util.ArrayList;
import java.util.ArrayList.*;

public class Palindrome {
    public String reversedInput = "";
    public static int primOpsReverseChars = 0;
    public static int primOpsElementComparison= 0;
    public static int primOpsStackQueueComparison = 0;
    public static int primOpsRecursiveComparison = 0;



    // method reverses the characters using a loop and compares the two strings
    public boolean reverseChars(String input){
        boolean isPalindrome = false;
        primOpsReverseChars++;
        String reversedString = "";
        primOpsReverseChars++;

        // loop that reverses the input by adding the characters to a new string
        for(int i = 0; i < input.length(); i++){
            primOpsReverseChars++;
            reversedString += input.charAt((input.length()-i)-1);
            primOpsReverseChars++;
        }
// comparison to see if the strings are equal
        primOpsReverseChars++;
        if(reversedString.equals(input)){
            isPalindrome = true;
            primOpsReverseChars++;
        }
        return isPalindrome;
    }

    // method compares the first half of the string element by element to the last half of the string
    public boolean elementComparison(String input){
        boolean isPalindrome = true;
        primOpsElementComparison++;

        // looping through half of the characters as that is all that is needed
        for(int i = 0; i < input.length()/2; i++){
            primOpsElementComparison++;
            // if the characters are not equal then we set isPalindrome to false and break the loop
            primOpsElementComparison++;
            if(input.charAt(i) != input.charAt((input.length()-1)-i)){
                primOpsElementComparison++;
                isPalindrome = false;

                break;
            }
        }
        return isPalindrome;
    }

    // method compares a stack and a queue that contains the input string
    public boolean stackQueueComparison(String input){
        boolean isPalindrome = true;
        primOpsStackQueueComparison++;
        // initialising the stack and queue
        ArrayStack stack = new ArrayStack(20);
        primOpsStackQueueComparison++;
        ArrayQueue queue = new ArrayQueue(20);
        primOpsStackQueueComparison++;

        // adding the input to the stack and queue
        for(int i = 0; i < input.length(); i++){
            primOpsStackQueueComparison++;
            stack.push(input.charAt(i));
            primOpsStackQueueComparison++;
            queue.enqueue(input.charAt(i));
            primOpsStackQueueComparison++;
        }

        for(int i = 0; i < input.length(); i++){
            primOpsStackQueueComparison++;
            // comparing the elements at the top of the stack and the front of the queue
            primOpsStackQueueComparison++;
            if(stack.top() != queue.front()){
                // if they are not equal then isPalindrome is false and we break the loop
                primOpsStackQueueComparison++;
                isPalindrome = false;
                break;
            }
            // pop the top of the stack and dequeue the front of the queue
            primOpsStackQueueComparison++;
            stack.pop();
            primOpsStackQueueComparison++;
            queue.dequeue();
        }

        return isPalindrome;
    }

    // Recursive method that reverses a string
    public void reverse(String input){
        // if the input string is null or has 1 or fewer characters, then add the input string to the output and finish the recursion
        primOpsRecursiveComparison++;
            if (input == null || input.length() <= 1) {
                primOpsRecursiveComparison++;
                reversedInput += input;
            }
            else
            {
                // otherwise add the final character of the string to the output and call the function with the input being one character shorter
                primOpsRecursiveComparison++;
                reversedInput += input.charAt(input.length()-1);
                primOpsRecursiveComparison++;
                reverse(input.substring(0,input.length()-1));
            }
    }

    // method reverses the characters in a string using recursion and then compares them to see if it is a palindrome
    public boolean recursiveComparison(String input){
        primOpsRecursiveComparison++;
        boolean isPalindrome = false;
        // calling the reverse function
        primOpsRecursiveComparison++;
        reverse(input);
        // comparing the input string to the reversed string
        primOpsRecursiveComparison++;
        if(reversedInput.equals(input)){
            // if they are equal then isPalindrome is true
            primOpsRecursiveComparison++;
            isPalindrome = true;
        }
        // resetting the reversed string to an empty string
        primOpsRecursiveComparison++;
        reversedInput = "";

        return isPalindrome;
    }

    // method the converts an integer string to binary string
    public String intToBinary(String num){
        String binaryNum = "";
        String binaryFinal = "";
        int number = Integer.valueOf(num);
        int remainder;

        // while the number given is not 1 or 0, We divide the number by two and if the remainder is 1 add 1 to the output and if it is 0 then add 0 to the output
        while(number > 1){
            // get the remainder
            remainder = number % 2;
            // Set the number to the new number(number / 2)
            number = number / 2;
            // adding the corresponding bit to the binaryNum string
            binaryNum += remainder;
        }

        // when the loop exits we need to check the final remainder to add the final bit to the binary num
        if(number == 1){
            // if the remainder is 1 then a 1 must be added to the binary number
            binaryNum += 1;
        }
        // otherwise if the remainder is 0 then a 0 must be added to the binary number
        else if(number == 0){
            binaryNum += 0;
        }

        // finally the binary bits are in reverse order so they need to be reversed
        for(int i = 0; i < binaryNum.length(); i++){
            binaryFinal += binaryNum.charAt((binaryNum.length()-i)-1);
        }

        // return the final binary number
        return binaryFinal;
    }


    public static void main(String[] args) {
        ArrayList<Integer> primOps1 = new ArrayList<Integer>();
        ArrayList<Integer> primOps2 = new ArrayList<Integer>();
        ArrayList<Integer> primOps3 = new ArrayList<Integer>();
        ArrayList<Integer> primOps4 = new ArrayList<Integer>();
        Palindrome p = new Palindrome();
        String bin_Num;
        String dec_Num;
        boolean isDecimalPalindrome;
        boolean isBinaryPalindrome;
        int palindrome_Count = 0;
        long start_Time = System.currentTimeMillis();

        for (int j = 50000; j <= 1000000; j += 50000) {
            primOpsReverseChars = 0;
            primOpsElementComparison= 0;
            primOpsStackQueueComparison = 0;
            primOpsRecursiveComparison = 0;

            for (int i = 0; i < j; i++) {
                dec_Num = Integer.toString(i);
                bin_Num = p.intToBinary(dec_Num);

                isDecimalPalindrome = p.reverseChars(dec_Num);
                isBinaryPalindrome = p.reverseChars(bin_Num);

                if (isBinaryPalindrome && isDecimalPalindrome) {
                    palindrome_Count++;
                }
            }
            long end_Time = System.currentTimeMillis();
            long time_Taken = (end_Time - start_Time);

            //System.out.println("\nTime taken for reversing string comparison: " + time_Taken + "ms");
            primOps1.add(primOpsReverseChars);
            System.out.println(j +": " + primOpsReverseChars);
            //System.out.println("Number of both binary and decimal palindromes between 0 and 1000000 is: " + palindrome_Count);

            palindrome_Count = 0;
            start_Time = System.currentTimeMillis();
            for (int i = 0; i < j; i++) {
                dec_Num = Integer.toString(i);
                bin_Num = p.intToBinary(dec_Num);

                isDecimalPalindrome = p.elementComparison(dec_Num);
                isBinaryPalindrome = p.elementComparison(bin_Num);

                if (isBinaryPalindrome && isDecimalPalindrome) {
                    palindrome_Count++;
                }
            }
            end_Time = System.currentTimeMillis();
            time_Taken = (end_Time - start_Time);

            primOps2.add(primOpsElementComparison);
            //System.out.println("\nTime taken for element by element comparison: " + time_Taken + "ms");
            //System.out.println("nNumber of primitive operations for element by element comparison of "+ j +" numbers: " + primOpsElementComparison);
            //System.out.println("Number of both binary and decimal palindromes between 0 and 1000000 is: " + palindrome_Count);

            palindrome_Count = 0;
            start_Time = System.currentTimeMillis();
            for (int i = 0; i < j; i++) {
                dec_Num = Integer.toString(i);
                bin_Num = p.intToBinary(dec_Num);

                isDecimalPalindrome = p.stackQueueComparison(dec_Num);
                isBinaryPalindrome = p.stackQueueComparison(bin_Num);

                if (isBinaryPalindrome && isDecimalPalindrome) {
                    palindrome_Count++;
                }
            }
            end_Time = System.currentTimeMillis();
            time_Taken = (end_Time - start_Time);

            //System.out.println("\nTime taken for stack and queue comparison: " + time_Taken + "ms");
            primOps3.add(primOpsStackQueueComparison);
            //System.out.println("Number of primitive operations for stack and queue comparison of "+ j +" numbers: " + primOpsStackQueueComparison);
            //System.out.println("Number of both binary and decimal palindromes between 0 and 1000000 is: " + palindrome_Count);

            palindrome_Count = 0;
            start_Time = System.currentTimeMillis();
            for (int i = 0; i < j; i++) {
                dec_Num = Integer.toString(i);
                bin_Num = p.intToBinary(dec_Num);

                isDecimalPalindrome = p.recursiveComparison(dec_Num);
                isBinaryPalindrome = p.recursiveComparison(bin_Num);

                if (isBinaryPalindrome && isDecimalPalindrome) {
                    palindrome_Count++;
                }
            }
            end_Time = System.currentTimeMillis();
            time_Taken = (end_Time - start_Time);

            primOps4.add(primOpsRecursiveComparison);
            //System.out.println("\nTime taken for recursively reversing string comparison: " + time_Taken + "ms");
            //System.out.println("Number of primitive operations for recursively reversing string comparison of "+ j +" numbers: " + primOpsRecursiveComparison);
            //System.out.println("Number of both binary and decimal palindromes between 0 and 1000000 is: " + palindrome_Count);
        }

        System.out.println(primOps1);
        System.out.println(primOps2);
        System.out.println(primOps3);
        System.out.println(primOps4);
    }



}
