package com.time.nlp;

import java.net.URISyntaxException;
import java.net.URL;

/**
 * 外部调用时间处理类
 * @author duanyu
 */

public class TimeNLP {

   private static final URL url = TimeNormalizer.class.getResource("/TimeExp.m");
   private static TimeNormalizer normalizer;

   static {
       try {
           normalizer = new TimeNormalizer(url.toURI().toString());
       }catch (URISyntaxException e){
            e.printStackTrace();
       }
   }

    /**
     * query处理，默认是倾向于未来时间
     * @param query
     * @return
     */
   public  TimeUnit[] handle(String query){
       normalizer.setPreferFuture(true);
       normalizer.parse(query);// 抽取时间
       TimeUnit[] unit = normalizer.getTimeUnit();
       return unit;
   }

    /**
     * query处理
     * @param query
     * @param ispreferFuture 设置是否倾向未来时间
     * @return
     */
    public  TimeUnit[] handle(String query,boolean ispreferFuture){
        normalizer.setPreferFuture(ispreferFuture);
        normalizer.parse(query);// 抽取时间
        TimeUnit[] unit = normalizer.getTimeUnit();
        return unit;
    }
}
