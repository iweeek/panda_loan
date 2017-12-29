package com.pinganzhiyuan.graphql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pinganzhiyuan.mapper.ClientModuleMapper;
import com.pinganzhiyuan.mapper.TabModuleMappingMapper;
import com.pinganzhiyuan.model.TabModuleMapping;
import com.pinganzhiyuan.model.ClientModule;
import com.pinganzhiyuan.model.TabModuleMappingExample;
import com.pinganzhiyuan.model.TabModuleMappingExample.Criteria;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

@Component
public class TabType {
    
    private static GraphQLFieldDefinition singleQueryField;
    private static GraphQLFieldDefinition listQueryField;
    
    private static ClientModuleMapper clientModuleMapper;
    private static TabModuleMappingMapper tabModuleMappingMapper;

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
                        
                        TabModuleMappingExample example = new TabModuleMappingExample();
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
                        List<TabModuleMapping> mappingList = tabModuleMappingMapper.selectByExample(example);
                        
                        List<ClientModule> list = new ArrayList<ClientModule>();
                        for (TabModuleMapping mapping : mappingList) {
                            ClientModule module = clientModuleMapper.selectByPrimaryKey(mapping.getModuleId());
                            list.add(module);
                        }
                        return list;
                    } ).build();
        }
        return listQueryField;
    }
    
    @Autowired(required = true)
    public void setClientModuleMapper(ClientModuleMapper clientModuleMapper) {
        TabType.clientModuleMapper = clientModuleMapper;
    }
    
    @Autowired(required = true)
    public void setTabModuleMappingMapper(TabModuleMappingMapper tabModuleMappingMapper) {
        TabType.tabModuleMappingMapper = tabModuleMappingMapper;
    }
    
}
