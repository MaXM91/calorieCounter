        import java.util.Scanner;

        public class Main {
            public static void main(String[] args) {
                StepTracker StepTracker = new StepTracker();
                insertData insertData = new insertData();
                Scanner scanner = new Scanner(System.in);
                printMenu();
                int userInput = scanner.nextInt();

                while (userInput != 0) {                                       //Основное меню
                    if(userInput == 1) {
                        System.out.println("За какой месяц желаете изменить кол-во? (1-12)");
                        userInput = scanner.nextInt();
                           int month = insertData.insertMonth(userInput);
                        System.out.println("За какой день месяца желаете изменить кол-во?(1-30");
                        userInput = scanner.nextInt();
                           int day = insertData.insertDay(userInput);
                        System.out.println("На какое значение желаете изменить кол-во?");
                        userInput = scanner.nextInt();
                           int numberSteps = insertData.insertSteps(userInput);
                        StepTracker.takeSteps( month, day, numberSteps);
                           System.out.println("Данные успешно сохранены!");
                        printMenu();
                        userInput = scanner.nextInt();
                    } else if (userInput == 2) {
                        StepTracker.statistic();
                        System.out.println();
                        printMenu();
                        userInput = scanner.nextInt();
                    } else if (userInput == 3) {
                            System.out.println("За какой месяц желаете изменить цель? (1-12)");
                               userInput = scanner.nextInt();
                               int month = insertData.insertMonth(userInput);
                            System.out.println("За какой день месяца желаете изменить цель? (1-30");
                               userInput = scanner.nextInt();
                               int day = insertData.insertDay(userInput);
                            System.out.println("На какое значение желаете изменить цель?");
                               userInput = scanner.nextInt();
                               int numberSteps = insertData.insertSteps(userInput);
                        StepTracker.planSteps( month,  day,  numberSteps);
                               System.out.println("Данные успешно сохранены!");
                        printMenu();
                        userInput = scanner.nextInt();
                    } else {
                        System.out.println("Вы неправильно ввели команду!");
                        printMenu();
                        userInput = scanner.nextInt();
                    }

                }
                System.out.println("Программа завершена");
            }

            private static void printMenu() {
                System.out.println("Что Вы хотите сделать ? (Введите команду 0-3)");
                System.out.println("1 - Ввести количество шагов за определённый день");
                System.out.println("2 - Напечатать статистику за определённый месяц");
                System.out.println("3 - Изменить цель по количеству шагов в день");
                System.out.println("0 - Выйти из приложения");
            }



        }

        class insertData{                                                      // Проверка вводимых данных на ограничение диапазона ввода
            Scanner scanner = new Scanner(System.in);
            int insertMonth(int userInput){
                while(userInput < 1 || userInput > 12){
                    System.out.println("Неправильно указано значение! Укажите нужный месяц. (1-12)");
                    userInput = scanner.nextInt();
                }
                return userInput;
            }
            int insertDay(int userInput){
                while(userInput < 1 || userInput > 30){
                    System.out.println("Неправильно указано значение! Укажите нужную дату. (1-30)");
                    userInput = scanner.nextInt();
                }
                return userInput;
            }

           int insertSteps(int userInput){
               while(userInput < 0){
                   System.out.println("Неправильно указано значение! Укажите кол-во шагов. (>0)");
                   userInput = scanner.nextInt();
               }
               return userInput;
            }
        }

        class StepTracker {                                                    // Инициация хранилица методом создания обьектов.
            Converter Converter = new Converter();                             // 1 класс - массив 12 месяцев, по ячейке на месяц
            MonthData[] monthToData;                                           // 2 класс - 2 массива хранения по ячейкам массива месяцев


            public StepTracker() {                                             // Главный обработчик
                monthToData = new MonthData[12];
                for (int i = 0; i < monthToData.length; i++) {
                    monthToData[i] = new MonthData();
                }
            }

            void planSteps(int month, int day, int numberSteps){               // Изменение планируемых шагов

               monthToData[month-1].saveStepsPlan[day-1] = numberSteps;

            }
            void takeSteps(int month, int day, int numberSteps){               // Изменение сделанных шагов

                monthToData[month-1].saveStepsTake[day-1] = numberSteps;

            }

            void statistic(){                                                  // Меню статистики

                Scanner scanner = new Scanner(System.in);
                insertData insertData = new insertData();

                printMenuStatistic();
                int userInput = scanner.nextInt();

                while (userInput != 0) {
                if (userInput == 1) {
                    System.out.println("За какой месяц желаете получить данные? (1-12)");
                    userInput = scanner.nextInt();
                    int month = insertData.insertMonth(userInput);
                    MenuNumber1(month);
                    printMenuStatistic();
                    userInput = scanner.nextInt();
                } else if (userInput == 2) {
                    System.out.println("За какой месяц желаете получить данные? (1-12)");
                    userInput = scanner.nextInt();
                    int month = insertData.insertMonth(userInput);
                    MenuNumber2(month);
                    printMenuStatistic();
                    userInput = scanner.nextInt();
                } else if (userInput == 3) {
                    System.out.println("За какой месяц желаете получить данные? (1-12)");
                    userInput = scanner.nextInt();
                    int month = insertData.insertMonth(userInput);
                    MenuNumber3(month);
                    printMenuStatistic();
                    userInput = scanner.nextInt();
                } else if (userInput == 4) {
                    System.out.println("За какой месяц желаете получить данные? (1-12)");
                    userInput = scanner.nextInt();
                    int month = insertData.insertMonth(userInput);
                    MenuNumber4(month);
                    printMenuStatistic();
                    userInput = scanner.nextInt();
                } else if (userInput == 5) {
                    System.out.println("За какой месяц желаете получить данные? (1-12)");
                    userInput = scanner.nextInt();
                    int month = insertData.insertMonth(userInput);
                    MenuNumber5(month);
                    printMenuStatistic();
                    userInput = scanner.nextInt();
                } else if (userInput == 6) {
                    System.out.println("За какой месяц желаете получить данные? (1-12)");
                    userInput = scanner.nextInt();
                    int month = insertData.insertMonth(userInput);
                    MenuNumber6(month);
                    printMenuStatistic();
                    userInput = scanner.nextInt();
                } else if (userInput == 7) {
                    System.out.println("За какой месяц желаете получить данные? (1-12)");
                    userInput = scanner.nextInt();
                    int month = insertData.insertMonth(userInput);
                    MenuNumber7(month);
                    printMenuStatistic();
                    userInput = scanner.nextInt();
                } else if (userInput == 8) {
                    System.out.println("За какой месяц желаете получить данные? (1-12)");
                    userInput = scanner.nextInt();
                    int month = insertData.insertMonth(userInput);
                    MenuNumber8(month);
                    printMenuStatistic();
                    userInput = scanner.nextInt();
                } else {
                    System.out.println("Вы неправильно ввели команду!");
                    printMenuStatistic();
                    userInput = scanner.nextInt();
                }
                }
            }
            void MenuNumber1(int month) {

                for (int i = 0; i < 30; i++) {
                    System.out.print((i + 1) + " День: " + monthToData[month - 1].saveStepsTake[i]+ ", ");
                }
                System.out.println();
            }

            void MenuNumber2(int month) {

                for (int i = 0; i < 30; i++) {
                    System.out.print((i + 1) + " День: " + monthToData[month - 1].saveStepsPlan[i]+ ", ");
                }
                System.out.println();
            }

            void MenuNumber3(int month) {
                int theAmount = 0;
                for (int i = 0; i < 30; i++){
                    theAmount = theAmount + monthToData[month - 1].saveStepsTake[i];
                }
                System.out.println(theAmount);
            }

            void MenuNumber4(int month) {
                int theAmount = 0;
                for (int i = 0; i < 30; i++){
                    if(theAmount < monthToData[month - 1].saveStepsTake[i])
                        theAmount = monthToData[month - 1].saveStepsTake[i];
                }
                System.out.println("Максимальное кол-во шагов в указанном месяце: " + theAmount);
            }

            void MenuNumber5(int month) {
                int theAmount = 0;
                for (int i = 0; i < 30; i++){
                    theAmount = theAmount + monthToData[month - 1].saveStepsTake[i];
                }
                System.out.println("Среднее кол-во шагов в указанном месяце: " + theAmount/30);
            }

            void MenuNumber6(int month) {
                int theAmount = 0;
                for (int i = 0; i < 30; i++){
                    theAmount = theAmount+ monthToData[month - 1].saveStepsTake[i];
                }
                Converter.converterDistance(theAmount);

            }

            void MenuNumber7(int month) {
                int theAmount = 0;
                for (int i = 0; i < 30; i++){
                    theAmount = theAmount + monthToData[month - 1].saveStepsTake[i];
                }
                Converter.converterCalorie(theAmount);

            }
            void MenuNumber8(int month) {
                int maxStepUp = 0;
                int j = 0;
                for (int i = 0; i < monthToData[month-1].saveStepsTake.length; i++){
                    if(monthToData[month-1].saveStepsTake[i] >= monthToData[month - 1].saveStepsPlan[i]){
                        j++;
                        if(maxStepUp < j){
                            maxStepUp = j;
                        }
                    }
                    else {
                      j = 0;
                    }
                }
                System.out.println("Лучшая серия состоит из " + maxStepUp + " дней.");
            }


            private static void printMenuStatistic() {
                System.out.println("Какие данные за указанный месяц вывести на экран? (Введите команду 0-3)");
                System.out.println("1 - Кол-во шагов по дням.");
                System.out.println("2 - Запланированное кол-во шагов по дням.");
                System.out.println("3 - Общее кол-во шагов.");
                System.out.println("4 - Максимальное кол-во шагов.");
                System.out.println("5 - Среднее кол-во шагов.");
                System.out.println("6 - Пройденная дистанция.");
                System.out.println("7 - Кол-во сожженных калорий.");
                System.out.println("8 - Лучшая серия.");
                System.out.println("0 - Вернутся в главное меню.");
            }



        }

                 class MonthData {                                             // Создаем массивы для данных дня
                      int numberSteps = 10000;                                 // через массивы отвечающие за месяцы
                      int[] saveStepsPlan;
                      int[] saveStepsTake;

                         public MonthData() {
                               saveStepsPlan = new int[30];
                               saveStepsTake = new int[30];
                               for(int i = 0; i < saveStepsPlan.length; i++ ){
                                   saveStepsPlan[i] = numberSteps;
                                   saveStepsTake[i] = 0;

                               }
                             }
                 }







       class Converter {                                                       // Конвертируем введенные данные
              void converterDistance(int theAmount) {  //1 шаг = 0.75м 1км = 1000 м

                  System.out.println("Пройдено " + (theAmount / 0.75 /1000) + " км.");

              }

              void converterCalorie(int theAmount) { // 1 шаг 50 кал, 1 ккал 1000 кал

                  System.out.println("Сожжено " + (theAmount * 50 / 1000) + " ккал.");

              }

        }

