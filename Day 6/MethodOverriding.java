class Animal{
    void makeSound(){
        System.out.println("Animal Sound");
    }
}

class Dog extends Animal{
    @Override
    void makeSound(){
        System.out.println("Dog Barks : bow bow");
    }
}
class Cat extends Animal{
    @Override
    void makeSound(){
        System.out.println("Cat meows : Meow meow");

    }
}
public class MethodOverriding{
    public static void main(String[] args) {
        Animal myDog =new Dog();
        Animal myCat =new Cat();
        System.out.println("Dog Sound");
        myDog.makeSound();
        System.out.println("Cat Sound");
        myCat.makeSound();
    }
}