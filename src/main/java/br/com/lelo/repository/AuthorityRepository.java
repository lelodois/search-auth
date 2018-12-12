package br.com.lelo.repository;

import br.com.lelo.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorityRepository extends JpaRepository<Authority, String> {

    @Query("  SELECT u " +
            " FROM Authority u " +
            " WHERE " +
            " LOWER(u.name) = LOWER(:name)")
    Authority findByName(String name);

}