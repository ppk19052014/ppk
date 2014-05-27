package com.luxoft.vklinduhov.football.mvc;

import com.luxoft.vklinduhov.football.beans.Club;
import com.luxoft.vklinduhov.football.beans.Player;
import com.luxoft.vklinduhov.football.beans.Tournament;
import com.luxoft.vklinduhov.football.dao.impl.ClubDaoImpl;
import com.luxoft.vklinduhov.football.dao.impl.PlayerDaoImpl;
import com.luxoft.vklinduhov.football.dao.impl.TournamentDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class FootballController{

    @Autowired
    private ClubDaoImpl clubDao;

    @Autowired
    private PlayerDaoImpl playerDao;

    @Autowired
    private TournamentDaoImpl tournamentDao;



    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    public String signIn(HttpServletRequest servletRequest) {
        if("admin".equals(servletRequest.getParameter("login")) && "password".equals(servletRequest.getParameter("password"))){
            return "admin";
        }
        else return "signIn";
    }

    @RequestMapping(value = "signIn", method = RequestMethod.GET)
    public void signIn() {
    }

    @RequestMapping(value = "showTournaments", method = RequestMethod.GET)
    public ModelAndView showTournaments(){
        List<Tournament> tournamentList = tournamentDao.getAll();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("showTournamentList");
        mav.addObject("tournamentList", tournamentList);
        return mav;
    }

    @RequestMapping(value = "addTournament", method = RequestMethod.GET)
    public ModelAndView tournament() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addTournament");
        mav.addObject("tournament", new Tournament());
        return mav;
    }

    @RequestMapping(value = "addTournament", method = RequestMethod.POST)
    public String addTournament(@ModelAttribute Tournament tournament, ModelMap model) {
        tournamentDao.create(tournament);
        model.addAttribute("result", "Tournament " + tournament + " is added");
        return "addTournament";
    }

    @RequestMapping(value = "editTournament", method = RequestMethod.GET)
    public ModelAndView setEditTournamentForm(@RequestParam String tournamentId) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("editTournament");
        mav.addObject("editTournament", tournamentDao.read(tournamentId));
        return mav;
    }

    @RequestMapping(value = "editTournament", method = RequestMethod.POST)
    public String editTournament(@ModelAttribute Tournament tournament, ModelMap model) {
        tournamentDao.update(tournament);
        model.addAttribute("result", "Tournament " + tournament + " is edited");
        return "editTournament";
    }

    @RequestMapping(value = "showTournaments", method = RequestMethod.POST)
    public ModelAndView removeTournament(@RequestParam String tournamentId) {
        String name = tournamentDao.read(tournamentId).getName();
        tournamentDao.delete(tournamentId);
        ModelAndView mav = showTournaments();
        mav.addObject("result", "Tournament " + name + " is deleted");
        return mav;
    }



    @RequestMapping(value = "showClubs", method = RequestMethod.GET)
    public ModelAndView showClubList(){
        List<Club> allClubs = clubDao.getAll();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("showClubList");
        mav.addObject("allClubs", allClubs);
        return mav;
    }

    @RequestMapping(value = "addClub", method = RequestMethod.GET)
    public ModelAndView club() {
        List<Tournament> tournamentList = tournamentDao.getAll();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addClub");
        mav.addObject("club", new Club());
        mav.addObject("tournamentList", tournamentList);
        return mav;
    }

    @RequestMapping(value = "addClub", method = RequestMethod.POST)
    public String addClub(@ModelAttribute Club club, ModelMap model) {
        if(club.getTournamentId() != null){
            Tournament tournament = tournamentDao.read(club.getTournamentId());
            club.setTournamentName(tournament.getName());
            List<Club> clubList = tournament.getClubList();
            if(clubList == null){
                clubList = new ArrayList<Club>();
            }
            clubList.add(club);
        }
        List<Tournament> tournamentList = tournamentDao.getAll();
        model.addAttribute("tournamentList", tournamentList);
        clubDao.create(club);
        model.addAttribute("result", "Club " + club + " is added");
        return "addClub";
    }

    @RequestMapping(value = "editClub", method = RequestMethod.GET)
    public ModelAndView setEditClubForm(@RequestParam String clubId) {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("editClub");
        mav.addObject("editClub", clubDao.read(clubId));

        return mav;
    }

    @RequestMapping(value = "editClub", method = RequestMethod.POST)
    public String editClub(@ModelAttribute Club club, ModelMap model) {
        clubDao.update(club);
        model.addAttribute("result", "Club " + club + " is edited");
        return "editClub";
    }

    @RequestMapping(value = "showClubs", method = RequestMethod.POST)
    public ModelAndView removeClub(@RequestParam String clubId) {
        String name = clubDao.read(clubId).getName();
        clubDao.delete(clubId);
        ModelAndView mav = showClubList();
        mav.addObject("result", "Club " + name + " is deleted");
        return mav;
    }



    @RequestMapping("showPlayers")
    public ModelAndView showPlayerList(){
        List<Player> allPlayers = playerDao.getAll();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("showPlayerList");
        mav.addObject("allPlayers", allPlayers);
        return mav;
    }

    @RequestMapping(value = "addPlayer", method = RequestMethod.GET)
    public ModelAndView player() {
        List<Club> allClubs = clubDao.getAll();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addPlayer");
        mav.addObject("player",new Player());
        mav.addObject("clubList", allClubs);
        return mav;
    }

    @RequestMapping(value = "addPlayer", method = RequestMethod.POST)
    public String addPlayer(@ModelAttribute("player") Player player, ModelMap model) {
        if(player.getClubId() != null){
            Club club = clubDao.read(player.getClubId());
            player.setClubName(club.getName());
            List<Player> playerList = club.getPlayerList();
            if(playerList == null){
                playerList = new ArrayList<Player>();
            }
            playerList.add(player);
        }
        playerDao.create(player);
        List<Club> clubList = clubDao.getAll();
        model.addAttribute("clubList", clubList);
        model.addAttribute("result", "Player " + player + " is added");
        return "addPlayer";
    }

    @RequestMapping(value = "editPlayer", method = RequestMethod.GET)
    public ModelAndView setEditPlayerForm(@RequestParam String playerId) {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("editPlayer");

        List<Club> allClubs = clubDao.getAll();

        mav.addObject("clubList", allClubs);
        mav.addObject("editPlayer", playerDao.read(playerId));

        return mav;
    }

    @RequestMapping(value = "editPlayer", method = RequestMethod.POST)
    public String editPlayer(@ModelAttribute Player player, ModelMap model) {
        playerDao.update(player);
        model.addAttribute("result", "Player " + player + " is edited");
        return "editPlayer";
    }

    @RequestMapping(value = "showPlayers", method = RequestMethod.POST)
    public ModelAndView removePlayer(@RequestParam String playerId) {
        String name = playerDao.read(playerId).getName();
        playerDao.delete(playerId);
        ModelAndView mav = showPlayerList();
        mav.addObject("result", "Player " + name + " is deleted");
        return mav;
    }



    @RequestMapping(value = "gamesAndTournaments", method = RequestMethod.GET)
    public void gamesAndTournaments() {
    }
}