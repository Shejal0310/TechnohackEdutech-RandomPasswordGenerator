import java.util.Scanner;
import java.security.SecureRandom;
public class PasswordGenerator
{
    private static final String lowercase_characters = "abcdefghijklmnopqrstuvwxyz";
    private static final String uppercase_characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String numeric_characters = "0123456789";
    private static final String special_characters = "!@#$%^&*()_-=+<>?/";
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of password : ");
        int length = sc.nextInt();

        System.out.println("Are you want to include lowercase characters? (y/n): ");
        boolean includelower = sc.next().equalsIgnoreCase("y");

        System.out.println("Are you want to include uppercase characters? (y/n): ");
        boolean includeupper = sc.next().equalsIgnoreCase("y");

        System.out.println("Are you want to include numeric characters? (y/n): ");
        boolean includenumeric = sc.next().equalsIgnoreCase("y");

        System.out.println("Are you want to include special characters? (y/n): ");
        boolean includespecial = sc.next().equalsIgnoreCase("y");

        String password = generatePassword(length, includelower, includeupper, includenumeric, includespecial);
        System.out.println("Generated Password : "+ password);
    }

    private static <String> String generatePassword(int length, boolean includelower, boolean includeupper, boolean includenumeric, boolean includespecial)
    {
        StringBuilder character = new StringBuilder();
        if(includelower) character.append(lowercase_characters);
        if(includeupper) character.append(uppercase_characters);
        if(includenumeric) character.append(numeric_characters);
        if(includespecial) character.append(special_characters);

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for(int i = 0; i < length; i++)
        {
            int randomIndex = random.nextInt(character.length());
            password.append(character.charAt(randomIndex));
        }

        return (String) password.toString();
    }
}