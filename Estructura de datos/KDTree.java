import java.util.ArrayList;
import java.util.List;

class Punto {
    double x, y; // Coordenadas en el plano

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Método para calcular la distancia entre dos puntos
    public double distancia(Punto otro) {
        double dx = this.x - otro.x;
        double dy = this.y - otro.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

class KDTree {
    private static class Nodo {
        Punto punto;
        Nodo izquierdo;
        Nodo derecho;

        Nodo(Punto punto) {
            this.punto = punto;
            izquierdo = null;
            derecho = null;
        }
    }

    private Nodo raiz;

    public KDTree(List<Punto> puntos) {
        raiz = construirArbol(puntos, 0);
    }

    private Nodo construirArbol(List<Punto> puntos, int profundidad) {
        if (puntos.isEmpty()) {
            return null;
        }

        int k = 2; // 2D space, cambia según tus dimensiones
        int eje = profundidad % k;

        puntos.sort((p1, p2) -> {
            if (eje == 0) {
                return Double.compare(p1.x, p2.x);
            } else {
                return Double.compare(p1.y, p2.y);
            }
        });

        int indiceMediano = puntos.size() / 2;
        Nodo nodoMediano = new Nodo(puntos.get(indiceMediano));

        nodoMediano.izquierdo = construirArbol(puntos.subList(0, indiceMediano), profundidad + 1);
        nodoMediano.derecho = construirArbol(puntos.subList(indiceMediano + 1, puntos.size()), profundidad + 1);

        return nodoMediano;
    }

    public Punto encontrarVecinoMasCercano(Punto objetivo) {
        return encontrarVecinoMasCercano(raiz, objetivo, 0, null);
    }

    private Punto encontrarVecinoMasCercano(Nodo nodoActual, Punto objetivo, int profundidad, Punto masCercano) {
        if (nodoActual == null) {
            return masCercano;
        }

        double distanciaActual = nodoActual.punto.distancia(objetivo);
        double mejorDistancia = (masCercano != null) ? masCercano.distancia(objetivo) : Double.POSITIVE_INFINITY;

        if (distanciaActual < mejorDistancia) {
            masCercano = nodoActual.punto;
        }

        int eje = profundidad % 2;
        Nodo siguienteRama, ramaOpuesta;

        if ((eje == 0 && objetivo.x < nodoActual.punto.x) || (eje == 1 && objetivo.y < nodoActual.punto.y)) {
            siguienteRama = nodoActual.izquierdo;
            ramaOpuesta = nodoActual.derecho;
        } else {
            siguienteRama = nodoActual.derecho;
            ramaOpuesta = nodoActual.izquierdo;
        }

        masCercano = encontrarVecinoMasCercano(siguienteRama, objetivo, profundidad + 1, masCercano);

        if ((eje == 0 && Math.abs(objetivo.x - nodoActual.punto.x) < mejorDistancia) ||
            (eje == 1 && Math.abs(objetivo.y - nodoActual.punto.y) < mejorDistancia)) {
            masCercano = encontrarVecinoMasCercano(ramaOpuesta, objetivo, profundidad + 1, masCercano);
        }

        return masCercano;
    }


    public static void main(String[] args) {
        List<Punto> puntos = new ArrayList<>();
        puntos.add(new Punto(2, 3));
        puntos.add(new Punto(5, 4));
        puntos.add(new Punto(9, 6));
        puntos.add(new Punto(4, 7));
        puntos.add(new Punto(8, 1));

        KDTree kdTree = new KDTree(puntos);

        Punto objetivo = new Punto(7, 3);
        Punto masCercano = kdTree.encontrarVecinoMasCercano(objetivo);

        System.out.println("El punto más cercano a " + objetivo.x + ", " + objetivo.y + " es " + masCercano.x + ", " + masCercano.y);
    }
}

