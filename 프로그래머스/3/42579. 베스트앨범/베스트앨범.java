import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 많이 재생된 장르가 일빠따 수록
        // 그 장르 안에서 젤 많이 재생된 노래 먼저 수록
        // 재생횟수가 같으면 고유번호 기준 오름차순 수록 (인덱스가 고유번호임)
        
        Map<String, PriorityQueue<Music>> album = new HashMap<>();
        Map<String, Integer> totalCntMap = new HashMap<>();
        Set<String> genreNames = new HashSet<>();
        
        for(int i=0; i<genres.length; i++) {
            int uniqueIdx = i;
            String genre = genres[i];
            int playCnt = plays[i];
            genreNames.add(genre);
            
            totalCntMap.put(genre, totalCntMap.getOrDefault(genre, 0) + playCnt);
            PriorityQueue pq = album.getOrDefault(genre, new PriorityQueue<>());
            pq.add(new Music(uniqueIdx, playCnt));
            album.put(genre, pq);
        }
        
        List<Genre> list = new ArrayList<>();
        for(String name : genreNames) {
            int totalNum = totalCntMap.get(name);
            list.add(new Genre(name, totalNum));
        }
        
        list.sort((g1, g2) -> {
            // if(g1.totalPlay == g2.totalPlay) {
            //     return g1.
            // }
            return g2.totalPlay - g1.totalPlay;
        });
        
        List<Integer> result = new ArrayList<>();
        for(Genre genre : list) {
            String name = genre.genre;
            PriorityQueue<Music> pq = album.get(name);
            if(pq.size() < 2) {
                Music music = pq.poll();
                result.add(music.num);
                continue;
            }
            for(int i=0; i<2; i++) {
                result.add(pq.poll().num);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static class Music implements Comparable<Music> {
        int num;
        int playNum;
        
        public Music(int num, int playNum) {
            this.num = num;
            this.playNum = playNum;
        }
        
        @Override
        public int compareTo(Music other) {
            if(other.playNum == this.playNum) {
                return this.playNum - other.playNum;
            }
            
            return other.playNum - this.playNum;
        }
    }
    
    static class Genre {
        String genre;
        int totalPlay;
        
        public Genre(String genre, int totalPlay) {
            this.genre = genre;
            this.totalPlay = totalPlay;
        }
    }
}