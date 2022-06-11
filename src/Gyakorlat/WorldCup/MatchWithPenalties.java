package Gyakorlat.WorldCup;

import java.time.LocalDate;

public class MatchWithPenalties extends Match {

    private int penaltiesA;
    private int penaltiesB;

    public MatchWithPenalties(int year, String stage, String date,
                              String teamA, String teamB,
                              int goalsA, int goalsB,
                              int penaltiesA, int penaltiesB) {
        super(year, stage, date, teamA, teamB, goalsA, goalsB);
        this.penaltiesA = penaltiesA;
        this.penaltiesB = penaltiesB;
    }

    @Override
    protected String printMatchToCSV() {
        //year;stage;date;team_a;team_b;goals_a;goals_b;penalties_a;penalties_b
        return super.printMatchToCSV() + ";" + this.penaltiesA + ";" + this.penaltiesB;
    }

    public int getPenaltiesA() {
        return penaltiesA;
    }

    public void setPenaltiesA(int penaltiesA) {
        this.penaltiesA = penaltiesA;
    }

    public int getPenaltiesB() {
        return penaltiesB;
    }

    public void setPenaltiesB(int penaltiesB) {
        this.penaltiesB = penaltiesB;
    }
}
