package com.luxoft.vklinduhov.football.mvc;

import com.luxoft.vklinduhov.football.dao.impl.ClubDaoImpl;
import com.luxoft.vklinduhov.football.dao.impl.PlayerDaoImpl;
import com.luxoft.vklinduhov.football.dao.impl.TournamentDaoImpl;
import com.luxoft.vklinduhov.football.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Herta on 02.06.2014.
 *
 */
@Controller
public class SimpleService {
    @Autowired
    private UserDaoImpl userDao;

    @Autowired
    private ClubDaoImpl clubDao;

    @Autowired
    private PlayerDaoImpl playerDao;

    @Autowired
    private TournamentDaoImpl tournamentDao;
}
