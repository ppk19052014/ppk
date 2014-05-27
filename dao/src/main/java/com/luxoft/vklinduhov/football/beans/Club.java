package com.luxoft.vklinduhov.football.beans;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "clubs")
public class Club extends AbstractEntity{

    private String name;
    private Date foundDate;
    private List<Player> playerList;
    private String tournamentId;
    private String tournamentName;

    public Club() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFoundDate() {
        return foundDate;
    }

    public void setFoundDate(Date foundDate) {
        this.foundDate = foundDate;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public String getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Club club = (Club) o;

        if (foundDate != null ? !foundDate.equals(club.foundDate) : club.foundDate != null) return false;
        if (name != null ? !name.equals(club.name) : club.name != null) return false;
        if (playerList != null ? !playerList.equals(club.playerList) : club.playerList != null) return false;
        if (tournamentId != null ? !tournamentId.equals(club.tournamentId) : club.tournamentId != null) return false;
        if (tournamentName != null ? !tournamentName.equals(club.tournamentName) : club.tournamentName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (foundDate != null ? foundDate.hashCode() : 0);
        result = 31 * result + (playerList != null ? playerList.hashCode() : 0);
        result = 31 * result + (tournamentId != null ? tournamentId.hashCode() : 0);
        result = 31 * result + (tournamentName != null ? tournamentName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}
