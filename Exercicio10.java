
import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int jogo_velha[][] = new int[3][3];
        int x;
        int y;
        boolean jogo = true;
        System.out.println("Bem vindo ao jogo da velha, o primeiro jogador sera o numero 1 e o outro o numero 2.");
        System.out.println("Escolham números entre 1 e 3.");
        while (jogo) {
            for (int v = 0; v < 2; v++) {
                System.out.printf("Vez do jogador %d ", v + 1);
                System.out.print("\nFileira: ");
                x = ler.nextInt();
                System.out.print("Coluna: ");
                y = ler.nextInt();
                //Verificar se o espaço está disponivel.
                if (verificar(jogo_velha, x-1, y-1)) {
                    //atribuir valor
                    atribuir(jogo_velha, x-1, y-1, v);
                } else {
                    //Fazer o jogador escolher um espaço disponivel
                    while (!verificar(jogo_velha, x-1, y-1)) {
                        System.out.println("espaço ocupado, jogue novamente");
                        demonstrarMatriz(jogo_velha);
                        System.out.print("\nFileira: ");
                        x = ler.nextInt();
                        System.out.print("Coluna: ");
                        y = ler.nextInt();
                    }
                    atribuir(jogo_velha, x-1, y-1, v);
                }
                demonstrarMatriz(jogo_velha);
                //Verifica se algum jogador ganhou
                if(!ganhador(jogo_velha, 1)){
                    System.out.println("Jogador 1 ganhou!");
                    System.exit(v);
                }else if(!ganhador(jogo_velha, 2)){
                    System.out.println("Jogador 2 ganhou!");
                    System.exit(v);
                }else{
                    //Verifica se deu velha
                    if(!verificarmatriz(jogo_velha)){
                        System.exit(v);
                    }
                }
            }
        }
    }
    private static boolean ganhador(int[][] jogo_velha,int x) {
        if(!ganhadorColuna(jogo_velha,x)) {
            return false;
        }
        else if(!ganhadorFileira(jogo_velha,x)) {
            return false;
        }
        else if(!ganhadorDiagonal(jogo_velha,x)) {
            return false;
        }
        return true;
    }
    private static boolean ganhadorDiagonal(int[][] jogo_velha,int x) {
        int countPrin = 0;
        int countSec= 0;
        for(int l = 0; l< jogo_velha.length; l++){
            for (int c = 0; c< jogo_velha[0].length; c++){
                if(l==c){
                    if (jogo_velha[l][c] == x) {
                        countPrin++;
                        if (l == 1 ){
                            if (jogo_velha[l][c] == x) {
                                countSec++;
                            }
                        }
                    }
                }else if(l == 0 && c == 2){
                    if (jogo_velha[l][c] == x) {
                        countSec++;
                    }
                }else if (l == 2 && c == 0) {
                    if (jogo_velha[l][c] == x) {
                        countSec++;
                    }
                }
                if(countPrin == 3 || countSec == 3){
                    return false;
                }

            }
        }
        return true;
    }
    private static boolean ganhadorColuna(int[][] jogo_velha, int x) {
        for (int l = 0; l <3; l++) {
            int count= 0;
            for (int c = 0; c < 3; c++) {
                if (jogo_velha[l][c] == x) {
                    count++;
                }
            }
            if(count == 3){
                return false;
            }
        }

        return true;
    }

    private static boolean ganhadorFileira(int[][] jogo_velha, int x) {
        for(int c = 0; c<3; c++) {
            int count = 0;
            for (int l = 0; l < 3; l++) {
                if (jogo_velha[l][c] == x) {
                    count++;
                }
            }
            if (count == 3) {
                return false;
            }
        }
        return true;
    }

    private static void atribuir(int[][] jogo_velha, int x, int y, int v) {
        if (v == 0) {
            jogo_velha[x][y] = 1;
        } else if (v == 1) {
            jogo_velha[x][y] = 2;
        }
    }

    private static void demonstrarMatriz(int[][] matriz) {
        for (int l = 0; l < matriz.length; l++) {
            for (int c = 0; c < matriz[0].length; c++) {
                System.out.print(" " + matriz[l][c]);
            }
            System.out.println("");
        }
    }

    private static boolean verificar(int[][] matriz, int l, int c) {
        if (matriz[l][c] != 0) {
            return false;
        }
        return true;
    }
    private static boolean verificarmatriz(int[][] jogo_velha) {
        int verificar = 0;
        for (int i = 0; i < jogo_velha.length; i++) {
            for (int j = 0; j < jogo_velha[0].length; j++) {
                if (jogo_velha[i][j]==0) {
                    verificar++;
                }
            }
        }
        if (verificar == 0) {
            System.out.println("Parece que deu velha, ninguem ganhou!!");
            return false;
        }
        return true;
    }

}

