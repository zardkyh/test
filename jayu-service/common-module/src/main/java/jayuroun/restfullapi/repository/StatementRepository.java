package jayuroun.restfullapi.repository;

import jayuroun.restfullapi.entity.Statement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatementRepository extends JpaRepository<Statement, Long>, StatementCommon {

}
