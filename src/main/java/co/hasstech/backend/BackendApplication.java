package co.hasstech.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
    CommandLineRunner probarConexionBD(DataSource dataSource) {
		return args -> {
			try (var conexion = dataSource.getConnection()) {
				System.out.println("✅ ¡CONEXIÓN EXITOSA A SQL SERVER!: " + conexion.getMetaData().getDatabaseProductName());
			} catch (Exception e) {
				System.err.println("❌ ERROR AL CONECTAR CON LA BASE DE DATOS: " + e.getMessage());
			}
		};
	}

}
