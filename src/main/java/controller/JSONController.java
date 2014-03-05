package controller;

import java.util.Calendar;
import java.util.GregorianCalendar;

import model.PersonneDO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JSONController {

	@RequestMapping("/json")
	public @ResponseBody
	PersonneDO index(
			final @RequestParam(value = "name", required = false, defaultValue = "joseph") String name) {
		final PersonneDO personneDO = new PersonneDO();
		personneDO.setNom(name);
		personneDO.setIdPersonne(1);
		personneDO.setDateNaissance(new GregorianCalendar(2014,
				Calendar.FEBRUARY, 18).getTime());
		return personneDO;
	}
}
