package Animals;

import java.time.LocalDate;
import java.util.ArrayList;

public class Horse extends PackAnimal {


    public Horse(String name, LocalDate dataBirth, ArrayList<CommandsAnimal> commands) {
        super(name, dataBirth, commands);
    }

    public Horse(String name, LocalDate dataBirth) {
        super(name, dataBirth);
    }

    public Horse(String name, LocalDate dataBirth, CommandsAnimal command) {
        super(name, dataBirth, command);
    }

    @Override
    public String toString() {
        return "\nHorse {id = " + super.getId() + ", name = " + name +
                ", dataBirth = " + dataBirth + ", commands = " + commands + '}';
    }
}
