package cd2tec.JavaTest.services;

import cd2tec.JavaTest.models.EntregaModel;
import cd2tec.JavaTest.repositories.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntregaService {
    @Autowired
    EntregaRepository entregaRepository;

    public EntregaModel save(EntregaModel entregaModel) {
        return entregaRepository.save(entregaModel);
    }
}
