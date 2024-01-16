public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }
    private void eat(){
        System.out.println(name+" eats");
    }

    public String getName() {
        return name;
    }

    private void sleep(){
        System.out.println(name+" sleeps");
    }
}
