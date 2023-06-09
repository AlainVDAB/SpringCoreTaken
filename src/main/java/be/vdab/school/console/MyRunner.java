package be.vdab.school.console;

import be.vdab.school.exceptions.RepositoryException;
import be.vdab.school.repository.LeerlingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    private final LeerlingRepository leerlingRepository;

    public MyRunner(LeerlingRepository leerlingRepository) {
        this.leerlingRepository = leerlingRepository;
    }

    @Override
    public void run(String... args) {
        try {
            leerlingRepository.findAll()
                    .forEach(leerling-> System.out.println(leerling.getVoornaam()));
        } catch (RepositoryException ex){
            ex.printStackTrace(System.err);
        }
    }
}
