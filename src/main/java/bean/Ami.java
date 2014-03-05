package bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

/**
 * @author joseph
 */
@Entity
@NamedQuery(name = "Ami.findAll", query = "SELECT a FROM Ami a")
@Table(name = "amis")
public class Ami implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int idFriend;

	@ManyToOne
	private Personne personne;

	public Ami() {
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
	public Personne getPersonne() {
		return personne;
	}

	/**
	 * @param personne
	 *            the personne to set
	 */
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

}