package dao;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import model.PersonneDO;

import org.junit.Before;
import org.junit.Test;

import services.IPersonneService;
import factory.PathEnum;
import factory.SpringFactory;

public class PersonneDAOTest {

  private IPersonneService iPersonneService;

  @Before
  public final void init() {

    iPersonneService = SpringFactory.getContext(PathEnum.CLASSPATH).getBean("personneService",
        IPersonneService.class);
  }

  public final void testCreatePersonne() {
    final PersonneDO personneDO = new PersonneDO();
    personneDO.setNom("CAMPOS");
    personneDO.setIdPersonne(5);
    personneDO.setDateNaissance(new Date());
    iPersonneService.createPersonne(personneDO);
  }

  public final void testUpdatePersonne() {
    final PersonneDO personneDO = new PersonneDO();
    personneDO.setNom("CARL");
    personneDO.setIdPersonne(2);
    personneDO.setDateNaissance(new Date());

    iPersonneService.updatePersonne(2, personneDO);
  }

  public final void testDeletePersonneById() {

    this.iPersonneService.deleterPersonneById(3);
  }

  public final void testDeletePersonne() {
    final PersonneDO personneDO = new PersonneDO();
    personneDO.setNom("CARL");
    personneDO.setIdPersonne(2);
    personneDO.setDateNaissance(new Date());
    this.iPersonneService.deletePersonne(personneDO);
  }

  @Test
  public final void testFindAllPersonne() {

    final List<PersonneDO> personneDOs = this.iPersonneService.findAllPersonne();
    for (PersonneDO personneDO : personneDOs) {
      System.out.println(personneDO);
    }
    assertNotNull(personneDOs);
  }

  public final void testAddFriendToPersonne() {
    final PersonneDO personneDO = this.iPersonneService.findPersonneById(1);
    this.iPersonneService.addFriendsToPersonne(personneDO, 2);
  }

  //	public final void testFindFrienOfPersonById() {
  //		assertNotNull(this.iPersonneService.findFriendsOfPersonneById(1));
  //	}
}
