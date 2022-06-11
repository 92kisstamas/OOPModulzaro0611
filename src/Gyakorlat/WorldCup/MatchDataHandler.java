package Gyakorlat.WorldCup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MatchDataHandler {

    private final String SEPARATOR = ";";

    List<Match> matchList = new ArrayList<>();

    public List<Match> getMatchList () {
        if (matchList.size() == 0) {
            setMatchList();
        }
        return matchList;
    }

    private void setMatchList () {

        try {

            try (BufferedReader reader = new BufferedReader(
                    new FileReader("files/matches_all.csv"))) {
                String line = "";
                reader.readLine();

                while ((line = reader.readLine()) != null) {
                    String[] temp = line.split(SEPARATOR);

                    if (temp.length < 8){
                        Match matchTemp = new Match(
                                Integer.parseInt(temp[0]),
                                temp[1],
                                temp[2],
                                temp[3],
                                temp[4],
                                Integer.parseInt(temp[5]),
                                Integer.parseInt(temp[6])
                        );
                        matchList.add(matchTemp);
                    } else {
                        MatchWithPenalties matchTemp = new MatchWithPenalties(
                                Integer.parseInt(temp[0]),
                                temp[1],
                                temp[2],
                                temp[3],
                                temp[4],
                                Integer.parseInt(temp[5]),
                                Integer.parseInt(temp[6]),
                                Integer.parseInt(temp[7]),
                                Integer.parseInt(temp[8])
                        );
                        matchList.add(matchTemp);
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
