package mgierasinski.service;

import mgierasinski.domain.Profession;

import java.util.List;

public interface ProfessionService {

    void addProfession(Profession profession);
    void editProfession(Profession profession);
    List<Profession> listProfessions();

    void removeProfession(long professionId);
    Profession findByProfessionName(String professionName);
    Profession findById(long id);

}
