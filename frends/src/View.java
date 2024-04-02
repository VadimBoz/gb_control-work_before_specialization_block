import Animals.Animal;
import Animals.AnimalType;
import Animals.CommandsAnimal;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class View {

    public <T extends Animal> void printToConsoleAnimals(ArrayList<T> listAnimal) {
        System.out.println(listAnimal);
        System.out.println("------------------------------------------------------------------------");
    }

    public void startMenu() {
        System.out.println();
        System.out.println("---------  Программа Реестр животных   ---------------");
        System.out.println();
        System.out.println("""  
                     1. Добавить животное
                     2. Вывести список животных по типу
                     3. Добавить новую команду для животного
                     4. Вывести список животных по дате рождения
                     5. Вывести список команд животного
                     6. Сохранить данные на диск
                     7. Выйти из программы
                     
                     Введите пункт меню >
                """);
    }


    public void addAnimalMenu1() {
        System.out.println();
        System.out.println("Быберете номер типа животного (число):");
        System.out.println(AnimalType.AnimalTypeTostring());
    }
    public void addAnimalMenu2() {
        System.out.println("Введите дату рождения животного в фомате DD-MM-YYYY");
    }

    public void addAnimalMenu3() {
        System.out.println();
        System.out.println("Введите номера команд животного, которые оно знает через пробел");
        System.out.println(CommandsAnimal.аnimalCommandsTostring());
    }

    public void addAnimalMenu4() {
        System.out.println("Введите имя животного");
    }


    public void printInfo(String str) {
        System.out.println(str);
    }


    public void PrintAnimalMemu1() {
        System.out.println("Введите номер типа животного или '0' для печати животных всех типов");
        System.out.println(AnimalType.AnimalTypeTostring());
        System.out.println();
    }


    public <T extends Animal> void printToConsoleAnimalList(ArrayList<T> animalList) {
        System.out.println("__________________________________");
        System.out.println(animalList);
        System.out.println("__________________________________");
    }


    public void addCommandsToAnimalMenu1() {
        System.out.println("Введите ID животного ");

    }

    public void addCommandsToAnimalMenu2() {
        System.out.println("Номера команд для добавления к выбранному животному");
        System.out.println(CommandsAnimal.аnimalCommandsTostring());

    }

    public  void getListAnimalWithDateMenu1() {
        System.out.println("Введите месяц и год через пробел формате мм ГГГГ или exit (01 2020)");

    }

    public void printCommandsListForIdMenu1() {
        System.out.println("Введите ID животного или exit");
    }

}



