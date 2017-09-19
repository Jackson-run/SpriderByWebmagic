package ustc.sse.SpriderByWebmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class NewsPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("(http://info\\.meadin\\.com/Index_.*\\.shtml)").all());//http://info.meadin.com/Index_1.shtml
        //提取新闻标题
        page.putField("Title", page.getHtml().css(".listview").css(".list").css("h3").xpath("//a/text()"));
        //提取新闻所属类别主题
        page.putField("topical",page.getHtml().css(".listview").css(".list").css(".clear.date").xpath("//a/text()"));
        //提取新闻简要信息
        page.putField("Info", page.getHtml().css(".listview").css(".list").xpath("//p/text()"));
        //提起新闻发布时间
        page.putField("Time",page.getHtml().css(".listview").css(".list").css(".clear.date").xpath("//div[@class='clear date']/span[@class='fr arial']/text()"));
    }

    @Override
    public Site getSite() {
        return site;
    }

}
