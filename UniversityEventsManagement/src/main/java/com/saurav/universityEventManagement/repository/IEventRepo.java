package com.saurav.universityEventManagement.repository;
import com.saurav.universityEventManagement.model.EventModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IEventRepo extends CrudRepository<EventModel,Integer> {
}
