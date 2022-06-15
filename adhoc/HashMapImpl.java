import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class HashMapImpl {
    private int id;
    private String name;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        HashMap<String, String> h = new HashMap<>();

        System.out.println(h.put("key", "val"));
        System.out.println(h.put("key", "val"));

    }

    public Map<Integer, HashMapImpl> convertListAfterJava8(List<HashMapImpl> list) {
        Map<Integer, HashMapImpl> map = list.stream()
                .collect(Collectors.toMap(HashMapImpl::getId, Function.identity()));
        return map;
    }

}