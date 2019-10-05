import java.util.Enumeration; 
import java.util.Hashtable; 

import static java.lang.System.out; 

public class TestMachineProprties { 

        public static void main(String ...args) { 
                out.println("Properties : "); 
                Hashtable<Object, Object> props = System.getProperties(); 
                Enumeration<Object> keys = props.keys(); 
                while(keys.hasMoreElements()) { 
                        Object key = keys.nextElement(); 
                        out.println(key + " : " + props.get(key)); 
                } 
                out.println("availableProcessors : " + Runtime.getRuntime().availableProcessors()); 
                out.println("NUMBER_OF_PROCESSORS : " + System.getenv("NUMBER_OF_PROCESSORS")); 
        } 
}


