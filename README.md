Progetto: Gestione di Animali e Proprietari
Descrizione 
Il progetto consiste in un'applicazione Spring Boot che gestisce le informazioni sugli animali e i loro proprietari. Utilizziamo PostgreSQL come database per memorizzare i dati. Il sistema permette di eseguire operazioni CRUD (Create, Read, Update, Delete) sia sugli animali che sui proprietari.
Struttura 
1. Modelli (Entities)
Abbiamo due entità principali:
    Animale: rappresenta un animale con attributi come ID, nome, razza, sesso, data di nascita e un riferimento al proprietario.
    Proprietario: rappresenta un proprietario con attributi come ID, nome, cognome e una lista di animali posseduti.

Principio SOLID: Single Responsibility Principle (SRP)
Ogni entità ha una sola responsabilità, ossia rappresentare e gestire i dati relativi a se stessa. Le entità contengono solo campi e metodi che riguardano direttamente il loro stato e comportamento.

2. Repository
Abbiamo due repository:
    AnimaleRepository: gestisce le operazioni CRUD per l'entità Animale.
    ProprietarioRepository: gestisce le operazioni CRUD per l'entità Proprietario.

Principio SOLID: Dependency Inversion Principle (DIP)
Le classi di servizio non dipendono da implementazioni concrete, ma dalle astrazioni (le interfacce dei repository). Spring Boot inietta le dipendenze in fase di runtime, seguendo il DIP.

3. Servizi

Abbiamo due servizi principali:
    AnimaleService: fornisce la logica di business per la gestione degli animali.
    ProprietarioService: fornisce la logica di business per la gestione dei proprietari.

Principio SOLID: Single Responsibility Principle (SRP)
Ogni servizio ha la responsabilità unica di gestire la logica di business relativa alla sua entità.
Principio SOLID: Open/Closed Principle (OCP)
I servizi sono aperti per estensioni (possiamo aggiungere nuovi metodi), ma chiusi per modifiche (non dobbiamo modificare il codice esistente per aggiungere nuove funzionalità).
Principio SOLID: Liskov Substitution Principle (LSP)
Le classi di servizio possono essere sostituite con sottoclassi senza alterare il comportamento del sistema.

4. Controller

Abbiamo due controller principali:
    AnimaleController: gestisce le richieste HTTP per le operazioni sugli animali.
    ProprietarioController: gestisce le richieste HTTP per le operazioni sui proprietari.

Principio SOLID: Single Responsibility Principle (SRP)
Ogni controller ha la responsabilità unica di gestire le richieste HTTP per la sua entità.
Principio SOLID: Interface Segregation Principle (ISP)
I controller espongono solo i metodi necessari per le operazioni specifiche, evitando interfacce troppo generiche o con troppi metodi.
Principio SOLID: Dependency Inversion Principle (DIP)
I controller dipendono dalle interfacce di servizio piuttosto che dalle implementazioni concrete. Spring Boot gestisce l'iniezione delle dipendenze, permettendo una facile sostituzione dei servizi.

5. Configurazione e Sicurezza

La configurazione dell'applicazione include la connessione al database PostgreSQL. Le entità vengono mappate alle rispettive tabelle del database utilizzando JPA.
Spiegazione dei Principi SOLID Utilizzati
    Single Responsibility Principle (SRP): Ogni classe ha una sola responsabilità. Le entità gestiscono i loro dati, i repository gestiscono l'accesso ai dati, i servizi contengono la logica di business e i controller gestiscono le richieste HTTP.
    Open/Closed Principle (OCP): I servizi e i controller sono progettati per essere estensibili senza dover modificare il codice esistente. Ad esempio, possiamo aggiungere nuovi metodi ai servizi senza alterare quelli esistenti.
    Liskov Substitution Principle (LSP): Le classi possono essere sostituite con le loro sottoclassi. Ad esempio, se avessimo una classe che estende AnimaleService, potremmo sostituirla senza alterare il comportamento dell'applicazione.
    Interface Segregation Principle (ISP): I controller espongono solo i metodi necessari per le operazioni specifiche, evitando di creare interfacce troppo generiche.
    Dependency Inversion Principle (DIP): Le classi di servizio e i controller dipendono dalle interfacce dei repository, non dalle implementazioni concrete. Questo permette di iniettare dipendenze e di sostituirle facilmente se necessario.

Bean dependecies diagram
 
Conclusione
Il progetto segue una chiara separazione delle responsabilità, mantenendo il codice modulare e manutenibile. Utilizzando i principi SOLID, abbiamo creato un'applicazione ben strutturata, facile da estendere e modificare. Questo approccio garantisce che il codice sia robusto, scalabile e facile da comprendere per gli sviluppatori.
