package org.jellyfin.androidtv.playback;

import androidx.leanback.media.PlayerAdapter;

public class VideoPlayerAdapter extends PlayerAdapter {

    private final PlaybackController playbackController;

    public VideoPlayerAdapter(PlaybackController playbackController) {
        this.playbackController = playbackController;
    }

    @Override
    public void play() {
        playbackController.play(playbackController.getCurrentPosition());
    }

    @Override
    public void pause() {
        playbackController.pause();
    }

    @Override
    public void seekTo(long positionInMs) {
        playbackController.seek(positionInMs);
    }

    @Override
    public long getDuration() {
        return playbackController.getCurrentlyPlayingItem().getRunTimeTicks()!= null ?
                playbackController.getCurrentlyPlayingItem().getRunTimeTicks() / 10000 : -1;
    }

    @Override
    public long getCurrentPosition() {
        return playbackController.getCurrentPosition();
    }

    @Override
    public boolean isPlaying() {
        return playbackController.isPlaying();
    }

    @Override
    public long getBufferedPosition() {
        return getDuration();
    }

    void updateCurrentPosition() {
        getCallback().onCurrentPositionChanged(this);
    }

    void updatePlayState() {
        getCallback().onPlayStateChanged(this);
    }
}
