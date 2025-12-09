public class PocaoCura extends Item
{

    public PocaoCura()
    {
        super("Poção de Cura");
    }

    @Override
    public void usar(Personagem p)
    {
        p.curar(10);
        System.out.println(p.getNome() + " recuperou 10 de vida!");
    }
}
