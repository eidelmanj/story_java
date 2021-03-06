package server.loginManager.repos;

import server.loginManager.tables.Session;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface SessionRepository extends CrudRepository<Session, Long>, QueryDslPredicateExecutor<Session> {

}

