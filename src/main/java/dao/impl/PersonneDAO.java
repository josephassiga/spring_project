package dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bean.Ami;
import bean.Personne;
import dao.IPersonneDAO;

/**
 * @author joseph
 */
@Repository
public class PersonneDAO implements IPersonneDAO {

	@PersistenceContext(unitName = "JPA_UNIT")
	private EntityManager entityManager;

	@Override
	@Transactional("transactionManager")
	public void createPersonne(final Personne personne) {

		this.entityManager.persist(personne);
	}

	@Override
	@Transactional("transactionManager")
	public void deletePersonne(final Personne personneDO) {

		this.entityManager.remove(personneDO);
	}

	@Override
	@Transactional("transactionManager")
	public void deleterPersonneById(final Integer IdPersonne) {

		final Personne personneDO = this.entityManager.find(Personne.class,
				IdPersonne);
		if (personneDO != null) {
			this.deletePersonne(personneDO);
		}
	}

	@Override
	@Transactional("transactionManager")
	public void updatePersonne(final Integer idPersonne,
			final Personne personneDO) {
		final Personne personne = this.entityManager.find(Personne.class,
				idPersonne);
		if (personne != null) {
			personne.setNom(personneDO.getNom());
			personne.setIdPersonne(personneDO.getIdPersonne());
			personne.setDateNaissance(personneDO.getDateNaissance());
			this.entityManager.merge(personne);
		}
	}

	@Override
	@Transactional("transactionManager")
	public List<Personne> findAllPersonne() {
		@SuppressWarnings("unchecked")
		List<Personne> personneDOs = (List<Personne>) this.entityManager
				.createNamedQuery("Personne.findAll").getResultList();

		return personneDOs;
	}

	@Override
	@Transactional("transactionManager")
	public List<Personne> findFriendsOfPersonneById(final Integer idPersonne) {

		Personne personneDO = this.entityManager.find(Personne.class,
				idPersonne);

		List<Personne> personneDOs = new ArrayList<Personne>();

		for (Ami amiDO : personneDO.getAmis()) {
			personneDOs.add(this.entityManager.find(Personne.class,
					amiDO.getIdFriend()));
		}

		return personneDOs;
	}

	@Override
	@Transactional("transactionManager")
	public List<Personne> findFriendOfPersonne(final Personne personneDO) {
		return this.findFriendsOfPersonneById(personneDO.getIdPersonne());
	}

	@Override
	@Transactional("transactionManager")
	public void addFriendsToPersonne(Personne personne, int IdFriend) {
		final Ami ami = new Ami();
		ami.setIdFriend(IdFriend);
		ami.setPersonne(personne);
		this.entityManager.merge(ami);

	}

	@Override
	@Transactional("transactionManager")
	public Personne findPersonneById(Integer idPersonne) {
		final Personne personneDO = this.entityManager.find(Personne.class,
				idPersonne);
		return personneDO;
	}
}
