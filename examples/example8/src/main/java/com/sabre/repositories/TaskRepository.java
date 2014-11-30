package com.sabre.repositories;

import com.sabre.entities.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Michal
 * 2014-11-18.
 */

public interface TaskRepository extends CrudRepository<Task, Long> {

    public List<Task> findByDone(Boolean done);

    @Query("select t from Task t where t.description like %?1%")
    public List<Task> getByDescriptionLike(String search);
}
