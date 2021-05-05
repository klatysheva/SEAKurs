package interfaces.otherPersonGroup;

import interfaces.Person;

public class PersonsGroupNew implements PersonsInterface {

	Person[] seminarTeilnehmer = new Person[5];
	
	public boolean add(Person einTeilnehmer ) { // Anmelden und Rückgabe der AnmeldeNr.
		if (this.seminarTeilnehmer[ size() ] == null)
		{
			this.seminarTeilnehmer[ size() ] = einTeilnehmer; // keine Angabe der Klasse, da automatisch
			return true;
		}
		else 
			return false; 
	}

	public int size() {
		int anz;
		System.out.println( "Länge des Arrays "+ this.seminarTeilnehmer.length); // nur zum Testen	
		for (anz = 0; ((anz < this.seminarTeilnehmer.length ) && ( this.seminarTeilnehmer[anz] != null )); anz++ ) {}
		System.out.println("anz = "+anz);
		return anz; // Ausgabe der belegten Länge des des Arrays über return
	}

	public Person get(int i ) {
		if ( i < this.size())
		   return this.seminarTeilnehmer[i];
		else 
			return null;	
	}

	public boolean remove(Person person) {  // Methode noch nicht implementiert
		return false;
	}
}
