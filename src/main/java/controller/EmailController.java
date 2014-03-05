package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import formulaire.Email;

@Controller
@RequestMapping("email")
public class EmailController {

	@Autowired
	@Qualifier(value = "senderMail")
	private JavaMailSenderImpl mailSender;

	@RequestMapping
	public String index(final ModelMap model) {
		model.addAttribute("email", new Email());
		return "email";
	}

	@RequestMapping("sendMail")
	public String sendMail(final @ModelAttribute Email email) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(email.getFrom());
		message.setTo(email.getTo());
		message.setSubject(email.getSubject());
		message.setText(email.getMessage());
		mailSender.send(message);

		return "json";
	}

}
