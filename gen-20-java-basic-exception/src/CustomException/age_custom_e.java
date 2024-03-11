package CustomException;

public class age_custom_e extends Exception {

    public age_custom_e(){}
    public age_custom_e(String message){
        super(message);
    }

    public age_custom_e (Throwable cause){
        super(cause);
    }

    public age_custom_e(String message, Throwable cause){
        super(message, cause);
    }
}
