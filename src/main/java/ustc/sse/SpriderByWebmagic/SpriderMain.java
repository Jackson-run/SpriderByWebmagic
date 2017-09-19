package ustc.sse.SpriderByWebmagic;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class SpriderMain extends Spider{
    public SpriderMain(PageProcessor pageProcessor) {
        super(pageProcessor);
    }

    public static void main(String[] args) {
        //启动爬虫测试github不同步
        create(new NewsPageProcessor()).addUrl("http://info.meadin.com/Index_1.shtml").thread(10).run();
    }
}
