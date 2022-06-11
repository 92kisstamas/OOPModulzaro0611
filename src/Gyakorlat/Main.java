package Gyakorlat;

import Gyakorlat.WorldCup.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        WorldCupDataHandler WoCuDaHa = new WorldCupDataHandler();
        List<WorldCup> worldCupList = new ArrayList<>(WoCuDaHa.getWorldCupsList());
        System.out.println(worldCupList.size());

        MatchDataHandler MaDaHa = new MatchDataHandler();
        List<Match> matchList = new ArrayList<>(MaDaHa.getMatchList());
        System.out.println(matchList.size());

        Match match = new Match();
        match.setWorldCup_Match(matchList, worldCupList);

        Scanner sc = new Scanner(System.in);
        int cupTemp = 0;

        do {
            System.out.println("Add meg a bajnokság évét, vagy a rendező ország nevét:" +
                    "\n(Segítségért írd be: HELP)");
            String cupData = sc.nextLine();

            if (cupData.equalsIgnoreCase("help")){
                System.out.println("(Lekérhető adatok:\n2010, South Africa" +
                        "\n2014, Brazil\n2018, Russia)");
            } else if (cupData.equalsIgnoreCase("2010") ||
                    cupData.equalsIgnoreCase("South Africa")){
                cupTemp = 2010;
            } else if (cupData.equalsIgnoreCase("2014") ||
                    cupData.equalsIgnoreCase("Brazil")){
                cupTemp = 2014;
            } else if (cupData.equalsIgnoreCase("2018") ||
                    cupData.equalsIgnoreCase("Russia")){
                cupTemp = 2018;
            } else {
                System.out.println("Rossz adat!");
            }

        } while (cupTemp == 0);

        String maxGoalsDiff = null;
        int winBets = 0;

        Map<StageEnum, Integer> allGoalsFromStage = new TreeMap<>();

        for (WorldCup worldCup : worldCupList) {
            if (cupTemp == worldCup.getYear()) {
                worldCup.writeWorldCupMatchesToCSV();
                maxGoalsDiff = worldCup.maxGoalsDifferentACup();
                winBets = worldCup.winnerBets();
                allGoalsFromStage = worldCup.numberOfGoalsFromStage();
            }
        }

        System.out.println(maxGoalsDiff);

        System.out.println("A szerencsejátékfüggő delikvensünk " + winBets
                + " fogadást nyert meg.");

        for (Map.Entry<StageEnum, Integer> temp : allGoalsFromStage.entrySet()) {
            System.out.println(temp.getKey() + ": " + temp.getValue());
        }







    }


}
