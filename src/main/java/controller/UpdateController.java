package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import services.IPersonneService;
import validator.FormulaireValidator;
import formulaire.FormulaireBean;

@Controller
@RequestMapping("updatePersonne")
public class UpdateController {

	@Autowired
	private IPersonneService service;

	@Autowired
	private FormulaireValidator formulaireValidator;

	protected static Logger logger = Logger.getLogger("UpdateController");

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYY");
		dateFormat.setLenient(false);

		/**
		 * true passed to CustomDateEditor constructor means convert empty
		 * String to null
		 */
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	@RequestMapping
	public String update(
			final @ModelAttribute("formulaireBean") @Valid FormulaireBean formulaireBean,
			final BindingResult result, final ModelMap model) {

		logger.info("[=== Entrer dans la fonction update() ===]");

		formulaireValidator.validate(formulaireBean, result);

		if (result.hasErrors()) {
			return "personne";
		}
		// this.service.updatePersonne(formulaireBean.getPersonneDO()
		// .getIdPersonne(), formulaireBean.getPersonneDO());

		logger.info("[=== Entrer dans la fonction update() ===]");

		model.addAttribute("formulaireBean", new FormulaireBean());
		model.addAttribute("personnes", service.findAllPersonne());
		return "personne";
	}

}
