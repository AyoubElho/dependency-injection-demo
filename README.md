

  <h1>Inversion de Contrôle et Injection des Dépendances</h1>

  <p><strong>Réalisé par :</strong> Ayoub el houani<br>
    <strong>Formation :</strong> Master-SDIA</p>

  <h2>Introduction</h2>
    <p>Ce repository contient l'implémentation de l'activité pratique démontrant les concepts de couplage faible, d'Inversion de Contrôle (IoC) et d'Injection des Dépendances (DI) en Java. Les différentes approches abordées vont de l'instanciation classique (statique/dynamique) à l'utilisation du Framework Spring (versions XML et Annotations).</p>

  <h2>Diagramme de Classes</h2>
    <p>L'architecture de l'application est basée sur la séparation des couches (DAO et Métier) pour garantir un couplage faible.</p>
 <img width="500" height="703" alt="image" src="https://github.com/user-attachments/assets/8256ce02-bdde-454f-9c68-1f1e0b5fa26e" />


  <h2>Structure du Projet</h2>
    <p>Le projet est un projet Maven structuré de la manière suivante :</p>
<pre><code>injDep
├── pom.xml
├── src/main/java
│   ├── dao
│   │   ├── IDao.java          # Interface DAO
│   │   └── DaoImpl.java       # Implémentation base de données
│   ├── ext
│   │   └── DaoImpl2.java      # Extension/Implémentation Web Service
│   ├── metier
│   │   ├── IMetier.java       # Interface Métier
│   │   └── IMetierImpl.java   # Implémentation Métier (couplage faible)
│   └── pres
│       ├── Presentation.java              # Injection par instanciation
│       ├── PresAvecSpringVersionXml.java  # Injection via Spring (XML)
│       └── PresSpringAnnot.java           # Injection via Spring (Annotations)
└── src/main/resources
    └── config.xml             # Fichier de configuration Spring (XML)</code></pre>

  <h2>Étapes de Réalisation (Partie 1)</h2>

   <h3>1 &amp; 2. Couche DAO (<code>dao</code> et <code>ext</code>)</h3>
    <ul>
        <li>Création de l'interface <code>IDao</code> définissant la méthode <code>getData()</code>.</li>
        <li>Création d'une première implémentation <code>DaoImpl</code> simulant la récupération de données depuis une base de données (retourne <code>25</code>).</li>
        <li>Création d'une seconde implémentation <code>DaoImpl2</code> simulant l'appel à un Web Service (retourne <code>77</code>).</li>
    </ul>

  <h3>3 &amp; 4. Couche Métier (<code>metier</code>)</h3>
    <ul>
        <li>Création de l'interface <code>IMetier</code> avec la méthode <code>calcul()</code>.</li>
        <li>Implémentation dans <code>IMetierImpl</code>. Cette classe déclare un objet de type <code>IDao</code> et ne fait jamais appel au mot-clé <code>new</code> pour instancier les données, respectant ainsi le principe de <strong>couplage faible</strong>.</li>
    </ul>

   <h3>5. L'Injection des Dépendances (<code>pres</code>)</h3>
    <p>Plusieurs méthodes d'injection ont été expérimentées pour lier la couche Métier à la couche DAO :</p>
    <ol>
        <li><strong>Par instanciation statique / dynamique</strong> : Testées via la classe classique <code>Presentation.java</code>.</li>
        <li><strong>Par le framework Spring (Version XML)</strong> : Utilisation du fichier <code>config.xml</code> pour configurer les <code>&lt;bean&gt;</code> et l'injection des propriétés (via <code>ref="dao"</code>). L'exécution se fait dans <code>PresAvecSpringVersionXml.java</code>.</li>
        <li><strong>Par le framework Spring (Version Annotations)</strong> : Utilisation des annotations <code>@Component</code> sur les classes d'implémentation et de la configuration <code>AnnotationConfigApplicationContext</code> dans <code>PresSpringAnnot.java</code>. L'injection spécifique de l'implémentation Web Service se fait en précisant le composant via <code>@Qualifier("dao2")</code>.</li>
    </ol>

  <h2>Résultats de l'exécution</h2>
    <p>Voici les résultats obtenus lors de l'exécution avec le Framework Spring (basculement entre les différentes implémentations de l'interface <code>IDao</code>) :</p>

   <h3>Exécution avec l'implémentation "Base de données" (<code>DaoImpl</code>)</h3>
    <img width="641" height="292" alt="image" src="https://github.com/user-attachments/assets/97df9007-0d5d-4f58-abec-8c6eda66496b" />


  <h3>Exécution avec l'implémentation "Web Service" (<code>DaoImpl2</code>)</h3>
    <img width="630" height="278" alt="image" src="https://github.com/user-attachments/assets/66e837a0-838a-4ffa-ae14-702177286e1a" />

