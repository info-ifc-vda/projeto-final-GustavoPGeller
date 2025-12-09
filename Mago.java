public class Mago extends Personagem
{
    protected int mana;
    protected int manaMax;

    public Mago(String n)
    {
        super(n, 12, 6);
        this.mana = 12;
        this.tipo = 3;
        this.vidaMax = this.vida;
        this.manaMax = this.mana;

        inventario.add(new PocaoMana());
    }

    @Override
    public int atacar()
    {
        if (this.mana >= 5)
        {
            this.mana -= 5;
            System.out.println(this.nome+" lança uma bola de fogo!");
            return this.dano;
        }

        else
        {
            System.out.println(this.nome+" não tem mana suficiente!\n"+this.nome+" recupera 2 de mana!");
            this.mana += 3;
            return 0;
        }
    }

    @Override
    public void receberDano(int d)
    {
        this.vida -= (d - this.defesa);
        if(this.vivo())
        {
            System.out.println(this.nome+" recebeu "+(d - this.defesa)+" de dano!");
        }
    }

    public void curarMana(int cura)
    {
        this.mana = (this.mana + cura);
    }

    //get
    public int getMana()
    {
        return this.mana;
    }
    public int getManaMax()
    {
        return this.manaMax;
    }
}
