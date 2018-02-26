package com.pinganzhiyuan.graphql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pinganzhiyuan.mapper.ClientColumnMappingMapper;
import com.pinganzhiyuan.mapper.ClientVersionMapper;
import com.pinganzhiyuan.mapper.ColumnMapper;
import com.pinganzhiyuan.mapper.MidNavMapper;
import com.pinganzhiyuan.mapper.ProductColumnMappingMapper;
import com.pinganzhiyuan.mapper.ProductMapper;
import com.pinganzhiyuan.model.ClientColumnMapping;
import com.pinganzhiyuan.model.ClientColumnMappingExample;
import com.pinganzhiyuan.model.MidAd;
import com.pinganzhiyuan.model.MidNav;
import com.pinganzhiyuan.model.Product;
import com.pinganzhiyuan.model.ProductColumnMapping;
import com.pinganzhiyuan.model.ProductColumnMappingExample;
import com.pinganzhiyuan.model.ProductExample;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

@Component
public class MidNavType {
    
    private static GraphQLFieldDefinition singleQueryField;
    private static GraphQLFieldDefinition listQueryField;
    
    private static MidNavMapper midNavMapper;
    
    private static ClientVersionMapper clientVersionMapper;
    private static ClientColumnMappingMapper clientColumnMappingMapper; 
    
    private static ColumnMapper columnMapper;
    private static ProductColumnMappingMapper productColumnMappingMapper;
    
    private static ProductMapper productMapper;

    private static GraphQLObjectType type;
   

    public static GraphQLObjectType getType() {
        if (type == null) {
            type = GraphQLObjectType
                    .newObject().name("MidNav").description("中部导航")
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
                            .newFieldDefinition().name("subtitle")
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
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("productId")
                            .description("产品Id")
                            .type(Scalars.GraphQLLong)
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
                    .name("midNavs")
                    .description("中部导航列表")
                    .type(new GraphQLList(getType()))
                    .dataFetcher(environment ->  {
                        
                        String packageName = environment.getArgument("packageName");
                        Long channelId = environment.getArgument("channelId");
                        int platform;
                        String columnKey = "mid_nav_01";
                        
                        if (channelId == 13) {
                            platform = 1;
                        } else {
                            platform = 0;
                        }
                        // 栏位
                        ClientColumnMappingExample example = new ClientColumnMappingExample();
                        example.createCriteria()
                            .andPackageNameEqualTo(packageName)
                            .andPlatformIdEqualTo(platform)
                            .andColumnKeyEqualTo(columnKey);
                        List<ClientColumnMapping> list = clientColumnMappingMapper.selectByExample(example);
                        if (list == null || list.size() == 0) {
                            return null;
                        } else {
                            columnKey = list.get(0).getColumnKey();
                        }
                        
                        ProductColumnMappingExample productColumnMappingExample = 
                              new ProductColumnMappingExample();
                        productColumnMappingExample
                                .createCriteria().andColumnKeyEqualTo(columnKey);
                        
                        
                        List<ProductColumnMapping> productColumnMappings = 
                                productColumnMappingMapper.selectByExample(productColumnMappingExample);
                        if (productColumnMappings == null || productColumnMappings.size() == 0) {
                            return null;
                        }
                        
                        List<Long> productIds = new ArrayList();
                        for (ProductColumnMapping mapping : productColumnMappings) {
                            productIds.add(mapping.getProductId());
                        }
                        // 返回产品
                        ProductExample productExample = new ProductExample();
                        productExample.createCriteria().andIdIn(productIds).andIsPublishedEqualTo(true);
                        List<Product> products = productMapper.selectByExample(productExample);
                        List<MidNav> midNavs = new ArrayList<>();
                        for (Product product : products) {
                            midNavs.add(MidNav.convertToModel(product));
                        }
                        
                        return midNavs;
                    } ).build();
        }
        return listQueryField;
    }
    
    @Autowired(required = true)
    public void setProductMapper(MidNavMapper midMapper) {
        MidNavType.midNavMapper = midMapper;
    }
    @Autowired(required = true)
    public void setClientVersionMapper(ClientVersionMapper clientVersionMapper) {
        MidNavType.clientVersionMapper = clientVersionMapper;
    }
    
    @Autowired(required = true)
    public void setClientColumnMappingMapper(ClientColumnMappingMapper clientColumnMappingMapper) {
        MidNavType.clientColumnMappingMapper = clientColumnMappingMapper;
    }

    @Autowired(required = true)
    public void setProductColumnMappingMapper(ProductColumnMappingMapper productColumnMappingMapper) {
        MidNavType.productColumnMappingMapper = productColumnMappingMapper;
    }
    @Autowired(required = true)
    public void setColumnMapper(ColumnMapper columnMapper) {
        MidNavType.columnMapper = columnMapper;
    }
    @Autowired(required = true)
    public void setProductMapper(ProductMapper productMapper) {
        MidNavType.productMapper = productMapper;
    }
}
