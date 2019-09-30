package mgierasinski.service;

import mgierasinski.dao.ProfessionRepository;
import mgierasinski.domain.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Blob;
import java.util.List;

@Service
public class ProfessionServiceImpl implements ProfessionService {


    private JdbcTemplate jdbcTemp;

    public ProfessionServiceImpl(DataSource dataSource) {
        jdbcTemp = new JdbcTemplate(dataSource);
    }

    @Autowired
    ProfessionRepository professionRepository;

    @Override
    public void addProfession(Profession profession) {
        professionRepository.save(profession);
    }

    @Override
    public void editProfession(Profession profession) {
        professionRepository.save(profession);
    }

    @Override
    public List<Profession> listProfessions() {
        return  professionRepository.findAll();
    }

    @Override
    public void removeProfession(long professionId) {
        professionRepository.delete(professionId);
    }

    @Override
    public Profession findByProfessionName(String professionName) {
        return professionRepository.findByProfessionName(professionName);
    }

    @Override
    public Profession findById(long id) {
        return professionRepository.findByProfessionId(id);
    }

    @Transactional
    public Blob getPhotoById(long id) {

        String query = "select p.professionPicture from profession p where p.professionId=?";

        Blob photo = jdbcTemp.queryForObject(query, new Object[] { id }, Blob.class);

        return photo;
    }
}
