package KMP;

import javax.sound.midi.Patch;

/**
 * 
 */
public class KMP {
    private int[][] table;
    private String pat;
    public KMP(String pat){
        this.pat=pat;
        if(pat.length()==0){
            System.out.println("Invalid pattern: length is zero");
        }
        else{
            buildTable(pat);
        }
    }
    /**
     * 
     * @param pat: the string used as pattern
     * this function will build a pat.length*256 array as the table
     * table[i][j] shows at pat.charAt(i) if a character:char(j) shows up
     * what state will the process be in.
     */
    private void buildTable(String pat){
        this.table=new int[pat.length()][256];
        this.table[0][pat.charAt(0)]=1;
        int shadowState=0;
        for(int i=1;i<pat.length();i++){
            for(int j=0;j<256;j++){
                if(j==pat.charAt(i)){ 
                    table[i][j]=i+1;
                }
                else{ // current char didn't match the criterion for the proceeding state, 
                // retreat to the shadow state and see where the current char will bring us to.
                    table[i][j]=table[shadowState][j];
                }
            }
            shadowState=table[shadowState][pat.charAt(i)];
        }
    }

    /**
     * 
     * @param txt: the corpus we use to find whether pat is in or not.
     * this function aims to find whether pat is in txt, using table of course.
     */
    public int isPatIn(String txt){
        if(this.table==null){
            return -1;
        }
        int currentState=0;
        for(int i=0;i<txt.length();i++){
            currentState=this.table[currentState][txt.charAt(i)];
            if(currentState==this.pat.length()){
                return i-this.pat.length()+1;
            }
        }
        return -1;
    }
}
