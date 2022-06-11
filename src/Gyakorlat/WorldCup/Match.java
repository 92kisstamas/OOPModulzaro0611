package Gyakorlat.WorldCup;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import static Gyakorlat.WorldCup.StageEnum.*;

public class Match {

    private WorldCup worldCup;

    private int year;
    private StageEnum stage;
    private LocalDate date;
    private String teamA;
    private String teamB;
    private int goalsA;
    private int goalsB;

    public Match() {}

    public Match (int year, String stage, String date,
                  String teamA, String teamB,
                  int goalsA, int goalsB) {
        this.year = year;
        this.stage = getEnum(stage);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        formatter = formatter.withLocale(Locale.forLanguageTag(date));
        this.date = LocalDate.parse(date, formatter);
        this.teamA = teamA;
        this.teamB = teamB;
        this.goalsA = goalsA;
        this.goalsB = goalsB;
    }

    protected String printMatchToCSV () {
        //year;stage;date;team_a;team_b;goals_a;goals_b;

        return
                this.worldCup.getYear() + ";" + this.stage + ";" + this.date
                + ";" + this.teamA + ";" + this.teamB + ";" + this.goalsA
                + ";" + this.goalsB;
    }

    public void setWorldCup_Match(List<Match> matches, List<WorldCup> worldCups) {

        for (Match match : matches){
            for (WorldCup worldCup : worldCups){
                if (match.getYear() == worldCup.getYear()){
                    match.setWorldCup(worldCup);
                    worldCup.addMatchList(match);
                }
            }
        }
    }

    private StageEnum getEnum (String temp) {

        return switch (temp) {
            case "Group A" -> GROUP_A;
            case "Group B" -> GROUP_B;
            case "Group C" -> GROUP_C;
            case "Group D" -> GROUP_D;
            case "Group E" -> GROUP_E;
            case "Group F" -> GROUP_F;
            case "Group G" -> GROUP_G;
            case "Group H" -> GROUP_H;
            case "Round of 16" -> ROUND_OF_16;
            case "Quarter-finals" -> QUARTER_FINALS;
            case "Semi-finals" -> SEMI_FINALS;
            case "Third place play-off" -> THIRD_PLACE_PLAYOFF;
            case "Final" -> FINAL;
            default -> null;
        };
    }

    public void setWorldCup(WorldCup worldCup) {
        this.worldCup = worldCup;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public StageEnum getStage() {
        return stage;
    }

    public void setStage(StageEnum stage) {
        this.stage = stage;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public int getGoalsA() {
        return goalsA;
    }

    public void setGoalsA(int goalsA) {
        this.goalsA = goalsA;
    }

    public int getGoalsB() {
        return goalsB;
    }

    public void setGoalsB(int goalsB) {
        this.goalsB = goalsB;
    }
}
