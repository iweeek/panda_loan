package com.pinganzhiyuan.graphql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pinganzhiyuan.mapper.ClientColumnMappingMapper;
import com.pinganzhiyuan.mapper.ClientVersionMapper;
import com.pinganzhiyuan.mapper.ColumnMapper;
import com.pinganzhiyuan.mapper.ProductColumnMappingMapper;
import com.pinganzhiyuan.mapper.TopNavMapper;
import com.pinganzhiyuan.model.ClientColumnMapping;
import com.pinganzhiyuan.model.ClientColumnMappingExample;
import com.pinganzhiyuan.model.Column;
import com.pinganzhiyuan.model.ColumnExample;
import com.pinganzhiyuan.model.ColumnExample.Criteria;
import com.pinganzhiyuan.model.TopNav;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

@Component
public class TopNavType {
    
    private static GraphQLFieldDefinition singleQueryField;
    private static GraphQLFieldDefinition listQueryField;
    
    private static TopNavMapper topNavMapper;
    
    private static ClientVersionMapper clientVersionMapper;
    private static ClientColumnMappingMapper clientColumnMappingMapper; 
    
    private static ColumnMapper columnMapper;
    private static ProductColumnMappingMapper productColumnMappingMapper;
    

    private static GraphQLObjectType type;
   

    public static GraphQLObjectType getType() {
        if (type == null) {
            type = GraphQLObjectType
                    .newObject().name("TopNav").description("顶部导航")
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

//    public static GraphQLFieldDefinition getSingleQueryField() {
//        if (singleQueryField == null) {
//            singleQueryField = GraphQLFieldDefinition
//                    .newFieldDefinition()
//                    .name("banner")
//                    .description("banner")
//                    .type(getType())
//                    .dataFetcher(environment -> {
//                        return bannerMapper.selectByExample(null);
//                    }).build();
//        }
//        return singleQueryField;
//    }
    
    public static GraphQLFieldDefinition getListQueryField() {
        if(listQueryField == null) {
            listQueryField = GraphQLFieldDefinition.newFieldDefinition()
                    .argument(GraphQLArgument.newArgument().name("packageName").type(Scalars.GraphQLString).build())
                    .argument(GraphQLArgument.newArgument().name("channelId").type(Scalars.GraphQLLong).build())
                    .name("topNavs")
                    .description("顶部导航列表")
                    .type(new GraphQLList(getType()))
                    .dataFetcher(environment ->  {
                        String packageName = environment.getArgument("packageName");
                        Long channelId = environment.getArgument("channelId");
                        int platform;
                        
                        // 原本的逻辑
//                        List<TopNav> list = topNavMapper.selectByExample(null);
                        if (channelId == 13) {
                            platform = 1;
                        } else {
                            platform = 0;
                        }
                        ClientColumnMappingExample example = new ClientColumnMappingExample();
                        example.createCriteria()
                            .andPackageNameEqualTo(packageName)
                            .andPlatformIdEqualTo(platform);
                        List<ClientColumnMapping> list = clientColumnMappingMapper.selectByExample(example);
                        if (list == null || list.size() == 0) {
                            return null;
                        }
                        List<String> filter = new ArrayList<String>();
                        ColumnExample columnExample = new ColumnExample();
                        Criteria criteria = columnExample.createCriteria();
                        for (ClientColumnMapping item : list) {
                            if (item.getColumnKey().contains("top_nav")) {
                                filter.add(item.getColumnKey());
                            }
                        }
                        
                        criteria.andColumnKeyIn(filter);
                        List<Column> columns = columnMapper.selectByExample(columnExample);
                        if (columns == null || columns.size() == 0) {
                            return null;
                        }
                        
                        List<TopNav> topNavs = new ArrayList<>();
                        for (Column column : columns) {
                            topNavs.add(TopNav.convertToModel(column));
                        }
                        
                        return topNavs;
                    } ).build();
        }
        return listQueryField;
    }
    
    @Autowired(required = true)
    public void setProductMapper(TopNavMapper topNavMapper) {
        TopNavType.topNavMapper = topNavMapper;
    }
    
    @Autowired(required = true)
    public void setClientVersionMapper(ClientVersionMapper clientVersionMapper) {
        TopNavType.clientVersionMapper = clientVersionMapper;
    }
    
    @Autowired(required = true)
    public void setClientColumnMappingMapper(ClientColumnMappingMapper clientColumnMappingMapper) {
        TopNavType.clientColumnMappingMapper = clientColumnMappingMapper;
    }

    @Autowired(required = true)
    public void setProductColumnMappingMapper(ProductColumnMappingMapper productColumnMappingMapper) {
        TopNavType.productColumnMappingMapper = productColumnMappingMapper;
    }
    @Autowired(required = true)
    public void setColumnMapper(ColumnMapper columnMapper) {
        TopNavType.columnMapper = columnMapper;
    }
}
