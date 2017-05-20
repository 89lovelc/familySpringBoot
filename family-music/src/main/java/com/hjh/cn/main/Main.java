package com.hjh.cn.main;

/**
 * Created by 黄建辉 on 2017/1/5.
 */


import com.hjh.cn.BasicMusicPlayer;

import javax.sound.sampled.FloatControl;
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File file = new File(args[0]);
        final BasicMusicPlayer basicMusicPlayer = new BasicMusicPlayer();

        basicMusicPlayer.load(file);

        Thread  thread = new Thread(){
            @Override
            public void run() {
                basicMusicPlayer.play();
            }
        };

        thread.start();

        FloatControl folatController = basicMusicPlayer.getFloatVoiceControl();

        Scanner scan = new Scanner(System.in);
        while(true){
            char a = scan.next().charAt(0);
            switch (a) {
                case '1':
                    basicMusicPlayer.pause();
                    break;
                case '2':
                    basicMusicPlayer.resume();
                    break;
            }
        }
    }
}
