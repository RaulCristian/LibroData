Grupa: 324CB
Nume: Voinea Raul-Cristian

						Tema 1
			LibroData – Gestiunea și livrarea de cărți electronice

	In aceasta tema am avut de implementat gestiunea si livrarea de carti electronice
cu ajutorul limbajului de programare JAVA.
	Enititatile folosite sunt urmatoarele:
*Book:	
	- pe langa atribuirea de valori pentru campuri a trebuit sa scriem metoda Publish()
	implementata din interfata IPublishingArtifact;
	- a trebuit sa returnam un string cu metadata unei carti si am folosit functia .concat
	pentru a creea string-ul "metadata"

*Language

*Author

*PublishingBrand:
	- la fel ca la entitatea Book a tebuit sa scriem metoda Publish() asemanator

*EditorialGroup:
	- acelasi lucru ca la PublishingBrand

*PublishingRetailer:
	- am creat functia addPubArtefact care adauga in lista obiecte de tip IPublishingArtifact
	(Book, EditorialGroup, PublishingBrand)

*IPublishingArtifact:
	- este o interfață ce este implementată de către clasele Book, PublishingBrand,
	EditorialGroup.
	- contine metoda Publish();

		Initializari pentru fiecare entitate
	Am definit o clasa Initializations.java unde am scris initializarile fiecarui fisier.
*books.in:
	- am creat o carte (book_new) in care adaugam fiecare token;
	- dupa ce am terminat linia adaugam book_new in lista.
	
*languages.in:
	- am procedat la fel ca la books.in.

*authors.in:
	- am procedat la fel ca la books.in.

*countries.in:
	- am procedat la fel ca la books.in.

*editorial-groups.in:
	- am procedat la fel ca la books.in.

*publishing-brands.in:
	- am procedat la fel ca la books.in.

*publishing-retailers.in:
	- am procedat la fel ca la books.in.

		Initializarea asocierilor
*books-authors.in:
	- pastram in 2 variabile id-ul cartii si id-ul autorului din fisier;
	- cautam cartea in lista de carti dupa id;
	- dupa ce am gasit cartea cautam autorul in lista de autori dupa id;
	- cand am gasit autorul cu id-ul corespunzator il adaugam in lista de autori a cartii.

*editorial-groups-books.in:
	- acelasi procedeu ca la books-authors.in.

*publishing-brands-books.in:
	- acelasi procedeu ca la books-authors.in.


*publishing-retailers-countries.in:
	- acelasi procedeu ca la books-authors.in.

*publishing-retailers-books.in:
	- acelasi procedeu ca la books-authors.in doar ca aici adaugam cartea ca un Artefact;


*publishing-retailers-editorial-groups.in:
	- acelasi procedeu ca la publishing-retailers-books.in.

*publishing-retailers-publishing-brands.in:
	- acelasi procedeu ca la publishing-retailers-books.in.

	Am mai facut o functie care asociaza fiecarei carti limba in care este scrisa dupa id-ul limbii.


		Administration:
*getBooksForPublishingRetailerID(int publishingRetailerID):
	- cautam publishingRetailer-ul dupa ID
	- luam fiecare Artefact din el si verificam de ce tip este;
	- daca e de tip Book, adaugam cartea in lista;
	- daca e de tip EditorialGroup sau PublishingBrand, ii facem cast la
	EditorialGroup, respectiv PublishingBrand si adaugm in lista noastra
	toate cartile din acestea;
	- inainte de a returna lista ne asiguram ca o carte nu a fost introdusa
	de 2 ori si stergem duplicatele.

*getLanguagesForPublishingRetailerID(int publishingReatilerID):
	- asemanator ca la getBooksForPublishingRetailerID(int publishingRetailerID);

*getCountriesForBookID(int bookID):
	- cea mai usoara conexiune intre o carte si un publishingretailer se gasesc
	in fisierul publishing-retailer-books.in;
	- caut cartea dupa id si dupa iau fiecare tara din lista de tari
	din publishingretailer-ul corespunzator.

*getCommonBooksForRetailerIDs(int retailerID1, int retailerID2):
	- am folosit prima functie pentru a crea 2 liste de carti,
	cate o lista pentru fiecare publishingretailer;
	- luam din prima lista fiecare carte si verificam daca exista
	si in cea de a 2-a lista dupa ISBN;
	- daca exista in ambele liste, adaugam cartea in lista finala;
	- inainte de a returna lista stergem duplicatele daca acestea exista.

*getAllBooksForRetailerIDs(int retailerID1, int retailerID2):
	- am folosit prima functie pentru a crea 2 liste de carti,
	cate o lista pentru fiecare publishingretailer;'
	- adaugam ambele lista in lista finala si dupa stergem duplicatele.

		Main

	- declaram static lista de publishingretailer-uri si de carti pentru
a fi vizibile in fiecare fisier;
	- initializam fiecare fisier si creem liste pentru fiecare entitate;
	- initializam asocierile;
















