package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NamedQuery;

/**
 * @author joseph
 */
@Entity
@NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p")
@Table(name = "personne")
public class Personne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPersonne;

	private String nom;

	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	/**
	 * FetchType.LAZY = charger les amis quand on appel la méthode getAmis().
	 * CascadeType.PERSIST = la créatioin d'une personne sera repercuté chez
	 * tous ses amis.
	 */
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "personne")
	private List<Ami> amis;

	public Personne() {
	}

	/**
	 * @return the idPersonne
	 */
	public int getIdPersonne() {
		return idPersonne;
	}

	/**
	 * @param idPersonne
	 *            the idPersonne to set
	 */
	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the dateNaissance
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * @param dateNaissance
	 *            the dateNaissance to set
	 */
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * @return the amis
	 */
	public List<Ami> getAmis() {
		return amis;
	}

	/**
	 * @param amis
	 *            the amis to set
	 */
	public void setAmis(List<Ami> amis) {
		this.amis = amis;
	}

	/**
	 * @param ami
	 * @return
	 */
	public Ami addAmi(final Ami ami) {
		getAmis().add(ami);
		ami.setPersonne(this);

		return ami;
	}

	/**
	 * @param ami
	 * @return
	 */
	public Ami removeAmi(final Ami ami) {
		getAmis().remove(ami);
		ami.setPersonne(null);

		return ami;
	}

}