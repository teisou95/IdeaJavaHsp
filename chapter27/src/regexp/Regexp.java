package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 */
public class Regexp {
    public static void main(String[] args) {
        String content = "Apache112 起初由伊利诺伊大学香槟分校的国家超级电脑应用中心（NCSA）开发。" +
                "此后，Apache 被开放源代码团体的成员不断的发展和加强。" +
                "Apache 服务器拥有牢靠可信的美誉，" +
                "已用在超过半数的因特网站中－特别是几乎所有最热门和访问量最大的网站。\n" +
                "Apache最开始是Netscape网页服务器之外的开放源代码选择。" +
                "后来它开始在功能和速度超越其他的基于Unix的HTTP服务器。" +
                "1996年4月以来，Apache一直是Internet上最流行的HTTP服务器:" +
                " 1999年5月它在 57% 的网页服务器上运行；到了2005年7月这个比例上升到了69%。" +
                "在2005年11月的时候达到接近70%的市占率，" +
                "不过随着拥有大量域名数量的主机域名商转换为微软IIS平台" +
                "，Apache市占率近年来呈现些微下滑。" +
                "而Google自己的网页服务器平台GWS推出后，" +
                "加上Lighttpd这个轻量化网页服务器软件使用的网站慢慢增加，" +
                "反应在整体网页服务器市占率上，根据netcraft在2007年7月的最新统计数据，" +
                "Apache的市占率已经降为52.65%，8月时又滑落到50.92%。尽管如此，" +
                "它仍旧是现阶段因特网市场上，市占率最高的网页服务器软件。\n" +
                "广泛的解释是（也是最显而易见的）:这个名字来自这么一个事实:" +
                "当Apache在1995年初开发的时候，它是由当时最流行的HTTP服务器NCSA HTTPd 1.3 的代码修改而成的，" +
                "因此是“一个修补的（a patchy）”服务器。然而在服务器官方网站的FAQ中是这么解释的" +
                ":“‘Apache’这个名字是为了纪念名为Apache(印地语)的美洲印第安人土著的一支，" +
                "众所周知他们拥有高超的作战策略和无穷的耐性”。无论如何，Apache 2.x 分支不包含任何 NCSA 的代码。 [2]";
        String  sourceBaidu = "class=\"name_2Px2N\">\n" +
                "                                                <div class=\"c-single-text-ellipsis\">中共中央政治局召开会议 </div>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"c-text  hot-state_NdlbW\"></div>\n" +
                "                                    </div>\n" +
                "                                </a>\n" +
                "                                <a class=\"item-wrap_2oCLZ \" href=\"https://www.baidu.com/s?wd=%E4%B8%89%E5%8F%AA%E7%BE%8A%E8%A2%AB%E7%BD%9A%E6%B2%A16894.91%E4%B8%87+%E6%9A%82%E5%81%9C%E7%BB%8F%E8%90%A5&amp;sa=fyb_hp_news&amp;rsv_dl=fyb_hp_news\" target=\"_blank\">\n" +
                "                                    <div class=\"active-item_1Em2h\">\n" +
                "                                        <img class=\"active-item-img_3i_Tx\" src=\"https://fyb-2.cdn.bcebos.com/hotboard_image/38eb01e176c31ec41a3d347496837b12?x-bce-process=image/resize,m_fill,w_732,h_272\" alt=\"\">\n" +
                "                                        <div class=\"sign-index_mtI7K c-index-bg0\">1 </div>\n" +
                "                                        <div class=\"content-pos_1fT0H\">\n" +
                "                                            <img class=\"content-bg_3R_MY\" src=\"//fyb-pc-static.cdn.bcebos.com/static/asset/hot-title-bg_7df0f96d81d643e9b8b1cb24ad81ed7f.png\">\n" +
                "                                            <div class=\"name_2Px2N\">\n" +
                "                                                <div class=\"c-single-text-ellipsis\">三只羊被罚没6894.91万 暂停经营 </div>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"c-text c-text-bao_3s8Nn hot-state_NdlbW\">爆 </div>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"normal_1fQqB\">\n" +
                "                                        <div class=\"index_k2hIU c-index-single-hot1\">1 </div>\n" +
                "                                        <div class=\"content-wrap_1RisM\">\n" +
                "                                            <div class=\"name_2Px2N\">\n" +
                "                                                <div class=\"c-single-text-ellipsis\">三只羊被罚没6894.91万 暂停经营 </div>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"c-text c-text-bao_3s8Nn hot-state_NdlbW\">爆 </div>\n" +
                "                                    </div>\n" +
                "                                </a>\n" +
                "                                <a class=\"item-wrap_2oCLZ \" href=\"https://www.baidu.com/s?wd=%E4%B8%89%E5%8F%AA%E7%BE%8A%E5%B0%B1%E8%99%9A%E5%81%87%E5%AE%A3%E4%BC%A0%E8%87%B4%E6%AD%89%EF%BC%9A%E5%86%85%E9%83%A8%E6%95%B4%E9%A1%BF&amp;sa=fyb_hp_news&amp;rsv_dl=fyb_hp_news\" target=\"_blank\">\n" +
                "                                    <div class=\"active-item_1Em2h\">\n" +
                "                                        <img class=\"active-item-img_3i_Tx\" src=\"https://fyb-2.cdn.bcebos.com/hotboard_image/b836a20b93424be08aa7b1a074652c78?x-bce-process=image/resize,m_fill,w_732,h_272\" alt=\"\">\n" +
                "                                        <div class=\"sign-index_mtI7K c-index-bg1\">2 </div>\n" +
                "                                        <div class=\"content-pos_1fT0H\">\n" +
                "                                            <img class=\"content-bg_3R_MY\" src=\"//fyb-pc-static.cdn.bcebos.com/static/asset/hot-title-bg_7df0f96d81d643e9b8b1cb24ad81ed7f.png\">\n" +
                "                                            <div class=\"name_2Px2N\">\n" +
                "                                                <div class=\"c-single-text-ellipsis\">三只羊就虚假宣传致歉：内部整顿 </div>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"c-text c-text-hot_3ZhI9 hot-state_NdlbW\">热 </div>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"normal_1fQqB\">\n" +
                "                                        <div class=\"index_k2hIU c-index-single-hot2\">2 </div>\n" +
                "                                        <div class=\"content-wrap_1RisM\">\n" +
                "                                            <div class=\"name_2Px2N\">\n" +
                "                                                <div class=\"c-single-text-ellipsis\">三只羊就虚假宣传致歉：内部整顿 </div>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"c-text c-text-hot_3ZhI9 hot-state_NdlbW\">热 </div>\n" +
                "                                    </div>\n" +
                "                                </a>\n" +
                "                                <a class=\"item-wrap_2oCLZ \" href=\"https://www.baidu.com/s?wd=%E5%85%A8%E5%9B%BD%E5%90%84%E5%9C%B0%E8%8A%B1%E5%9B%A2%E9%94%A6%E7%B0%87%E5%96%9C%E8%BF%8E%E5%9B%BD%E5%BA%86&amp;sa=fyb_hp_news&amp;rsv_dl=fyb_hp_news\" target=\"_blank\">\n" +
                "                                    <div class=\"active-item_1Em2h\">\n" +
                "                                        <img class=\"active-item-img_3i_Tx\" src=\"https://fyb-2.cdn.bcebos.com/hotboard_image/55b0bb822ce588c8d5d97853e5b4a861?x-bce-process=image/resize,m_fill,w_732,h_272\" alt=\"\">\n" +
                "                                        <div class=\"sign-index_mtI7K c-index-bg2\">3 </div>\n" +
                "                                        <div class=\"content-pos_1fT0H\">\n" +
                "                                            <img class=\"content-bg_3R_MY\" src=\"//fyb-pc-static.cdn.bcebos.com/static/asset/hot-title-bg_7df0f96d81d643e9b8b1cb24ad81ed7f.png\">\n" +
                "                                            <div class=\"name_2Px2N\">\n" +
                "                                                <div class=\"c-single-text-ellipsis\">全国各地花团锦簇喜迎国庆 </div>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"c-text  hot-state_NdlbW\"></div>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"normal_1fQqB\">\n" +
                "                                        <div class=\"index_k2hIU c-index-single-hot3\">3 </div>\n" +
                "                                        <div class=\"content-wrap_1RisM\">\n" +
                "                                            <div class=\"name_2Px2N\">\n" +
                "                                                <div class=\"c-single-text-ellipsis\">全国各地花团锦簇喜迎国庆 </div>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"c-text  hot-state_NdlbW\"></div>\n" +
                "                                    </div>\n" +
                "                                </a>\n" +
                "                                <a class=\"item-wrap_2oCLZ \" href=\"https://www.baidu.com/s?wd=%E4%B8%9C%E5%8C%97%E9%9B%A8%E5%A7%90%E5%93%AD%E4%BA%86%EF%BC%9A%E6%9C%89%E9%97%AE%E9%A2%98%E5%80%BE%E5%AE%B6%E8%8D%A1%E4%BA%A7%E9%83%BD%E8%B5%94&amp;sa=fyb_hp_news&amp;rsv_dl=fyb_hp_news\" target=\"_blank\">\n" +
                "                                    <div class=\"active-item_1Em2h\">\n" +
                "                                        <img class=\"active-item-img_3i_Tx\" src=\"https://fyb-2.cdn.bcebos.com/hotboard_image/d34ce2a69a4366a3f704eb8e8f71e747?x-bce-process=image/resize,m_fill,w_732,h_272\" alt=\"\">\n" +
                "                                        <div class=\"sign-index_mtI7K c-index-bg3\">4 </div>\n" +
                "                                        <div class=\"content-pos_1fT0H\">\n" +
                "                                            <img class=\"content-bg_3R_MY\" src=\"//fyb-pc-static.cdn.bcebos.com/static/asset/hot-title-bg_7df0f96d81d643e9b8b1cb24ad81ed7f.png\">\n" +
                "                                            <div class=\"name_2Px2N\">\n" +
                "                                                <div class=\"c-single-text-ellipsis\">东北雨姐哭了：有问题倾家荡产都赔 </div>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"c-text  hot-state_NdlbW\"></div>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"normal_1fQqB\">\n" +
                "                                        <div class=\"index_k2hIU c-index-single-hot4\">4 </div>\n" +
                "                                        <div class=\"content-wrap_1RisM\">\n" +
                "                                            <div class=\"name_2Px2N\">\n" +
                "                                                <div class=\"c-single-text-ellipsis\">东北雨姐哭了：有问题倾家荡产都赔 </div>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"c-text  hot-state_NdlbW\"></div>\n" +
                "                                    </div>\n" +
                "                                </a>\n" +
                "                                <a class=\"item-wrap_2oCLZ \" href=\"https://www.baidu.com/s?wd=%E4%BA%BA%E6%B0%91%E7%BD%91%E8%AF%84%E4%B8%A5%E6%89%93%E5%81%B7%E6%8B%8D%E9%BB%91%E7%81%B0%E4%BA%A7&amp;sa=fyb_hp_news&amp;rsv_dl=fyb_hp_news\" target=\"_blank\">\n" +
                "                                    <div class=\"active-item_1Em2h\">\n" +
                "                                        <img class=\"active-item-img_3i_Tx\" src=\"https://fyb-1.cdn.bcebos.com/fyb/de6163834f53ca92c1273fff98ac9078.jpeg?x-bce-process=image/resize,m_fill,w_732,h_272\" alt=\"\">\n" +
                "                                        <div class=\"sign-index_mtI7K c-index-bg4\">5 </div>\n" +
                "                                        <div class=\"content-pos_1fT0H\">\n" +
                "                                            <img class=\"content-bg_3R_MY\" src=\"//fyb-pc-static.cdn.bcebos.com/static/asset/hot-title-bg_7df0f96d81d643e9b8b1cb24ad81ed7f.png\">\n" +
                "                                            <div class=\"name_2Px2N\">\n" +
                "                                                <div class=\"c-single-text-ellipsis\">人民网评严打偷拍黑灰产 </div>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"c-text  hot-state_NdlbW\"></div>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"normal_1fQqB\">\n" +
                "                                        <div class=\"index_k2hIU c-index-single-hot5\">5 </div>\n" +
                "                                        <div class=\"content-wrap_1RisM\">\n" +
                "                                            <div class=\"name_2Px2N\">\n" +
                "                                                <div class=\"c-single-text-ellipsis\">人民网评严打偷拍黑灰产 </div>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"c-text  hot-state_NdlbW\"></div>\n" +
                "                                    </div>\n" +
                "                                </a>\n" +
                "                                <a class=\"item-wrap_2oCLZ \" href=\"https://www.baidu.com/s?wd=%E5%A4%96%E8%B5%84%E4%B9%B0%E7%88%86%E4%B8%AD%E5%9B%BD%E8%B5%84%E4%BA%A7&amp;sa=fyb_hp_news&amp;rsv_dl=fyb_hp_news\" target=\"_blank\">\n" +
                "                                    <div class=\"active-item_1Em2h\">\n" +
                "                                        <img class=\"active-item-img_3i_Tx\" src=\"https://fyb-1.cdn.bcebos.com/fyb/de6163834f53ca92c1273fff98ac9078.jpeg?x-bce-process=image/resize,m_fill,w_732,h_272\" alt=\"\">\n" +
                "                                        <div class=\"sign-index_mtI7K c-index-bg5\">6 </div>\n" +
                "                                        <div class=\"content-pos_1fT0H\">\n" +
                "                                            <img class=\"content-bg_3R_MY\" src=\"//fyb-pc-static.cdn.bcebos.com/static/asset/hot-title-bg_7df0f96d81d643e9b8b1cb24ad81ed7f.png\">\n" +
                "                                            <div class=\"name_2Px2N\">\n" +
                "                                                <div class=\"c-single-text-ellipsis\">外资买爆中国资产 </div>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"c-text  hot-state_NdlbW\"></div>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"normal_1fQqB\">\n" +
                "                                        <div class=\"index_k2hIU c-index-single-hot6\">6 </div>\n" +
                "                                        <div class=\"content-wrap_1RisM\">\n" +
                "                                            <div class=\"name_2Px2N\">\n" +
                "                                                <div class=\"c-single-text-ellipsis\">外资买爆中国资产 </div>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"c-text  hot-state_NdlbW\"></div>\n" +
                "                                    </div>\n" +
                "                                </a>\n" +
                "                                <a class=\"item-wrap_2oCLZ \" href=\"https://www.baidu.com/s?wd=%E6%B8%A9%E5%B7%9E75%E5%B2%81%E8%80%81%E4%BA%BA%E9%AA%91%E7%94%B5%E9%A9%B4%E5%8E%BB%E6%8B%89%E8%90%A8%E6%97%85%E6%B8%B8&amp;sa=fyb_hp_news&amp;rsv_dl=fyb_hp_news\" target=\"_blank\">\n" +
                "                                    <div class=\"active-item_1Em2h\">\n" +
                "                                        <img class=\"active-item-img_3i_Tx\" src=\"https://fyb-2.cdn.bcebos.com/hotboard_image/5453d0e56e39ebf95529367e31e1b640?x-bce-process=image/resize,m_fill,w_732,h_272\" alt=\"\">\n" +
                "                                        <div class=\"sign-index_mtI7K c-index-bg6\">7 </div>\n" +
                "                                        <div class=\"content-pos_1fT0H\">\n" +
                "                                            <img class=\"content-bg_3R_MY\" src=\"//fyb-pc-static.cdn.bcebos.com/static/asset/hot-title-bg_7df0f96d81d643e9b8b1cb24ad81ed7f.png\">\n" +
                "                                            <div class=\"name_2Px2N\">\n" +
                "                                                <div class=\"c-single-text-ellipsis\">温州75岁老人骑电驴去拉萨旅游 </div>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"c-text  hot-state_NdlbW\"></div>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"normal_1fQqB\">\n" +
                "                                        <div class=\"index_k2hIU c-index-single-hot7\">7 </div>\n" +
                "                                        <div class=\"content-wrap_1RisM\">\n" +
                "                                            <div class=\"name_2Px2N\">\n" +
                "                                                <div class=\"c-single-text-ellipsis\">温州75岁老人骑电驴去拉萨旅游 </div>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"c-text  hot-state_NdlbW\"></div>\n" +
                "                                    </div>\n" +
                "                                </a>\n" +
                "                                <a class=\"item-wrap_2oCLZ \" href=\"https://www.baidu.com/s?wd=%E9%9F%A9%E5%9B%BD2%E5%85%AC%E6%96%A4%E7%99%BD%E8%8F%9C%E5%8D%96%E5%88%B079%E5%85%83&amp;sa=fyb_hp_news&amp;rsv_dl=fyb_hp_news\" target=\"_blank\">\n" +
                "                                    <div class=\"active-item_1Em2h\">\n" +
                "                                        <img class=\"active-item-img_3i_Tx\" src=\"https://fyb-1.cdn.bcebos.com/fyb/de6163834f53ca92c1273fff98ac9078.jpeg?x-bce-process=image/resize,m_fill,w_732,h_272\" alt=\"\">\n" +
                "                                        <div class=\"sign-index_mtI7K c-index-bg7\">8 </div>\n" +
                "                                        <div class=\"content-pos_1fT0H\">\n" +
                "                                            <img class=\"content-bg_3R_MY\" src=\"//fyb-pc-static.cdn.bcebos.com/static/asset/hot-title-bg_7df0f96d81d643e9b8b1cb24ad81ed7f.png\">\n" +
                "                                            <div class=\"name_2Px2N\">\n" +
                "                                                <div class=\"c-single-text-ellipsis\">韩国2公斤白菜卖到79元 </div>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"c-text  hot-state_NdlbW\"></div>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"normal_1fQqB\">\n" +
                "                                        <div class=\"index_k2hIU c-index-single-hot8\">8 </div>\n" +
                "                                        <div class=\"content-wrap_1RisM\">\n" +
                "                                            <div class=\"name_2Px2N\">\n" +
                "                                                <div class=\"c-single-text-ellipsis\">韩国2公斤白菜卖到79元 </div>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"c-text  hot-state_NdlbW\"></div>\n" +
                "                                    </div>\n" +
                "                                </a>\n" +
                "                                <a class=\"item-wrap_2oCLZ \" href=\"https://www.baidu.com/s?wd=%E5%BE%AE%E4%BF%A1%E5%AE%9E%E5%86%B5%E5%9B%BE%E7%9A%84%E7%AC%AC%E4%B8%80%E6%89%B9%E5%8F%97%E5%AE%B3%E8%80%85%E5%87%BA%E7%8E%B0%E4%BA%86&amp;sa=fyb_hp_news&amp;rsv_dl=fyb_hp_news\" target=\"_blank\">\n" +
                "                                    <div class=\"active-item_1Em2h\">\n" +
                "                                        <img class=\"active-item-img_3i_Tx\" src=\"https://fyb-2.cdn.bcebos.com/hotboard_image/fdf53f99d76ae6e879fa225ceb802ef6?x-bce-process=image/resize,m_fill,w_732,h_272\" alt=\"\">\n" +
                "                                        <div class=\"sign-index_mtI7K c-index-bg8\">9 </div>\n" +
                "                                        <div class=\"content-pos_1fT0H\">\n" +
                "                                            <img class=\"content-bg_3R_MY\" src=\"//fyb-pc-static.cdn.bcebos.com/static/asset/hot-title-bg_7df0f96d81d643e9b8b1cb24ad81ed7f.png\">\n" +
                "                                            <div class=\"name_2Px2N\">\n" +
                "                                                <div class=\"c-single-text-ellipsis\">微信实况图的第一批受害者出现了 </div>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"c-text  hot-state_NdlbW\"></div>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"normal_1fQqB\">\n" +
                "                                        <div class=\"index_k2hIU c-index-single-hot9\">9 </div>\n" +
                "                                        <div class=\"content-wrap_1RisM\">\n" +
                "                                            <div class=\"name_2Px2N\">\n" +
                "                                                <div class=\"c-single-text-ellipsis\">微信实况图的第一批受害者出现了 </div>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"c-text  hot-state_NdlbW\"></div>\n" +
                "                                    </div>\n" +
                "                                </a>\n" +
                "                                <a class=\"item-wrap_2oCLZ \" href=\"https://www.baidu.com/s?wd=%E5%AE%98%E6%96%B9%E9%80%9A%E6%8A%A5%E5%AD%A9%E5%AD%90%E5%BA%8A%E5%8D%95%E8%A2%AB%E5%A4%A9%E9%99%8D%E7%83%9F%E5%A4%B4%E7%83%A7%E7%84%A6&amp;sa=fyb_hp_news&amp;rsv_dl=fyb_hp_news\" target=\"_blank\">\n" +
                "                                    <div class=\"active-item_1Em2h\">\n" +
                "                                        <img class=\"active-item-img_3i_Tx\" src=\"https://fyb-2.cdn.bcebos.com/hotboard_image/b679c70f099143f24a2448d8b5b5047d?x-bce-process=image/resize,m_fill,w_732,h_272\" alt=\"\">\n" +
                "                                        <div class=\"sign-index_mtI7K c-index-bg9\">10 </div>\n" +
                "                                        <div class=\"content-pos_1fT0H\">\n" +
                "                                            <img class=\"content-bg_3R_MY\" src=\"//fyb-pc-static.cdn.bcebos.com/static/asset/hot-title-bg_7df0f96d81d643e9b8b1cb24ad81ed7f.png\">\n" +
                "                                            <div class=\"name_2Px2N\">\n" +
                "                                                <div class=\"c-single-text-ellipsis\">官方通报孩子床单被天降烟头烧焦 </div>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"c-text  hot-state_NdlbW\"></div>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"normal_1fQqB\">\n" +
                "                                        <div class=\"index_k2hIU c-index-single-hot10\">10 </div>\n" +
                "                                        <div class=\"content-wrap_1RisM\">\n" +
                "                                            <div class=\"name_2Px2N\">\n" +
                "                                                <div class=\"c-single-text-ellipsis\">官方通报孩子床单被天降烟头烧焦 </div>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"c-text  hot-state_NdlbW\"></div>";

        String ipAdd = "册并向Inter NIC提出申请的组织机构。通过它直接访问因特网。\n" +
                "私有地址\n" +
                "私有地址（Private address）属于非注册地址，专门为组织机构内部使用。\n" +
                "以下列出留用的内部私有地址\n" +
                "A类 10.0.0.0--10.255.255.255\n" +
                "B类 172.16.0.0--172.31.255.255\n" +
                "C类 192.168.0.0--192.168.255.255";

        // 提取文章所有单词
        // 正则表达式
//        Pattern pattern = Pattern.compile("[a-zA-Z]+"); // 模板设置 单词
//        Pattern pattern = Pattern.compile("[0-9]+"); // 模板设置 数字
//        Pattern pattern = Pattern.compile("([0-9]+)|([a-zA-Z]+)"); // 模板设置 单词 + 数字
//        Matcher matcher = pattern.matcher(content); // 匹配
//        while (matcher.find()) { // 找到就返回 true
//            System.out.println("找到: " + matcher.group(0));
//        }

        // 提取百度热搜
//        Pattern pattern = Pattern.compile("<div class=\"c-single-text-ellipsis\">(\\S*) </div>");
//        Matcher matcher = pattern.matcher(sourceBaidu);
//        while (matcher.find()) {
//            System.out.println("找到: " + matcher.group(1));
//        }
        // 提取ip地址
        Pattern pattern = Pattern.compile("\\d+\\.\\d+\\.\\d+\\.\\d+");
        Matcher matcher = pattern.matcher(ipAdd);
        while (matcher.find()) {
            System.out.println("找到: " + matcher.group(0));
        }


        // 传统方式
//        StringBuilder stringBuilder = new StringBuilder();
//        char[] chars = content.toCharArray();
//        for (char aChar : chars) {
//            if ((aChar >= 'a' && aChar <= 'z') || (aChar >= 'A' && aChar <= 'Z')) {
//                stringBuilder.append(aChar);
//            } else {
//                stringBuilder.append("分");
//            }
//        }
//        String s = stringBuilder.toString();
////        System.out.println(s);
//        String[] split = s.split("分");
//        for (String s1 : split) {
//            if (!"".equals(s1)) System.out.println(s1);
//        }

    }
}
