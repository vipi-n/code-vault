package practice.interviews;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortDaysWithEnum {

    enum SortEnum{
        SUNDAY(0),MONDAY(1),TUESDAY(2),WEDNESDAY(3),THURSDAY(4),FRIDAY(5),SATURDAY(6);
        private Integer weekdayVal;
        SortEnum(Integer weekdayVal){
            this.weekdayVal = weekdayVal;
        }
        public Integer getWeekdayVal(){
            return this.weekdayVal;
        }
    }

    public static void main(String[] args) {
        Arrays.asList(SortEnum.MONDAY, SortEnum.SUNDAY, SortEnum.THURSDAY)
                .stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
    }

}
