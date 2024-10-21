import java.util.Scanner;
import java.util.Random;

public class Task_1 {
    public static void main(String[] args) {

        String[] array = {"ksenia", "oleg", "egor", "dima", "pavel"};
        Random rand = new Random();

        String selectedWord = array[rand.nextInt(array.length)];
        System.out.println("Выбранное слово: " + selectedWord);

        StringBuilder hiddenWord = new StringBuilder("*".repeat(selectedWord.length()));
        System.out.println("Зашифрованное слово: " + hiddenWord);

        int lives = 6;
        Scanner scanner = new Scanner(System.in);

        while (lives > 0 && !hiddenWord.toString().equals(selectedWord)){
            System.out.print("Введите букву (осталось всего попыток:" + lives + "): ");
            String symbol = scanner.nextLine().toLowerCase();

            if(symbol.length() != 1){
                System.out.println("Введи одну букву.");
                continue;
            }

            char guessedLetter = symbol.charAt(0);
            boolean foundedLetter = false;

            for(int i = 0; i < selectedWord.length(); i++){
                if(guessedLetter == selectedWord.charAt(i)){
                    hiddenWord.setCharAt(i, guessedLetter);
                    foundedLetter = true;
                }
            }

            if(foundedLetter){
                System.out.println("Верно: " + hiddenWord);
            }else{
                System.out.println("Неверно, вводи заново.");
                lives--;
            }
        }
        if(lives == 0){
            System.out.println("Вы не угадали слово:( Было загадано слово: " + selectedWord);
        }if(lives > 0){
            System.out.println("Вы выиграли:)" + selectedWord);
        }
        scanner.close();

    }
}
