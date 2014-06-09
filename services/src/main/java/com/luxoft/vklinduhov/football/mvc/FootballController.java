package com.luxoft.vklinduhov.football.mvc;

import com.luxoft.vklinduhov.football.beans.*;
import com.luxoft.vklinduhov.football.dao.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
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

    @Autowired
    private SeasonDaoImpl seasonDao;


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

    @RequestMapping(value = "generateTournamentData", method = RequestMethod.GET)
    public ModelAndView generateTournamentData(@RequestParam String tournamentId) {
        ModelAndView modelAndView = showTournaments();
        generateTournament(tournamentId);
        modelAndView.addObject("result", "Data has been generated for " + tournamentDao.read(tournamentId).getName());
        return modelAndView;
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
        mav.addObject("tournament", tournament);
        ArrayList<Club> clubs = new ArrayList<Club>();
        for (int i = 0; i < tournament.getAllClubsId().size(); i++) {
            clubs.add(clubDao.read(tournament.getAllClubsId().get(i)));
        }
        mav.addObject("allClubs", clubs);
        return mav;
    }

    @RequestMapping(value = "seasonResult", method = RequestMethod.GET)
    public ModelAndView seasonResult(@RequestParam String tournamentId) {
        ModelAndView mav = new ModelAndView();

        Tournament tournament = tournamentDao.read(tournamentId);
        Season season = seasonDao.readByTournament(tournamentId);
        if (season == null) {
            season = new Season();
            season.setYears(createYears());
            season.setTournamentId(tournamentId);
            season.setTourList(generateTours(tournamentId));
        }

        mav.addObject("tournament", tournament);
        mav.addObject("season", season);
        mav.addObject("seasonResultList", createSeasonResultList(tournament, season.getTourList()));
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

    @RequestMapping(value = "clubInfo", method = RequestMethod.GET)
    public ModelAndView clubInfo(@RequestParam String clubId) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("clubInfo");
        Club club = clubDao.read(clubId);
        mav.addObject("club", club);
        List<Player> players = new ArrayList<Player>();
        for (int i = 0; i < club.getAllPlayersId().size(); i++) {
            players.add(playerDao.read(club.getAllPlayersId().get(i)));
        }
        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.getPosition().compareTo(o2.getPosition());
            }
        });
        mav.addObject("allPlayers", players);
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


    private static final String[] POSITION_LIST = {"Goalkeeper", "Defender", "Midfielder", "Forward"};

    public Club generateClub(Tournament tournament, int i) {
        Club newClub = new Club();
        newClub.setName("Club" + (i+1));
        newClub.setTournamentId(tournament.getId());
        newClub.setTournamentName(tournament.getName());
        newClub.setFoundDate(generateRandDate(1900, 2010));
        clubDao.create(newClub);
        int playersCount = randBetween(23, 40);
        for (int j = 0; j < playersCount; j++) {
            Player player = generatePlayer(newClub, j);
            playerDao.create(player);
            newClub.addPlayerId(player.getId());
            clubDao.update(newClub);
        }
        return newClub;
    }

    public Player generatePlayer(Club newClub, int j) {
        Player newPlayer = new Player();
        newPlayer.setName("Player" + (j+1));
        newPlayer.setBirthsDay(generateRandDate(1975, 1998));
        newPlayer.setClubName(newClub.getName());
        newPlayer.setClubId(newClub.getId());
        newPlayer.setPosition(POSITION_LIST[new Random().nextInt(POSITION_LIST.length)]);
        int height = randBetween(170, 195);
        newPlayer.setHeight(String.valueOf(height));
        int weight = height - randBetween(100, 110);
        newPlayer.setWeight(String.valueOf(weight));
        return newPlayer;
    }

    public String generateRandDate(int start, int end) {
        GregorianCalendar gc = new GregorianCalendar();

        int year = randBetween(start, end);

        gc.set(gc.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        return new SimpleDateFormat("dd/MM/yyyy").format(gc.getTime()).toString();
    }

    public int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public String createYears() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        String firstYear = new SimpleDateFormat("yyyy").format(calendar.getTime());
        calendar.add(Calendar.YEAR, 1);
        String secondYear = new SimpleDateFormat("yyyy").format(calendar.getTime());
        return firstYear + " - " + secondYear;
    }

    public List<List<Game>> generateTours(String tournamentId) {
        if (tournamentId == null) {
            return Collections.emptyList();
        }

        List<String> clubsId = tournamentDao.read(tournamentId).getAllClubsId();
        List<List<Game>> tourList = new ArrayList<List<Game>>(clubsId.size() - 1);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        generateFirstCircle(clubsId, tourList, calendar);
        calendar.add(Calendar.MONTH, 1);
        generateSecondCircle(clubsId, tourList, calendar);

        return tourList;
    }

    public void generateSecondCircle(List<String> clubsId, List<List<Game>> tourList, Calendar calendar) {
        for (int i = 0; i < clubsId.size() - 1; i++) {
            ArrayList<Game> gameListForTour = new ArrayList<Game>();
            for (int j = 0; j < clubsId.size() / 2; j++) {
                if (clubsId.size() % 2 == 1 && j == clubsId.size() / 2 - 1) {
                    break;
                }
                Game game = new Game(clubsId.get(clubsId.size() - 1 - j), clubsId.get(j));
                game.setDate(new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
                game.setClubHomeName(clubDao.read(clubsId.get(clubsId.size() - 1 - j)).getName());
                game.setClubAwayName(clubDao.read(clubsId.get(j)).getName());
                generateGamesResult(game);
                gameListForTour.add(game);
            }
            tourList.add(gameListForTour);
            shiftIds(clubsId);
            calendar.add(Calendar.WEEK_OF_YEAR, 1);
        }
    }

    public void generateFirstCircle(List<String> clubsId, List<List<Game>> tourList, Calendar calendar) {
        for (int i = 0; i < clubsId.size() - 1; i++) {
            ArrayList<Game> gameListForTour = new ArrayList<Game>();
            for (int j = 0; j < clubsId.size() / 2; j++) {
                if (clubsId.size() % 2 == 1 && j == clubsId.size() / 2 - 1) {
                    break;
                }
                Game game = new Game(clubsId.get(j), clubsId.get(clubsId.size() - 1 - j));
                game.setDate(new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
                game.setClubHomeName(clubDao.read(clubsId.get(j)).getName());
                game.setClubAwayName(clubDao.read(clubsId.get(clubsId.size() - 1 - j)).getName());
                generateGamesResult(game);
                gameListForTour.add(game);
            }
            tourList.add(gameListForTour);
            shiftIds(clubsId);
            calendar.add(Calendar.WEEK_OF_YEAR, 1);
        }
    }

    public void shiftIds(List<String> clubsId) {
        String removed = clubsId.remove(1);
        clubsId.add(removed);
    }

    public void generateGamesResult(Game game) {
        Integer hgoals = new Random().nextInt(5);
        String homeGoals = String.valueOf(hgoals);
        Integer agoals = new Random().nextInt(5);
        String awayGoals = String.valueOf(agoals);

        game.setHomeGoals(homeGoals);
        game.setAwayGoals(awayGoals);
    }

    public List<SeasonResult> createSeasonResultList(Tournament tournament, List<List<Game>> tourList) {
        List<SeasonResult> seasonResultList = new ArrayList<SeasonResult>(tournament != null ? tournament.getAllClubsId().size() : 0);

        if (tournament != null && tournament.getAllClubsId() != null) {
            for (String clubId : tournament.getAllClubsId()) {
                Club club = clubDao.read(clubId);
                SeasonResult seasonResult = new SeasonResult(tourList, club.getId(), club.getName());
                seasonResultList.add(seasonResult);
            }
        }

        Collections.sort(seasonResultList, new Comparator<SeasonResult>() {
            @Override
            public int compare(SeasonResult seasonResult1, SeasonResult seasonResult2) {
                int compared = seasonResult1.getPoints().compareTo(seasonResult2.getPoints());
                if (compared == 0) {
                    compared = seasonResult1.getGoalDifference().compareTo(seasonResult2.getGoalDifference());
                }
                if (compared == 0) {
                    compared = seasonResult1.getGoalScored().compareTo(seasonResult2.getGoalScored());
                }
                if (compared == 0) {
                    compared = 1;
                }
                return -compared;
            }
        });
        return seasonResultList;
    }

    public void generateTournament(String tournamentId) {
        clearData(tournamentId);
        Tournament tournament = tournamentDao.read(tournamentId);
        for (int i = 0; tournament != null && i < Integer.valueOf(tournament.getMembersCount()); i++) {
            Club newClub = generateClub(tournament, i);
            tournament.addClubId(newClub.getId());
            tournamentDao.update(tournament);
        }
    }

    public void clearData(String tournamentId) {
        Tournament tournament = tournamentDao.read(tournamentId);
        List<String> clubList = tournament.getAllClubsId();
        for (String clubId : clubList) {
            Club club = clubDao.read(clubId);
            if(club != null){
                for (String playerId : club.getAllPlayersId()) {
                    playerDao.delete(playerId);
                }
            }
            clubDao.delete(clubId);
        }
        tournament.setClubListId(null);
        tournamentDao.update(tournament);
    }
}