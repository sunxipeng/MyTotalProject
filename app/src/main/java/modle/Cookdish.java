package modle;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/1/12.
 */
public class Cookdish implements Serializable{

    private static final long serialVersionUID = -7060210544600464481L;

    public ArrayList<String> albums;

    public String burden;

    public String imtro;

    public String ingredients;

    public  ArrayList<Step> steps;

    public  String tags;

    public  String title;


    public class Step implements Serializable{

        public String img;

        public String step;

    }
}
