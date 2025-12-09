public class Lobo extends Npc
{
    public Lobo() 
    {
        super("Lobo", 7, 3);
        this.vidaMax = 7;
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
            System.out.println("Lobo recebeu "+d+" de dano!");
        }
    }
}
