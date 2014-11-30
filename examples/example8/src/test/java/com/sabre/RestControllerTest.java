package com.sabre;

import com.sabre.entities.Task;
import com.sabre.repositories.TaskRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Michal
 * 2014-11-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationReady.class)
public class RestControllerTest {
    @Autowired
    TaskRepository repository;

    @Test
    public void testFindEntitiesWithDoInDescription() throws Exception {
        List<Task> aDo = repository.getByDescriptionLike("Do");
        assertThat(aDo.size(), equalTo(2));
    }
}
