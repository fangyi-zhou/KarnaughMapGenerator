import java.util.HashMap;
import java.util.Map;

class StateTable {
    private final int noOfStates;
    private final String[] aliases;
    private final Map<String, Integer> revMap;

    StateTable(int noOfStates){
        this.noOfStates = noOfStates;
        aliases = new String[noOfStates];
        revMap = new HashMap<>();
    }

    boolean setAlias(int idx, String alias){
        if (revMap.containsKey(alias)) {
            return false;
        }
        if (aliases[idx] != null) {
            revMap.remove(aliases[idx]);
        }
        aliases[idx] = alias;
        revMap.put(alias, idx);
        return true;
    }

    String getAlias(int idx){
        return aliases[idx];
    }

    int getNoOfStates(){
        return noOfStates;
    }

    int getState (String alias){
        Integer result = revMap.get(alias);
        return (result == null) ? -1 : result;
    }
}