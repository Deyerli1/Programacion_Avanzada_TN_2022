public class Main {
    
    public static void main(String[] args) {

        Procesador pro = new Procesador();
//        String correcto = "esta es una prueba para ver como nos da el resultado del ejercicio, quiero creer que VA A DAR BIEN pero tengo ganas de llorar";
//        String incorrecto = "esat es uan uapber aarp rve coom nso ad le routdsela edl ciejieocr, rioeuq cerre que VA A RDA IENB repo gtoen asnag de olarlr";
//        
        //PRUEBA 3 = 124
        String correcto = "Estamos pintando! Gracias vuelva prontos! El Colo Sapeee";
        String incorrecto = "ostant!Em inpaEados lGci tp!Sase vCeeursa oelvla pooron";

        
        //System.out.println(pro.procesar("Estamos pintando! Gracias vuelva prontos! El Colo Sapeee", "ostant!Em inpaEados lGci tp!Sase vCeeursa oelvla pooron"));
        System.out.println(pro.procesar(correcto,incorrecto));
    }
}