public class List {
    private Knoten first;
    private Knoten akt;

    public List() {

    }

    ////// Diese Methoden bitte korrigieren

//Falls die Liste nicht leer ist, wird das letzte Objekt der Liste aktuelles Objekt


    public void toLast() {
        if (first != null) {
            Knoten temp = first;
            while (temp.getNachfolger() != null) {
                temp = temp.getNachfolger();
            }
            akt = temp;
        }
    }

    //Falls es ein aktuelles Objekt gibt und pObject ungleich null ist, wird das aktuelle Objekt durch pObject ersetzt

    public void insert(Aufgabe pAufgabe) {
        if (akt != null) {
            Knoten temp = first;
            if (akt == first) {
                first = new Knoten(pAufgabe);
                first.setNachfolger(temp);
                return;
            }
            while (temp.getNachfolger() != akt) {
                temp = temp.getNachfolger();
            }
            temp.setNachfolger(new Knoten(pAufgabe));
            temp = temp.getNachfolger();
            temp.setNachfolger(akt);
        }
        if (first == null && akt == null) {
            first = new Knoten(pAufgabe);
        }
        if (first != null && akt == null && pAufgabe == null) {
            // nichts
        }
    }

    //Falls aktuelles Objekt vorhanden, wird ein neues Objekt vor dem aktuellen Objekt in die Liste eingefügt. Falls die Liste leer ist und es somit kein aktuelles Objekt gibt, wird pObject in die Liste eingefügt und es gibt weiterhin kein aktuelles Objekt. Falls es kein aktuelles Objekt gibt und die Liste nicht leer ist oder pObject gleich null ist, bleibt die Liste unverändert


    //Fall1 akt Objekt ist das erste Objekt

    public void concat(List pList) {
        if (first != null && pList != null && pList.isEmpty() == false) {
            Knoten temp = first;
            while (temp.getNachfolger() != null) {
                temp = temp.getNachfolger();
            }
            temp.setNachfolger(pList.first);
        }
    }


    //Die Liste pList wird an die Liste angehängt. Das aktuelle Objekt bleibt unverändert. Falls pList null oder eine leere Liste ist, bleibt die Liste unverändert.

    public void remove() {
        if (akt != null) {
            Knoten temp = first;
            while (temp.getNachfolger() != akt) {
                temp = temp.getNachfolger();
            }
            temp.setNachfolger(akt.getNachfolger());
            akt = temp.getNachfolger();
        }
    }


    //Falls es ein aktuelles Objekt gibt, wird das aktuelle Objekt gelöscht und das Objekt hinter dem gelöschten Objekt wird zum aktuellen Objekt. Wird das Objekt, das am Ende der Liste steht, gelöscht, gibt es kein aktuelles Objekt mehr. Wenn die Liste leer ist oder es kein aktuelles Objekt gibt, bleibt die Liste unverändert.

    //Liefert den Wert true wenn die Liste keine Objekte enthält
    public boolean isEmpty() {
        if (first == null) {
            return true;
        } else {
            return false;
        }
    }


    //////////// ab hier passt es

    //Liefert den Wert true wenn es ein aktuelles Objekt gibt
    public boolean hasAccess() {
        if (akt != null) {
            return true;
        } else {
            return false;
        }
    }

    //Falls die Liste nicht leer ist, es ein aktuelles Objekt gibt(nicht das letzte),wird das dem aktuellen Objekt in der Liste folgende Objekt zum aktuellen Objekt, andernfalls gibt es nach Ausführung des Aufrtags kein aktuelles Objekt
    public void next() {
        if (akt != null && akt.getNachfolger() != null) {
            akt = akt.getNachfolger();
        }
    }

    //Wenn Liste nicht leer --> erstes Objekt wird aktuelles Objekt
    public void toFirst() {
        if (first != null) {
            akt = first;
        }
    }

    //Falls es ein aktuelles Objekt gibt, wird das aktuelle Objekt zurückgegeben
    public Aufgabe getObject() {
        if (akt != null) {
            return akt.getInhalt();
        }
        return null;
    }

    public void setObject(Aufgabe pAufgabe) {
        if (hasAccess() && pAufgabe != null) {
            akt.setInhalt(pAufgabe);
        }
    }

    //Ein neues Objekt pObject wird am Ende der Liste angefügt. Das aktuelle Objekt bleibt unverändert. Wenn die Liste leer ist, wird das Objekt pObject in die Liste eingefügt und es gibt weiterhin kein aktuelles Objekt. Falls pObject gleich null ist, bleibt die Liste unverändert
    public void append(Aufgabe pAufgabe) {
        if (first == null) {
            first = new Knoten(pAufgabe);
            return;
        }
        Knoten tmp = first;

        while (tmp.getNachfolger() != null) {
            tmp = tmp.getNachfolger();
        }
        tmp.setNachfolger(new Knoten(pAufgabe));
    }


}