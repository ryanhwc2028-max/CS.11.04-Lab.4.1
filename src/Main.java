import java.util.Scanner;

public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String s) {
        int l = s.length();
        int front = 0;
        int back = 0;
        for (int i = 0; i < l; i++){
            if (s.charAt(i) == '('){
                front++;
            } else {
                back++;
            }
        }
        if (front == back){
            return true;
        } else {
            return false;
        }
    }

    // 2. reverseInteger
    public static String reverseInteger(int n) {
        int l = String.valueOf(n).length();
        String x = "";
        for (int i = 0; i < l; i++){
            String numbers = String.valueOf(n);
            int lastNumber = l - 1 - i; // -1 cuz the index starts at 0 and length() function starts at 1
            x += numbers.charAt(lastNumber);
        }
        return x;
    }


    // 3. encryptThis
    public static String encryptThis(String input) {
        int l = input.length();
        int[] letters = new int[l]; //it needs to have the correct length for the array
        for (int i = 0; i<l; i++){
            char letter = input.charAt(i);
            if (letter == ' '){ //it needs to be single quotes for char
                letters[i] = 0;
            } else {
                letters[i] = 1;
            }
        }
        String newStr = "";
        int start = 0;
        int end = 0;
        for (int i = 0; i<l; i++){
            if (letters[i] == 0 || i == letters.length - 1){
                if (letters[i] == 0) { //if theres a space not the end
                    end = i;
                } else {
                    end = i + 1;
                }
                newStr = newStr+encryptWord(input.substring(start, end));
                if (i < letters.length - 1) { // to add a space when its inbetween words
                    newStr += " ";
                }
                start = i+1;
            }
        }
        return newStr;
    }

    public static String encryptWord(String input){
        String newStr = "";
        int l = input.length();
        int second = 1; // first character is at index 0
        int last = input.length() - 1;//since last is the length (which starts at 1) and array starts at zero
        int number = (int) input.charAt(0); // automatically switches to ASCII number
        String x = "";
        if (l == 1){ //since if theres only 1 or 2 letters theres no last one to be swapped wiht
            return newStr + (int) input.charAt(0);
        } 
        if (l == 2){
            return newStr + (int) input.charAt(0) + input.charAt(1);
        }
        for (int i = 2; i<last; i++){
            x += input.charAt(i); 
        }
        newStr = number + String.valueOf(input.charAt(last)) + x + String.valueOf(input.charAt(second));
        return newStr;
    }


    // 4. decipherThis
    public static String decipherThis(String input) {
        int l = input.length();
        int[] letters = new int[l]; //it needs to have the correct length for the array
        for (int i = 0; i<l; i++){
            char letter = input.charAt(i);
            if (letter == ' '){ //it needs to be single quotes for char
                letters[i] = 0;
            } else {
                letters[i] = 1;
            }
        }
        String newStr = "";
        int start = 0;
        int end = 0;
        for (int i = 0; i<l; i++){
            if (letters[i] == 0 || i == letters.length - 1){
                if (letters[i] == 0) { //if theres a space not the end
                    end = i;
                } else {
                    end = i + 1;
                }
                newStr = newStr + decipherWord(input.substring(start, end));
                if (i < letters.length - 1) { // to add a space when its inbetween words
                    newStr += " ";
                }
                start = i+1;
            }
        }
        return newStr;
    }

    public static String decipherWord(String input){
        String newStr = "";
        int l = input.length();
        int second = l-1; // first character is at index 0
        int asciiStart = 0;
        int asciiEnd = 0;
        for (int i = 0; i < l; i++) {
            if (!Character.isDigit(input.charAt(i))) {
                asciiEnd = i; 
                break;
            }
            asciiEnd = i + 1;  
        }
        if (asciiEnd == 0) return ""; 
        int last = asciiEnd;
        char letter = (char) Integer.parseInt(input.substring(0, asciiEnd)); //converts it to a ascii letter

        String x = "";

        if (l == asciiEnd) { //since if theres only 1 or 2 letters theres no last one to be swapped wiht
            return newStr + letter;
        } 
        if (l == asciiEnd + 1) {
            return newStr + letter + input.charAt(asciiEnd);
        }

        for (int i = asciiEnd + 1; i<l-1; i++){ //+1 so it starts after the og first letter
            x += input.charAt(i); 
        }
        newStr = "" + letter + input.charAt(second) + x + input.charAt(last); // "" is needed to force it into a string or letter and input.CharAt(second) will be treated as ints??
        return newStr;
    }



}
