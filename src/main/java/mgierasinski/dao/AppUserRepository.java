package mgierasinski.dao;

import mgierasinski.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByEmail(String email);
    AppUser findByUserId(long id);
    AppUser findByLogin(String login);

    @Transactional
    @Modifying
    @Query(value = "update usercharacter uc set uc.userLvl=:newLevel where uc.userId=:userId ",nativeQuery = true)
    void lvlAdvanced(@Param("newLevel") long newLevel, @Param("userId") long userId);
}


