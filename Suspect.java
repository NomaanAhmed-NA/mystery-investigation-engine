public class Suspect {
    String name;
    int age;
    String relation;
    String alibi;

    public Suspect(String name, int age, String relation, String alibi) {
        this.name = name;
        this.age = age;
        this.relation = relation;
        this.alibi = alibi;
    }
    
    // print suspect info
    public void display() {
        System.out.println(name + " (" + age + ") - " + relation);
        System.out.println("alibi: " + alibi);
        System.out.println("-");
    }
}
