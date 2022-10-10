        import java.util.Scanner;

        public class Main {


            public static void main(String[] args) {
                StepTracker StepTracker = new StepTracker();
                int userInput;

                while ((userInput = InOutData.printMenu()) != 0) {                       //Основное меню
                           if (userInput == 1) {
                          StepTracker.takeSteps();
                    } else if (userInput == 2) {
                          StepTracker.statistic();
                    } else if (userInput == 3) {
                          StepTracker.planSteps();
                    } else {
                            System.out.println("Вы неправильно ввели команду!");
                    }

                }
                System.out.println("Программа завершена.");
            }


        }



        class StepTracker {                                                    // Инициация хранилица методом создания обьектов.
            InOutData insertData = new InOutData();                          // 1 класс - массив 12 месяцев, по ячейке на месяц
                                                                               // 2 класс - 2 массива хранения по ячейкам массива месяцев
            int userInput;
            Converter Converter = new Converter();
            MonthData[] monthToData;

            int planSteps = 10000;

            public StepTracker() {                                             // Главный обработчик

                monthToData = new MonthData[12];
                for (int i = 0; i < monthToData.length; i++) {
                    monthToData[i] = new MonthData();
                }
            }

            void planSteps(){                                                  // Изменение планируемых шагов

                System.out.println("На какое значение желаете изменить кол-во?");
                planSteps = insertData.insertSteps();
                System.out.println("Данные успешно сохранены!");

            }
            void takeSteps(){                                                  // Изменение сделанных шагов

                System.out.println("За какой месяц желаете ввести данные? (1-12)");
                int month = insertData.insertMonth();
                System.out.println("За какой день месяца желаете ввести данные? (1-30");
                int day = insertData.insertDay();
                System.out.println("Какое значение ввода?");
                int numberSteps = insertData.insertSteps();

                monthToData[month-1].saveStepsTake[day-1] = numberSteps;

            }

            void statistic(){                                                  // Меню статистики

                while ((userInput = InOutData.printMenuStatistic()) != 0) {
                       if (userInput == 1) {
                          menuNumber1();
                       } else if (userInput == 2) {
                          menuNumber2();
                       } else if (userInput == 3) {
                          menuNumber3();
                      } else if (userInput == 4) {
                          menuNumber4();
                      } else if (userInput == 5) {
                          menuNumber5();
                      } else if (userInput == 6) {
                          menuNumber6();
                      } else if (userInput == 7) {
                          menuNumber7();
                      } else if (userInput == 8) {
                          menuNumber8();
                      } else {
                          System.out.println("Вы неправильно ввели команду!");
                      }
                }
            }
            void menuNumber1() {

                System.out.println("За какой месяц желаете получить данные? (1-12)");
                int month = insertData.insertMonth();

                for (int i = 0; i < monthToData[month - 1].saveStepsTake.length; i++) {
                    if (i < (monthToData[month - 1].saveStepsTake.length - 1))
                        System.out.print((i + 1) + " День: " + monthToData[month - 1].saveStepsTake[i] + ", ");
                    else
                        System.out.println((i + 1) + " День: " + monthToData[month - 1].saveStepsTake[i] + ".");
                }
            }
            void menuNumber2() {

                System.out.println("Запланированное кол-во шагов: " + planSteps);
            }

            void menuNumber3() {

                System.out.println("За какой месяц желаете получить данные? (1-12)");
                int month = insertData.insertMonth();

                int theAmount = 0;
                for (int i = 0; i < 30; i++){
                    theAmount = theAmount + monthToData[month - 1].saveStepsTake[i];
                }
                System.out.println(theAmount);
            }

            void menuNumber4() {
                System.out.println("За какой месяц желаете получить данные? (1-12)");
                int month = insertData.insertMonth();

                int theAmount = 0;
                for (int i = 0; i < 30; i++){
                    if(theAmount < monthToData[month - 1].saveStepsTake[i])
                        theAmount = monthToData[month - 1].saveStepsTake[i];
                }
                System.out.println("Максимальное кол-во шагов в указанном месяце: " + theAmount);
            }

            void menuNumber5() {
                System.out.println("За какой месяц желаете получить данные? (1-12)");
                int month = insertData.insertMonth();

                int theAmount = 0;
                for (int i = 0; i < 30; i++){
                    theAmount = theAmount + monthToData[month - 1].saveStepsTake[i];
                }
                System.out.println("Среднее кол-во шагов в указанном месяце: " + theAmount/30);
            }

            void menuNumber6() {
                System.out.println("За какой месяц желаете получить данные? (1-12)");
                int month = insertData.insertMonth();

                int theAmount = 0;
                for (int i = 0; i < 30; i++){
                    theAmount = theAmount+ monthToData[month - 1].saveStepsTake[i];
                }
                Converter.converterDistance(theAmount);

            }

            void menuNumber7() {
                System.out.println("За какой месяц желаете получить данные? (1-12)");
                int month = insertData.insertMonth();

                int theAmount = 0;
                for (int i = 0; i < 30; i++){
                    theAmount = theAmount + monthToData[month - 1].saveStepsTake[i];
                }
                Converter.converterCalorie(theAmount);

            }
            void menuNumber8() {
                System.out.println("За какой месяц желаете получить данные? (1-12)");
                int month = insertData.insertMonth();

                int maxStepUp = 0;
                int j = 0;
                for (int i = 0; i < monthToData[month-1].saveStepsTake.length; i++){
                    if(monthToData[month-1].saveStepsTake[i] >= planSteps){
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



        }

                 class MonthData {                                             // Создаем массив для данных дня

                      int[] saveStepsTake;


                         public MonthData() {
                               saveStepsTake = new int[30];
                               for(int i = 0; i < saveStepsTake.length; i++ ){
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


        class InOutData{                                                      // Проверка вводимых данных на ограничение диапазона ввода
            static Scanner scanner = new Scanner(System.in);
            int insertMonth(){
                int userInput = scanner.nextInt();
                while(userInput < 1 || userInput > 12){
                    System.out.println("Неправильно указано значение! Укажите нужный месяц. (1-12)");
                    userInput = scanner.nextInt();
                }
                return userInput;
            }
            int insertDay(){
                int userInput = scanner.nextInt();
                while(userInput < 1 || userInput > 30){
                    System.out.println("Неправильно указано значение! Укажите нужную дату. (1-30)");
                    userInput = scanner.nextInt();
                }
                return userInput;
            }

            int insertSteps(){
                int userInput = scanner.nextInt();
                while(userInput < 0){
                    System.out.println("Неправильно указано значение! Укажите кол-во шагов. (>0)");
                    userInput = scanner.nextInt();
                }
                return userInput;
            }
            static int printMenu() {

                System.out.println("Что Вы хотите сделать ? (Введите команду 0-3)");
                System.out.println("1 - Ввести количество шагов за определённый день.");
                System.out.println("2 - Напечатать статистику за определённый месяц.");
                System.out.println("3 - Изменить цель по количеству шагов в день.");
                System.out.println("0 - Выйти из приложения.");

                return scanner.nextInt();
            }

            static int printMenuStatistic() {

                System.out.println("Какие данные за указанный месяц вывести на экран? (Введите команду 0-8)");
                System.out.println("1 - Кол-во шагов по дням.");
                System.out.println("2 - Запланированное кол-во шагов по дням.");
                System.out.println("3 - Общее кол-во шагов.");
                System.out.println("4 - Максимальное кол-во шагов.");
                System.out.println("5 - Среднее кол-во шагов.");
                System.out.println("6 - Пройденная дистанция.");
                System.out.println("7 - Кол-во сожженных калорий.");
                System.out.println("8 - Лучшая серия.");
                System.out.println("0 - Вернутся в главное меню.");

                return scanner.nextInt();
            }
        }
