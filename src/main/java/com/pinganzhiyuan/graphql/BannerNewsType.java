package com.pinganzhiyuan.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pinganzhiyuan.mapper.BannerNewsMapper;
import com.pinganzhiyuan.model.BannerNews;
import com.pinganzhiyuan.model.Client;

import graphql.Scalars;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

@Component
public class BannerNewsType {
    
    private static GraphQLFieldDefinition singleQueryField;
    private static GraphQLFieldDefinition listQueryField;
    
    private static BannerNewsMapper bannerNewsMapper;

    private static GraphQLObjectType type;
   

    public static GraphQLObjectType getType() {
        if (type == null) {
            type = GraphQLObjectType
                    .newObject().name("BannerNews").description("BannerNews")
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("id")
                            .description("唯一主键")
                            .type(Scalars.GraphQLLong)
                            .dataFetcher(environment -> {
                                //为了兼容安卓客户端的问题
                                BannerNews bannerNews = environment.getSource();
                                String url = bannerNews.getUrl();
                                String arr[] = url.substring(url.indexOf("?") + 1).split("&");
                                String pid = "0";
                                for (int i = 0; i < arr.length; i++) {
                                    if (arr[i].contains("pid")) {
                                        String pidArr[] = arr[i].split("=");
                                        pid = pidArr[1];
                                        break;
                                    }
                                }
                                
                                return Long.valueOf(pid);
                             })
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("description")
                            .description("描述")
                            .type(Scalars.GraphQLString)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("productName")
                            .description("产品名称")
                            .type(Scalars.GraphQLString)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("url")
                            .description("产品的跳转地址")
                            .type(Scalars.GraphQLString)
                            .build())
                    .build();
        }
        return type;
    }

//    public static GraphQLFieldDefinition getSingleQueryField() {
//        if (singleQueryField == null) {
//            singleQueryField = GraphQLFieldDefinition
//                    .newFieldDefinition()
//                    .name("news")
//                    .description("banner")
//                    .type(getType())
//                    .dataFetcher(environment -> {
//                        return bannerNewsMapper.selectByExample(null);
//                    }).build();
//        }
//        return singleQueryField;
//    }
    
    public static GraphQLFieldDefinition getListQueryField() {
        if(listQueryField == null) {
            listQueryField = GraphQLFieldDefinition.newFieldDefinition()
                    .name("bannerNewsList")
                    .description("横幅新闻列表")
                    .type(new GraphQLList(getType()))
                    .dataFetcher(environment ->  {
                        return bannerNewsMapper.selectByExample(null);
                    } ).build();
        }
        return listQueryField;
    }
    
    @Autowired(required = true)
    public void setBannerNewsMapper(BannerNewsMapper bannerNewsMapper) {
        BannerNewsType.bannerNewsMapper = bannerNewsMapper;
    }
}
