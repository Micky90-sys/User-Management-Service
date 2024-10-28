# User-Management-Service
 User Management Service costruito come microservizio per la gestione della registrazione, autenticazione e autorizzazione degli utenti. Utilizza tecnologie moderne come Spring Boot, JWT (JSON Web Tokens), OAuth 2.0 per garantire un sistema sicuro e scalabile per la gestione degli utenti.


User Management Service
Descrizione del Progetto
Questo progetto è un User Management Service costruito come microservizio per la gestione della registrazione, autenticazione e autorizzazione degli utenti. Utilizza tecnologie moderne come Spring Boot, JWT (JSON Web Tokens), OAuth 2.0 per garantire un sistema sicuro e scalabile per la gestione degli utenti. È stato creato con l’obiettivo di fornire un'API solida e sicura per l'autenticazione e la gestione degli utenti.

Caratteristiche Principali
Registrazione degli utenti: I nuovi utenti possono registrarsi fornendo le loro informazioni.
Autenticazione: Gli utenti possono autenticarsi utilizzando JWT, con un sistema sicuro e affidabile.
Autorizzazione: Viene implementata la gestione dei ruoli e delle autorizzazioni usando Spring Security.
Test automatizzati: Implementazione di test unitari e di integrazione con JUnit e Mockito per garantire alta qualità e affidabilità.
Database in-memory: Utilizzo di H2 come database in-memory per la fase di sviluppo e testing.
Tecnologie Utilizzate
Java 11: Linguaggio principale per lo sviluppo.
Spring Boot 2.7.5: Framework principale per lo sviluppo del backend.
Spring Security: Utilizzato per la gestione dell’autenticazione e dell’autorizzazione.
JWT (JSON Web Tokens): Per l’autenticazione sicura degli utenti.
OAuth 2.0: Per l'autorizzazione degli utenti.
JUnit 5: Framework per i test.
Mockito: Per creare mock durante i test unitari.
H2 Database: Database in-memory per testare l'applicazione in fase di sviluppo.
Installazione e Setup
Prerequisiti
Java 11
Maven
Passi per eseguire il progetto
Clonare il repository:

bash
Copia codice
git clone https://github.com/tuo-username/user-management-service.git
cd user-management-service
Compilare il progetto:

bash
Copia codice
mvn clean install
Eseguire i test:

bash
Copia codice
mvn test
Avviare l'applicazione:

bash
Copia codice
mvn spring-boot:run
L'applicazione sarà eseguita su http://localhost:8080.

Endpoints API
POST /api/register: Registrazione di un nuovo utente.
POST /api/login: Login e ricezione di un token JWT per l'autenticazione.
GET /api/user/{id}: Recupera le informazioni di un utente (autorizzato).
Ogni richiesta a endpoint protetti richiede il token JWT nel campo Authorization:

http
Copia codice
Authorization: Bearer <token>
Test
Il progetto include test unitari e di integrazione per garantire la corretta funzionalità delle API. Utilizzando JUnit 5 e Mockito, è possibile eseguire i test con il seguente comando:

bash
Copia codice
mvn test
Contribuire
Forka il progetto
Crea un nuovo branch (git checkout -b feature/nuova-funzionalità)
Effettua le modifiche e fai un commit (git commit -m 'Aggiungi nuova funzionalità')
Push al branch (git push origin feature/nuova-funzionalità)
Apri una Pull Request
Licenza
Questo progetto è rilasciato sotto la MIT License.
