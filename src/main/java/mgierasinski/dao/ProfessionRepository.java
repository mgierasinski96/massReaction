package mgierasinski.dao;

import mgierasinski.domain.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProfessionRepository extends JpaRepository<Profession,Long> {

    Profession findByProfessionId(long id);
    Profession findByProfessionName(String professionName);
}
