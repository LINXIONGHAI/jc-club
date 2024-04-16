import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("zhangsan,22");
        list.add("lisi,25");
        list.add("wangwu,24");
        Collections.addAll(list, "zhaoliu,26", "wangqi,27");
        Map<String, String> collect = list.stream().filter(s -> Integer.parseInt(s.split(",")[1]) > 24)
                .collect(Collectors.toMap(s -> s.split(",")[0], s -> s.split(",")[1]));

        System.out.println(collect);


    }

}
