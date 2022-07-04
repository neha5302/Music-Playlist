package com.neha;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
   private String name;
   private String artist;
   private ArrayList<Song> songs;
   public Album(String name,String artist){
       this.name = name;
       this.artist = artist;
       this.songs = new ArrayList<Song>();
   }
   public Album(){

   }
   public boolean addSong(String title,double duration){
        if (findSong(title)==null){
            songs.add(new Song(title,duration));
            System.out.println(title + " successfully added to the list");
            return true;
        }else {
            System.out.println("Song with name " + title + "already exists!");
            return false;
        }
   }

    private Song findSong(String title) {
       for (Song check : songs){
           if (check.getTitle().equals(title))return check;
       }
       return null;
    }
    public boolean addToPlaylist(int trackNumber, LinkedList<Song> Playlist){
       int index = trackNumber-1;
       if (index>0 && index<=this.songs.size()){
           Playlist.add(this.songs.get(index));
           return true;
       }
       else{
           System.out.println("This album does not have song with track number "+trackNumber);
           return false;
       }

   }
   public boolean addToPlaylist(String title, LinkedList<Song> Playlist){
       for (Song check : this.songs){
           if (check.getTitle().equals(title)){
               Playlist.add(check);
               return true;
           }
       }
       System.out.println(title + " there is not such song in album");
       return false;
   }
}
