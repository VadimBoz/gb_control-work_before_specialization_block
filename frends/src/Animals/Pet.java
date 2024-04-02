package Animals;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pet extends Animal {
    public Pet(String name, LocalDate dataBirth, ArrayList<CommandsAnimal> commands) {
        super(name, dataBirth, commands);
    }

    public Pet(String name, LocalDate dataBirth) {
        super(name, dataBirth);
    }

    public Pet(String name, LocalDate dataBirth, CommandsAnimal command) {
        super(name, dataBirth, command);
    }

    @Override
    public String toString() {
        return "Pet {id = " + super.getId() + ", name = " + name +
                ", dataBirth = " + dataBirth + ", commands = " + commands + '}';
    }

}
