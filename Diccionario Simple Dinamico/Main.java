public class Main {
    public static void main(String[] args) {
        DiccionarioSimpleTDA d = new DiccionarioSimple();

        d.InicializarDiccionario();

        d.Agregar(1, 100);
        d.Agregar(2, 200);
        d.Agregar(1, 150);

        System.out.println(d.Recuperar(1));
        System.out.println(d.Recuperar(2));

        d.Eliminar(2);

        int[] claves = d.Claves();

        for (int i = 0; i < claves.length; i++) {
            System.out.println(claves[i]);
        }
    }
}