public class NodoRaizCuadrada extends NodoOperador {
    /**
     *
     * @param izq
     * @param der
     */
    public NodoRaizCuadrada(CompositeEA izq, CompositeEA der) {
        super(izq, der);
        precedence=2;
    }
 /**
     * La evaluación del nodo, divide la evaluación de los hijos izquierdo y
     * derecho.
     *
     * @return la raíz cuadrada del hijo derecho
     */
    @Override
    public double evalua() {
        if (der.evalua() < 0) {
            throw new ArithmeticException("No puedes sacar raices negativas");
        }
        return Math.sqrt(der.evalua());
    }
  
}