package cd2tec.JavaTest.repositories;

import cd2tec.JavaTest.models.EntregaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EntregaRepository extends JpaRepository<EntregaModel, UUID> {
}
