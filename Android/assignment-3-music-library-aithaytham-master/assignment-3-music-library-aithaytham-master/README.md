# Assignment 3: Music Library

After manipulating basic widgets, the objective of this assignment is to
work with Activities and Intents. In the previous lecture, we have seen
how to create new Activities and how to create Intents to pass
information from an Activity to another.

This assignment will also make you work on concepts seen in Lecture 2
such as RecyclerViews.

This assignment requires less implementation work than Assignment 2, but
it might take you some time to correctly read and use the information
written in the file that comes with the starter code.

## Description of the App

This app is similar to your favorite music player application, except
that we are not going to play any song. We will simply be listing names
of artists, albums, and songs.

The starter code provides you with an empty project. Your task will
consist in:

- Creating three Activities: BandActivity, AlbumActivity, and
  SongActivity;
- In BandActivity, the application should:
	- Read the contents of the CSV file;
    - Display the names of the bands in a RecyclerView;
    - When the user clicks on an item in the list, AlbumActivity should
      appear.
- In AlbumActivity, the application should:
	- Read the contents of the CSV file;
	- Display a RecyclerView with the titles of the albums corresponding
		  to the Band that was clicked on;
    - When the user clicks on an item in the list, SongActivity should
      appear.
- In SongActivity, the application should:
	- Read the contents of the CSV file;
	- Display in a RecyclerView the titles of the songs in the album
		  that the user selected.

The CSV file contains:

- A header row that describes the contents of each album;
- A list of bands, albums, and songs.

It is located in the `res/raw` folder.

## Bonus to make the app better

All this section is bonus work. Please make sure that the principal
features are implemented correctly before working on bonuses.

1. Instead of reading the contents of the file in every activity, pass
	 the necessary information with Intents;
2. Use a custom layout for to display the items of the RecyclerView so
	 that it can display the album's artwork;

## Deadline for submission

Deadline: October 22nd, 2019 23:59

Lateness policy applies if still available. Issues with configuring the
IDE or working with Git/GitHub will not warrant any deadline extension.
