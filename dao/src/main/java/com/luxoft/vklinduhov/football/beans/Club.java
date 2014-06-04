package com.luxoft.vklinduhov.football.beans;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "clubs")
public class Club extends AbstractEntity{

    @Field
    private String name;
    @Field
    private String foundDate;
    @Field
    private List<String> playerListId;
    @Field
    private String tournamentId;
    @Field
    private String tournamentName;

    public Club() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoundDate() {
        return foundDate;
    }

    public void setFoundDate(String foundDate) {
        this.foundDate = foundDate;
    }

    public List<String> getPlayerListId() {
        return playerListId;
    }

    public void setPlayerListId(List<String> playerList) {
        this.playerListId = playerList;
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

    public void addPlayerId(String playerId){
        if(playerListId == null){
            playerListId = new ArrayList<String>();
        }
        playerListId.add(playerId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Club club = (Club) o;

        if (foundDate != null ? !foundDate.equals(club.foundDate) : club.foundDate != null) return false;
        if (name != null ? !name.equals(club.name) : club.name != null) return false;
        if (playerListId != null ? !playerListId.equals(club.playerListId) : club.playerListId != null) return false;
        if (tournamentId != null ? !tournamentId.equals(club.tournamentId) : club.tournamentId != null) return false;
        if (tournamentName != null ? !tournamentName.equals(club.tournamentName) : club.tournamentName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (foundDate != null ? foundDate.hashCode() : 0);
        result = 31 * result + (playerListId != null ? playerListId.hashCode() : 0);
        result = 31 * result + (tournamentId != null ? tournamentId.hashCode() : 0);
        result = 31 * result + (tournamentName != null ? tournamentName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name;
    }

    public List<String> getAllPlayersId() {
        return playerListId == null ? new ArrayList<String>() : new ArrayList<String>(playerListId);
    }
}
