import Animals.*;
import Animals.CommandsAnimal;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
/***
 * контроллер приложения
 * длтдш

 */


public class Controller {



//        Animals animals = new Animals();
        View animalView = new View();
//        ServiceAnimal serviceAnimal = new ServiceAnimal();
        ServiceDB serviceDB = new ServiceDB();

        public void start() {
                System.out.println("Загружаем данные о животных");
                try {
                        serviceDB.readAnimalToList();
                } catch (IOException e) {
                        e.printStackTrace();
                }
                System.out.println("-----------------------------");
                System.out.println("данные загружены успешно");
                String key = "";
                Scanner scanner = new Scanner(System.in);
                while (!Objects.equals(key, "7")) {
                        animalView.startMenu();
                        key = scanner.nextLine().trim();
                        switch (key) {
                                case "1" -> addAnimal();
                                case "2" -> printAnimal();
                                case "3" -> addCommandsToAnimal();
                                case "4" -> getListAnimalWithDate();
                                case "5" -> printCommandsListForId();
                                case "6" -> saveDataToFiles();
                                case "7" -> System.out.println("Программа завершена");
                                default -> System.out.println("Такой команды нет\n");
                        }
                }
        }


        public void  addAnimal() {
                Scanner scanner2 = new Scanner(System.in);
                int flag2 = 0;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu");
                while (flag2 != 1) {
                        animalView.addAnimalMenu1();
                        String key1 = scanner2.nextLine();
                        if (key1.equals("exit")) {
                                break;
                        }
                        if (!key1.matches("\\d+")) {
                                System.out.println("введите число соответствующее виду животного");
                                continue;
                        }
                        int inputAnimalType = Integer.parseInt(key1);
                        AnimalType animalType = null;
                        for (AnimalType item : AnimalType.values()) { // определяем тип животного для добавления
                                if (item.getAnimalType() == inputAnimalType) {
                                        animalType = AnimalType.setEnumType(inputAnimalType);
                                        break;
                                }
                        }
                        if (animalType == null) {
                                System.out.println("Введен неверный тип животного, повторите ввод");
                                continue;
                        }

                        animalView.addAnimalMenu2();
                        String dataAnimal = scanner2.nextLine();  // ввод даты
                        LocalDate date;
                        try {
                                date = LocalDate.parse(dataAnimal, formatter);
                        } catch (Exception e) {
                                System.out.println("Введен неверный формат даты повторите ввод");
                                continue;
                        }

                        animalView.addAnimalMenu3(); // Введите номера способностей животного через пробел
                        String commadns = scanner2.nextLine();
                        ArrayList<CommandsAnimal> commadnsList = null;
                        try {
                                commadnsList = ServiceAnimal.parseIntCommandsAnimal(commadns);
                        } catch (Exception e) {
                                System.out.println("введены неверные номера команд");
                                continue;
                        }

                        animalView.addAnimalMenu4(); // имя животного
                        String nameAnimal = scanner2.nextLine();
                        Animal current = serviceDB.getAnimals().createAnimal(nameAnimal, date, commadnsList, animalType);
                        serviceDB.getAnimals().addAnimal(current, animalType);
                        animalView.printInfo("Добавлено животное");
                        animalView.printInfo(current.toString());
                        flag2 = 1;
                }
        }


        public void printAnimal() {
                Scanner scanner3 = new Scanner(System.in);
                int flag3 = 0;
                while (flag3 != 1) {
                        animalView.PrintAnimalMemu1();
                        String key3 = scanner3.nextLine();
//                        String inputAnimalType = Integer.parseInt(key3);
                        AnimalType animalType = null;
                        if (key3.equals("0")) {
                                for (AnimalType type: AnimalType.values()) {
                                        animalView.printToConsoleAnimals(serviceDB.animals.getAnimalList(type));
                                }
                        } else {
                                switch (key3) {
                                        case "1" ->  animalView.printToConsoleAnimals(serviceDB.animals.getCatList());
                                        case "2" ->  animalView.printToConsoleAnimals(serviceDB.animals.getDogList());
                                        case "3" ->  animalView.printToConsoleAnimals(serviceDB.animals.getHamsterList());
                                        case "4" ->  animalView.printToConsoleAnimals(serviceDB.animals.getHorseList());
                                        case "5" ->  animalView.printToConsoleAnimals(serviceDB.animals.getCamelList());
                                        case "6" ->  animalView.printToConsoleAnimals(serviceDB.animals.getDonkeyList());
                                        default -> System.out.println("такого номера нет");
                                }
                        }
                        flag3 = 1;
                }
        }


        public void addCommandsToAnimal() {
                Scanner scanner4 = new Scanner(System.in);
                int flag4 = 0;
                while (flag4 != 1) {
                        animalView.addCommandsToAnimalMenu1();
                        String idStr = scanner4.nextLine();
                        if (idStr.equals("exit")) {
                                break;
                        }
                        if (!idStr.matches("\\d+")) {
                                System.out.println("введите число соответствующее id животного");
                                continue;
                        }

                        ArrayList<? extends Animal> curAnimalsList;
                        Animal curAnimal = null;
                        for (AnimalType animalType : AnimalType.values() ) {
                                 curAnimalsList = serviceDB.getAnimals().getAnimalList(animalType);
                                for (Animal item : curAnimalsList) {
                                     if (item.getId() == Integer.parseInt(idStr)) {
                                           curAnimal = item;
                                     }
                                }
                        }
                        if (curAnimal != null) animalView.printInfo(curAnimal.toString());
                        else {
                                animalView.printInfo("животное не найдено");
                                continue;
                        }

                        animalView.addCommandsToAnimalMenu2();
                        String animalCommands = scanner4.nextLine();
                        ArrayList<CommandsAnimal> commands = ServiceAnimal.parseIntCommandsAnimal(animalCommands);
                        curAnimal.setAddCommands(commands);
                        System.out.println(curAnimal);
                        flag4 = 1;
                }
        }


        public  void getListAnimalWithDate() {
                int flag5 = 0;
                Scanner scanner5 = new Scanner(System.in);
                while (flag5 != 1) {
                        animalView.getListAnimalWithDateMenu1();
                        String dateIn = scanner5.nextLine().trim();
                        if (dateIn.equals("exit")) {
                                break;
                        }
                        if (!dateIn.matches("\\d{1,}\\s\\d{4}")) {
                                System.out.println("неверный формат даты");
                                continue;
                        }
                        String[] dateInAr = dateIn.split(" ");
                        LocalDate date1 = LocalDate.of(Integer.parseInt(dateInAr[1]), Integer.parseInt(dateInAr[0]), 1);
                        LocalDate date2 = LocalDate.of(Integer.parseInt(dateInAr[1]), Integer.parseInt(dateInAr[0]),  date1.lengthOfMonth());

                        for (AnimalType type: AnimalType.values()) {
                                ArrayList<? extends Animal> curlist = serviceDB.animals.getAnimalList(type);
                                for (Animal item:curlist) {
                                        if (item.getDataBirth().isAfter(date1.minusDays(1))
                                                && item.getDataBirth().isBefore(date2.plusDays(1)))
                                                System.out.println(item);
                                }
                        }
//                        flag5 = 1;
                }
        }

        public void printCommandsListForId() {
                Scanner scanner6 = new Scanner(System.in);
                int flag6 = 0;
                while (flag6 != 1) {
                        animalView.printCommandsListForIdMenu1();
                        String idStr = scanner6.nextLine();
                        if (idStr.equals("exit")) {
                                break;
                        }
                        if (!idStr.matches("\\d+")) {
                                System.out.println("введите число соответствующее id животного");
                                continue;
                        }

                        ArrayList<? extends Animal> curAnimalsList;
                        Animal curAnimal = null;
                        for (AnimalType animalType : AnimalType.values() ) {
                                curAnimalsList = serviceDB.getAnimals().getAnimalList(animalType);
                                for (Animal item : curAnimalsList) {
                                        if (item.getId() == Integer.parseInt(idStr)) {
                                                curAnimal = item;
                                        }
                                }
                        }
                        if (curAnimal != null) animalView.printInfo(curAnimal.toString());
                        else {
                                animalView.printInfo("животное не найдено");
                                continue;
                        }
                        System.out.println("животное знает команды: ");
                        System.out.println(curAnimal.getCommands());
                }
        }

        public void saveDataToFiles() {
                serviceDB.writeAllAnimalToFiles();
                System.out.println("данные сохранены");

        }
}





