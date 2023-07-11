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
		Evento ev1 = new Evento("Evento 1", LocalDate.of(2000, 6, 11), "Primo evento", TipoEvento.PRIVATO, 60);

		EventoDAO dao = new EventoDAO(JpaUtil.getEntityManagerFactory().createEntityManager());

		dao.save(ev1);
		dao.refresh(ev1);
		log.info("Lettura tabella eventi: " + dao.getById(ev1.getId()));

	}

}
