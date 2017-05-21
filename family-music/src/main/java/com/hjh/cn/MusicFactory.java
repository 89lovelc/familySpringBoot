package com.hjh.cn;

import javax.sound.sampled.FloatControl;
import java.net.URL;

/**
 * Created by 89lovelc on 2017/5/20.
 */
public class MusicFactory {

    private MusicFactory(){};

    private static BasicMusicPlayer basicMusicPlayer = new BasicMusicPlayer();

    /**
     * 暂停
     */
    public static void pause(){
        if(!basicMusicPlayer.isEmpty()){
            basicMusicPlayer.pause();
        }
    }

    /**
     * 加载
     * @param url
     */
    public static void load(URL url){
        if(!basicMusicPlayer.isEmpty()){
            basicMusicPlayer.end();
            while(basicMusicPlayer.isOver != true){
            }
            basicMusicPlayer.isOver = false;
            basicMusicPlayer.setEnd(false);
        }
        basicMusicPlayer.load(url);
    }


    /**
     * 播放
     */
    public  static void play(){
        if(!basicMusicPlayer.isEmpty()){
            Thread  thread = new Thread(){
                @Override
                public void run() {
                    basicMusicPlayer.play();
                }
            };
            thread.start();
        }else{

        }
    }


    /**
     * 继续播放
     */
    public static void resume(){
        if(!basicMusicPlayer.isEmpty()){
            basicMusicPlayer.resume();
        }
    }


    /**
     * 调节声音
     * @param deep
     */
    // 音量minValue -80 maxValue 6
    public static void deep(int deep){
        FloatControl controller = basicMusicPlayer.getFloatVoiceControl();
        float value = (float) (-80 + (deep/100.00) * 86);
        controller.setValue(value);
        basicMusicPlayer.value = value;

    }

}
