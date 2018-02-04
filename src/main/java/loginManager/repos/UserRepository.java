package loginManager.repos;

import com.querydsl.core.types.Predicate;
import loginManager.tables.User;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete



public interface UserRepository extends CrudRepository<User, Long>, QueryDslPredicateExecutor<User> {

    public List<User> findAll(Predicate predicate);
}

