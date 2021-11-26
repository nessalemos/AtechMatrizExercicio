import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class main {

    public int maximum(int matriz[][]){
        int temp[] = new int[matriz[0].length];
        main mh = new main();
        int maxArea = 0;
        int area = 0;
            for(int i=0; i < matriz.length; i++){
                for(int j=0; j < temp.length; j++){
                    if(matriz[i][j] == 0){
                        temp[j] = 0;
                    }else{
                        temp[j] += matriz[i][j];
                    }
                }
                area = mh.maxHistogram(temp);
                if(area > maxArea){
                    maxArea = area;
                }
            }
        return maxArea;
    }

    public int maxHistogram(int temp[]){
        Deque<Integer> stack = new LinkedList<Integer>();
        int maxArea = 0;
        int area = 0;
        int i;
        for(i=0; i < temp.length;){
            if(stack.isEmpty() || temp[stack.peekFirst()] <= temp[i]){
                stack.offerFirst(i++);
            }else{
                int top = stack.pollFirst();

                if(stack.isEmpty()){
                    area = temp[top] * i;
                }
                else{
                    area = temp[top] * (i - stack.peekFirst() - 1);
                }
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }

    public static void main(String args[]){

        int min = 0;
        int max = 1;

        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o número de linhas da Matriz: ");
        int dimensao = entrada.nextInt();
        Scanner entrada2 = new Scanner(System.in);
        System.out.println("Digite o número de colunas da Matriz");
        int dimensao2 = entrada2.nextInt();
        int[][] matriz = new int[dimensao][dimensao2];

        for(int row1 = 0; row1 < matriz.length; row1++){
            for(int col1 = 0; col1 < matriz[row1].length; col1++) {
                matriz[row1][col1] = (int) Math.floor(Math.random() * (max - min + 1) + min);
                System.out.print(matriz[row1][col1] + " ");
            }
            System.out.println();
        }

        main main = new main();
        int maxRectangle = main.maximum(matriz);
        System.out.println("Área do maior retângulo: " + maxRectangle);
    }
}

