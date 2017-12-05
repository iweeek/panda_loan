package com.pinganzhiyuan.graphql;

import java.util.List;

import com.pinganzhiyuan.mapper.ProductMapper;
import com.pinganzhiyuan.model.Product;
import com.pinganzhiyuan.model.ProductExample;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

public class RecommendProductType {
    
    private static GraphQLFieldDefinition singleQueryField;
    private static GraphQLFieldDefinition listQueryField;
    private static ProductMapper productMapper;

    private static GraphQLObjectType type;
   

    public static GraphQLObjectType getType() {
        if (type == null) {
            type = GraphQLObjectType
                    .newObject().name("RecommendProduct").description("获取首页推荐产品")
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("id")
                            .description("唯一主键")
                            .type(Scalars.GraphQLLong)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("title")
                            .description("名称")
                            .type(Scalars.GraphQLString)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("subtitle")
                            .description("副标题")
                            .type(Scalars.GraphQLString)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("imgUrl")
                            .description("图片地址")
                            .type(Scalars.GraphQLString)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("targetUrl")
                            .description("导向地址")
                            .type(Scalars.GraphQLString)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("littleTitle")
                            .description("小标题")
                            .type(Scalars.GraphQLString)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("property")
                            .description("属性")
                            .type(Scalars.GraphQLString)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("edu")
                            .description("额度")
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
//                    .name("首页推荐产品")
//                    .description("首页推荐产品")
//                    .type(getType())
//                    .dataFetcher(environment -> {
//                        
//                    }).build();
//        }
//        return singleQueryField;
//    }
    
    public static GraphQLFieldDefinition getListQueryField() {
        if(listQueryField == null) {
            listQueryField = GraphQLFieldDefinition.newFieldDefinition()
                    .name("RecommendProducts")
                    .description("获取产品列表")
                    .type(new GraphQLList(getType()))
                    .dataFetcher(environment ->  {
                        ProductExample example = new ProductExample();
                        example.setOrderByClause("weight asc");
                        List<Product> list = productMapper.selectByExample(example);
                        return list;
                    } ).build();
        }
        return listQueryField;
    }
}
