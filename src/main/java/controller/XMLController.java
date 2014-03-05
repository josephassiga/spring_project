package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import model.PersonneDO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class XMLController {

	@RequestMapping(value = "xml")
	public @ResponseBody
	PersonneDO index(
			final @RequestParam(value = "name", required = false, defaultValue = "joseph") String name) {
		final Date date = new Date();
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"dd/MM/YYYY", Locale.FRANCE);

		final PersonneDO bean = new PersonneDO();
		bean.setIdPersonne(1);
		bean.setNom(name);
		try {
			bean.setDateNaissance(simpleDateFormat.parse(simpleDateFormat
					.format(date)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return bean;
	}
}
