public class DiccionarioSimple implements DiccionarioSimpleTDA {

    NodoDiccionario origen;

    @Override
    public void InicializarDiccionario() {
        origen = null;
    }

    @Override
    public void Agregar(int clave, int valor) {
        NodoDiccionario aux = origen;

        while (aux != null && aux.clave != clave) {
            aux = aux.sig;
        }

        if (aux != null) {
            aux.valor = valor;
        } else {
            NodoDiccionario nuevo = new NodoDiccionario();
            nuevo.clave = clave;
            nuevo.valor = valor;
            nuevo.sig = origen;
            origen = nuevo;
        }
    }

    @Override
    public void Eliminar(int clave) {
        if (origen != null) {
            if (origen.clave == clave) {
                origen = origen.sig;
            } else {
                NodoDiccionario ant = origen;
                NodoDiccionario act = origen.sig;

                while (act != null && act.clave != clave) {
                    ant = act;
                    act = act.sig;
                }

                if (act != null) {
                    ant.sig = act.sig;
                }
            }
        }
    }

    @Override
    public int Recuperar(int clave) {
        NodoDiccionario aux = origen;

        while (aux != null && aux.clave != clave) {
            aux = aux.sig;
        }

        if (aux != null) {
            return aux.valor;
        }

        return -1;
    }

    @Override
    public int[] Claves() {
        int cantidad = 0;
        NodoDiccionario aux = origen;

        while (aux != null) {
            cantidad++;
            aux = aux.sig;
        }

        int[] claves = new int[cantidad];
        aux = origen;
        int i = 0;

        while (aux != null) {
            claves[i] = aux.clave;
            i++;
            aux = aux.sig;
        }

        return claves;
    }
}