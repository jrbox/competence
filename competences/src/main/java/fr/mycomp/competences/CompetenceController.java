package fr.mycomp.competences;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/competences")
public class CompetenceController {

    private final CompetenceService competenceService;

    public CompetenceController(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }

  @GetMapping("")
    public Iterable<Competence> getAllCompetences() {
        return competenceService.getAllCompetences();
    }

    @PostMapping("")
    public Competence createCompetence(@RequestBody Competence competence) {
        return competenceService.createCompetence(competence);
    }

    @GetMapping("/{id}")
    public Competence getCompetence(@PathVariable String id) {
        return competenceService.getCompetence(id);
    }

    @PutMapping("/{id}")
    public Competence updateCompetence(@RequestBody Competence competence) {
        return competenceService.updateCompetence(competence);
    }

    @PatchMapping("/{id}")
    public Competence patchCompetence(@PathVariable String id, @RequestBody Competence competence) {
        return competenceService.patchCompetence(id, competence);
    }

    @DeleteMapping("/{id}")
    public void deleteCompetence(@PathVariable String id) {
        competenceService.deleteCompetence(id);
    }
    
}
