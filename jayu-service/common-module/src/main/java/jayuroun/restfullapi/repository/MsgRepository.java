package jayuroun.restfullapi.repository;

import jayuroun.restfullapi.entity.Msg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MsgRepository extends JpaRepository<Msg, Long>, MsgCommon {

    // Native Query(EXEC)를 이용한 프로시저 실행 방법
    // Output Parameter를 가져올 방법이 없다...
    @Query( nativeQuery=true, value="DECLARE @RETCODE INTEGER; EXEC GETALL @RETCODE OUTPUT;" )
    List<Msg> sp_getall();

    @Query( nativeQuery=true, value="EXEC INIT_DATA" )
    List<Msg> sp_initdata();

}
