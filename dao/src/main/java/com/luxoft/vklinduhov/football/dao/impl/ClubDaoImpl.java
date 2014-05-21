package com.luxoft.vklinduhov.football.dao.impl;

import com.luxoft.vklinduhov.football.beans.Club;
import com.luxoft.vklinduhov.football.dao.ClubDao;
import com.luxoft.vklinduhov.football.dao.mapper.ClubRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository(value = "clubDao")
@Transactional
public class ClubDaoImpl implements ClubDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private ClubDaoImpl() {
    }

    @Override
    public void addClub(Club club) {
        jdbcTemplate.execute("insert into clubs(name) values (" + "'" + club.getName() + "'" + ");");
    }

    @Override
    public void removeClubById(int id) {
        jdbcTemplate.execute("DELETE FROM clubs WHERE id=" + id + ";");
    }

    @Override
    public Club getClubById(int id) {
        List<Club> clubList = jdbcTemplate.query("SELECT * FROM clubs WHERE id=" + id + ";", new ClubRowMapper());
        if (!clubList.isEmpty()) {
            return clubList.get(0);
        }
        return null;
    }

    @Override
    public void editClub(Club editClub) {

        Club clubFromDb = getClubById(editClub.getId());

        if (clubFromDb != null) {
            clubFromDb.setName(editClub.getName());
            jdbcTemplate.execute("UPDATE clubs SET name ='" + editClub.getName() + "' WHERE id=" + editClub.getId() + ";");
        }
    }

    @Override
    public List<Club> getAllClubs() {
        return jdbcTemplate.query("SELECT * FROM clubs;", new ClubRowMapper());
    }
}
