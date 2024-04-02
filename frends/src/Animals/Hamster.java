package Animals;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hamster extends Pet {

    public Hamster(String name, LocalDate dataBirth, ArrayList<CommandsAnimal> commands) {
        super(name, dataBirth, commands);
    }

    public Hamster(String name, LocalDate dataBirth) {
        super(name, dataBirth);
    }

    public Hamster(String name, LocalDate dataBirth, CommandsAnimal command) {
        super(name, dataBirth, command);
    }

    @Override
    public String toString() {
        return "\nHamster {id = " + super.getId() + ", name = " + name +
                ", dataBirth = " + dataBirth + ", commands = " + commands + '}';
    }
}
