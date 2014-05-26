package com.luxoft.vklinduhov.football.mvc;

import com.luxoft.vklinduhov.football.beans.Club;
import com.luxoft.vklinduhov.football.beans.Player;
import com.luxoft.vklinduhov.football.beans.Position;
import com.luxoft.vklinduhov.football.dao.impl.ClubDaoImpl;
import com.luxoft.vklinduhov.football.dao.impl.PlayerDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
public class FootballController{

    @Autowired
    private ClubDaoImpl clubDao;

    @Autowired
    private PlayerDaoImpl playerDao;



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
        return new ModelAndView("addClub");
    }

    @RequestMapping(value = "addClub", method = RequestMethod.POST)
    public String addClub(@ModelAttribute Club club, ModelMap model) {
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

    @RequestMapping(value = "removeClub", method = RequestMethod.POST)
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
        mav.addObject("positionList", Arrays.asList(Position.values()));
        mav.addObject("clubList", allClubs);
        return mav;
    }

    @RequestMapping(value = "addPlayer", method = RequestMethod.POST)
    public String addPlayer(@ModelAttribute("player") Player player, ModelMap model) {
        playerDao.create(player);
        List<Club> allClubs = clubDao.getAll();
        model.addAttribute("positionList", Arrays.asList(Position.values()));
        model.addAttribute("clubList", allClubs);
        model.addAttribute("result", "Player " + player + " is added");
        return "addPlayer";
    }

    @RequestMapping(value = "editPlayer", method = RequestMethod.GET)
    public ModelAndView setEditPlayerForm(@RequestParam String playerId) {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("editPlayer");

        List<Club> allClubs = clubDao.getAll();

        mav.addObject("positionList", Arrays.asList(Position.values()));
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

    @RequestMapping(value = "removePlayer", method = RequestMethod.POST)
    public ModelAndView removePlayer(@RequestParam String playerId) {
        playerDao.delete(playerId);
        return showPlayerList();
    }



    @RequestMapping(value = "gamesAndTournaments", method = RequestMethod.GET)
    public void gamesAndTournaments() {
    }
}