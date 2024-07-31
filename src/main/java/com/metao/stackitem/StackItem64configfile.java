package com.metao.stackitem;

import net.fabricmc.fabric.mixin.item.ItemAccessor;
import net.minecraft.component.ComponentMap;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.*;

import java.util.stream.Stream;


public class StackItem64configfile {
    private final Logger logger = LogManager.getLogger(StackItem64configfile.class);
    //json 생성 파일경로
    final File jsonconfile = Paths.get("config", "stackitem.json5").toFile();

    public void InitConfig () throws IOException {
        StackItem64load.SetStack stack;
        //json 파일 없으면 생성
        if (!jsonconfile.exists()) {
            try (InputStream in = this.getClass().getClassLoader().getResourceAsStream("default_stackitemconfig.json5")) {
                if (in == null) {
                    throw new IllegalStateException("json file load fail");
                }
                java.nio.file.Files.copy(in, jsonconfile.toPath());
            }
            catch (Exception e) {
                logger.catching(Level.ERROR, e);
            }
        }
        try (final InputStream in = new FileInputStream(jsonconfile)) {
            //json 파일서 설정 불러오기
            stack = StackItem64load.loadFile(in);
            SetStacking(stack);
        }

    }
    private static void SetStacking (StackItem64load.SetStack setStack) {
        int i;
        //아이템 갯수 설정파일서 아이템 이름, 최대 갯수 불러온뒤 리스트화
        List<String> Itemname = Stream.of(setStack.ItemName).toList();
        List<Integer> Itemstack = new ArrayList<>(Stream.of(setStack.ItemStack).toList()) ;
        //아이템 갯수 목록 마지막이 빈값이면 제거
        if (Itemstack.getLast() == null){
            Itemstack.removeLast();
        }
        //아이템 갯수 목록이 아이템 이름보다 많으면 제거 (오류 방지용)
            while (Itemstack.size() > Itemname.size()) {
                Itemstack.removeLast();
            }
        //아이템 최대 갯수 조절 반복문
        for (i=0; i<Itemstack.size();i++ ) {
            Item ChangeItemStack = Registries.ITEM.get(Identifier.of(Itemname.get(i)));
            ((ItemAccessor) ChangeItemStack).setComponents(ComponentMap.builder()
                    .addAll(ChangeItemStack.getComponents())
                    .add(DataComponentTypes.MAX_STACK_SIZE, Itemstack.get(i))
                    .build());

        }


    }


}

