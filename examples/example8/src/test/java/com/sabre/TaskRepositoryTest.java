package com.sabre;

import com.google.common.collect.Iterables;
import com.sabre.entities.Task;
import com.sabre.repositories.TaskRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Michal
 * 2014-11-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationReady.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class TaskRepositoryTest {
    @Autowired
    TaskRepository repository;

    @Value("${local.server.port}")
    int port;

    String endpoint;

    RestTemplate restTemplate = new RestTemplate();

    @Before
    public void before() {
        repository.deleteAll();
        endpoint = "http://localhost:"+port+"/task";
    }

    @Test
    public void testCreateEntity() throws Exception {
        Task request = new Task().withBudget(100.3).withName("Task 1").withDone(true).withDescription("Task 1 description");
        Task response = restTemplate.postForObject(endpoint, request, Task.class);

        Iterable<Task> all = repository.findAll();
        assertThat(Iterables.size(all), equalTo(1));
        Task fromDb = Iterables.getOnlyElement(all);

        assertThat(response.getId(), equalTo(fromDb.getId()));
        assertThat(response.getName(), equalTo(fromDb.getName()));
        assertThat(response.getName(), equalTo(request.getName()));
    }

    @Test
    public void testDeleteEntity() {
        Task newTask = new Task().withBudget(100.3).withName("Task 1").withDone(true).withDescription("Task 1 description");
        newTask = repository.save(newTask);

        assertThat(Iterables.size(repository.findAll()), equalTo(1));
        restTemplate.delete(endpoint+"/"+newTask.getId());
        assertThat(Iterables.size(repository.findAll()), equalTo(0));
    }


}
