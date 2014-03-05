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
import org.springframework.web.bind.annotation.RequestMethod;

import services.IPersonneService;
import validator.FormulaireValidator;
import formulaire.FormulaireBean;

/**
 * 
 * @author joseph
 *
 */
@Controller
@RequestMapping("createPersonne")
public class CreateController {

	@Autowired
	private IPersonneService service;

	@Autowired
	private FormulaireValidator formulaireValidator;

	protected static Logger logger = Logger.getLogger("CreateController");

	/**
	 * @param binder
	 */
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
	
	/**
	 * 
	 * @param formulaireBean
	 * @param result
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String create(
			final @ModelAttribute("formulaireBean") @Valid FormulaireBean formulaireBean,
			final BindingResult result, final ModelMap model) {

		formulaireValidator.validate(formulaireBean, result);

		model.addAttribute("personnes", service.findAllPersonne());

		if (result.hasErrors()) {
			return "personne";
		}
		logger.info("[=== Entrer dans la fonction create() ===]");

		System.out.println("BONJOUR LES GARDS");
		// this.service.createPersonne(formulaireBean.getPersonneDO());

		logger.info("[=== Entrer dans la fonction create() ===]");

		model.addAttribute("formulaireBean", new FormulaireBean());

		return "personne";
	}

}
