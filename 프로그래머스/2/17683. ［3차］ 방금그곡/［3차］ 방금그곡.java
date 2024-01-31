class Solution {
    
    private String tunning(String m) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m.length(); i++) {
            if (i < m.length() - 1 && m.charAt(i+1) == '#') {
                sb.append('(');
                sb.append(m.charAt(i));
                sb.append("#)");
                i++;
            }
            else sb.append(m.charAt(i));
        }
        return sb.toString();
    }
    
    private int getPlaytime(String st, String et) {
        int start = Integer.parseInt(st.substring(0, 2)) * 60 
            + Integer.parseInt(st.substring(3, 5));
        int end = Integer.parseInt(et.substring(0, 2)) * 60 
            + Integer.parseInt(et.substring(3, 5));
        return end - start;
    }
    
    private String getMusic(String melody, int playtime) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, idx = 0; i < playtime; i++, idx++) {
            if (melody.charAt((idx+1) % melody.length()) == '#') {
                sb.append('(');
                sb.append(melody.charAt(idx % melody.length()));
                idx++;
                sb.append("#)");
            }
            else {
                sb.append(melody.charAt(idx % melody.length()));
            }
        }
        return sb.toString();
    }
    
    public String solution(String m, String[] musicinfos) {
        m = tunning(m);
        int maxLength = 0;
        String result = "(None)";
        for (String musicinfo : musicinfos) {
            String[] info = musicinfo.split(",");
            int playtime = getPlaytime(info[0], info[1]);
            String music = getMusic(info[3], playtime);
            if (maxLength < playtime && music.indexOf(m) != -1) {
                maxLength = playtime;
                result = info[2];
            }
        }
        return result;
    }
}