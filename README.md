# Spring DAO

Les classes DAO sont donc les classes qui contiennent le code qui permet d’échanger des informations avec la base de données. En Java, selon la technologie utilisée, il peut s’agir des classes qui utilisent l’API JDBC ou JPA par exemple.

Le module *Spring Data Access* reprend ce principe d’architecture en cherchant à simplifier l’intégration et l’implémentation des interactions avec les bases de données.

## L’annotation @Repository

Nous avons vu précédemment que le Spring Framework définit des stéréotypes pour préciser le rôle des composants.

Le stéréotype le plus général est défini par l’annotation ``@Component``. Mais, il est également possible d’utiliser l’annotation ``@Repository`` pour indiquer qu’une classe sert de point d’accès à un mécanisme de stockage et de recherche d’une collection d’objets.

```java
@Repository
public class UserDao {

  public void save(User user) {
    // ...
  }

  public User getById(long id) {
    // ...
  }

}
```

## Intégration de JPA

Pour une application utilisant JPA, il est possible d’injecter un ``EntityManager`` dans un repository grâce à l’annotation ``@Autowired`` ou ``@Inject`` ou même ``@PersistenceContext``.

> [!NOTE]
> L’annotation ``@PersistenceContext`` est celle qui est recommandée par la norme JPA.

```java
@Repository
public class UserDao {

  @PersistenceContext
  private EntityManager entityManager;

  public void save(User user) {
    // ...
  }

  public User getById(long id) {
    // ...
  }

}
```

Le Spring Framework s’occupe pour nous de gérer la création et la fermeture de l’objet ``EntityManager``. Si vous avez besoin de modifier des données dans la base de données, alors vous devrez sans doute penser à gérer explicitement les transactions. Nous aborderons spécifiquement ce point dans le chapitre [Spring Transaction](https://github.com/iliasse-e/spring-transaction).

## Intégration dans une application Spring Boot

Spring Boot est un projet conçu pour simplifier considérablement la configuration des applications basées sur le Spring Framework. Si Vous souhaitez intégrer le support de JPA dans votre application, il suffit d’ajouter la dépendance suivante :

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```
