package model;

import org.springframework.stereotype.Component;

/**
 * @author joseph
 */
@Component
public class AmiDO {

	private int id;

	private int idFriend;

	private PersonneDO personne;

	public AmiDO() {
	}

	public AmiDO(int id, int idFriend, PersonneDO personne) {
		super();
		this.id = id;
		this.idFriend = idFriend;
		this.personne = personne;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the idFriend
	 */
	public int getIdFriend() {
		return idFriend;
	}

	/**
	 * @param idFriend
	 *            the idFriend to set
	 */
	public void setIdFriend(int idFriend) {
		this.idFriend = idFriend;
	}

	/**
	 * @return the personne
	 */
	public PersonneDO getPersonne() {
		return personne;
	}

	/**
	 * @param personne
	 *            the personne to set
	 */
	public void setPersonne(PersonneDO personne) {
		this.personne = personne;
	}

}