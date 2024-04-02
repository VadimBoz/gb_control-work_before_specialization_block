package Animals;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Animal {
    private int id;
    private static int count = 0;
    String name;
    LocalDate dataBirth;
    ArrayList<CommandsAnimal> commands = new ArrayList<>();

    public Animal(String name, LocalDate dataBirth, ArrayList<CommandsAnimal> commands) {
        this.name = name;
        this.dataBirth = dataBirth;
        if (commands != null) this.commands  = commands;
        count++;
        id = count;

    }

    public Animal(int id, String name, LocalDate dataBirth, ArrayList<CommandsAnimal> commands) {
        this.name = name;
        this.dataBirth = dataBirth;
        this.id = id;
    }

    public Animal(String name, LocalDate dataBirth, CommandsAnimal command) {
        this.name = name;
        this.dataBirth = dataBirth;
        this.commands.add(command);
        count++;
        id = count;
    }

    public Animal(String name, LocalDate dataBirth) {
        this.name = name;
        this.dataBirth = dataBirth;
        count++;
        id = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Animal.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDataBirth() {
        return dataBirth;
    }

    public void setDataBirth(LocalDate dataBirth) {
        this.dataBirth = dataBirth;
    }

    public ArrayList<CommandsAnimal> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<CommandsAnimal> commands) {
        this.commands = commands;
    }

    public void setAddCommands(ArrayList<CommandsAnimal> commandsAdd) {
        this.commands.addAll(commandsAdd);
    }



    void AddCommand (CommandsAnimal commandsAnimal) {
        if (commandsAnimal == null ) this.commands  = new ArrayList<>();
        this.commands.add(commandsAnimal);
    }


    public Period getAge() {
        LocalDate dateNow = LocalDate.now();
        return Period.between(dataBirth, dateNow);
    }


    @Override
    public String toString() {
        return "Animals { id = " + id + ", name = " + name +
                ", dataBirth = " + dataBirth + ", commands = " + commands + '}';
    }
}
