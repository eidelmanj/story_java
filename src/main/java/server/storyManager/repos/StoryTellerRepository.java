package server.storyManager.repos;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import server.storyManager.tables.StoryTeller;

public interface StoryTellerRepository extends CrudRepository<StoryTeller, Long>, QueryDslPredicateExecutor<StoryTeller> {

}

