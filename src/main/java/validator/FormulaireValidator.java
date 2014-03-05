package validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import formulaire.FormulaireBean;

@Component
public class FormulaireValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return FormulaireBean.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		final FormulaireBean formulaireBean = (FormulaireBean) target;

		final String nomPersone = formulaireBean.getPersonneDO().getNom();

		if ((nomPersone.isEmpty()) && (nomPersone.length() == 0)) {
			ValidationUtils.rejectIfEmpty(errors, "personneDO.nom",
					"personneDO.nom.empty");
		}

	}

}
