package Gyakorlat.WorldCup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class WorldCupDataHandler {

    private final String SEPARATOR = ";";

    private List<WorldCup> worldCups = new ArrayList<>();

    public List<WorldCup> getWorldCupsList () {
        if (worldCups.size() == 0) {
            worldCupList();
        }
        return worldCups;
    }

    private void worldCupList () {

        try {

            try (BufferedReader reader = new BufferedReader(
                    new FileReader("files/worldcups.csv"))) {
                String line = "";
                reader.readLine();

                while ((line = reader.readLine()) != null) {
                    String[] temp = line.split(SEPARATOR);

                    WorldCup newWorldCup = new WorldCup(
                            Integer.parseInt(temp[0]),
                            temp[1],
                            temp[2],
                            temp[3],
                            temp[4]
                    );

                    worldCups.add(newWorldCup);

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
