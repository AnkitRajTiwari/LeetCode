class TimeMap {

    public static class Info {
        int timestamp;
        String value;

        public Info(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Info>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Info> infoList = map.getOrDefault(key, new ArrayList<>());
        infoList.add(new Info(value, timestamp));
        map.put(key, infoList);
    }

    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            return binarySearch(map.get(key), timestamp);
        }
        return "";
    }

    public String binarySearch(List<Info> listOfInfo, int timestamp) {
        int start = 0, end = listOfInfo.size() - 1;
        String value = "";
        while (start <= end) {
            int mid = (end + start) / 2;
            if (listOfInfo.get(mid).timestamp <= timestamp) {
                value = listOfInfo.get(mid).value;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */