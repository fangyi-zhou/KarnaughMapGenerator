class KarnaughMap {

    private final boolean[][] transitions;
    private final char[][][] output = new char[3][4][4];
    private final String[] prefixesVertical = { "00", "01", "11", "10" };
    private final String[] prefixesHorizontal = { "00", "01", "11", "10" };


    KarnaughMap(TransitionTable tTable){
        this.transitions = tTable.getTransitions();
        generateMap();
    }

    private void generateMap(){
        for (int i = 0; i < 3; i++){
            generateMap(i);
        }
    }

    private void generateMap(int num){
        initialMap(num);
        for (boolean[] transition : transitions) {
            int vertical = getIdx(transition[2], transition[3]);
            int horizontal = getIdx(transition[0], transition[1]);
            char out = getCharOutput(transition[4 + num]);
            output[num][horizontal][vertical] = out;
        }
    }

    private int getIdx(boolean x, boolean y){
        if (!x && !y) {
            return 0;
        } else if (!x) {
            return 1;
        } else if (y) {
            return 2;
        } else {
            return 3;
        }
    }

    private char getCharOutput(boolean x){
        return x ? '1' : '0';
    }

    private void initialMap(int num){
        for (int i = 0; i < output[num].length; i++){
            for (int j = 0; j < output[num][i].length; j++){
                output[num][i][j] = 'x';
            }
        }
    }

    void show(){
        for (int i = 0; i < 3; i++){
            System.out.println();
            System.out.println("D" + (2 - i));
            System.out.print("\t");
            for (int j = 0; j < 4; j++){
                System.out.print(prefixesVertical[j] + "\t");
            }
            System.out.println();
            for (int j = 0; j < 4; j++){
                System.out.print(prefixesHorizontal[j] + "\t");
                for (int k = 0; k < 4; k++){
                    System.out.print(output[i][j][k] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
