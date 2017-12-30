package cn.com.service;


import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * ${DESCRIPTION}
 *
 * @author lightTrace
 * @create 2017-12-27 22:04
 **/
@Service
public class SearchService {

    @Autowired
    private TransportClient client;

    /**
     *
     * @Description:批量插入索引
     * void
     * @exception:
     * @author: yzxia
     * @time:2016-5-24 下午4:03:31
     */
    public void builderSearchIndex() {

        long start = System.currentTimeMillis();
        try {
            //创建索引
            IndexResponse response = client.prepareIndex("people", "man", "1")
                    .setSource(jsonBuilder()
                            .startObject()
                            .field("name", "jack")
                            .field("country", "china")
                            .field("age", "24")
                            .endObject()
                    )
                    .get();

        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("创建索引时间 " + (end - start) + " 毫秒");
    }

    /**
     * 搜索新闻
     *
     * @param
     * @return
     */
    public Map<String, Object> searchsNews(String id) {
        try {
            GetResponse result = this.client.prepareGet("people","man",id).get();
            return result.getSource();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
