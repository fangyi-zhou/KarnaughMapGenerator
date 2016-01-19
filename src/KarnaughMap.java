/**
 * Created by fangyi on 17/01/2016.
 */
public class KarnaughMap {

    private boolean[][] transitions;
    private char[][][] output = new char[3][4][4];
    private final String[] prefixesVertical = { "00", "01", "11", "10" };
    private final String[] prefixesHorizontal = { "00", "01", "11", "10" };


    public KarnaughMap(TransitionTable tTable){
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
        for (int i = 0; i < transitions.length; i++){
            int vertical = getIdx(transitions[i][2], transitions[i][3]);
            int horizontal = getIdx(transitions[i][0], transitions[i][1]);
            char out = getCharOutput(transitions[i][4 + num]);
            output[num][horizontal][vertical] = out;
        }
    }

    private int getIdx(boolean x, boolean y){
        if (!x && !y) {
            return 0;
        } else if (!x && y) {
            return 1;
        } else if (x && y) {
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

    public void show(){
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
