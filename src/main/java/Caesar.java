import java.util.Scanner;

public class Caesar {
    // Given a String, encrypts the String with the Caesar cipher
    // and returns the encrypted String
    // Ex. encryptCaesar("Hello, World!") => "Khoor, Zruog!"
    public static String encryptCaesar(String message) {
        String encrypted = "";
        for (int i = 0; i < message.length(); i++) {
            char new_char = message.charAt(i);
            if ((new_char < 65 || new_char > 122) || (new_char >= 91 && new_char < 97)){
                encrypted = encrypted + new_char;
            }
            else if ((new_char == 'x') || (new_char == 'y') || (new_char == 'z') || (new_char == 'X') || (new_char == 'Y') || (new_char == 'Z')){
                new_char = (char) (new_char - 23);
                encrypted = encrypted + new_char;
            }
            else {
                new_char = (char) (new_char + 3);
                encrypted = encrypted + new_char;
            }
        }

        return encrypted;
    }

    // Given a String, decrypts the String with the Caesar cipher
    // and returns the original String
    // Ex. decryptCaesar("Khoor, Zruog!") => "Hello, World!"
    public static String decryptCaesar(String message) {
        String decyrpted = "";
        for (int i = 0; i < message.length(); i++) {
            char new_char = message.charAt(i);
            if ((new_char < 65 || new_char > 122) || (new_char >= 91 && new_char < 97)){
                decyrpted = decyrpted + new_char;
            }
            else if ((new_char == 'a') || (new_char == 'b') || (new_char == 'c') || (new_char == 'A') || (new_char == 'B') || (new_char == 'C')){
                new_char = (char) (new_char + 23);
                decyrpted = decyrpted + new_char;
            }
            else {
                new_char = (char) (new_char - 3);
                decyrpted = decyrpted + new_char;
            }
        }

        return decyrpted;
    }

    // Given a String and a key corresponding to a shift, encrypts
    // the String using the given key and returns the encrypted String
    // Ex. encryptCaesarKey("Hello, World!", 5) => "Mjqqt, Btwqi!".
    public static String encryptCaesarKey(String message, int key) {
        String encrypted = "";
        for (int i = 0; i < message.length(); i++) {
            char new_char = message.charAt(i);

            if (new_char >= 0 && new_char < 65){
                encrypted = encrypted + new_char;
            }
            else if (new_char >= 91 && new_char < 97){
                encrypted = encrypted + new_char;
            }
            else if (new_char > 122){
                encrypted = encrypted + new_char;
            }
            else {
                for (int j = 1; j <= key; j++) {
                    new_char++;
                    if (new_char == (char) ((int) 'z' + 1)) {
                        new_char = 'a';
                    } else if (new_char == (char) ((int) 'Z' + 1)) {
                        new_char = 'A';
                    }

                }
                encrypted = encrypted + new_char;
            }
        }

        return encrypted;
    }

    // Given a String and a key corresponding to a shift, decrypts
    // the String using the given key and returns the original String
    // Ex. decryptCaesarKey("Mjqqt, Btwqi!", 5) => "Hello, World!"
    public static String decryptCaesarKey(String message, int key) {
        String encrypted = "";
        for (int i = 0; i < message.length(); i++) {
            char new_char = message.charAt(i);

            if (new_char >= 0 && new_char < 65){
                encrypted = encrypted + new_char;
            }
            else if (new_char >= 91 && new_char < 97){
                encrypted = encrypted + new_char;
            }
            else if (new_char > 122){
                encrypted = encrypted + new_char;
            }
            else {
                for (int j = 1; j <= key; j++) {
                    new_char--;
                    if (new_char == 64) {
                        new_char = 'Z';
                    } else if (new_char == 96) {
                        new_char = 'z';
                    }

                }
                encrypted = encrypted + new_char;
            }
        }

        return encrypted;
    }


    // The main method is already provided for you
    // You do not need to edit this code until Part 2
    public static void main(String[] args) {


        System.out.println(encryptCaesarKey("Hello, World!", 5));

        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesar(message));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesar(message));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
