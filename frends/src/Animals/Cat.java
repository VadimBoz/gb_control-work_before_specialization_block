package Animals;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cat extends Pet {


    public Cat(String name, LocalDate dataBirth, ArrayList<CommandsAnimal> commands) {
        super(name, dataBirth, commands);
    }

    public Cat(String name, LocalDate dataBirth) {
        super(name, dataBirth);
    }

    public Cat(String name, LocalDate dataBirth, CommandsAnimal command) {
        super(name, dataBirth, command);
    }

    @Override
    public String toString() {
        return "\nCat {id = " + super.getId() + ", name = " + name +
                ", dataBirth = " + dataBirth + ", commands = " + commands + "}";
    }
}
