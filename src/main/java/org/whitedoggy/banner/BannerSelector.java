package org.whitedoggy.banner;

import java.util.Random;

public class BannerSelector {
    private final Banner[] banner;

    public BannerSelector(Banner[] banners) {
        this.banner = banners;
    }

    public Banner select(int pc, boolean c1, boolean c2, boolean used) {
        if(c1 && c2){
            if(!used) return banner[1];
            else return banner[3];
        }
        if(pc >= 1) return banner[0];
        return banner[2];
    }
}