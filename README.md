# Programmation Dynamique par Réflexion en Java

##  Objectif

Ce TP explore la **programmation dynamique en Java** via la réflexion (`java.lang.reflect`). L'objectif est d'instancier des classes, d'injecter des dépendances et d'invoquer des méthodes **sans dépendre d'une configuration statique**, en chargeant les implémentations depuis un fichier de configuration externe.

---

##  Structure du projet

```
projet/
├── src/
│   ├── dao/
│   │   ├── IDao.java           # Interface DAO
│   │   └── DaoImpl.java        # Implémentation DAO
│   ├── metier/
│   │   ├── IMetier.java        # Interface Métier
│   │   └── MetierImpl.java     # Implémentation Métier
│   └── presentation/
│       └── Presentation2.java  # Réflexion
└── config.txt                  # Fichier de configuration des classes
```

---

## Architecture

| Composant     | Rôle                                              |
|---------------|---------------------------------------------------|
| `IDao`        | Fournit une valeur brute (`getValue(): double`)   |
| `DaoImpl`     | Retourne `100.0`                                  |
| `IMetier`     | Effectue un calcul métier (`calcul(): double`)    |
| `MetierImpl`  | Multiplie la valeur DAO par 2                     |

---

##  Étapes d'implémentation

### 1. Interface `IDao`

### 2. Classe `DaoImpl`

### 3. Interface `IMetier`

### 4. Classe `MetierImpl`

### 5. Classe `Presentation2` (réflexion)

---

## Configuration

Créer un fichier `config.txt` à la **racine du projet** contenant les noms complets des classes (avec package) :

```
dao.DaoImpl
metier.MetierImpl
```


## Concepts clés

- **`Class.forName(String)`** — charge une classe à partir de son nom complet
- **`getDeclaredConstructor().newInstance()`** — instancie un objet sans `new`
- **`getMethod(String, Class<?>...)`** — récupère une méthode par son nom et ses paramètres
- **`Method.invoke(Object, Object...)`** — invoque dynamiquement une méthode sur un objet
- **Injection de dépendances** — `MetierImpl` reçoit son `IDao` via `setDao()`, appelé par réflexion

---

## Remarques

- La réflexion permet de **découpler** complètement le code des implémentations concrètes.
- Changer `config.txt` suffit pour utiliser une autre implémentation de `IDao` ou `IMetier` **sans recompiler**.
