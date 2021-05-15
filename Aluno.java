public class Aluno extends Thread{
    private String nome;
    private int[][] ma = {{1,2,3},{4,5,6},{7,8,9}};
    private Long delay = 0L;

    public Aluno(String nome, Long delay){
        this.nome = nome;
        this.delay = delay;
        start();
    }

    public void run(){
        if(delay > 0){
            try {
                sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Aluno : " + nome);
        imprimirMatriz(ma);
        int[][] mb = somarMatrizes(ma,ma);
        imprimirMatriz(mb);
    }

    public int[][] somarMatrizes(int[][] a, int[][] b){
        for(var i=0; i<a.length; i++){
            for(var j=0; j<a[i].length; j++){
                a[i][j] = a[i][j] + b[i][j];
            }
        }
        return a;
    }

    public void imprimirMatriz(int[][] matriz){
        for(var i=0; i < matriz.length; i++){
            var temp = "|  ";
            for(var j=0; j < matriz[i].length; j++){
                Integer y = matriz[i][j];
                temp = temp + imprimirNumero(matriz[i][j]) + " ";
            }
            temp = temp + "|";
            System.out.println(temp);
        }
        System.out.println("");
    }

    public String imprimirNumero(int num){
        Integer y = num;
        String space = "";
        if(num < 10){
            space = "   ";
        } else if(num < 100){
            space = "  ";
        } else if(num < 1000){
            space = "  ";
        }
        return y.toString() + space;
    }
}