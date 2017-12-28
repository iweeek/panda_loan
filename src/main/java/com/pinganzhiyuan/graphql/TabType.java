package com.pinganzhiyuan.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pinganzhiyuan.mapper.BannerMapper;
import com.pinganzhiyuan.mapper.BannerNewsMapper;
import com.pinganzhiyuan.mapper.TabMapper;
import com.pinganzhiyuan.mapper.TermMapper;
import com.pinganzhiyuan.model.Tab;
import com.pinganzhiyuan.model.TabExample;
import com.pinganzhiyuan.model.TabExample.Criteria;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

@Component
public class TabType {
    
    private static GraphQLFieldDefinition singleQueryField;
    private static GraphQLFieldDefinition listQueryField;
    
    private static TabMapper tabMapper;

    private static GraphQLObjectType type;
   
    public static GraphQLObjectType getType() {
        if (type == null) {
            type = GraphQLObjectType
                    .newObject().name("Tab").description("底部标签")
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("id")
                            .description("唯一主键")
                            .type(Scalars.GraphQLLong)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("name")
                            .description("标签名")
                            .type(Scalars.GraphQLString)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("iconUrl")
                            .description("icon的地址")
                            .type(Scalars.GraphQLString)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("sequence")
                            .description("顺序")
                            .type(Scalars.GraphQLInt)
                            .build())
                    .build();
        }
        return type;
    }

//    public static GraphQLFieldDefinition getSingleQueryField() {
//        if (singleQueryField == null) {
//            singleQueryField = GraphQLFieldDefinition
//                    .newFieldDefinition()
//                    .name("banner")
//                    .description("banner")
//                    .type(getType())
//                    .dataFetcher(environment -> {
//                        return bannerMapper.selectByExample(null).get(0);
//                    }).build();
//        }
//        return singleQueryField;
//    }
    
    public static GraphQLFieldDefinition getListQueryField() {
        if(listQueryField == null) {
            listQueryField = GraphQLFieldDefinition.newFieldDefinition()
                    .name("tabs")
                    .description("底部标签列表")
                    .argument(GraphQLArgument.newArgument().name("packageName").type(Scalars.GraphQLString).build())
                    .argument(GraphQLArgument.newArgument().name("versionCode").type(Scalars.GraphQLInt).build())
                    .argument(GraphQLArgument.newArgument().name("channelId").type(Scalars.GraphQLLong).build())
                    .type(new GraphQLList(getType()))
                    .dataFetcher(environment ->  {
                        String packageName = environment.getArgument("packageName");
                        Integer versionCode = environment.getArgument("versionCode");
                        Long channelId = environment.getArgument("channelId");
                        
                        TabExample example = new TabExample();
                        Criteria criteria = example.createCriteria();
                        
                        if (packageName != null) {
                            criteria.andPackageNameEqualTo(packageName);
                        }
                        
                        if (versionCode != null) {
                            criteria.andVersionEqualTo(versionCode);
                        }
                        
                        if (channelId != null) {
                            criteria.andChannelIdEqualTo(channelId);
                        }
                        
                        example.setOrderByClause("sequence asc");
                        List<Tab> list = tabMapper.selectByExample(example);
                        return list;
                    } ).build();
        }
        return listQueryField;
    }
    
    @Autowired(required = true)
    public void setTabMapper(TabMapper tabMapper) {
        TabType.tabMapper = tabMapper;
    }
    
}
