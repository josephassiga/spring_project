package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * @author joseph
 */
@Component
public class PersonneDO {

	@Min(1)
	private int idPersonne;

	@NotBlank
	private String nom;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Past
	private Date dateNaissance;

	private Integer tailleListeAmis;

	private List<AmiDO> amis = new ArrayList<AmiDO>();

	public PersonneDO() {
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
	public List<AmiDO> getAmis() {
		return amis;
	}

	/**
	 * @param amis
	 *            the amis to set
	 */
	public void setAmis(List<AmiDO> amis) {
		this.amis = amis;
	}

	/**
	 * @param ami
	 * @return
	 */
	public AmiDO addAmi(final AmiDO ami) {
		getAmis().add(ami);
		ami.setPersonne(this);

		return ami;
	}

	/**
	 * @param ami
	 * @return
	 */
	public AmiDO removeAmi(final AmiDO ami) {
		getAmis().remove(ami);
		ami.setPersonne(null);

		return ami;
	}

	/**
	 * @return the tailleListeAmis
	 */
	public Integer getTailleListeAmis() {
		return 0;
	}

	/**
	 * @param tailleListeAmis
	 *            the tailleListeAmis to set
	 */
	public void setTailleListeAmis(Integer tailleListeAmis) {
		this.tailleListeAmis = tailleListeAmis;
	}

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "PersonneDO [idPersonne=" + idPersonne + ", nom=" + nom + ", dateNaissance="
        + dateNaissance + ", amis=" + amis + "]";
  }
	
	

}