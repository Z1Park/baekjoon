class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String[]> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();
        for (String log : logs) {
            String[] split = log.split(" ");
            if (Character.isDigit(split[1].charAt(0))) digitList.add(log);
            else letterList.add(split);
        }
        Collections.sort(letterList, (o1, o2) -> {
            int len = Math.min(o1.length, o2.length);
            for (int i = 1; i < len; i++) {
                int comparsion = o1[i].compareTo(o2[i]);
                if (comparsion != 0)
                    return comparsion;
            }
            int comparsion = Integer.compare(o1.length, o2.length);
            if (comparsion != 0) return comparsion;
            return o1[0].compareTo(o2[0]);
        });
        String[] result = new String[logs.length];
        int idx = 0;
        for (String[] letterLog : letterList)
            result[idx++] = String.join(" ", letterLog);
        for (String digitLog : digitList)
            result[idx++] = digitLog;
        return result;
    }
}