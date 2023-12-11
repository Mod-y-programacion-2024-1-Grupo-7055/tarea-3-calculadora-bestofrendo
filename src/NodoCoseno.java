public class NodoCoseno extends NodoOperador {
    /**
     *
     * @param izq
     * @param der
     */
    public NodoCoseno(CompositeEA izq, CompositeEA der) {
        super(izq, der);
        precedence=2;
    }
 /**
     * La evaluación del nodo, divide la evaluación de los hijos izquierdo y
     * derecho.
     *
     * @return el coseno del hijo derecho
     */
    @Override
    public double evalua() {
        return Math.cos(der.evalua());
    }
  
}