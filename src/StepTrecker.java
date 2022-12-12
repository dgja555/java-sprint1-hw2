import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


class StepTracker {
    Converter converter = new Converter();
    Scanner scanner = new Scanner(System.in);

    HashMap<String, ArrayList<Integer>> monthOfDay;
    ArrayList<Integer> daysInMonth;
    int[] days = new int[30];

    StepTracker(String[] months) {
        monthOfDay = new HashMap<>();
        for (String month : months) {
            monthOfDay.put(month, daysInMonth);
        }
        daysInMonth = new ArrayList<>();
        for (int i : days) {
            daysInMonth.add(i);
        }
    }

    void addSteps(String month, int day, int step) {
        if (step >= 0) {
            daysInMonth.set((day - 1), step);
            monthOfDay.put(month, daysInMonth);
            System.out.println("Шаги сохранены.");
        } else {
            System.out.println("Количество шагов не может быть отрицательным.");
        }
    }

    void goStepsInDay(String month) {
        ArrayList<Integer> stepsPerDay = monthOfDay.get(month);
        for (int i = 0 ; i < stepsPerDay.size(); i++) {
            System.out.println((i + 1) + " день: " + stepsPerDay.get(i));
        }
    }

    void sumStepMonth(String month) {
        ArrayList<Integer> stepsPerDay = monthOfDay.get(month);
        int sumStepMonth = 0;
        for (Integer sumStep : stepsPerDay) {
            sumStepMonth += sumStep;
        }
        System.out.println("За месяц вы прошли "+ sumStepMonth + " шагов." );
    }

    void maxStepMonth(String month) {
        ArrayList<Integer> stepsPerDay = monthOfDay.get(month);
        int maxStepMonth = 0;
        for (Integer max : stepsPerDay) {
            if (max > maxStepMonth) {
                maxStepMonth = max;
            }
        }
        System.out.println("Максимальное количество шагов за " + month + " - "+ maxStepMonth);
    }


    void averageStepMonth(String month) {
        ArrayList<Integer> stepsPerDay = monthOfDay.get(month);
        int sumStepMonth = 0;
        for (Integer sumStep : stepsPerDay) {
            sumStepMonth += sumStep;
        }
        int averageStepMonth = sumStepMonth / stepsPerDay.size();
        System.out.println("Среднее количество шагов за " + month + " - " + averageStepMonth);
    }

    void distanceCovered(String month) {
        ArrayList<Integer> stepsPerDay = monthOfDay.get(month);
        int sumStepMonth = 0;
        for (Integer sumStep : stepsPerDay) {
            sumStepMonth += sumStep;
        }
        System.out.println("Пройденная дистанция за " + month + " - " + converter.distanceInKilometres(sumStepMonth)+ " километров");
    }

    void energySpent(String month) {
        ArrayList<Integer> stepsPerDay = monthOfDay.get(month);
        int sumStepMonth = 0;
        for (Integer sumStep : stepsPerDay) {
            sumStepMonth += sumStep;
        }
        System.out.println("Сожжено за " + month + " - " + converter.cCal(sumStepMonth)+ " килокаллорий");
    }

    void bestSeries(int ambitionStep, String month) {
        ArrayList<Integer> stepsPerDay = monthOfDay.get(month);
        ArrayList<Integer> listBestSeries = new ArrayList<>();

        int dayRow = 0;
        for (int i = 0; i < stepsPerDay.size(); i++) {
            if (stepsPerDay.get(i) >= ambitionStep) {
                if (i - (i - 1) == 1) {
                    dayRow++;
                    System.out.println("серия - " + dayRow + " дней.");
                }
            }
            listBestSeries.add(dayRow);
        }

        int bestSeries = 0;
        for (Integer row : listBestSeries) {
            if (bestSeries < row) {
                bestSeries = row;
            }

        }
        System.out.println("Целевое количество шагов" + " - " + ambitionStep);
        System.out.println("Лучшая серия - " + (bestSeries) + " дней.");
    }

    int newAmbitionStep(){
        System.out.println("Введите новое целевое значение шагов в день");

        return scanner.nextInt();
    }

}