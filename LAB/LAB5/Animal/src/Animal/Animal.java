package Animal;

//begin class Animal
public abstract class Animal {
    public String kind;//the animal kind   
    
    //begin method get_kind
    public String get_kind(){
   	 return kind;
    }//end method get_kind
    
    //abstract method talk
    public abstract void talk();
}//end class Animal
