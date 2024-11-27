package me.umar.repositories;

import me.umar.models.cleintsystem.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findByNameLike(String name);

    List<Client> findByNameLikeAndSurnameLike(String name, String surname);

    List<Client> findByNameLikeAndSurnameLikeAndAgeBetween(String name, String surname, Integer minAge, Integer maxAge);
}
