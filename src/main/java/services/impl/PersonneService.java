package services.impl;

import java.util.ArrayList;
import java.util.List;

import model.AmiDO;
import model.PersonneDO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import services.IPersonneService;
import bean.Ami;
import bean.Personne;
import dao.IPersonneDAO;

@Service
@Transactional
public class PersonneService implements IPersonneService {

	@Autowired
	private IPersonneDAO personneDAO;

	@Override
	public void createPersonne(final PersonneDO personneDO) {

		this.personneDAO.createPersonne(this.convertModelToBean(personneDO));

	}

	@Override
	public void deletePersonne(final PersonneDO personneDO) {

		this.personneDAO.deletePersonne(this.convertModelToBean(personneDO));
	}

	@Override
	public void deleterPersonneById(final Integer IdPersonne) {

		this.personneDAO.deleterPersonneById(IdPersonne);
	}

	@Override
	public void updatePersonne(final Integer idPersonne,
			final PersonneDO personneDO) {
		this.personneDAO.updatePersonne(idPersonne,
				this.convertModelToBean(personneDO));
	}

	@Override
	public void addFriendsToPersonne(final PersonneDO personneDo,
			final int IdFriend) {
		final PersonneDO personne = this.convertBeanToModel(this.personneDAO
				.findPersonneById(personneDo.getIdPersonne()));
		this.personneDAO.addFriendsToPersonne(
				this.convertModelToBean(personne), IdFriend);
	}

	@Override
	public PersonneDO findPersonneById(final Integer idPersonne) {
		return this.convertBeanToModel(this.personneDAO
				.findPersonneById(idPersonne));
	}

	@Override
	public List<PersonneDO> findAllPersonne() {
		final List<PersonneDO> personneDOs = new ArrayList<PersonneDO>();

		for (Personne personne : this.personneDAO.findAllPersonne()) {
			personneDOs.add(this.convertBeanToModel(personne));
		}

		return personneDOs;
	}

	/**
	 * Permet de convertir un model PersonneDO en un Bean Personne
	 * 
	 * @param personneDO
	 * @return
	 */
	private final Personne convertModelToBean(final PersonneDO personneDO) {
		final Personne personne = new Personne();

		personne.setIdPersonne(personneDO.getIdPersonne());
		personne.setNom(personneDO.getNom());
		personne.setDateNaissance(personneDO.getDateNaissance());

		return personne;
	}

	/**
	 * Permet de convertir un model Personne en un Bean PersonneDO
	 * 
	 * @param personneDO
	 * @return
	 */
	private final PersonneDO convertBeanToModel(final Personne personne) {
		final PersonneDO personneDO = new PersonneDO();
		final List<AmiDO> amiDOs = new ArrayList<AmiDO>();
		personneDO.setIdPersonne(personne.getIdPersonne());
		personneDO.setNom(personne.getNom());
		personneDO.setDateNaissance(personne.getDateNaissance());
		for (final Ami ami : personne.getAmis()) {
			amiDOs.add(new AmiDO(ami.getId(), ami.getIdFriend(), personneDO));
		}
		return personneDO;
	}
}
