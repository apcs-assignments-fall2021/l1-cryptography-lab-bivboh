import java.util.Scanner;

public class Vigenere {
    public static char encryptCaesarLetter(char ch, int key) {
            if (ch >= 0 && ch < 65){
                ch = ch;
            }
            else if (ch >= 91 && ch < 97){
                ch = ch;
            }
            else if (ch > 122){
                ch = ch;
            }
            else {
                for (int j = 1; j <= key; j++) {
                    ch++;
                    if (ch == (char) ((int) 'z' + 1)) {
                        ch = 'a';
                    } else if (ch == (char) ((int) 'Z' + 1)) {
                        ch = 'A';
                    }

                }
            }
        return ch;
    }

    public static char decryptCaesarLetter(char ch, int key) {
            if (ch >= 0 && ch < 65){
                ch = ch;
            }
            else if (ch >= 91 && ch < 97){
                ch = ch;
            }
            else if (ch > 122){
                ch = ch;
            }
            else {
                for (int j = 1; j <= key; j++) {
                    ch--;
                    if (ch == 64) {
                        ch = 'Z';
                    } else if (ch == 96) {
                        ch = 'z';
                    }

                }
            }

        return ch;
    }

    public static String encryptVigenere(String message, String key) {
        int key_index = 0;
        String new_message = "";
        for (int i = 0; i < message.length(); i++) {
            char new_char = message.charAt(i);
            char key_char = key.charAt(key_index);
            int shift = key_char - 'A';
            if ((new_char < 'A' || new_char > 'z') || (new_char > 'Z' && new_char < 'a')){
                key_index = key_index;
            }
            else {
                key_index ++;
            }
            if (key_index == key.length()){
                key_index = 0;
            }
            new_message = new_message + encryptCaesarLetter(new_char, shift);

        }
        return new_message;
        // REPLACE THIS WITH YOUR CODE
    }

    public static String decryptVigenere(String message, String key) {
        int key_index = 0;
        String new_message = "";
        for (int i = 0; i < message.length(); i++) {
            char new_char = message.charAt(i);
            char key_char = key.charAt(key_index);
            int shift = key_char - 'A';
            if ((new_char < 'A' || new_char > 'z') || (new_char > 'Z' && new_char < 'a')){
                key_index = key_index;
            }
            else {
                key_index ++;
            }
            if (key_index == key.length()){
                key_index = 0;
            }
            new_message = new_message + decryptCaesarLetter(new_char, shift);

        }
        return new_message;

    }


    public static void main(String[] args) {
        System.out.println("Encrypting 'a' by 5 should give 'f', and got: " + encryptCaesarLetter('a', 5));
        System.out.println("Encrypting 'y' by 8 should give 'g', and got: " + encryptCaesarLetter('y', 8));
        System.out.println("Encrypting 'A' by 4 should give 'E', and got: " + encryptCaesarLetter('A', 4));
        System.out.println("Encrypting 'Z' by 3 should give 'C', and got: " + encryptCaesarLetter('Z', 3));
        System.out.println("Encrypting '#' by 5 should give '#', and got: " + encryptCaesarLetter('#', 5));
        System.out.println();
        System.out.println("Decrypting 'f' by 5 should give 'a', and got: " + decryptCaesarLetter('f', 5));
        System.out.println("Decrypting 'g' by 8 should give 'y', and got: " + decryptCaesarLetter('g', 8));
        System.out.println("Decrypting 'E' by 4 should give 'A', and got: " + decryptCaesarLetter('E', 4));
        System.out.println("Decrypting 'C' by 3 should give 'Z', and got: " + decryptCaesarLetter('C', 3));
        System.out.println("Decrypting '#' by 5 should give '#', and got: " + decryptCaesarLetter('#', 5));

        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
