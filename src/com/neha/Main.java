package com.neha;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {

        Album album = new Album("Album1","Artist1");
        album.addSong("song1",4.2);
        album.addSong("song2",6.2);
        album.addSong("song3",1.52);
        album.addSong("song4",3.5);
        albums.add(album);
        album = new Album("Album2","Artist2");
        album.addSong("song1",4.2);
        album.addSong("song2",2.2);
        album.addSong("song3",1.5);

        albums.add(album);

        LinkedList<Song> playlist1 = new LinkedList<>();
        albums.get(0).addToPlaylist("song1",playlist1);
        albums.get(0).addToPlaylist("song4",playlist1);
        albums.get(1).addToPlaylist("song2",playlist1);
        
        play(playlist1);
    }

    private static void play(LinkedList<Song> playlist) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();

        if (playlist.size()==0){
            System.out.println("This playlist have no songs");
        }else {
            System.out.println("Now Playing:--\n"  + listIterator.next().toString());
            printMenu();
        }
        while (!quit){
            int action = sc.nextInt();
            sc.nextLine();
            switch (action){
                case 0:
                    System.out.println("Playlist is complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }if (listIterator.hasNext()){
                    System.out.println("Now playing "+listIterator.next().toString());
                }else {
                    System.out.println("No song available. Reached to the end of the list");
                    forward = false;
                }
                    break;

                case 2:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now playing "+ listIterator.previous().toString());
                    }else {
                        System.out.println("We are at the first song");
                     forward = false;
                    }
                    break;

                case 3:
                    if (forward){
                        if (listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                        forward = false;
                    }else {
                            System.out.println("We are at the start of the list");
                        }
                    }else {
                        if (listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("We are at the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playlist.size()>0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now playing: " + listIterator.next().toString());
                            forward= true;
                        }else {
                            if (listIterator.hasPrevious()) {
                                System.out.println("Now playing: " + listIterator.previous().toString());
                            }
                        }
                    }
            }
    }
    }
    private static void printMenu(){
        System.out.println("Hey! Available options are:\n press");
        System.out.println("""
                0 - to quit
                1 - to play next song
                2 - to play previous song
                3 - to replay the current song
                4 - to get list of all songs
                5 - print all the options
                6 - remove the current song from playlist
                """);
    }
    private static void printList(LinkedList<Song> playlist){
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("-------------------------");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-------------------------");
    }
}
