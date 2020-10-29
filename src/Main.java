class Main {
    public static void main(String[] args) {
        List l = new List();
        Aufgabe a = new Aufgabe("HEE HEE");
        l.append(a);
        l.append(a);
        l.append(a);
        l.append(a);
        l.toFirst();
        System.out.println(l.hasAccess());

    }
}