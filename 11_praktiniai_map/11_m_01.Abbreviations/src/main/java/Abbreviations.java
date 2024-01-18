import java.util.HashMap;
import java.util.Map;

public class Abbreviations {
    Map<String, String> map;
    private String abbreviation;
    private String explanation;

    public Abbreviations() {
    }

    public void addAbbreviation(String abbreviation, String explanation) {
//        this.abbreviation = abbreviation;
//        this.explanation = explanation;
//        map = new HashMap<String, String>() {{
//            put("abbreviation", "explanation");
//        }};
        map = new HashMap<>();
        map.put(abbreviation,explanation);
    }

    public boolean hasAbbreviation(String abbreviation) {
        return map.containsKey(abbreviation);
    }
    public  String findExplanationFor (String abbreviation){
        return map.get(abbreviation);
    }
}
