package com.pinganzhiyuan.graphql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pinganzhiyuan.mapper.ClientColumnMappingMapper;
import com.pinganzhiyuan.mapper.ColumnMapper;
import com.pinganzhiyuan.mapper.TopNavMapper;
import com.pinganzhiyuan.mapper.TopRightEntryMapper;
import com.pinganzhiyuan.model.ClientColumnMapping;
import com.pinganzhiyuan.model.ClientColumnMappingExample;
import com.pinganzhiyuan.model.Column;
import com.pinganzhiyuan.model.ColumnExample;
import com.pinganzhiyuan.model.MidNav;
import com.pinganzhiyuan.model.Product;
import com.pinganzhiyuan.model.ProductColumnMapping;
import com.pinganzhiyuan.model.ProductColumnMappingExample;
import com.pinganzhiyuan.model.ProductExample;
import com.pinganzhiyuan.model.TopNav;
import com.pinganzhiyuan.model.TopRightEntry;
import com.pinganzhiyuan.model.ColumnExample.Criteria;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

@Component
public class TopRightEntyType {
    
    private static GraphQLFieldDefinition singleQueryField;
    private static GraphQLFieldDefinition listQueryField;
    
    private static TopRightEntryMapper topRightEntyMapper;

    private static ClientColumnMappingMapper clientColumnMappingMapper; 
    private static ColumnMapper columnMapper;
    
    private static GraphQLObjectType type;
   

    public static GraphQLObjectType getType() {
        if (type == null) {
            type = GraphQLObjectType
                    .newObject().name("TopRightEnty").description("顶部右侧入口（七日排行）")
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("title")
                            .description("名称")
                            .type(Scalars.GraphQLString)
                            .staticValue("近七日申请排行")
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("selectParam")
                            .description("选择参数名")
                            .type(Scalars.GraphQLString)
                            .staticValue("typeId")
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("iconUrl")
                            .description("图标地址")
                            .type(Scalars.GraphQLString)
                            .staticValue("")
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("paramValue")
                            .description("选择参数值")
                            .type(Scalars.GraphQLInt)
                            .staticValue(1)
                            .build())
                    .build();
        }
        return type;
    }
    
//    public static GraphQLFieldDefinition getTitleField() {
//        if (singleQueryField == null) {
//            singleQueryField = GraphQLFieldDefinition
//                    .newFieldDefinition()
//                    .name("topRightEntryName")
//                    .description("名称")
//                    .type(Scalars.GraphQLString)
//                    .staticValue("七日排行")
//                    .build()
//                    .name("topRightEntryTypeId")
//                    .description("选择类型Id")
//                    .type(Scalars.GraphQLInt)
//                    .staticValue(1)
//                    .build();
//        }
//        return singleQueryField;
//    }

    public static GraphQLFieldDefinition getSingleQueryField() {
        if (singleQueryField == null) {
            singleQueryField = GraphQLFieldDefinition
                    .newFieldDefinition()
                    .argument(GraphQLArgument.newArgument().name("packageName").type(Scalars.GraphQLString).build())
                    .argument(GraphQLArgument.newArgument().name("channelId").type(Scalars.GraphQLLong).build())
                    .name("topRightEntry")
                    .description("顶部右侧入口")
                    .type(getType())
                    .dataFetcher(environment ->  {
                        
                        String packageName = environment.getArgument("packageName");
                        Long channelId = environment.getArgument("channelId");
                        int platform;
                        String columnKey = "";
                        TopRightEntry topRightEntry;
                        
                        if (channelId == 13) {
                            platform = 1;
                        } else {
                            platform = 0;
                        }
                        // 栏位
                        ClientColumnMappingExample example = new ClientColumnMappingExample();
                        example.createCriteria()
                            .andPackageNameEqualTo(packageName)
                            .andPlatformIdEqualTo(platform);
                        List<ClientColumnMapping> list = clientColumnMappingMapper.selectByExample(example);
                        if (list == null || list.size() == 0) {
                            return null;
                        } else {
                            columnKey = list.get(0).getColumnKey();
                        }
                        
                        ColumnExample columnExample = new ColumnExample();
                        columnExample.createCriteria().andColumnKeyEqualTo(columnKey);
                        List<Column> topRightEntryList = columnMapper.selectByExample(columnExample);
                        
                        if (topRightEntryList == null || topRightEntryList.size() == 0) {
                            return null;
                        } else {
                            Column column = topRightEntryList.get(0);
                            topRightEntry = new TopRightEntry();
                            topRightEntry.setTitle(column.getTitle());;
                            topRightEntry.setSelectParam("typeId");
                            topRightEntry.setParamValue(String.valueOf(column.getId()));
                        }
                       
                        return topRightEntry;
                    } )
//                    .staticValue(type)
                    .build();
        }
        return singleQueryField;
    }
    
//    public static GraphQLFieldDefinition getListQueryField() {
//        if(listQueryField == null) {
//            listQueryField = GraphQLFieldDefinition.newFieldDefinition()
//                    .name("topRightEntries")
//                    .description("顶部右侧导航列表")
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
    
    @Autowired(required = true)
    public void setClientColumnMappingMapper(ClientColumnMappingMapper clientColumnMappingMapper) {
        TopRightEntyType.clientColumnMappingMapper = clientColumnMappingMapper;
    }
    
    @Autowired(required = true)
    public void setColumnMapper(ColumnMapper columnMapper) {
        TopRightEntyType.columnMapper = columnMapper;
    }
}
