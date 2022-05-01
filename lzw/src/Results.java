import java.util.Vector;

public class Results {
    private Vector<String> dictionary=new Vector<>();
    private Vector<String> code=new Vector<>();

    public Results() {
    }

    public Vector<String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Vector<String> dictionary) {
        this.dictionary = dictionary;
    }

    public Vector<String> getCode() {
        return code;
    }

    public void setCode(Vector<String> code) {
        this.code = code;
    }
}
