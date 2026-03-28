public class TimeBasedKeyValueStore {
    private Map<String, List<Pair> map;

    static class Pair {
        int timestamp;
        String value;
        public Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }


}