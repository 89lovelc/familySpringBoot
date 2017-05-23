package com.hjh.cn.controller;

import com.hjh.cn.Application;
import com.hjh.cn.storage.FileSystemStorageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 89lovelc on 2017/5/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes =Application.class)
public class FileUploadServiceTest {

    @Autowired
    private FileSystemStorageService fileSystemStorageService;

    @Test
    public void test(){
        System.out.println(fileSystemStorageService.getMusicList());
    }
}
