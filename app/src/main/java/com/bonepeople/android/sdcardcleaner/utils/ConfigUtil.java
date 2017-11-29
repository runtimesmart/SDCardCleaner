package com.bonepeople.android.sdcardcleaner.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Set;

/**
 * 负责配置文件的读写
 * <p>
 * Created by bonepeople on 2017/11/29.
 */

public class ConfigUtil {
    private static final String FILENAME = "config";
    private static final String FIELD_SAVELIST = "saveList";
    private static final String FIELD_CLEANLIST = "cleanList";

    /**
     * 将保留文件的列表存入配置文件中
     */
    public static void putSaveList(@NonNull Context _context, @Nullable Set<String> _list) {
        SharedPreferences _sharedpreferences = _context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor _editor = _sharedpreferences.edit();
        _editor.putStringSet(FIELD_SAVELIST, _list);
        _editor.apply();
    }

    /**
     * 将清理文件的列表存入配置文件中
     */
    public static void putCleanList(@NonNull Context _context, @Nullable Set<String> _list) {
        SharedPreferences _sharedpreferences = _context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor _editor = _sharedpreferences.edit();
        _editor.putStringSet(FIELD_CLEANLIST, _list);
        _editor.apply();
    }

    /**
     * 从配置文件中读取保留文件列表
     */
    @Nullable
    public static Set<String> getSaveList(@NonNull Context _context) {
        SharedPreferences _sharedperferences = _context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        return _sharedperferences.getStringSet(FIELD_SAVELIST, null);
    }

    /**
     * 从配置文件中读取清理文件列表
     */
    @Nullable
    public static Set<String> getCleanList(@NonNull Context _context) {
        SharedPreferences _sharedperferences = _context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        return _sharedperferences.getStringSet(FIELD_CLEANLIST, null);
    }
}
