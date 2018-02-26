package com.pinganzhiyuan.graphql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pinganzhiyuan.mapper.ClientColumnMappingMapper;
import com.pinganzhiyuan.mapper.ClientVersionMapper;
import com.pinganzhiyuan.mapper.ColumnMapper;
import com.pinganzhiyuan.mapper.MidAdMapper;
import com.pinganzhiyuan.mapper.ProductColumnMappingMapper;
import com.pinganzhiyuan.mapper.ProductMapper;
import com.pinganzhiyuan.model.ClientColumnMapping;
import com.pinganzhiyuan.model.ClientColumnMappingExample;
import com.pinganzhiyuan.model.Column;
import com.pinganzhiyuan.model.MidAd;
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
public class MidAdType {
    
    private static GraphQLFieldDefinition singleQueryField;
    private static GraphQLFieldDefinition listQueryField;
    
    private static MidAdMapper midAdMapper;

    private static ClientVersionMapper clientVersionMapper;
    private static ClientColumnMappingMapper clientColumnMappingMapper; 
    
    private static ColumnMapper columnMapper;
    private static ProductColumnMappingMapper productColumnMappingMapper;
    
    private static ProductMapper productMapper;
    
    private static GraphQLObjectType type;
   

    public static GraphQLObjectType getType() {
        if (type == null) {
            type = GraphQLObjectType
                    .newObject().name("MidAd").description("中部广告")
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("id")
                            .description("唯一主键")
                            .type(Scalars.GraphQLLong)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("name")
                            .description("广告名称")
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
                            .newFieldDefinition().name("description")
                            .description("描述")
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
//                        return bannerMapper.selectByExample(null).get(0);
//                    }).build();
//        }
//        return singleQueryField;
//    }
    
    public static GraphQLFieldDefinition getListQueryField() {
        if(listQueryField == null) {
            listQueryField = GraphQLFieldDefinition.newFieldDefinition()
                    .argument(GraphQLArgument.newArgument().name("packageName").type(Scalars.GraphQLString).build())
                    .argument(GraphQLArgument.newArgument().name("channelId").type(Scalars.GraphQLLong).build())
                    .name("midAds")
                    .description("中部广告列表")
                    .type(new GraphQLList(getType()))
                    .dataFetcher(environment ->  {
                        
                        String packageName = environment.getArgument("packageName");
                        Long channelId = environment.getArgument("channelId");
                        int platform;
                        String columnKey = "mid_ad_01";
                        
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
                        List<MidAd> midAds = new ArrayList<>();
                        for (Product product : products) {
                            midAds.add(MidAd.convertToModel(product));
                        }
                        
                        return midAds;
                    } ).build();
        }
        return listQueryField;
    }
    
    @Autowired(required = true)
    public void setMidAdMapper(MidAdMapper midAdMapper) {
        MidAdType.midAdMapper = midAdMapper;
    }
    
    @Autowired(required = true)
    public void setClientVersionMapper(ClientVersionMapper clientVersionMapper) {
        MidAdType.clientVersionMapper = clientVersionMapper;
    }
    
    @Autowired(required = true)
    public void setClientColumnMappingMapper(ClientColumnMappingMapper clientColumnMappingMapper) {
        MidAdType.clientColumnMappingMapper = clientColumnMappingMapper;
    }

    @Autowired(required = true)
    public void setProductColumnMappingMapper(ProductColumnMappingMapper productColumnMappingMapper) {
        MidAdType.productColumnMappingMapper = productColumnMappingMapper;
    }
    @Autowired(required = true)
    public void setColumnMapper(ColumnMapper columnMapper) {
        MidAdType.columnMapper = columnMapper;
    }
    @Autowired(required = true)
    public void setProductMapper(ProductMapper productMapper) {
        MidAdType.productMapper = productMapper;
    }
    
}
