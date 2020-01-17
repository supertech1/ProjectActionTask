package com.example.projectapi.apicode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.projectapi.apicode.entities.Action;

@Repository("actionRepository")
public interface ActionRepository extends CrudRepository<Action, Long> {
	@Query(value = "SELECT * FROM action AS a WHERE project_id=:project_id", nativeQuery= true)
	List<Action> getSetOfActionsForAProject(@Param("project_id") int project_id);

}
