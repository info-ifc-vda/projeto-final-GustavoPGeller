public class Goblin extends Npc
{
    public Goblin() 
    {
        super("Goblin", 12, 4);
        this.vidaMax = 12;
    }

    @Override
    public int atacar()
    {
        return this.dano;
    }

    @Override
    public void receberDano(int d)
    {
        this.vida -= d;
        if(this.vivo())
        {
            System.out.println("Goblin recebeu "+d+" de dano!");
        }
    }
}