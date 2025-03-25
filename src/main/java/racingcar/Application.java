package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Scanner;
 class RandomNum{
     private int num = 0;
     private int car_num = 0;
     public int random_num(){
         num = Randoms.pickNumberInRange(0, 9);
         if(num >= 4) car_num += 1;
         return car_num;
     }
}
class Carprint{
    StringBuilder car_position = new StringBuilder();

     public String print_car(int go_car_int){
            String car_position = "-".repeat(go_car_int);
            return car_position;
    }
}
class Winner {
     //우승자 출력
}

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        String input = Console.readLine();
        String[] name = input.split(",");
        for(int k = 0; k < name.length; k++){
           if(name[k].length() >= 5){
                throw new IllegalArgumentException();
            }
         }
        //글자가 5이상으로 입력되고 난 뒤에 다시 입력을 받아야 하는데 이미 name 배열의 크기가 정해져 버림
        //다시 입력을 받을때 name 배열도 다시 입력되어야됨..

        System.out.println("시도할 횟수는 몇번인가요?");
        int input_num = Integer.parseInt(Console.readLine());
        System.out.println(input_num);
        RandomNum[] cars = new RandomNum[name.length];
        Carprint[] p_cars = new Carprint[name.length];
        int[] go_number = new int[name.length];
        for(int i = 0; i < name.length; i++){
            cars[i] = new RandomNum();
            p_cars[i] = new Carprint();
        }


        for(int k = 0; k < input_num; k++){
            for(int j = 0; j < name.length; j++){
                go_number[j] = cars[j].random_num();
            }

            for(int j = 0; j < name.length; j++){
                System.out.println(name[j] + " : " + p_cars[j].print_car(go_number[j]));
            }
        }

        int max = go_number[0];
        for(int i = 0; i < name.length; i++){
            if(go_number[i] > max){
                max = go_number[i];
            }
        }

        System.out.println("최종 우승자 : ");
        for(int i = 0; i < name.length; i++){
            if(go_number[i] == max){
                System.out.println(name[i]+",");
            }
        }
    }
}
