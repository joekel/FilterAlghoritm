package collectionTutorial;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class TestExclStrat implements ExclusionStrategy {

    public boolean shouldSkipClass(Class<?> arg0) {
        return false;
    }

    public boolean shouldSkipField(FieldAttributes f) {

        return (f.getDeclaringClass() == User.class && f.getName().equals("ik"))
        		
        		||
        		
        (f.getDeclaringClass() == User.class && f.getName().equals("name"));
    }

}