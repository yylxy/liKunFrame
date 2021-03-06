package com.hbung.http.download;

/**
 * 作者　　: 李坤
 * 创建时间: 15:10 Administrator
 * 邮箱　　：496546144@qq.com
 * <p>
 * 功能介绍：实现接口的抽象类
 */
public abstract class DownloadTaskListenerAdapter implements DownloadTaskListener {
    /**
     * 下载暂停
     *
     * @param downloadTask
     * @param completedSize
     * @param totalSize
     * @param percent
     */
    public void onPause(DownloadTask downloadTask, long completedSize, long totalSize, double percent) {

    }

    /**
     * 下载取消
     *
     * @param downloadTask
     */
    public void onCancel(DownloadTask downloadTask) {

    }


    /**
     * 下载失败
     *
     * @param downloadTask
     * @param errorCode    {@link DownloadStatus}
     */
    public void onError(DownloadTask downloadTask, int errorCode) {

    }


}
