package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import bean.Personne;

/**
 * @author joseph
 */

@Repository
public interface IPersonneDAO {

	/**
	 * Crèe une Personne connaissant l'objet personneDO
	 * 
	 * @param personne
	 */
	void createPersonne(final Personne personne);

	/**
	 * Supprime une personne connaissant l'objet
	 * 
	 * @param personne
	 */
	void deletePersonne(final Personne personne);

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
	 * @param personne
	 */
	void updatePersonne(final Integer idPersonne, final Personne personne);

	/**
	 * Recupère la liste des personnes présents en base.
	 * 
	 * @return
	 */
	List<Personne> findAllPersonne();

	/**
	 * Permet de rechercher la liste des amis d'une Personne connaissant son de
	 * idPersonne
	 * 
	 * @param idPersonne
	 * @return
	 */
	List<Personne> findFriendsOfPersonneById(final Integer idPersonne);

	/**
	 * Permet de rechercher la liste des amis d'une personne connaissant
	 * l'object.
	 * 
	 * @param personne
	 * @return
	 */
	List<Personne> findFriendOfPersonne(final Personne personne);

	/**
	 * Permet d'ajouter un ami de idFriend à une personne de idPersonne.
	 * 
	 * @param IdPersonne
	 * @param IdFriend
	 */
	void addFriendsToPersonne(final Personne personne, final int IdFriend);

	/**
	 * Recherche une personne en fonction de son identifiant.
	 * 
	 * @param idPersonne
	 * @return
	 */
	Personne findPersonneById(final Integer idPersonne);
}
