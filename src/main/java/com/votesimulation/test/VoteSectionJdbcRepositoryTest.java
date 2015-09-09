package com.votesimulation.test;

import com.votesimulation.impl.entities.VoteSection;
import com.votesimulation.impl.repository.VoteSectionJdbcRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Anca on 24-Aug-15.
 */
public class VoteSectionJdbcRepositoryTest {
    private VoteSectionJdbcRepository voteSectionJdbcRepository;

    @Before
    public void setUp() throws  Exception{
        //simulate the spring bean initialization lifecycle
        // first, construct the bean
        voteSectionJdbcRepository = new VoteSectionJdbcRepository();

        // then, inject its dependencies
        voteSectionJdbcRepository.setDataSource(createTestDataSource());

    }

    @Test
    public void testFindAllVoteSections(){
        List<VoteSection> voteSectionList = voteSectionJdbcRepository.findAllVoteSections();
        assertNotNull("Vote section list is null - process of population went bad", voteSectionList);
        assertEquals("VoteSection city is wrong", "Bucuresti", voteSectionList.get(0).getCity());
        assertEquals("VoteSection street is wrong", "Mariuca", voteSectionList.get(1).getStreet());
        assertEquals("VoteSection number is wrong", Integer.valueOf(5), voteSectionList.get(2).getNumber());
    }

    private DataSource createTestDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setName("rewards")
                .addScript("/com/votesimulation/test/schema.sql")
                .addScript("/com/votesimulation/test/test-data.sql")
                .build();
    }
}
