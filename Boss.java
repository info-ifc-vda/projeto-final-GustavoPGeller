public class Boss extends Npc
{
    public Boss() 
    {
        super("Null Reaper", 100, 8);
        this.vidaMax = 100;
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
            System.out.println("O Null Reaper recebeu "+d+" de dano!");
        }
    }
}