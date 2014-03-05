package services;

import java.util.List;

import model.PersonneDO;

import org.springframework.stereotype.Repository;

@Repository
public interface IPersonneService {
	/**
	 * Crèe une Personne connaissant l'objet personneDO
	 * 
	 * @param personneDO
	 */
	void createPersonne(final PersonneDO personneDO);

	/**
	 * Supprime une personne connaissant l'objet
	 * 
	 * @param personneDO
	 */
	void deletePersonne(final PersonneDO personneDO);

	/**
	 * Supprime une personne connaissant son Id
	 * 
	 * @param IdPersonne
	 */
	void deleterPersonneById(final Integer IdPersonne);

	/**
	 * Met à jour les informations d'une personne de idPersonne avec l'objet
	 * personneDO
	 * 
	 * @param idPersonne
	 * @param personneDO
	 */
	void updatePersonne(final Integer idPersonne, final PersonneDO personneDO);

	/**
	 * Permet d'ajouter un ami de idFriend à une personne de idPersonne.
	 * 
	 * @param IdPersonne
	 * @param IdFriend
	 */
	void addFriendsToPersonne(final PersonneDO personne, final int IdFriend);

	/**
	 * Recherche une personne en fonction de son identifiant.
	 * 
	 * @param idPersonne
	 * @return
	 */
	PersonneDO findPersonneById(final Integer idPersonne);

	/**
	 * Recupère la liste des personnes présents en base.
	 * 
	 * @return
	 */
	List<PersonneDO> findAllPersonne();
}
