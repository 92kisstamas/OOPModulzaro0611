package Gyakorlat.WorldCup;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.Math.abs;

public class WorldCup {

    private final int year;
    private final String host;
    private final String confederation;
    private final String date_from;
    private final String date_to;

    private List<Match> matchList = new ArrayList<>();

    public Map<StageEnum, Integer> numberOfGoalsFromStage () {
        Map<StageEnum, Integer> tempMap = new TreeMap<>();
        int allgoal;

        for (Match match : matchList){
            allgoal = 0;

            /*if (match instanceof MatchWithPenalties){
                allgoal = match.getGoalsA() + match.getGoalsB()
                        + ((MatchWithPenalties) match).getPenaltiesA()
                        + ((MatchWithPenalties) match).getPenaltiesB();
            } else {
                allgoal = match.getGoalsA() + match.getGoalsB();
            }*/

            allgoal = match.getGoalsA() + match.getGoalsB();

            if (!tempMap.containsKey(match.getStage())){
                tempMap.putIfAbsent(match.getStage(), 0);
            }

            int temp = tempMap.get(match.getStage());
            tempMap.put(match.getStage(), temp + allgoal);
        }

        return tempMap;
    }

    public int winnerBets () {
        int counter = 0;

        for (Match match : matchList){
            if (match instanceof MatchWithPenalties &&
                    ((MatchWithPenalties) match).getPenaltiesA() >
                            ((MatchWithPenalties) match).getPenaltiesB()){
                counter++;
            } else if (match.getGoalsA() > match.getGoalsB()){
                counter++;
            }
        }

        return counter;
    }

    public WorldCup(int year, String host,
                    String confederation, String date_from,
                    String date_to) {
        this.year = year;
        this.host = host;
        this.confederation = confederation;
        this.date_from = date_from;
        this.date_to = date_to;
    }

    public String maxGoalsDifferentACup (){
        int max = Integer.MIN_VALUE;
        String matchTemp = "";

        for (Match match : matchList) {
            if (abs(match.getGoalsA() - match.getGoalsB()) > max){
                max = abs(match.getGoalsA() - match.getGoalsB());
                matchTemp = match.getTeamA() + " - " + match.getTeamB();
            }
        }
        return "A maximális gólkülönbség az adott kupán:\n"
                + matchTemp + " -> " + max;
    }

    public void writeWorldCupMatchesToCSV () {

        try {
            File file = new File("files/aCupMatches.csv");

            try (BufferedWriter writer = new BufferedWriter(
                    new FileWriter(file))){

                writer.write("year;stage;date;team_a;team_b;" +
                        "goals_a;goals_b;penalties_a;penalties_b\n");

                for (Match match : matchList) {
                    writer.write(match.printMatchToCSV() + "\n");
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void addMatchList (Match match) {
        matchList.add(match);
    }

    public int getYear() {
        return year;
    }

    public String getHost() {
        return host;
    }

    public String getConfederation() {
        return confederation;
    }

    public String getDate_from() {
        return date_from;
    }

    public String getDate_to() {
        return date_to;
    }

    @Override
    public String toString() {
        return "WorldCup{" +
                "year=" + year +
                ", host='" + host + '\'' +
                ", confederation='" + confederation + '\'' +
                ", date_from='" + date_from + '\'' +
                ", date_to='" + date_to + '\'' +
                '}';
    }
}
