package jayuroun.restfullapi.service;

import jayuroun.restfullapi.repository.MsgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MsgService {



}
