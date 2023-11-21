public class NodoSeno extends NodoOperador {
    /**
     *
     * @param izq
     * @param der
     */
    public NodoSeno(CompositeEA izq, CompositeEA der) {
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
        if (izq==null){
            return Math.sin(der.evalua());
        }
        return Math.sin(der.evalua());
    }
  
}