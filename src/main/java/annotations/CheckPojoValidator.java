package annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 
 * @author joseph
 *
 */
public class CheckPojoValidator implements ConstraintValidator<Pojo, Object> {

  private PojoEnum            pojoEnum;
  private static final String GET = "get";
  private static final String SET = "set";
  private static final String DO  = "Do";
  private static final String DTO = "Dto";

  @Override
  public void initialize(final Pojo constraintAnnotation) {
    this.pojoEnum = constraintAnnotation.value();
  }

  @Override
  public boolean isValid(final Object object, final ConstraintValidatorContext context) {

    if (object == null) {
      return true;

    }

    if (this.pojoEnum == PojoEnum.POJO) {
      return this.verifyAttributeModificator(object);
    }

    return false;
  }

  /**
   * Permet de vérifier si les attributs sont privés.
   * getFields() retourne un tableau de tous les chaps publics.
   * @param object
   * @return
   */
  private boolean verifyAttributeModificator(final Object object) {

    final Field[] fields = object.getClass().getDeclaredFields();

    for (Field field : fields) {

      final int fieldModifier = field.getModifiers();

      //Vérifie si on a une constante : private static
      if (Modifier.isPrivate(fieldModifier) == true) return false;

    }
    return true;
  }

  /**
   * Permet de vérifier si les attributs ont ont des getters/setters en public
   * @param object
   * @return
   */
  private boolean verifyAttributGettersAndSetters(final Object object) {
    final List<String> methodes = getListeMethodes(object.getClass().getDeclaredMethods());
    final Field[] fields = object.getClass().getDeclaredFields();

    for (Field field : fields) {
      if ((findAttributeGetter(field.getName(), methodes) == false)
          || (findAttributeSetter(field.getName(), methodes) == false)) {
        return false;
      }
    }

    return true;
  }

  /**
   * Permet d'avoir toutes les methodes déclarées dans le POJO
   * @param methods
   * @return
   */
  private List<String> getListeMethodes(final Method[] methods) {
    final List<String> listeMethodes = new ArrayList<String>();

    for (final Method method : methods) {
      listeMethodes.add(method.getName());
    }
    return listeMethodes;
  }

  /**
   * Permet de savoir un attribut a bien un setteurs.
   * @param attributeName
   * @param methodes
   * @return
   */
  private boolean findAttributeSetter(final String attributeName, final List<String> methodes) {

    final String nameAttributeSetter = SET + UpperCaseFisrtLetter(attributeName);

    return methodes.contains(nameAttributeSetter);
  }

  /**
   * Permet de savoir si un attribut a bien un getters.
   * @param attributeName
   * @param methodes
   * @return
   */
  private boolean findAttributeGetter(final String attributeName, final List<String> methodes) {

    final String nameAttributeGetter = GET + UpperCaseFisrtLetter(attributeName);

    return methodes.contains(nameAttributeGetter);
  }

  /**
   * Permet d'avoir toutes les méthodes autorisées dans un POJO.
   * @param object
   * @return
   */
  private Set<String> methodesAutorisees(final Object object) {

    final Set<String> methodes = new HashSet<String>();

    for (Field field : object.getClass().getDeclaredFields()) {
      methodes.add(SET + UpperCaseFisrtLetter(field.getName()));
      methodes.add(GET + UpperCaseFisrtLetter(field.getName()));
    }

    for (Method method : object.getClass().getSuperclass().getDeclaredMethods()) {
      methodes.add(method.getName());
    }

    return methodes;
  }

  /**
   * Permet de mettre le premier caractère de nameAttribute en majuscule.
   * @param nameAttribute
   * @return
   */
  private String UpperCaseFisrtLetter(final String nameAttribute) {
    return nameAttribute.substring(0, 1).toUpperCase() + nameAttribute.substring(1);
  }

  /**
   * Permet de savoir si une le nom de la classe du POJO est suffixé par DO pu Dto.
   * @param object
   * @return
   */
  private boolean verifyPojoClassName(final Object object) {
    final String className = object.getClass().getSimpleName();
    if (className.endsWith(DO) || className.endsWith(DTO)) {
      return true;
    }
    return false;
  }

  /**
   * Permet de vérifier que le package du POJO est en minuscule.
   * @param object
   * @return
   */
  private boolean verifyPojoPackage(final Object object) {
    final String packageName = object.getClass().getPackage().getName();

    return packageName.toLowerCase().equals(packageName);
  }

  /**
   * Permet de vérifier si les constances sont en public static
   * @param object
   * @return
   */
  private boolean verifyPojoConstantAttribute(final Object object) {
    final Field[] fields = object.getClass().getDeclaredFields();

    for (Field field : fields) {

      final int fieldModifier = field.getModifiers();

      if ((Modifier.isPublic(fieldModifier) == true) && (Modifier.isStatic(fieldModifier) == false))
        return false;

    }

    return true;
  }

  /**
   * Permet de vérifier les options : Entity et public static
   * @param object
   * @return
   */
  private boolean verifyPojoOptions(final Object object) {
    final Annotation[] annotations = object.getClass().getAnnotations();
    final List<String> listeAnnotations = new ArrayList<String>();

    if (object.getClass().getSimpleName().endsWith("Do") == false)
      return false;

    for (Annotation annotation : annotations)
      listeAnnotations.add(annotation.annotationType().getSimpleName());

    return listeAnnotations.contains("Entity") && verifyPojoConstantAttribute(object);
  }
}
