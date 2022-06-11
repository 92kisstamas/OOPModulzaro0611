package Gyakorlat.WorldCup;

public enum StageEnum {

    GROUP_A,
    GROUP_B,
    GROUP_C,
    GROUP_D,
    GROUP_E,
    GROUP_F,
    GROUP_G,
    GROUP_H,
    ROUND_OF_16,
    QUARTER_FINALS,
    SEMI_FINALS,
    THIRD_PLACE_PLAYOFF,
    FINAL
    ;

    StageEnum () {}

    public StageEnum getEnum (String tempEnum) {
        return switch (tempEnum) {
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

}
