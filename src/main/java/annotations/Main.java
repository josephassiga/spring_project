package annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import bean.Personne;

public class Main {

  public static void main(String[] args) {

    verifyAttributeModificator(new Personne());
  }

  private static void verifyAttributeModificator(final Object object) {

    final Field[] fields = object.getClass().getDeclaredFields();
    final Modifier modifier = new Modifier();
    final Method[] methods = object.getClass().getDeclaredMethods();
    final Set<Method> methodesSet = new HashSet<Method>(Arrays.asList(methods));
    final Set<Method> methodesSetOfSuperClass = new HashSet<Method>(Arrays.asList(object.getClass()
        .getSuperclass().getDeclaredMethods()));
    methodesSet.removeAll(methodesSetOfSuperClass);

    System.out.println("========= Methodes : Setter =============");
    //    Set<String> methodesAutorises =  methodesAutorisees(object);
    //    for(Method method : methods){
    //      System.out.println(method.getName()+" : "+methodesAutorises.contains(method.getName()));
    //    }
  

  }

  /**
   * Permet de retourner la liste des methodes de la classe.
   * @param methods
   * @return
   */
  private static List<String> getListeMethodes(final Method[] methods) {
    final List<String> listeMethodes = new ArrayList<String>();

    for (Method method : methods) {
      listeMethodes.add(method.getName());
    }
    return listeMethodes;
  }

  private static boolean findAttributeSetter(final String attributeName, final List<String> methodes) {

    final String nameAttributeSetter = "set" + UpperCaseFisrtLetter(attributeName);
    System.out.println(nameAttributeSetter + " : " + methodes.contains(nameAttributeSetter));
    return methodes.contains(nameAttributeSetter);
  }

  private static boolean findAttributeGetter(final String attributeName, final List<String> methodes) {

    final String nameAttributeGetter = "get" + UpperCaseFisrtLetter(attributeName);

    System.out.println(nameAttributeGetter + " : " + methodes.contains(nameAttributeGetter));
    return methodes.contains(nameAttributeGetter);
  }

  private static Set<String> methodesAutorisees(final Object object) {

    final Set<String> methodes = new HashSet<String>();

    for (Field field : object.getClass().getDeclaredFields()) {
      methodes.add("set" + UpperCaseFisrtLetter(field.getName()));
      methodes.add("get" + UpperCaseFisrtLetter(field.getName()));
    }

    for (Method method : object.getClass().getSuperclass().getDeclaredMethods()) {
      methodes.add(method.getName());
    }

    return methodes;
  }

  private static String UpperCaseFisrtLetter(final String nameAttribute) {
    return nameAttribute.substring(0, 1).toUpperCase() + nameAttribute.substring(1);
  }

  private static boolean verifyPojoClassName(final Object object) {
    final String className = object.getClass().getSimpleName();
    if (className.endsWith("DO") || className.endsWith("Dto")) {
      return true;
    }
    return false;
  }

  private static boolean verifyPojoPackage(final Object object) {
    final String packageName = object.getClass().getPackage().getName();

    return packageName.toLowerCase().equals(packageName);
  }

  private static boolean verifyPojoOptions(final Object object) {
    final Annotation[] annotations = object.getClass().getAnnotations();
    final List<String> listeAnnotations = new ArrayList<String>();

    if (object.getClass().getSimpleName().endsWith("Do") == false)
      return false;

    for (Annotation annotation : annotations)
      listeAnnotations.add(annotation.annotationType().getSimpleName());

    return listeAnnotations.contains("Entity");
  }
  
  private static boolean verifyPojoConstantAttribute(final Object object){
    final Field[] fields = object.getClass().getDeclaredFields();

    final Modifier modifier = new Modifier();

    for (Field field : fields) {

      final int fieldModifier = field.getModifiers();
      
      if ((modifier.isPublic(fieldModifier) == true) && (modifier.isStatic(fieldModifier) == false))
        return false;

    }
    
    return true;
  }
}
