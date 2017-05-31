import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Юля on 24.04.2017.
 */
public class Text {
    private Sentence[] sentences = new Sentence[16];

    public Text(String text){
        sentences=TokenToSentence(text);

    }

    public Sentence[] TokenToSentence(String text){
        ArrayList<Sentence> temp=new ArrayList<Sentence>();
        StringTokenizer tokenizer=new StringTokenizer(text,".!?");
        while(tokenizer.hasMoreTokens()){
            Sentence token=new Sentence(tokenizer.nextToken());
            temp.add(token);
        }
        Sentence[] sentences=new Sentence[temp.size()];
        sentences=temp.toArray(sentences);
        return sentences;
    }
}
