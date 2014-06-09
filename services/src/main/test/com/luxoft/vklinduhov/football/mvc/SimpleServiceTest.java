package com.luxoft.vklinduhov.football.mvc;

import com.luxoft.vklinduhov.football.beans.Club;
import com.luxoft.vklinduhov.football.beans.Game;
import com.luxoft.vklinduhov.football.beans.SeasonResult;
import com.luxoft.vklinduhov.football.beans.Tournament;
import com.luxoft.vklinduhov.football.dao.impl.ClubDaoImpl;
import com.luxoft.vklinduhov.football.dao.impl.TournamentDaoImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class SimpleServiceTest {

    private static String tournamentId;

    @Before
    public void before(){
        List<Tournament> all = tournamentDao.getAll();
        for (Tournament anAll : all) {
            tournamentDao.delete(all.get(0).getId());
        }
        Tournament newTournament = new Tournament();
        newTournament.setName("TestTournament");
        newTournament.setCountry("TestCountry");
        newTournament.setMembersCount("10");
        tournamentDao.create(newTournament);
        tournamentId = newTournament.getId();
    }

    @After
    public void after(){
        footballController.clearData(tournamentId);
        tournamentDao.delete(tournamentId);
    }

    @Autowired
    private ClubDaoImpl clubDao;

    @Autowired
    private TournamentDaoImpl tournamentDao;

    @Autowired
    private FootballController footballController;

    @Test
    public void testGenerateGames() throws Exception {
        List<Tournament> all = tournamentDao.getAll();
        Tournament tournament = null;
        for(Tournament tour : all){
            if("Tournament1".equals(tour.getName())){
                tournament = tour;
            }
        }

        List<SeasonResult> seasonResultList = new ArrayList<SeasonResult>(tournament != null ? tournament.getAllClubsId().size() : 0);

        if(tournament != null && tournament.getAllClubsId() != null){
            List<List<Game>> tourList = footballController.generateTours(tournament.getId());
            for(String clubId : tournament.getAllClubsId()){
                Club club = clubDao.read(clubId);
                SeasonResult seasonResult = new SeasonResult(tourList, club.getId(), club.getName());
                seasonResultList.add(seasonResult);
            }
        }

        Collections.sort(seasonResultList, new Comparator<SeasonResult>() {
            @Override
            public int compare(SeasonResult seasonResult1, SeasonResult seasonResult2) {
                int compared = seasonResult1.getPoints().compareTo(seasonResult2.getPoints());
                if(compared == 0){
                    compared = seasonResult1.getGoalDifference().compareTo(seasonResult2.getGoalDifference());
                }
                if (compared == 0){
                    compared = seasonResult1.getGoalScored().compareTo(seasonResult2.getGoalScored());
                }
                if(compared == 0){
                    compared = 1;
                }
                return -compared;
            }
        });
        for(SeasonResult result : seasonResultList){
            System.out.println(result);
        }
    }

    @Test
    public void test() {
        Tournament tournament = tournamentDao.read(tournamentId);
        footballController.generateTournamentData(tournament.getId());
    }

    @Test
    public void t() {
        List<String> strings = Arrays.asList("GoalKeeper", "Forward", "GoalKeeper", "Defender", "Midfielder", "GoalKeeper", "Defender", "Defender", "Forward","Forward");

        Collections.sort(strings);

        System.out.println(strings);
    }

}
