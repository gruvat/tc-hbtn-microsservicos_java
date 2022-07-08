package com.song.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SongRepository {
    private List<Song> list = new ArrayList<Song>();

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
        for (Song song : list) {
            if (song.getId().equals(id)) {
                return song;
            }
        }
        return null;
    }

    public void addSong(Song s) {
        this.list.add(s);
    }

    public void updateSong(Song s) {
        for (int i=0; i < this.list.size(); i++) {
            if (list.get(i).getId().equals(s.getId())) {
                list.remove(i);
                list.add(s);
                break;
            }
        }
    }

    public void removeSong(Song s) {
        for (int i=0; i < this.list.size(); i++) {
            if (list.get(i).getId().equals(s.getId())) {
                list.remove(i);
                break;
            }
        }
    }

}
