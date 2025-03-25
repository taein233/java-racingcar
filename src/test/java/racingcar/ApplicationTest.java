package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.InstanceOfAssertFactories.ARRAY;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    public class Random{

    }
    @Override
    public void runMain() {
        Scanner sc = new Scanner(System.in);
        //System.out.println("경주할 자동차 이름을 입력하세요.");
        String[] name = sc.next().split(",");
        for(int k = 0; k < name.length; k++){
            if(name[k].length() >= 5){
                throw new IllegalArgumentException();
            }
        }
        System.out.println("시도할 횟수는 몇번인가요?");
        int input_num = sc.nextInt();
        int[] name_add = new int[name.length];
        int[] ans = new int[name.length];
        for(int i = 0; i < input_num; i++) {
            int[] arr_num = new int[name.length];
            for(int j= 0; j < name.length; j++) {
                arr_num[j] = Randoms.pickNumberInRange(0, 9);
                if (arr_num[j] >= 4) {
                    ans[j] += 1;
                }
                System.out.print(name[j] + " : ");
                for (int k=0;k<ans[j];k++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }
        for (int max = 0; max < name.length; max++) {

        }
        Application.main(new String[]{});

    }
}
