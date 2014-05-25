package com.luxoft.vklinduhov.football.mvc;

import com.luxoft.vklinduhov.football.beans.Club;
import com.luxoft.vklinduhov.football.beans.Player;
import com.luxoft.vklinduhov.football.beans.Position;
import com.luxoft.vklinduhov.football.dao.ClubDao;
import com.luxoft.vklinduhov.football.dao.PlayerDao;
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
    private ClubDao clubDao;

    @Autowired
    private PlayerDao playerDao;

    @RequestMapping("showClubs")
    public ModelAndView showClubList(){
        List<Club> allClubs = clubDao.getAllClubs();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("showClubList");
        mav.addObject("allClubs", allClubs);
        return mav;
    }

    @RequestMapping("showPlayers")
    public ModelAndView showPlayerList(){
        List<Player> allPlayers = playerDao.getAllPLayers();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("showPlayerList");
        mav.addObject("allPlayers", allPlayers);
        return mav;
    }

    @RequestMapping(value = "addClub", method = RequestMethod.GET)
    public ModelAndView club() {
        return new ModelAndView("addClub");
    }

    @RequestMapping(value = "addClub", method = RequestMethod.POST)
    public String addClub(@ModelAttribute Club club, ModelMap model) {
        clubDao.addClub(club);
        model.addAttribute("club", club);
        return "addClubResult";
    }

    @RequestMapping(value = "addPlayer", method = RequestMethod.GET)
    public ModelAndView player() {
        List<Club> allClubs = clubDao.getAllClubs();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("addPlayer");
        mav.addObject("positionList", Arrays.asList(Position.values()));
        mav.addObject("clubList", allClubs);
        return mav;
    }

    @RequestMapping(value = "addPlayer", method = RequestMethod.POST)
    public String addPlayer(@ModelAttribute Player p, ModelMap model) {

        playerDao.addPlayer(p);
        model.addAttribute("name", p);

        return "addPlayerResult";
    }

    @RequestMapping(value = "editClub", method = RequestMethod.GET)
    public ModelAndView setEditClubForm(@RequestParam String clubId) {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("editClub");
        mav.addObject("editClub", clubDao.getClubById(Integer.valueOf(clubId)));

        return mav;
    }

    @RequestMapping(value = "editClub", method = RequestMethod.POST)
    public String editClub(@ModelAttribute Club club, ModelMap model) {

        Club editClub = clubDao.getClubById(club.getId());
        editClub.setName(club.getName());
        clubDao.editClub(editClub);
        model.addAttribute("club", editClub);

        return "editClubResult";
    }

    @RequestMapping(value = "editPlayer", method = RequestMethod.GET)
    public ModelAndView setEditPlayerForm(@RequestParam String playerId) {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("editPlayer");

        List<Club> allClubs = clubDao.getAllClubs();

        mav.addObject("positionList", Arrays.asList(Position.values()));
        mav.addObject("clubList", allClubs);
        mav.addObject("editPlayer", playerDao.getPlayerById(Integer.valueOf(playerId)));

        return mav;
    }

    @RequestMapping(value = "editPlayer", method = RequestMethod.POST)
    public String editPlayer(@ModelAttribute Player player, ModelMap model) {

        Player playerEdit = playerDao.getPlayerById(player.getId());
        playerEdit.setName(player.getName());
        playerEdit.setPosition(player.getPosition());
        playerEdit.setAge(player.getAge());
        playerEdit.setHeight(player.getHeight());
        playerEdit.setWeight(player.getWeight());
        playerEdit.setClubId(player.getClubId());

        model.addAttribute("player", playerEdit);

        return "editPlayerResult";
    }

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

    @RequestMapping(value = "gamesAndTournaments", method = RequestMethod.GET)
    public void gamesAndTournaments() {
    }
}