package com.luxoft.vklinduhov.football.beans;

import java.util.List;


public class SeasonResult extends AbstractEntity {

    public static final Integer LOSE_POINT = 0;
    public static final Integer DRAW_POINT = 1;
    public static final Integer WIN_POINT = 3;

    private String clubId;
    private String clubName;

    private Integer winCount = 0;
    private Integer drawCount = 0;
    private Integer loseCount = 0;

    private Integer goalScored = 0;
    private Integer goalMissed = 0;

    public SeasonResult() {
    }

    public SeasonResult(List<List<Game>> tourList, String clubId, String clubName) {
        this.clubId = clubId;
        this.clubName = clubName;
        for (List<Game> tour : tourList) {
            for (Game game : tour) {
                if (clubId.equals(game.getClubHomeId())) {
                    goalScored += Integer.valueOf(game.getHomeGoals());
                    goalMissed += Integer.valueOf(game.getAwayGoals());
                    updateCounts(game.getHomeGoals().compareTo(game.getAwayGoals()));
                    break;
                } else if (clubId.equals(game.getClubAwayId())) {
                    goalMissed += Integer.valueOf(game.getHomeGoals());
                    goalScored += Integer.valueOf(game.getAwayGoals());
                    updateCounts(game.getAwayGoals().compareTo(game.getHomeGoals()));
                    break;
                }
            }
        }
    }

    private int updateCounts(int compared) {
        if (compared < 0) {
            loseCount++;
            return LOSE_POINT;
        } else if (compared == 0) {
            drawCount++;
            return DRAW_POINT;
        } else {
            winCount++;
            return WIN_POINT;
        }
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public Integer getWinCount() {
        return winCount;
    }

    public Integer getDrawCount() {
        return drawCount;
    }

    public Integer getLoseCount() {
        return loseCount;
    }

    public Integer getGoalScored() {
        return goalScored;
    }

    public Integer getGoalMissed() {
        return goalMissed;
    }

    public Integer getGamesCount() {
        return winCount + drawCount + loseCount;
    }

    public Integer getPoints(){
        return winCount*WIN_POINT + drawCount*DRAW_POINT + loseCount*LOSE_POINT;
    }

    public Integer getGoalDifference() {
        return (goalScored - goalMissed);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeasonResult that = (SeasonResult) o;

        if (clubId != null ? !clubId.equals(that.clubId) : that.clubId != null) return false;
        if (clubName != null ? !clubName.equals(that.clubName) : that.clubName != null) return false;
        if (drawCount != null ? !drawCount.equals(that.drawCount) : that.drawCount != null) return false;
        if (goalMissed != null ? !goalMissed.equals(that.goalMissed) : that.goalMissed != null) return false;
        if (goalScored != null ? !goalScored.equals(that.goalScored) : that.goalScored != null) return false;
        if (loseCount != null ? !loseCount.equals(that.loseCount) : that.loseCount != null) return false;
        if (winCount != null ? !winCount.equals(that.winCount) : that.winCount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clubId != null ? clubId.hashCode() : 0;
        result = 31 * result + (clubName != null ? clubName.hashCode() : 0);
        result = 31 * result + (winCount != null ? winCount.hashCode() : 0);
        result = 31 * result + (drawCount != null ? drawCount.hashCode() : 0);
        result = 31 * result + (loseCount != null ? loseCount.hashCode() : 0);
        result = 31 * result + (goalScored != null ? goalScored.hashCode() : 0);
        result = 31 * result + (goalMissed != null ? goalMissed.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return clubName + ": " + this.getGamesCount() + ", " + winCount + ", " + drawCount + ", " + loseCount + ", "
                + goalScored + ", " + goalMissed + ", " + this.getGoalDifference() + ", " + this.getPoints();
    }
}
