package codeDev.io.ogrenciBasvuru.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public interface ModelMapperService {
ModelMapper forRequest();
ModelMapper forResponse();
}
