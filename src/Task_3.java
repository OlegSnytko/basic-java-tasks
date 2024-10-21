import java.util.Random;
import java.util.Scanner;
public class Task_3 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean exit = false;

        while (!exit){
            System.out.print("1 - выход из программы\nВыберите длинну пороля (от 8 до 12 символов): ");
            String selectLength = scanner.nextLine();
            System.out.println();

            int convertedLen = Integer.parseInt(selectLength);

            if(selectLength.equals("1")){
                exit = true;
                continue;
            }
            if(convertedLen < 8 || convertedLen > 12){
                System.out.println("Неверный ввод.");
                continue;
            }

            String lowerLetters = "abcdefghijklmnopqrstuvwxyz";
            String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String numbers = "0123456789";
            String specChars = "!@#$%^&*()-_=+[]{}|;:,.<>?";
            String allCharacters = lowerLetters + upperLetters + numbers + specChars;

            StringBuilder password = new StringBuilder();
            for(int i = 0; i < convertedLen; i++){
                password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
            }

            char[] arr = password.toString().toCharArray();
            for(int i = arr.length - 1; i > 0; i--){
                int j = random.nextInt(i + 1);
                char tempChar = arr[i];
                arr[i] = arr[j];
                arr[j] = tempChar;
            }
            System.out.println("Сгенерированный пороль: " + password);
        }
        scanner.close();
    }
}





