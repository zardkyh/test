package jayuroun.restfullapi.repository;

import jayuroun.restfullapi.entity.Msg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MsgRepository extends JpaRepository<Msg, Long>, MsgCommon {

}
