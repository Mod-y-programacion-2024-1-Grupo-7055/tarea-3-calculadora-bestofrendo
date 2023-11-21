public class NodoTangente extends NodoOperador {
    /**
     *
     * @param izq
     * @param der
     */
    public NodoTangente(CompositeEA izq, CompositeEA der) {
        super(izq, der);
        precedence=2;
    }
 /**
     * La evaluación del nodo, divide la evaluación de los hijos izquierdo y
     * derecho.
     *
     * @return la tan del hijo izquierdo
     */
    @Override
    public double evalua() {
        return Math.tan(der.evalua());
    }
  
}