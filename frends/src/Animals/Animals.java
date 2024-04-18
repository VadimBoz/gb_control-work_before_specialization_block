package Animals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

/***
 * коллекции животных
 */

public class Animals {
    ArrayList<Cat> catList = new ArrayList<>();
    ArrayList<Dog> dogList = new ArrayList<>();
    ArrayList<Hamster> hamsterList = new ArrayList<>();
    ArrayList<Camel> camelList = new ArrayList<>();
    ArrayList<Donkey> donkeyList = new ArrayList<>();
    ArrayList<Horse> horseList = new ArrayList<>();






    public void addAnimal(String name, LocalDate dataBirth, ArrayList<CommandsAnimal> commands, AnimalType animalType) {
        switch (animalType) {
            case Cat -> catList.add(new Cat(name, dataBirth, commands));
            case Dog -> dogList.add(new Dog(name, dataBirth, commands));
            case Hamster -> hamsterList.add(new Hamster(name, dataBirth, commands));
            case Camel -> camelList.add(new Camel(name, dataBirth, commands));
            case Donkey -> donkeyList.add(new Donkey(name, dataBirth, commands));
            case Horse -> horseList.add(new Horse(name, dataBirth, commands));
        }
    }

    /***
     * добавление животного
     * @param animal
     * @param animalType
     */
    public void addAnimal(Animal animal, AnimalType animalType) {
        switch (animalType) {
            case Cat -> catList.add((Cat) animal);
            case Dog -> dogList.add((Dog) animal);
            case Hamster -> hamsterList.add((Hamster) animal);
            case Camel -> camelList.add((Camel) animal);
            case Donkey -> donkeyList.add((Donkey) animal);
            case Horse -> horseList.add((Horse) animal);
        }
    }


    /***
     * добавление животного
     * @param name
     * @param animalType
     * @param dataBirth
     * @param  commands
     */
    public Animal createAnimal (String name, LocalDate dataBirth, ArrayList<CommandsAnimal> commands, AnimalType animalType) {
        switch (animalType) {
            case Cat -> {return new Cat(name, dataBirth, commands);}
            case Dog -> {return new Dog(name, dataBirth, commands);}
            case Hamster -> {return new Hamster(name, dataBirth, commands);}
            case Camel -> {return new Camel(name, dataBirth, commands);}
            case Donkey -> {return new Donkey(name, dataBirth, commands);}
            case Horse -> {return new Horse(name, dataBirth, commands);}
        }
        return null;
    }


    public void addCommandToAnimal(int animalId, AnimalType animalType, CommandsAnimal commandsAnimal) {
        switch (animalType) {
            case Cat -> setNewCommand(catList, animalId, animalType, commandsAnimal);
            case Dog -> setNewCommand(dogList, animalId, animalType, commandsAnimal);
            case Hamster -> setNewCommand(hamsterList, animalId, animalType, commandsAnimal);
            case Camel -> setNewCommand(camelList, animalId, animalType, commandsAnimal);
            case Donkey -> setNewCommand(donkeyList, animalId, animalType, commandsAnimal);
            case Horse -> setNewCommand(horseList, animalId, animalType, commandsAnimal);
        }
    }


    private  <T extends Animal>  void setNewCommand(ArrayList<T> animalList, int animalId, AnimalType animalType, CommandsAnimal commandsAnimal) {
        for (T temp: animalList) {
            if (temp.getId() == animalId) temp.getCommands().add(commandsAnimal);
        }
    }


    public  ArrayList<? extends Animal> getAnimalList(AnimalType animalType) {
        switch (animalType) {
            case Cat -> { return catList; }
            case Dog -> { return dogList; }
            case Hamster -> { return hamsterList; }
            case Camel -> { return camelList; }
            case Donkey -> { return donkeyList; }
            case Horse -> { return horseList; }
        }
        return new ArrayList<>();
    }


    public void removeAllAnimal(AnimalType animalType) {
        switch (animalType) {
            case Cat -> catList = new ArrayList<>();
            case Dog -> dogList = new ArrayList<>();
            case Hamster -> hamsterList = new ArrayList<>();
            case Camel -> camelList = new ArrayList<>();
            case Donkey -> donkeyList = new ArrayList<>();
            case Horse -> horseList = new ArrayList<>();
        }
    }


    public void removeAnimal(int animalId, AnimalType animalType) {
        switch (animalType) {
            case Cat -> catList = catList.stream().filter(u -> u.getId() != animalId).
                    collect(Collectors.toCollection(ArrayList::new));
            case Dog -> dogList = dogList.stream().filter(u -> u.getId() != animalId).
                    collect(Collectors.toCollection(ArrayList::new));
            case Hamster -> hamsterList = hamsterList.stream().filter(u -> u.getId() != animalId).
                    collect(Collectors.toCollection(ArrayList::new));
            case Camel -> camelList = camelList.stream().filter(u -> u.getId() != animalId).
                    collect(Collectors.toCollection(ArrayList::new));
            case Donkey -> donkeyList = donkeyList.stream().filter(u -> u.getId() != animalId).
                    collect(Collectors.toCollection(ArrayList::new));
            case Horse -> horseList = horseList.stream().filter(u -> u.getId() != animalId).
                    collect(Collectors.toCollection(ArrayList::new));
        }
    }


    public ArrayList<Cat> getCatList() {
        return catList;
    }

    public void setCatList(ArrayList<Cat> catList) {
        this.catList = catList;
    }

    public ArrayList<Dog> getDogList() {
        return dogList;
    }

    public void setDogList(ArrayList<Dog> dogList) {
        this.dogList = dogList;
    }

    public ArrayList<Hamster> getHamsterList() {
        return hamsterList;
    }

    public void setHamsterList(ArrayList<Hamster> hamsterList) {
        this.hamsterList = hamsterList;
    }

    public ArrayList<Camel> getCamelList() {
        return camelList;
    }

    public void setCamelList(ArrayList<Camel> camelList) {
        this.camelList = camelList;
    }

    public ArrayList<Donkey> getDonkeyList() {
        return donkeyList;
    }

    public void setDonkeyList(ArrayList<Donkey> donkeyList) {
        this.donkeyList = donkeyList;
    }

    public ArrayList<Horse> getHorseList() {
        return horseList;
    }

    public void setHorseList(ArrayList<Horse> horseList) {
        this.horseList = horseList;
    }
}
