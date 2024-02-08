public class Palindrome {

    // method reverses the characters using a loop and compares the two strings
    public boolean reverseChars(String input){
        boolean isPalindrome = false;
        String reversedInput = "";

        // loop that reverses the input by adding the characters to a new string
        for(int i = 0; i < input.length(); i++){
            reversedInput += input.charAt((input.length()-i)-1);
        }
// comparison to see if the strings are equal
        if(reversedInput.equals(input)){
            isPalindrome = true;
        }
        return isPalindrome;
    }

    // method compares the first half of the string element by element to the last half of the string
    public boolean elementComparison(String input){
        boolean isPalindrome = true;

        // looping through half of the characters as that is all that is needed
        for(int i = 0; i < input.length()/2; i++){
            // if the characters are not equal then we set isPalindrome to false and break the loop
            if(input.charAt(i) != input.charAt((input.length()-1)-i)){
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    // method compares a stack and a queue that contains the input string
    public boolean stackQueueComparison(String input){
        boolean isPalindrome = true;
        // initialising the stack and queue
        ArrayStack stack = new ArrayStack(20);
        ArrayQueue queue = new ArrayQueue(20);

        // adding the input to the stack and queue
        for(int i = 0; i < input.length(); i++){
            stack.push(input.charAt(i));
            queue.enqueue(input.charAt(i));
        }

        for(int i = 0; i < input.length(); i++){
            // comparing the elements at the top of the stack and the front of the queue
            if(stack.top() != queue.front()){
                // if they are not equal then isPalindrome is false and we break the loop
                isPalindrome = false;
                break;
            }
            // pop the top of the stack and dequeue the front of the queue
            stack.pop();
            queue.dequeue();
        }

        return isPalindrome;
    }

    public String reverse(String input){
        String outputString ="";
        if(input.isEmpty()){
            return outputString;
        }
        else{
            return outputString+=(input.substring(0, input.length()-1));
        }

    }

    public boolean recursiveComparison(String input){
        boolean isPalindrome = true;
        String reversedInput = "";
        reversedInput = reverse(input);

        System.out.println(reversedInput);
        return isPalindrome;
    }


    public static void main(String[] args){
        Palindrome p = new Palindrome();

        //boolean valid = p.recursiveComparison("123454321");
        boolean valid2 = p.recursiveComparison("Hello world");

        //System.out.println(valid);
        System.out.println(valid2);
    }


}
