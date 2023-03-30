package be.vdab.school.repository;

import be.vdab.school.domain.Leerling;
import be.vdab.school.exceptions.RepositoryException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
public class LeerlingRepository {
    public List<Leerling> findAll(){
        try (var stream = Files.lines(Path.of("/data/leerlingen.csv"))) {
            return stream
                    .map(regel -> regel.split(",")) // regel splitsen in zijn onderdelen
                    .map(onderdelen->
                            new Leerling(Long.parseLong(onderdelen[0]),onderdelen[1],onderdelen[2]))
                    .toList();
        } catch (IOException | ArrayIndexOutOfBoundsException |
                 NumberFormatException ex) {
            throw new RepositoryException(ex);
        }

    }

}
