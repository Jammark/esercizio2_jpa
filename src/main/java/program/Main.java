package program;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Evento;
import model.TipoEvento;
import util.EventoDAO;
import util.JpaUtil;

public class Main {

	private static final Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		Evento ev1 = new Evento("Evento 3", LocalDate.of(2001, 6, 11), "Terzo evento", TipoEvento.PRIVATO, 60);
		Evento ev2 = new Evento("Evento 2", LocalDate.of(2000, 8, 11), "Secondo evento", TipoEvento.PUBBLICO, 160);

		EventoDAO dao = new EventoDAO(JpaUtil.getEntityManagerFactory().createEntityManager());

		try {
		dao.save(ev1);
			dao.save(ev2);
		dao.refresh(ev1);
			dao.refresh(ev2);
			log.info("Lettura tabella eventi: " + dao.getById(ev2.getId()));
			dao.delete(ev1);
		} finally {
			dao.close();
			JpaUtil.close();
		}

	}

}
