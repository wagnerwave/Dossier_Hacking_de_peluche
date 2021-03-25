package com.cuatroochenta.miniland.model;

import androidx.core.app.NotificationCompatJellybean;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SongCategory {
    public String id;
    public ArrayList<Song> songList;
    public String title;

    public SongCategory() {
    }

    public SongCategory(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.id = jSONObject.getString("id");
            this.title = jSONObject.has(NotificationCompatJellybean.KEY_TITLE) ? jSONObject.getString(NotificationCompatJellybean.KEY_TITLE) : "";
            if (jSONObject.has("songs")) {
                this.songList = new ArrayList<>();
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray("songs");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.songList.add(new Song(jSONArray.getJSONObject(i)));
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            throw new JSONException("Error while parsing CategorySong Object. Source empty");
        }
    }

    public void addSongToList(Song song) {
        if (this.songList == null) {
            this.songList = new ArrayList<>();
        }
        this.songList.add(song);
    }

    public String getId() {
        return this.id;
    }

    public ArrayList<Song> getSongList() {
        return this.songList;
    }

    public String getTitle() {
        return this.title;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
