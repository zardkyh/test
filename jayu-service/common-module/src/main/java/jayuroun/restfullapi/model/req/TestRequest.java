package jayuroun.restfullapi.model.req;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class TestRequest {

    private long id;

    private String uid;

    private String name;
}
