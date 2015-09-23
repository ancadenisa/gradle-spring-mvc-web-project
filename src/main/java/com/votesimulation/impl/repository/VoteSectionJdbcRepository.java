package com.votesimulation.impl.repository;

import com.votesimulation.impl.entities.VoteSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anca on 24-Aug-15.
 */
@Repository
public class VoteSectionJdbcRepository {

    private DataSource dataSource;

    /**
     * Sets the data source this repository will use to load vote sections
     * @param dataSource the data source
     */
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<VoteSection> findAllVoteSections(){
        String sql = "select ID, CITY, STREET, NUMBER from VOTE_SECTION";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<VoteSection> voteSectionList = new ArrayList<>();
        DataSource dataSource = this.dataSource;
        try{
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                VoteSection vs = mapVoteSection(rs);
                voteSectionList.add(vs);
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    // Close to prevent database cursor exhaustion
                    rs.close();
                } catch (SQLException ex) {
                }
            }
            if (ps != null) {
                try {
                    // Close to prevent database cursor exhaustion
                    ps.close();
                } catch (SQLException ex) {
                }
            }
            if (conn != null) {
                try {
                    // Close to prevent database connection exhaustion
                    conn.close();
                } catch (SQLException ex) {
                }
            }
        }
        return voteSectionList;
    }

    private VoteSection mapVoteSection(ResultSet rs) throws  SQLException{
        Integer id = Integer.parseInt(rs.getString("ID"));
        String city = rs.getString("CITY");
        String street = rs.getString("STREET");
        Integer number = Integer.parseInt(rs.getString("NUMBER"));
        return new VoteSection(id, city, street, number);
    }
}
