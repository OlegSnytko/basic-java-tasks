import java.util.Scanner;
public class Task_2 {
    public static void main(String[] args){

        final double CURS_USD = 1.0;
        final double CURS_RUB = 91.75;
        final double CURS_BYN = 3.27;
        final double CURS_EUR = 0.93;
        final double CURS_BTC = 0.000015;


        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit){
            System.out.println("1)USD:\n2)RUB\n3)BYN\n4)EUR\n5)BTC\n6)Exit\n");
            System.out.println("Выбери валюту: ");
            String input = scanner.nextLine();

            if(input.equals("6")){
                exit = true;
                continue;
            }

            System.out.println("Введи количество: ");
            double amount = Double.parseDouble(scanner.nextLine());

            double[] rates = {CURS_USD, CURS_RUB, CURS_BYN, CURS_EUR, CURS_BTC};
            String[] currencies = {"USD", "RUB", "BYN", "EUR", "BTC"};
            int selectedCurrency = Integer.parseInt(input) - 1;

            if(selectedCurrency < 0 || selectedCurrency >= rates.length){
                System.out.println("Неверный ввод");
                continue;
            }

            System.out.println("Результаты конвертации:");
            for(int i = 0; i < rates.length; i++){
                if(i != selectedCurrency){
                    double convertedAmount = amount * (rates[i] / rates[selectedCurrency]);
                    System.out.printf("%s: %.3f\n", currencies[i], convertedAmount);
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}

