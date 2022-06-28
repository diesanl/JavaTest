package cd2tec.JavaTest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "Api de consulta frete", description = "API de teste p vaga na cd2tec (Já passou o prazo, eu sei.)"),
		servers = {
				@Server(url = "http://localhost:8080")
		}
)
public class JavaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaTestApplication.class, args);
	}

}
