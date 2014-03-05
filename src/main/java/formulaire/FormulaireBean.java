package formulaire;

import javax.validation.Valid;

import model.PersonneDO;

import org.springframework.stereotype.Component;

@Component
public class FormulaireBean {

	@Valid
	private PersonneDO personneDO;

	private PersonneDO friendDO;

	public FormulaireBean() {
		super();
	}

	/**
	 * @return the personneDO
	 */
	public PersonneDO getPersonneDO() {
		return personneDO;
	}

	/**
	 * @param personneDO
	 *            the personneDO to set
	 */
	public void setPersonneDO(PersonneDO personneDO) {
		this.personneDO = personneDO;
	}

	/**
	 * @return the friendDO
	 */
	public PersonneDO getFriendDO() {
		return friendDO;
	}

	/**
	 * @param friendDO
	 *            the friendDO to set
	 */
	public void setFriendDO(PersonneDO friendDO) {
		this.friendDO = friendDO;
	}

	@Override
	public String toString() {
		return "FormulaireBean [personneDO=" + personneDO + ", friendDO="
				+ friendDO + "]";
	}

}
