class StateTable {
    private final int noOfStates;
    private final String[] aliases;

    StateTable(int noOfStates){
        this.noOfStates = noOfStates;
        aliases = new String[noOfStates];
    }

    void setAlias(int idx, String alias){
        aliases[idx] = alias;
    }

    String getAlias(int idx){
        return aliases[idx];
    }

    int getNoOfStates(){
        return noOfStates;
    }

    int getState (String alias){
        for (int i = 0; i < aliases.length; i++) {
            if (alias.equals(aliases[i])) {
                return i;
            }
        }
        return -1;
    }
}

