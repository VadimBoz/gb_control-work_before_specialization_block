import Animals.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/***
 * bd
 * @author vadim
 */

public class ServiceDB {

    Animals animals = new Animals();
    String separator = System.getProperty("file.separator");
    File fileCats = new File(getPathDataDirectory().toAbsolutePath() + separator + "cats.srv");
    File fileDogs = new File(getPathDataDirectory().toAbsolutePath() + separator + "dogs.srv");
    File fileHamsters = new File(getPathDataDirectory().toAbsolutePath() + separator + "hamsters.srv");
    File fileHorses = new File(getPathDataDirectory().toAbsolutePath() + separator + "horses.srv");
    File fileCamels = new File(getPathDataDirectory().toAbsolutePath() + separator + "camels.srv");
    File fileDonkeys = new File(getPathDataDirectory().toAbsolutePath() + separator + "donkeys.srv");


    public Animals getAnimals() {
        return animals;
    }


    public void readAnimalToList() throws IOException {

        if (!fileCats.exists()) throw new IOException("Файл с данными cats.srv не найден");
        if (!fileDogs.exists()) throw new IOException("Файл с данными dogs.srv не найден");
        if (!fileHamsters.exists()) throw new IOException("Файл с данными hamsters.srv не найден");
        if (!fileHorses.exists()) throw new IOException("Файл с данными horses.srv не найден");
        if (!fileCamels.exists()) throw new IOException("Файл с данными camels.srv не найден");
        if (!fileDonkeys.exists()) throw new IOException("Файл с данными donkeys.srv не найден");

        readDataFromFile(fileCats, AnimalType.Cat);
        readDataFromFile(fileDogs, AnimalType.Dog);
        readDataFromFile(fileHamsters, AnimalType.Hamster);
        readDataFromFile(fileHorses, AnimalType.Camel);
        readDataFromFile(fileCamels, AnimalType.Horse);
        readDataFromFile(fileDonkeys, AnimalType.Donkey);
    }

    private void readDataFromFile(File file, AnimalType animalType) throws IOException {
            BufferedReader br = new BufferedReader(new FileReader(file));
            Animal currentAnimal = null;
            while (br.ready()) {
                String fileLine = br.readLine();
                if(fileLine.length() < 20) {
                    System.out.println("Данные в файле некорректные подозрительно короткая строка");
                    continue;
                }
                String[] ar = fileLine.split(";");
                if (ar.length < 4) throw new IllegalArgumentException("Данные в файле некорректные " + file.getName());
                if (!ar[0].matches("\\d+")) throw new IllegalArgumentException("Данные в файле некорректные (id)");
                currentAnimal = parseDataFromFileToAnimal(ar, animalType);
                    switch (animalType) {
                        case Cat -> {
                            Cat currentCat = (Cat) currentAnimal;
                            Cat.setCount(currentCat.getId());
                            animals.addAnimal(currentAnimal, AnimalType.Cat);
                        }
                        case Dog -> {
                            Dog currentDog = (Dog) currentAnimal;
                            Dog.setCount(currentDog.getId());
                            animals.getDogList().add(currentDog);
                        }
                        case Hamster -> {
                            Hamster currentHamster = (Hamster) currentAnimal;
                            Hamster.setCount(currentHamster.getId());
                            animals.getHamsterList().add(currentHamster);
                        }
                        case Camel -> {
                            Camel currentCamel = (Camel) currentAnimal;
                            Camel.setCount(currentCamel.getId());
                            animals.getCamelList().add(currentCamel);
                        }
                        case Horse -> {
                            Horse currentHorse = (Horse) currentAnimal;
                            Horse.setCount(currentHorse.getId());
                            animals.getHorseList().add(currentHorse);
                        }
                        case Donkey -> {
                            Donkey currentDonkey = (Donkey) currentAnimal;
                            Donkey.setCount(currentDonkey.getId());
                            animals.getDonkeyList().add(currentDonkey);
                        }
                        default -> System.out.println("что не так с данными в файлах");
                }
        }
        br.close();
    }

    private Animal parseDataFromFileToAnimal(String[] dataFromFile, AnimalType animalType) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu");
        LocalDate dateAnimal;
        int IdAnimal = Integer.parseInt(dataFromFile[0]);
        String animalName = dataFromFile[1];
        try {
            dateAnimal = LocalDate.parse(dataFromFile[3], formatter);
        } catch (DateTimeParseException e) {
            System.out.println("неверный формат даты в файле" + animalType.name());
            dateAnimal = LocalDate.now();
        }

        ArrayList<CommandsAnimal> commadnsList = null;
        if (dataFromFile.length > 4) {
            try {
                commadnsList = ServiceAnimal.parseStrCommandsAnimal(dataFromFile[4]);
            } catch (Exception e) {
                System.out.println("неверный формат команд животного");
            }
        }
        switch (animalType) {
            case Cat -> {
                return new Cat(animalName, dateAnimal, commadnsList);
            }
            case Dog -> {
                return new Dog(animalName, dateAnimal, commadnsList);
            }
            case Hamster -> {
                return new Hamster(animalName, dateAnimal, commadnsList);
            }
            case Camel -> {
                return new Camel(animalName, dateAnimal, commadnsList);
            }
            case Horse -> {
                return new Horse(animalName, dateAnimal, commadnsList);
            }
            case Donkey -> {
                return new Donkey(animalName, dateAnimal, commadnsList);
            }
            default -> {
                return null;
            }
        }
    }


    public Path getPathDataDirectory() {
        Path homeDir = Path.of(System.getProperty("user.dir"));
//        System.out.println(homeDir);
        String separator = System.getProperty("file.separator");
        Path defaultDir = Path.of(homeDir.toAbsolutePath() + separator +
                "gb_control-work_before_specialization_block" + separator +
                "frends" + separator +
                "src" + separator +
                "data" + separator);
        System.out.println(defaultDir);
        if (Files.exists(defaultDir)) {
            System.out.println("папка по умолчанию c БД найдена " + defaultDir.toAbsolutePath());
        } else {

            System.out.println("папка по умолчанию c БД не найдена, создаем новую");
            try {
                Files.createDirectories(defaultDir);
                System.out.println("папка создана");
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }

        }
        return defaultDir;
    }

    public <T extends Animal> void writeListToFile(File file, ArrayList<T> listAnimal, AnimalType animalType) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            for (Animal item: listAnimal) {
                String comandsRes = "";
                for (CommandsAnimal comand: item.getCommands()) {
                    comandsRes = comandsRes + comand.name() + "-";
                }
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu");
                comandsRes = comandsRes.substring(0, comandsRes.length()-1);
                String line = item.getId() + ";" + item.getName() + ";" +
                        animalType.name() + ";" + formatter.format(item.getDataBirth()) + ";" + comandsRes + "\n";
                bw.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void writeAllAnimalToFiles() {
        try {
            writeListToFile(fileCats, animals.getCatList(), AnimalType.Cat);
            writeListToFile(fileDogs, animals.getDogList(), AnimalType.Dog);
            writeListToFile(fileHamsters, animals.getHamsterList(), AnimalType.Hamster);
            writeListToFile(fileHorses, animals.getHorseList(), AnimalType.Horse);
            writeListToFile(fileCamels, animals.getCamelList(), AnimalType.Camel);
            writeListToFile(fileDonkeys, animals.getDonkeyList(), AnimalType.Donkey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
