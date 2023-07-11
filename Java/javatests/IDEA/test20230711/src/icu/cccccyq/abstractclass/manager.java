package icu.cccccyq.abstractclass;

public class manager extends employee {
    public double bonus;
    public manager (String name, int id, double salary){
        super(name,id,salary);
    }

    public double getBonus() {
        return bonus;
    }
    public void work(){
        System.out.println("6");
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
//test