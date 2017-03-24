package com.cfm880.drag.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by chengfangming on 2017/3/15.
 */

public class Menu {

    /**
     * update : 1
     * md5 : 4a5c016a5c9c73ca5a7ac1c4bfb7b3ef
     * ret : 1
     * msg : ok
     * currVer : 80
     * from : android
     * URL : http://cdn.tg0123.com/zbd/u2/menu/
     * cate : {"selected":1,"item":[{"name":"热门","cateid":"10000","img":"aa.png","img_up":"aa1.png","activitytype":1,"data1":"1","data2":"1","default":1},{"name":"完赛","cateid":"10002","img":"aa.png","img_up":"aa.png","activitytype":0,"data1":"1","data2":"1","default":1},{"name":"全部","cateid":"10001","img":"quanbudianji.png","img_up":"quanbu.png","activitytype":2,"data1":"1","data2":"1","default":1},{"name":"NBA","cateid":"9","img":"nbadianji.png","img_up":"nba.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"CBA","cateid":"1","img":"cbadianji.png","img_up":"cba.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"英超","cateid":"3","img":"yingchaodianji.png","img_up":"yingchao.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"西甲","cateid":"5","img":"xijiadianji.png","img_up":"xijia.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"排球","cateid":"44","img":"paiqiudianji_1.png","img_up":"paiqiu_1.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"羽毛球","cateid":"45","img":"yumaoqiudianji_1.png","img_up":"yumaoqiu_1.png","activitytype":4,"data1":"1","data2":"1","default":0},{"name":"网球","cateid":"35","img":"wangqiudianji_1.png","img_up":"wangqiu_1.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"中超","cateid":"18","img":"zhongchaodianji.png","img_up":"zhongchao.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"亚冠","cateid":"15","img":"yaguandianji.png","img_up":"yaguan.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"欧冠","cateid":"8","img":"ouguandianji.png","img_up":"ouguan.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"德甲","cateid":"2","img":"dejiajianji.png","img_up":"dejia.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"意甲","cateid":"4","img":"yijiadianji.png","img_up":"yijia.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"欧联杯","cateid":"12","img":"oulianbeidianji.png","img_up":"oulianbei.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"中甲","cateid":"19","img":"zhongjiadianji.png","img_up":"zhongjia.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"国足","cateid":"23","img":"zhongguozuqiudianji.png","img_up":"zhongguozuqiu.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"国际足球","cateid":"22","img":"guojizuqiudianji.png","img_up":"guojizuqiu.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"法甲","cateid":"11","img":"fajiadianji.png","img_up":"fajia.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"台球","cateid":"36","img":"taiqiudianji_1.png","img_up":"taiqiu_1.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"乒乓球","cateid":"47","img":"pingpangqiudianji_1.png","img_up":"pingpangqiu_1.png","activitytype":4,"data1":"1","data2":"1","default":0},{"name":"拳击","cateid":"41","img":"quanjidianji_1.png","img_up":"quanji_1.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"全部完赛","cateid":"10003","img":"","img_up":"","activitytype":-1,"data1":"","data2":"","default":1}]}
     * main : {"selected":0,"item":[{"cateid":1,"name":"主页","img_up":"aa.png","img_down":"bb.png","opentype":"5","data1":"http://www.baidu.com","data2":""},{"cateid":2,"name":"赛事","img_up":"aa.png","img_down":"bb.png","opentype":"5","data1":"http://www.baidu.com","data2":""},{"cateid":3,"name":"新闻","img_up":"aa.png","img_down":"bb.png","opentype":"5","data1":"http://www.baidu.com","data2":""},{"cateid":4,"name":"发现","img_up":"aa.png","img_down":"bb.png","opentype":"5","data1":"http://www.baidu.com","data2":""}]}
     */

    private int update;
    private String md5;
    private int ret;
    private String msg;
    private int currVer;
    private String from;
    private String URL;
    private CateBean cate;
    private MainBean main;

    public int getUpdate() {
        return update;
    }

    public void setUpdate(int update) {
        this.update = update;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCurrVer() {
        return currVer;
    }

    public void setCurrVer(int currVer) {
        this.currVer = currVer;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public CateBean getCate() {
        return cate;
    }

    public void setCate(CateBean cate) {
        this.cate = cate;
    }

    public MainBean getMain() {
        return main;
    }

    public void setMain(MainBean main) {
        this.main = main;
    }

    public static class CateBean {
        /**
         * selected : 1
         * item : [{"name":"热门","cateid":"10000","img":"aa.png","img_up":"aa1.png","activitytype":1,"data1":"1","data2":"1","default":1},{"name":"完赛","cateid":"10002","img":"aa.png","img_up":"aa.png","activitytype":0,"data1":"1","data2":"1","default":1},{"name":"全部","cateid":"10001","img":"quanbudianji.png","img_up":"quanbu.png","activitytype":2,"data1":"1","data2":"1","default":1},{"name":"NBA","cateid":"9","img":"nbadianji.png","img_up":"nba.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"CBA","cateid":"1","img":"cbadianji.png","img_up":"cba.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"英超","cateid":"3","img":"yingchaodianji.png","img_up":"yingchao.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"西甲","cateid":"5","img":"xijiadianji.png","img_up":"xijia.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"排球","cateid":"44","img":"paiqiudianji_1.png","img_up":"paiqiu_1.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"羽毛球","cateid":"45","img":"yumaoqiudianji_1.png","img_up":"yumaoqiu_1.png","activitytype":4,"data1":"1","data2":"1","default":0},{"name":"网球","cateid":"35","img":"wangqiudianji_1.png","img_up":"wangqiu_1.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"中超","cateid":"18","img":"zhongchaodianji.png","img_up":"zhongchao.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"亚冠","cateid":"15","img":"yaguandianji.png","img_up":"yaguan.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"欧冠","cateid":"8","img":"ouguandianji.png","img_up":"ouguan.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"德甲","cateid":"2","img":"dejiajianji.png","img_up":"dejia.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"意甲","cateid":"4","img":"yijiadianji.png","img_up":"yijia.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"欧联杯","cateid":"12","img":"oulianbeidianji.png","img_up":"oulianbei.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"中甲","cateid":"19","img":"zhongjiadianji.png","img_up":"zhongjia.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"国足","cateid":"23","img":"zhongguozuqiudianji.png","img_up":"zhongguozuqiu.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"国际足球","cateid":"22","img":"guojizuqiudianji.png","img_up":"guojizuqiu.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"法甲","cateid":"11","img":"fajiadianji.png","img_up":"fajia.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"台球","cateid":"36","img":"taiqiudianji_1.png","img_up":"taiqiu_1.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"乒乓球","cateid":"47","img":"pingpangqiudianji_1.png","img_up":"pingpangqiu_1.png","activitytype":4,"data1":"1","data2":"1","default":0},{"name":"拳击","cateid":"41","img":"quanjidianji_1.png","img_up":"quanji_1.png","activitytype":4,"data1":"1","data2":"1","default":1},{"name":"全部完赛","cateid":"10003","img":"","img_up":"","activitytype":-1,"data1":"","data2":"","default":1}]
         */

        private int selected;
        private List<ItemBean> item;

        public int getSelected() {
            return selected;
        }

        public void setSelected(int selected) {
            this.selected = selected;
        }

        public List<ItemBean> getItem() {
            return item;
        }

        public void setItem(List<ItemBean> item) {
            this.item = item;
        }

        public static class ItemBean {
            /**
             * name : 热门
             * cateid : 10000
             * img : aa.png
             * img_up : aa1.png
             * activitytype : 1
             * data1 : 1
             * data2 : 1
             * default : 1
             */

            private String name;
            private String cateid;
            private String img;
            private String img_up;
            private int activitytype;
            private String data1;
            private String data2;
            @SerializedName("default")
            private int defaultX;
            private int weights;

            public int getWeights() {
                return weights;
            }

            public void setWeights(int weights) {
                this.weights = weights;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCateid() {
                return cateid;
            }

            public void setCateid(String cateid) {
                this.cateid = cateid;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getImg_up() {
                return img_up;
            }

            public void setImg_up(String img_up) {
                this.img_up = img_up;
            }

            public int getActivitytype() {
                return activitytype;
            }

            public void setActivitytype(int activitytype) {
                this.activitytype = activitytype;
            }

            public String getData1() {
                return data1;
            }

            public void setData1(String data1) {
                this.data1 = data1;
            }

            public String getData2() {
                return data2;
            }

            public void setData2(String data2) {
                this.data2 = data2;
            }

            public int getDefaultX() {
                return defaultX;
            }

            public void setDefaultX(int defaultX) {
                this.defaultX = defaultX;
            }
        }
    }

    public static class MainBean {
        /**
         * selected : 0
         * item : [{"cateid":1,"name":"主页","img_up":"aa.png","img_down":"bb.png","opentype":"5","data1":"http://www.baidu.com","data2":""},{"cateid":2,"name":"赛事","img_up":"aa.png","img_down":"bb.png","opentype":"5","data1":"http://www.baidu.com","data2":""},{"cateid":3,"name":"新闻","img_up":"aa.png","img_down":"bb.png","opentype":"5","data1":"http://www.baidu.com","data2":""},{"cateid":4,"name":"发现","img_up":"aa.png","img_down":"bb.png","opentype":"5","data1":"http://www.baidu.com","data2":""}]
         */

        private int selected;
        private List<ItemBeanX> item;

        public int getSelected() {
            return selected;
        }

        public void setSelected(int selected) {
            this.selected = selected;
        }

        public List<ItemBeanX> getItem() {
            return item;
        }

        public void setItem(List<ItemBeanX> item) {
            this.item = item;
        }

        public static class ItemBeanX {
            /**
             * cateid : 1
             * name : 主页
             * img_up : aa.png
             * img_down : bb.png
             * opentype : 5
             * data1 : http://www.baidu.com
             * data2 :
             */

            private int cateid;
            private String name;
            private String img_up;
            private String img_down;
            private String opentype;
            private String data1;
            private String data2;

            public int getCateid() {
                return cateid;
            }

            public void setCateid(int cateid) {
                this.cateid = cateid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg_up() {
                return img_up;
            }

            public void setImg_up(String img_up) {
                this.img_up = img_up;
            }

            public String getImg_down() {
                return img_down;
            }

            public void setImg_down(String img_down) {
                this.img_down = img_down;
            }

            public String getOpentype() {
                return opentype;
            }

            public void setOpentype(String opentype) {
                this.opentype = opentype;
            }

            public String getData1() {
                return data1;
            }

            public void setData1(String data1) {
                this.data1 = data1;
            }

            public String getData2() {
                return data2;
            }

            public void setData2(String data2) {
                this.data2 = data2;
            }
        }
    }
}
