package fr.mycomp.competences;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class EquipeRepository {

    private RestTemplate restTemplate = new RestTemplate();
    public void addToEquipe(Competence competence) {
        if(competence != null && competence.getEquipeId() != null) {
            String url = "http://localhost:3000/api/equipes/"+competence.getEquipeId()+"/competences";
            restTemplate.put(
                    url
                    , competence, Void.class);
        }
    }
    
    public void removeToEquipe(Competence competence) {
        if(competence != null && competence.getEquipeId() != null) {
            String url = "http://localhost:3000/api/equipes/"+competence.getEquipeId()+"/competences/"+competence.getId();
            restTemplate.delete(
                    url
                    , competence, Void.class);
        }
    }
    
}
