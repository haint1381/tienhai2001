package clean_code_refactoring.baitap;

public class TennisGame {

    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String WIN_FOR_PLAYER_2 = "Win for player2";
    public static final String WIN_FOR_PLAYER_1 = "Win for player1";
    public static final String ADVANTAGE_PLAYER_2 = "Advantage player2";
    public static final String ADVANTAGE_PLAYER_1 = "Advantage player1";
    public static final String SCORE = "-";
    public static final String LOVE_ALL = "Love-All";
    public static final String FIFTEEN_ALL = "Fifteen-All";
    public static final String THIRTY_ALL = "Thirty-All";
    public static final String FORTY_ALL = "Forty-All";
    public static final String DEUCE = "Deuce";

    public static String getScore(String playerName1, String playerName2, int play1_score, int play2_score) {
        String score = "";
        int tempScore = 0;
        if (play1_score == play2_score) {
            score = getStartGame(play1_score);
        } else if (play1_score >= 4 || play2_score >= 4) {

            score = getBetweenGames(play1_score, play2_score);
        } else {
            score = getEndGame(play1_score, play2_score, score);
        }

        return score;
    }

    private static String getEndGame(int play1_score, int play2_score, String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = play1_score;
            else {
                score += SCORE;
                tempScore = play2_score;
            }
            switch (tempScore) {
                case 0:
                    score += LOVE;
                    break;
                case 1:
                    score += FIFTEEN;
                    break;
                case 2:
                    score += THIRTY;
                    break;
                case 3:
                    score += FORTY;
                    break;
            }
        }
        return score;
    }

    private static String getBetweenGames(int play1_score, int play2_score) {
        String score;
        int minusResult = play1_score - play2_score;
        if (minusResult == 1) score = ADVANTAGE_PLAYER_1;
        else if (minusResult == -1) score = ADVANTAGE_PLAYER_2;
        else if (minusResult >= 2) score = WIN_FOR_PLAYER_1;
        else score = WIN_FOR_PLAYER_2;
        return score;
    }

    private static String getStartGame(int play1_score) {
        String score;
        switch (play1_score) {
            case 0:
                score = LOVE_ALL;
                break;
            case 1:
                score = FIFTEEN_ALL;
                break;
            case 2:
                score = THIRTY_ALL;
                break;
            case 3:
                score = FORTY_ALL;
                break;
            default:
                score = DEUCE;
                break;

        }
        return score;
    }
}