package com.stacktips.collections.list.linkedlist;

import java.util.LinkedList;

public class _1a_MusicPlayList {
    private final LinkedList<Song> playlist;

    public _1a_MusicPlayList() {
        playlist = new LinkedList<>();
    }

    public void addSong(Song song) {
        playlist.add(song);
    }

    public void removeSong(Song song) {
        playlist.remove(song);
    }

    public void displayPlaylist() {
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ". " + playlist.get(i));
        }
    }

    public static void main(String[] args) {
        _1a_MusicPlayList myPlaylist = new _1a_MusicPlayList();

        Song song1 = new Song("Bohemian Rhapsody", "Queen");
        Song song2 = new Song("Imagine", "John Lennon");
        Song song3 = new Song("Hotel California", "Eagles");

        myPlaylist.addSong(song1);
        myPlaylist.addSong(song2);
        myPlaylist.addSong(song3);

        System.out.println("My Playlist:");
        myPlaylist.displayPlaylist();

        System.out.println("Removing 'Imagine' from playlist.");
        myPlaylist.removeSong(song2);

        System.out.println("Updated Playlist:");
        myPlaylist.displayPlaylist();
    }
}
