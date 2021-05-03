# language: en

@searchVideo

Feature: Search and Watch a video on Youtube

Scenario: Search a video

Given go to Google
When search "youtube"
And click on first link
Then go to YouTube
When search for the "Vegita olha bem" video
And click on first video
Then watch the video