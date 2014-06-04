package com.luxoft.vklinduhov.football.mvc;

import com.luxoft.vklinduhov.football.beans.Club;
import com.luxoft.vklinduhov.football.beans.Player;
import com.luxoft.vklinduhov.football.beans.Tournament;
import com.luxoft.vklinduhov.football.beans.User;
import com.luxoft.vklinduhov.football.dao.impl.ClubDaoImpl;
import com.luxoft.vklinduhov.football.dao.impl.PlayerDaoImpl;
import com.luxoft.vklinduhov.football.dao.impl.TournamentDaoImpl;
import com.luxoft.vklinduhov.football.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class FootballController {

    public static final String SIGNED_IN = "signedIn";
    @Autowired
    private UserDaoImpl userDao;

    @Autowired
    private ClubDaoImpl clubDao;

    @Autowired
    private PlayerDaoImpl playerDao;

    @Autowired
    private TournamentDaoImpl tournamentDao;



    @RequestMapping(value = "main", method = RequestMethod.GET)
    public void main() {
    }



    @RequestMapping(value = "signUp", method = RequestMethod.POST)
    public ModelAndView signUp(HttpServletRequest servletRequest) {
        User user = new User();
        user.setLogin(servletRequest.getParameter("login"));
        user.setPassword(servletRequest.getParameter("password"));

        List<User> userList = userDao.getAll();
        int searchResult = Collections.binarySearch(userList, user, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getLogin().compareTo(o2.getLogin());
            }
        });

        ModelAndView mav = new ModelAndView();

        if (searchResult < 0) {
            userDao.create(user);
            mav.addObject("result", "User " + user + " is signed up");
            return mav;
        } else {
            mav.addObject("result", "User " + user + " already exist");
            return mav;
        }
    }

    @RequestMapping(value = "signUp", method = RequestMethod.GET)
    public void signUp() {
    }

    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    public String signIn(HttpServletRequest servletRequest) {
        if (isAdmin(servletRequest)) {
            servletRequest.getSession().setAttribute(SIGNED_IN, true);
            servletRequest.getSession().setAttribute("admin", true);
            return "admin";
        }
        User user = findUser(servletRequest);
        if (user != null && user.getPassword().equals(servletRequest.getParameter("password"))) {
            servletRequest.getSession().setAttribute(SIGNED_IN, true);
            return "main";
        } else return "signIn";
    }

    private User findUser(HttpServletRequest servletRequest) {
        User user = new User();
        user.setLogin(servletRequest.getParameter("login"));
        user.setPassword(servletRequest.getParameter("password"));
        List<User> userList = userDao.getAll();
        int searchResult = Collections.binarySearch(userList, user, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getLogin().compareTo(o2.getLogin());
            }
        });
        return searchResult < 0 ? null : userList.get(searchResult);
    }

    private boolean isAdmin(HttpServletRequest servletRequest) {
        return "admin".equals(servletRequest.getParameter("login")) && "password".equals(servletRequest.getParameter("password"));
    }

    @RequestMapping(value = "signIn", method = RequestMethod.GET)
    public void signIn() {
    }

    @RequestMapping(value = "signOut", method = RequestMethod.GET)
    public String signOut(HttpServletRequest servletRequest) {
        servletRequest.getSession().setAttribute(SIGNED_IN, false);
        servletRequest.getSession().setAttribute("admin", false);
        return "main";
    }



    @RequestMapping(value = "showTournaments", method = RequestMethod.GET)
    public ModelAndView showTournaments() {
        List<Tournament> allTournaments = tournamentDao.getAll();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("showTournamentList");
        mav.addObject("allTournaments", allTournaments);
        return mav;
    }

    @RequestMapping(value = "showTournaments", method = RequestMethod.POST)
    public ModelAndView removeTournament(@RequestParam String tournamentId) {
        String name = tournamentDao.read(tournamentId).getName();
        tournamentDao.delete(tournamentId);
        ModelAndView mav = showTournaments();
        mav.addObject("result", "Tournament " + name + " is deleted");
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

    @RequestMapping(value = "tournamentInfo", method = RequestMethod.GET)
    public ModelAndView tournamentInfo(@RequestParam String tournamentId) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("tournamentInfo");
        Tournament tournament = tournamentDao.read(tournamentId);
        mav.addObject("tournamentName", tournament.getName());
        ArrayList<Club> clubs = new ArrayList<Club>();
        for(int i = 0; i < tournament.getAllClubsId().size(); i++){
            clubs.add(clubDao.read(tournament.getAllClubsId().get(i)));
        }
        mav.addObject("allClubs", clubs);
        return mav;
    }



    @RequestMapping(value = "showClubs", method = RequestMethod.GET)
    public ModelAndView showClubList() {
        List<Club> allClubs = clubDao.getAll();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("showClubList");
        mav.addObject("allClubs", allClubs);
        return mav;
    }

    @RequestMapping(value = "showClubs", method = RequestMethod.POST)
    public ModelAndView removeClub(@RequestParam String clubId) {
        String name = clubDao.read(clubId).getName();
        clubDao.delete(clubId);
        ModelAndView mav = showClubList();
        mav.addObject("result", "Club " + name + " is deleted");
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
        clubDao.create(club);
        if (club.getTournamentId() != null) {
            Tournament tournament = tournamentDao.read(club.getTournamentId());
            club.setTournamentName(tournament.getName());
            tournament.addClubId(club.getId());
            tournamentDao.update(tournament);
        }
        String result = "Club " + club + " is added";
        List<Tournament> tournamentList = tournamentDao.getAll();
        model.addAttribute("tournamentList", tournamentList);
        model.addAttribute("result", result);
        return "addClub";
    }

    @RequestMapping(value = "editClub", method = RequestMethod.GET)
    public ModelAndView setEditClubForm(@RequestParam String clubId) {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("editClub");
        mav.addObject("tournamentList", tournamentDao.getAll());
        mav.addObject("editClub", clubDao.read(clubId));

        return mav;
    }

    @RequestMapping(value = "editClub", method = RequestMethod.POST)
    public ModelAndView editClub(@ModelAttribute Club club) {
        clubDao.update(club);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("editClub");
        mav.addObject("tournamentList", tournamentDao.getAll());
        mav.addObject("result", "Club " + club + " is edited");
        return mav;
    }



    @RequestMapping("showPlayers")
    public ModelAndView showPlayerList() {
        List<Player> allPlayers = playerDao.getAll();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("showPlayerList");
        mav.addObject("allPlayers", allPlayers);
        return mav;
    }

    @RequestMapping(value = "showPlayers", method = RequestMethod.POST)
    public ModelAndView removePlayer(@RequestParam String playerId) {
        String name = playerDao.read(playerId).getName();
        playerDao.delete(playerId);
        ModelAndView mav = showPlayerList();
        mav.addObject("result", "Player " + name + " is deleted");
        return mav;
    }

    @RequestMapping(value = "addPlayer", method = RequestMethod.GET)
    public ModelAndView player() {
        List<Club> allClubs = clubDao.getAll();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addPlayer");
        mav.addObject("player", new Player());
        mav.addObject("clubList", allClubs);
        return mav;
    }

    @RequestMapping(value = "addPlayer", method = RequestMethod.POST)
    public String addPlayer(@ModelAttribute("player") Player player, ModelMap model) {
        playerDao.create(player);
        if (player.getClubId() != null) {
            Club club = clubDao.read(player.getClubId());
            player.setClubName(club.getName());
            club.addPlayerId(player.getId());
            clubDao.update(club);
        }
        List<Club> clubList = clubDao.getAll();
        model.addAttribute("clubList", clubList);
        model.addAttribute("result", "Player " + player + " is added");
        return "addPlayer";
    }

    @RequestMapping(value = "editPlayer", method = RequestMethod.GET)
    public ModelAndView setEditPlayerForm(@RequestParam String playerId) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("editPlayer");
        mav.addObject("clubList", clubDao.getAll());
        mav.addObject("editPlayer", playerDao.read(playerId));
        return mav;
    }

    @RequestMapping(value = "editPlayer", method = RequestMethod.POST)
    public ModelAndView editPlayer(@ModelAttribute Player player) {
        playerDao.update(player);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("editPlayer");
        mav.addObject("clubList", clubDao.getAll());
        mav.addObject("result", "Player " + player + " is edited");
        return mav;
    }
}