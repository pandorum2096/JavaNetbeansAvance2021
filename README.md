"# JavaNetbeansAvance2021" 
Partie 2. Manipuler une servlet

1) Quelles méthodes sont supportées par la servlet

reponse:

    private static final String METHOD_DELETE = "DELETE";
    private static final String METHOD_HEAD = "HEAD";
    private static final String METHOD_GET = "GET";
    private static final String METHOD_OPTIONS = "OPTIONS";
    private static final String METHOD_POST = "POST";
    private static final String METHOD_PUT = "PUT";
    private static final String METHOD_TRACE = "TRACE";

2)Que se passe t il lors des actions suivantes : GET, POST, PUT, DELETE

reponse:

-GET = afficher les données
-POST = envoyer des données
-PUT = modifier des données
-DELETE = supprimer des données

/*************************************************************************************************/
Partie 3: Gestion d'une liste d'étudiants

Ou se trouve le fichier etudiants.csv ?
C:\\Users\\HP\\Dropbox\\Mon PC (DESKTOP-MAL4HBH)\\Documents\\GitHub\\JavaNetbeansAvance2021\\src\\etudiants.csv

Savez-vous pourquoi?

car on a indexé le lieu de creation du fichier
String filepath = "C:\\Users\\HP\\Dropbox\\Mon PC (DESKTOP-MAL4HBH)\\Documents\\GitHub\\JavaNetbeansAvance2021\\src\\etudiants.csv";
FileWriter fw = new FileWriter (filepath , false);