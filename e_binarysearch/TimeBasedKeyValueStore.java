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

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        List<Pair> pairs = map.get(key);
        int left = 0, right = pairs.size() - 1;
        String result = "";

        while(left <= right) {
            int mid = (left + right) / 2;

            if(pairs.get(mid).timestamp = timestamp) return pairs.get(mid).value;
            else if(pairs.get(mid).timestamp < timestamp) {
                result = pairs.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}