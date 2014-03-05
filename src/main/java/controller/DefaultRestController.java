package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import services.IPersonneService;
import formulaire.FormulaireBean;

@Controller
@RequestMapping("rest")
public class DefaultRestController {

	@Autowired
	private IPersonneService service;

	@RequestMapping(method = RequestMethod.GET)
	public String index(final ModelMap model) {
		model.addAttribute("formulaireBean", new FormulaireBean());
		// model.addAttribute("personnes", service.findAllPersonne());
		return "restPersonne";
	}

	@RequestMapping(value = { "/ajoutPersonne/{id}/{nom}/{date}" })
	public String get(final ModelMap model, final @PathVariable int id,
			final @PathVariable String nom, final @PathVariable String date) {
		model.addAttribute("formulaireBean", new FormulaireBean());
		// model.addAttribute("personnes", service.findAllPersonne());
		System.out.println("Ajout Personnes <--> Id : " + id + " Nom : " + nom
				+ " Date : " + date);

		return "redirect:/rest";
	}

	@RequestMapping(value = "/miseAjourPersonne/{id}/{nom}/{date}")
	public String post(final ModelMap model, final @PathVariable int id,
			final @PathVariable String nom, final @PathVariable String date) {
		model.addAttribute("formulaireBean", new FormulaireBean());
		// model.addAttribute("personnes", service.findAllPersonne());
		System.out.println("Mise A jour <--> Id : " + id + " Nom : " + nom
				+ " Date : " + date);
		return "redirect:/rest";
	}

	@RequestMapping(value = "/supprimePersonne/{id}/{nom}/{date}", method = RequestMethod.DELETE)
	public String delete(final ModelMap model, final @PathVariable int id,
			final @PathVariable String nom, final @PathVariable String date) {
		model.addAttribute("formulaireBean", new FormulaireBean());
		// model.addAttribute("personnes", service.findAllPersonne());
		System.out.println("Delete <--> Id : " + id + " Nom : " + nom
				+ " Date : " + date);
		return "redirect:/rest";
	}

	@RequestMapping(value = "/ajoutAmis/{name}", method = RequestMethod.PUT)
	public String put(final ModelMap model,
			final @PathVariable("name") String name) {
		model.addAttribute("formulaireBean", new FormulaireBean());
		// model.addAttribute("personnes", service.findAllPersonne());
		System.out.println("méthode PUT");
		return "redirect:/rest";
	}

}
