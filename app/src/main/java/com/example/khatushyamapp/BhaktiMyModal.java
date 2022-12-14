package com.example.khatushyamapp;

import java.util.ArrayList;
import java.util.List;

public class BhaktiMyModal {
    private String status;
    private String msg;
    private Integer paginationlimit;
    private List<Wallpaper> wallpapers = new ArrayList<Wallpaper>();
    private Integer count;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Integer getPaginationlimit() {
        return paginationlimit;
    }
    public void setPaginationlimit(Integer paginationlimit) {
        this.paginationlimit = paginationlimit;
    }
    public List<Wallpaper> getWallpapers() {
        return wallpapers;
    }
    public void setWallpapers(List<Wallpaper> wallpapers) {
        this.wallpapers = wallpapers;
    }
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    class Wallpaper {
        private String id;
        private String catId;
        private String imgavatar;
        private String views;
        private String title;
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getCatId() {
            return catId;
        }
        public void setCatId(String catId) {
            this.catId = catId;
        }
        public String getImgavatar() {
            return imgavatar;
        }
        public void setImgavatar(String imgavatar) {
            this.imgavatar = imgavatar;
        }
        public String getViews() {
            return views;
        }
        public void setViews(String views) {
            this.views = views;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
    }
}
