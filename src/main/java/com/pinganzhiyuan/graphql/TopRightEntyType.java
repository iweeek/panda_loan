package com.pinganzhiyuan.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pinganzhiyuan.mapper.TopNavMapper;
import com.pinganzhiyuan.mapper.TopRightEntryMapper;
import com.pinganzhiyuan.model.TopNav;

import graphql.Scalars;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

@Component
public class TopRightEntyType {
    
    private static GraphQLFieldDefinition singleQueryField;
    private static GraphQLFieldDefinition listQueryField;
    
    private static TopRightEntryMapper topRightEntyMapper;

    private static GraphQLObjectType type;
   

    public static GraphQLObjectType getType() {
        if (type == null) {
            type = GraphQLObjectType
                    .newObject().name("TopRightEnty").description("顶部右侧入口（今日排行）")
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("id")
                            .description("唯一主键")
                            .type(Scalars.GraphQLLong)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("title")
                            .description("标题")
                            .type(Scalars.GraphQLString)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("iconUrl")
                            .description("icon地址")
                            .type(Scalars.GraphQLString)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("url")
                            .description("跳转地址")
                            .type(Scalars.GraphQLString)
                            .build())
                    .build();
        }
        return type;
    }

    public static GraphQLFieldDefinition getSingleQueryField() {
        if (singleQueryField == null) {
            singleQueryField = GraphQLFieldDefinition
                    .newFieldDefinition()
                    .name("topRightEntry")
                    .description("顶部右侧入口")
                    .type(getType())
                    .dataFetcher(environment -> {
                        return topRightEntyMapper.selectByExample(null).get(0);
                    }).build();
        }
        return singleQueryField;
    }
    
//    public static GraphQLFieldDefinition getListQueryField() {
//        if(listQueryField == null) {
//            listQueryField = GraphQLFieldDefinition.newFieldDefinition()
//                    .name("topRightEntries")
//                    .description("顶部导航列表")
//                    .type(new GraphQLList(getType()))
//                    .dataFetcher(environment ->  {
//                        List<TopNav> list = topNavMapper.selectByExample(null);
//                        return list;
//                    } ).build();
//        }
//        return listQueryField;
//    }
    
    @Autowired(required = true)
    public void setProductMapper(TopRightEntryMapper topRightEntyMapper) {
        TopRightEntyType.topRightEntyMapper = topRightEntyMapper;
    }
}
