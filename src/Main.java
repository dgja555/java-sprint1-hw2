import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Здравствуйте. Вас приветствует счетчик шагов!");
        Scanner scanner = new Scanner(System.in);

        int ambitionStep = 10000;
        System.out.println("Ваше целевое значение шагов в день - " + ambitionStep);

        String[] months = {"Январь","Февраль","Март","Апрель","Май", "Июнь","Июль","Август","Сентябрь","Октябрь","Ноябрь","Декабрь"};

        StepTracker stepTracker = new StepTracker(months);

        while(true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                System.out.println("Выберите, за какой месяц вы хотите ввести шаги: ");
                for (int month = 0; month < months.length; month++) {
                    System.out.println((month + 1) + " - " + months[month]);
                }

                int monthInt = scanner.nextInt();
                String month = months[monthInt - 1];

                System.out.println("За какой день месяца " + month  + " вы хотите ввести шаги? Введите от 1 до 30:");
                int day = scanner.nextInt();

                System.out.println("Введите количество шагов за " + day + " день месяца " + month + ":");
                int step = scanner.nextInt();

                stepTracker.addSteps(month, day, step);

            } else if (command == 2) {
                System.out.println("Выберите, за какой месяц вы хотите получить статистику: ");
                for (int month = 0; month < months.length; month++) {
                    System.out.println((month + 1 ) +" - " + months[month]);
                }

                int monthInt = scanner.nextInt();
                String month = months[monthInt - 1];

                stepTracker.goStepsInDay(month);
                stepTracker.sumStepMonth(month);
                stepTracker.maxStepMonth(month);
                stepTracker.averageStepMonth(month);
                stepTracker.distanceCovered(month);
                stepTracker.energySpent(month);
                stepTracker.bestSeries(ambitionStep, month);

            } else if (command == 3) {

                ambitionStep = stepTracker.newAmbitionStep();

                System.out.println("Целевое количество шагов изменено.");
                System.out.println("Ваша новая цель - " + ambitionStep + " в день!");

            } else if (command == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды нет.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день месяца");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход");
    }
}