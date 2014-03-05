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
import formulaire.FormulaireBean;

@Controller
@RequestMapping("addFriend")
public class AddFriendController {

	@Autowired
	private IPersonneService service;

	protected static Logger logger = Logger.getLogger("AddFriendController");

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
	public String addFriend(
			final @ModelAttribute("formulaireBean") @Valid FormulaireBean formulaireBean,
			final BindingResult result, final ModelMap model) {

		logger.info("[=== Entrer dans la fonction addFriend() ===]");

		// this.service.addFriendsToPersonne(formulaireBean.getPersonneDO(),
		// formulaireBean.getFriendDO().getIdPersonne());

		logger.info("[=== Entrer dans la fonction addFriend() ===]");

		model.addAttribute("formulaireBean", new FormulaireBean());
		model.addAttribute("personnes", service.findAllPersonne());

		return "personne";
	}

}
