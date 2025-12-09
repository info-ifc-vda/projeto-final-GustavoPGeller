public class Bandido extends Npc
{
    public Bandido() 
    {
        super("Bandido", 30, 6);
        this.vidaMax = 30;
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
            System.out.println("Bandido recebeu "+d+" de dano!");
        }
    }
}