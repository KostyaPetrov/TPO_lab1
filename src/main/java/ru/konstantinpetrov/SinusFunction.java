package ru.konstantinpetrov;


public class SinusFunction {

    public float getFact(float val){
        float res=1;
        for(int i=1; i<=val;i++){
            res*=i;
        }
        return res;
    }



    public int sineExpansion(float x, int n) {
        float res=0;
        for(int i=1; i<n; i++){
            res+=(Math.pow(-1, i-1)*Math.pow(x, 2*i-1))/getFact(2*i-1);
        }
        res=Math.round(res);
        return (int) res;
    }

}
