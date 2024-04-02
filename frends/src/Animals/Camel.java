package Animals;

import java.time.LocalDate;
import java.util.ArrayList;

public class Camel extends  PackAnimal {

    public Camel(String name, LocalDate dataBirth, ArrayList<CommandsAnimal> commands) {
        super(name, dataBirth, commands);
    }

    public Camel(String name, LocalDate dataBirth) {
        super(name, dataBirth);
    }

    public Camel(String name, LocalDate dataBirth, CommandsAnimal command) {

        super(name, dataBirth, command);

    }

    @Override
    public String toString() {
        return "\nCamel {id = " + super.getId() + ", name = " + name +
                ", dataBirth = " + dataBirth + ", commands = " + commands + '}';
    }
}
