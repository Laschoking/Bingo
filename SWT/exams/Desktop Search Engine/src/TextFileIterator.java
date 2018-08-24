import java.lang.reflect.Array;
import java.util.*;

public class TextFileIterator implements Iterator<String> {
    String answer ="We wish you good luck in this exam!\nWe hope you are well pre-\npared";
    Resource res;
    int i = 0;
    String[] ar;




    public TextFileIterator(Resource res){
        if(res == null)  throw new NullPointerException();
        this.res = res;
        String tmp = answer.replaceAll("!"," ");
        tmp = tmp.replaceAll("\n","");
        tmp = tmp.replaceAll("-","");

        ar = tmp.split(" ");



    }
    @Override
    public boolean hasNext() {
        if (i   < ar.length && ar.length != 0 ) return true;
        else return false;
    }

    @Override
    public String next() {
        if (hasNext()){
            String temp = ar[i];

            System.out.println(ar[i]);
            i++;
            return temp;

        }
        throw new NoSuchElementException();
    }

    @Override
    public void remove(){
        throw new UnsupportedOperationException();
    }

    public String getAsString(Resource res){
        return answer;

    }

}
