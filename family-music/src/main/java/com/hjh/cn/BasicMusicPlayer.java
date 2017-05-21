package com.hjh.cn;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 黄建辉 on 2017/1/4.
 */
public class BasicMusicPlayer {

    private File file;
    private URL url;
    /**
     * 总音量的控制
     */
    private FloatControl floatVoiceControl;

    private  boolean isPause = false;
    private boolean isEnd = false;
    private boolean isEmpty = true;
    public boolean isOver = false;

    public float  value = -37;




    public BasicMusicPlayer(File file) {
        this.file = file;
    }

    public BasicMusicPlayer(URL url) {
        this.url = url;
    }

    public BasicMusicPlayer(){}

    public void play(){
        try {
            //得到本地音频输入流
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
            //得到音频编码格式
            AudioFormat audioFormat = audioInputStream.getFormat();
            // MPEG1L3转PCM_SIGNED
            if (audioFormat.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
                audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                        audioFormat.getSampleRate(), 16,
                        audioFormat.getChannels(),
                        audioFormat.getChannels() * 2,
                        audioFormat.getSampleRate(), false);
                audioInputStream = AudioSystem.getAudioInputStream(audioFormat,
                        audioInputStream);
            }
            //根据上面的音频格式获取输出信息
            DataLine.Info info = new DataLine.Info(SourceDataLine.class,audioFormat);
            //获取输出设备对象
            SourceDataLine sourceDataLine =(SourceDataLine) AudioSystem.getLine(info);
            //打开输出管道
            sourceDataLine.open();
            //允许管道执行数据io
            sourceDataLine.start();
            //获取总音量的控件
            floatVoiceControl = (FloatControl) sourceDataLine
                    .getControl(FloatControl.Type.MASTER_GAIN);
            // 音量minValue -80 maxValue 6
            // 设合适的初始音量
            floatVoiceControl.setValue(value);
            byte[] buf  = new byte[1024];
            int onceReadDataSize = 0;
            while((onceReadDataSize = audioInputStream.read(buf,0,buf.length))!= -1){
                if(isPause){
                    _pause();
                }
                if(isEnd){
                    isOver = true;
                    return ;
                }
                sourceDataLine.write(buf, 0, onceReadDataSize);
            }
            sourceDataLine.drain();
            sourceDataLine.close();
            audioInputStream.close();

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private synchronized void _pause() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized  void resume(){
        isPause = false;
        this.notify();
    }

    public void pause(){
        this.isPause = true;
    }


    public void  load(File file){
        this.file = file;
        try {
            this.url =  file.toURL();
            isEmpty =false;
        } catch (MalformedURLException e) {
            System.out.println("无法转化为URL");
            e.printStackTrace();
        }
    }

    public void load(URL url){
        this.url = url;
        this.isEmpty = false;
    }


    public FloatControl getFloatVoiceControl() {
        return floatVoiceControl;
    }

    public void end(){
        this.isEnd = true;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}
