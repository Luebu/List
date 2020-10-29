public class List{
    private Knoten first;
    private Knoten akt;

    public List(){

    }

    //Liefert den Wert true wenn die Liste keine Objekte enthält
    public boolean isEmpty(){
        if (first==null){
            return true;
        }else{
            return false;
        }
    }

    //Liefert den Wert true wenn es ein aktuelles Objekt gibt
    public boolean hasAccess(){
        if(akt != null){
            return true;
        }else{
            return false;
        }
    }

    //Falls die Liste nicht leer ist, es ein aktuelles Objekt gibt(nicht das letzte),wird das dem aktuellen Objekt in der Liste folgende Objekt zum aktuellen Objekt, andernfalls gibt es nach Ausführung des Aufrtags kein aktuelles Objekt
    public void next(){
        if(first==null||first.getNachfolger()==null){
            return;
        }
        akt=first.getNachfolger();
    }

    //Wenn Liste nicht leer --> erstes Objekt wird aktuelles Objekt
    public void toFirst(){
        if(first != null){
            akt = first;
        }
    }

    //Falls die Liste nicht leer ist, wird das letzte Objekt der Liste aktuelles Objekt
    public void toLast(){
        if(first==null){
            Knoten tmp = first;
            while (tmp.getNachfolger() != null){
                tmp = tmp.getNachfolger();
            }
            akt = tmp;
        }
    }

    //Falls es ein aktuelles Objekt gibt, wird das aktuelle Objekt zurückgegeben
    public Aufgabe getObject(){
        if(akt!=null){
            return akt.getInhalt();
        }
        return null;
    }

    //Falls es ein aktuelles Objekt gibt und pObject ungleich null ist, wird das aktuelle Objekt durch pObject ersetzt
    public void setObject(Aufgabe pAufgabe){
        if(hasAccess()&&pAufgabe!=null){
            akt=new Knoten(pAufgabe);
        }
    }

    //Ein neues Objekt pObject wird am Ende der Liste angefügt. Das aktuelle Objekt bleibt unverändert. Wenn die Liste leer ist, wird das Objekt pObject in die Liste eingefügt und es gibt weiterhin kein aktuelles Objekt. Falls pObject gleich null ist, bleibt die Liste unverändert
    public void append(Aufgabe pAufgabe){
        if(first == null){
            first = new Knoten(pAufgabe);
            return;
        }
        Knoten tmp = first;

        while (tmp.getNachfolger() != null){
            tmp = tmp.getNachfolger();
        }
        tmp.setNachfolger(new Knoten(pAufgabe)) ;
    }

    //Falls aktuelles Objekt vorhanden, wird ein neues Objekt vor dem aktuellen Objekt in die Liste eingefügt. Falls die Liste leer ist und es somit kein aktuelles Objekt gibt, wird pObject in die Liste eingefügt und es gibt weiterhin kein aktuelles Objekt. Falls es kein aktuelles Objekt gibt und die Liste nicht leer ist oder pObject gleich null ist, bleibt die Liste unverändert
    public void insert(Aufgabe pAufgabe) {
        Knoten temp=first;
        while(temp.getNachfolger()!=null){
            if(akt!=null){
                if(temp.getNachfolger()==akt){
                    temp.setNachfolger(new Knoten(pAufgabe));
                    temp.getNachfolger().setNachfolger(akt);
                    return;
                }
            }else if(isEmpty()){
                append(pAufgabe);

            }else if(akt==null&&isEmpty()==false&&pAufgabe==null){
                return;
            }
        }
    }

    //Die Liste pList wird an die Liste angehängt. Das aktuelle Objekt bleibt unverändert. Falls pList null oder eine leere Liste ist, bleibt die Liste unverändert.
    public void concat(List pList){
        if(pList==null&&pList.hasAccess()&&pList.isEmpty()==false){
            pList.toFirst();
            append(pList.getObject());
        }
    }

    //Falls es ein aktuelles Objekt gibt, wird das aktuelle Objekt gelöscht und das Objekt hinter dem gelöschten Objekt wird zum aktuellen Objekt. Wird das Objekt, das am Ende der Liste steht, gelöscht, gibt es kein aktuelles Objekt mehr. Wenn die Liste leer ist oder es kein aktuelles Objekt gibt, bleibt die Liste unverändert.
    public void remove(){
        Knoten tmp=akt;
        if(akt!=null&&isEmpty()==false)
            akt=null;
        akt=tmp.getNachfolger();
    }
}