package fr.mycomp.competences;

import org.springframework.stereotype.Service;

@Service
public class CompetenceService {

    private final CompetenceRepository competenceRepository;
    private final EquipeRepository equipeRepository;

    public CompetenceService(CompetenceRepository competenceRepository, EquipeRepository equipeRepository) {
        this.competenceRepository = competenceRepository;
        this.equipeRepository = equipeRepository;
    }

    public Competence createCompetence(Competence competence) {
        Competence newCompetence = competenceRepository.save(competence);
        equipeRepository.addToEquipe(newCompetence);
        return newCompetence;
    }

    public Competence getCompetence(String id) {
        return competenceRepository.findById(id).orElseThrow();
    }

    public Competence updateCompetence(Competence competence) {
        return competenceRepository.save(competence);
    }

    public void deleteCompetence(String id) {
        Competence competence = getCompetence(id);
        equipeRepository.removeToEquipe(competence);
        competenceRepository.deleteById(id);
    }

    public Iterable<Competence> getAllCompetences() {
        return competenceRepository.findAll();
    }

    public Competence patchCompetence(String id, Competence competence) {
        String competenceId = id != null ? id : competence.getId();
        Competence competenceToUpdate = getCompetence(competenceId);
        if (competence.getNom() != null) {
            competenceToUpdate.setNom(competence.getNom());
        }
        if(competence.getDescription() != null) {
            competenceToUpdate.setDescription(competence.getDescription());
        }
        return updateCompetence(competenceToUpdate);
    }
    
}
