/**
 * Created by fangyi on 17/01/2016.
 */
public class StateTable {
    int noOfStates;
    String[] aliases;
    public StateTable(int noOfStates){
        this.noOfStates = noOfStates;
        aliases = new String[noOfStates];
    }

    public void setAlias(int idx, String alias){
        aliases[idx] = alias;
    }

    public String getAlias(int idx){
        return aliases[idx];
    }

    public int getNoOfStates(){
        return noOfStates;
    }

    public int getState (String alias){
        for (int i = 0; i < aliases.length; i++) {
            if (alias.equals(aliases[i])) {
                return i;
            }
        }
        return -1;
    }
}

