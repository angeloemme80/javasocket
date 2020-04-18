package it.angelomassaro.javasocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Esempio di server web socket deployato con spring boot
 * Nel progetto esiste sia un client java (WebSocketClientTests), sia un client html(index.html sotto resources/static)
 * Il server ad ogni messaggio che arriva risponde al client con lo stesso messaggio e in più risponde a tutti i client connessi
 */

@SpringBootApplication
public class JavasocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavasocketApplication.class, args);
	}

}
