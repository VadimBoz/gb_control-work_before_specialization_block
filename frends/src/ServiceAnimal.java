import Animals.AnimalType;
import Animals.CommandsAnimal;

import java.util.ArrayList;

public class ServiceAnimal {

        public static ArrayList<CommandsAnimal> parseIntCommandsAnimal(String str) {
            String[] strPrepare = str.trim().split(" +");
            ArrayList<CommandsAnimal> res = new ArrayList<>();
            ArrayList<CommandsAnimal> allComands = CommandsAnimal.allCommandsAnimal();
            for (String item: strPrepare) {
                if (item.matches("\\d+")) {
                    int num = Integer.parseInt(item);
                    if (num > 0 && num <= allComands.size())
                        res.add(allComands.get(num - 1));
                }
            }
            return res;
        }


        public static ArrayList<CommandsAnimal> parseStrCommandsAnimal(String str) {
            String[] strPrepare = str.trim().split("-");
            ArrayList<CommandsAnimal> res = new ArrayList<>();
            ArrayList<CommandsAnimal> allComands = CommandsAnimal.allCommandsAnimal();
            for (String item: strPrepare) {
                for (CommandsAnimal command: allComands) {
                    if (item.equals(command.name())) {
                        res.add(command);
                    }
                }
            }
            return res;
        }


        public static AnimalType parseAnimalType(String str) {
        for (AnimalType item : AnimalType.values()) {
            if (str.equals(item.name()))
                return item ;

        }
        return null;
    }



}



