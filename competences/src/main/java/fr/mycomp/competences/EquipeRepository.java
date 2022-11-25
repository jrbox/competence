package fr.mycomp.competences;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class EquipeRepository {

    @Value("${EQUIPES_URL:http://equipes:3000/api/equipes}")
    private String equipeUrl;

    private RestTemplate restTemplate = new RestTemplate();
    public void addToEquipe(Competence competence) {
        if(competence != null && competence.getEquipeId() != null) {
            String url = equipeUrl+"/"+competence.getEquipeId()+"/competences";
            restTemplate.put(
                    url
                    , competence, Void.class);
        }
    }
    
    public void removeToEquipe(Competence competence) {
        if(competence != null && competence.getEquipeId() != null) {
            String url = equipeUrl+"/"+competence.getEquipeId()+"/competences/"+competence.getId();
            restTemplate.delete(
                    url
                    , competence, Void.class);
        }
    }
    
}
