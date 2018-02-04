package storyManager.repos;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import storyManager.tables.Story;

public interface StoryRepository extends CrudRepository<Story, Long>, QueryDslPredicateExecutor<Story> {

}

