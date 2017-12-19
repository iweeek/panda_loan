package com.pinganzhiyuan.graphql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.pinganzhiyuan.mapper.GuaranteeTypeMappingMapper;
import com.pinganzhiyuan.mapper.LoanAmountRangeMapper;
import com.pinganzhiyuan.mapper.ProductMapper;
import com.pinganzhiyuan.mapper.ProductTypeMappingMapper;
import com.pinganzhiyuan.mapper.SelectOrderMapper;
import com.pinganzhiyuan.model.GuaranteeTypeMapping;
import com.pinganzhiyuan.model.GuaranteeTypeMappingExample;
import com.pinganzhiyuan.model.Product;
import com.pinganzhiyuan.model.ProductExample;
import com.pinganzhiyuan.model.ProductExample.Criteria;
import com.pinganzhiyuan.model.ProductTypeMappingExample;
import com.pinganzhiyuan.model.SelectOrder;
import com.pinganzhiyuan.model.SelectOrderExample;
import com.pinganzhiyuan.model.LoanAmountRange;
import com.pinganzhiyuan.model.LoanAmountRangeExample;
import com.pinganzhiyuan.model.ProductTypeMapping;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

@Component
public class RecommendProductType {
    
    private static GraphQLFieldDefinition singleQueryField;
    private static GraphQLFieldDefinition listQueryField;
    
    private static ProductMapper productMapper;
    private static GuaranteeTypeMappingMapper guaranteeTypeMappingMapper;
    private static ProductTypeMappingMapper productTypeMappingMapper;
    private static SelectOrderMapper selectOrderMapper;
    private static LoanAmountRangeMapper loanAmountRangeMapper;

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
                            .newFieldDefinition().name("isNew")
                            .description("是否为新")
                            .type(Scalars.GraphQLBoolean)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("firstTags")
                            .description("第一行标签")
                            .type(Scalars.GraphQLString)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("secondTags")
                            .description("第二行标签")
                            .type(Scalars.GraphQLString)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("description")
                            .description("副标题")
                            .type(Scalars.GraphQLString)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("imgUrl")
                            .description("图片地址")
                            .type(Scalars.GraphQLString)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("url")
                            .description("导向地址")
                            .type(Scalars.GraphQLString)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("minAmount")
                            .description("贷款下限")
                            .type(Scalars.GraphQLInt)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("maxAmount")
                            .description("贷款上限")
                            .type(Scalars.GraphQLInt)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("creditAuth")
                            .description("信用资质")
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
    
    public static GraphQLFieldDefinition getSearchListField() {
        if(listQueryField == null) {
            listQueryField = GraphQLFieldDefinition.newFieldDefinition()
                    .argument(GraphQLArgument.newArgument().name("guaranteeId").type(Scalars.GraphQLLong).build())
                    .argument(GraphQLArgument.newArgument().name("loanAmountRangeId").type(Scalars.GraphQLLong).build())
                    .argument(GraphQLArgument.newArgument().name("term").type(Scalars.GraphQLInt).build())
                    .argument(GraphQLArgument.newArgument().name("selectOrderId").type(Scalars.GraphQLLong).build())
                    .argument(GraphQLArgument.newArgument().name("pageNumber").type(Scalars.GraphQLInt).build())
                    .argument(GraphQLArgument.newArgument().name("pageSize").type(Scalars.GraphQLInt).build())
                    .name("recommendProducts")
                    .description("获取产品列表")
                    .type(new GraphQLList(getType()))
                    .dataFetcher(environment ->  {
//                        String guaranteeIds = environment.getArgument("guaranteeIds");
                        Long guaranteeId = environment.getArgument("guaranteeId");
                        List<GuaranteeTypeMapping> guaranteeTypeMappingList = null;
                        List<Long> productIdList = new ArrayList<Long>();
                        if (guaranteeId != null && guaranteeId != 0) {
                            GuaranteeTypeMappingExample gExample = new GuaranteeTypeMappingExample();
                            gExample.or().andGuaranteeIdEqualTo(guaranteeId);
                            
                            guaranteeTypeMappingList = guaranteeTypeMappingMapper.selectByExample(gExample);
                            for (GuaranteeTypeMapping guaranteeTypeMapping : guaranteeTypeMappingList) {
                              ProductTypeMappingExample example = new ProductTypeMappingExample();
                              example.or().andTypeIdEqualTo(guaranteeTypeMapping.getProductTypeId());
                              List<ProductTypeMapping> productTypeMappingList = productTypeMappingMapper.selectByExample(example);
                              for (ProductTypeMapping mapping : productTypeMappingList) {
                                  productIdList.add(mapping.getProductId());
                              }
                          }
                        }
                        
                        //取出抵押Id列表
//                        if (guaranteeIds != null) {
//                            String guarIdArr[] = guaranteeIds.split("|");
//                            
//                            GuaranteeTypeMappingExample gExample = new GuaranteeTypeMappingExample();
//                            for (String guarId : guarIdArr) {
//                                gExample.or().andGuaranteeIdEqualTo(Long.valueOf(guarId));
//                            }
//                            
//                            //获取产品类型列表
//                            guaranteeTypeMappingList = guaranteeTypeMappingMapper.selectByExample(gExample);
//                            for (GuaranteeTypeMapping guaranteeTypeMapping : guaranteeTypeMappingList) {
//                                ProductTypeMappingExample example = new ProductTypeMappingExample();
//                                example.or().andTypeIdEqualTo(guaranteeTypeMapping.getProductTypeId());
//                                List<ProductTypeMapping> productTypeMappingList = productTypeMappingMapper.selectByExample(example);
//                                for (ProductTypeMapping mapping : productTypeMappingList) {
//                                    productIdList.add(mapping.getProductId());
//                                }
//                            }
//                        }
                        LoanAmountRange loanAmountRange = null;
                        Long loanAmountRangeId = environment.getArgument("loanAmountRangeId");
                        if (loanAmountRangeId != null && loanAmountRangeId != 0) {
                            LoanAmountRangeExample example = new LoanAmountRangeExample();
                            example.createCriteria().andIdEqualTo(loanAmountRangeId);
                            List<LoanAmountRange> list = loanAmountRangeMapper.selectByExample(example);
                            if (list.size() != 0) {
                                loanAmountRange = list.get(0);
                            }
                        }
                        
                        Integer term = environment.getArgument("term");
                        
                        String selectOrder = null;
                        Long selectOrderId = environment.getArgument("selectOrderId");
                        if (selectOrderId != null && selectOrderId != 0) {
                            SelectOrderExample example = new SelectOrderExample();
                            example.createCriteria().andIdEqualTo(selectOrderId);
                            List<SelectOrder> list = selectOrderMapper.selectByExample(example);
                            selectOrder = list.get(0).getField();
                        }
                        
//                        if (guaranteeTypeMappingList != null) {
//                            for (GuaranteeTypeMapping guaranteeTypeMapping : guaranteeTypeMappingList) {
//                                example.or().andTyp
//                            }
//                            
//                        }
                        
                        ProductExample example = new ProductExample();
                        Criteria criteria = example.createCriteria();
                        criteria.andIsPublishedEqualTo(true);
                        
                        if (productIdList.size() != 0) {
                            criteria.andIdIn(productIdList);
                        }
                        
                        if (term != null) {
                            criteria.andMinTermLessThanOrEqualTo(term).andMaxTermGreaterThanOrEqualTo(term);
                        }
                        
                        if (loanAmountRange != null) {
                            criteria.andMinAmountGreaterThanOrEqualTo(loanAmountRange.getMinAmount()).andMaxAmountGreaterThanOrEqualTo(loanAmountRange.getMaxAmount());
                        }
                        
                        String orderByClause = "";
                        if (selectOrder != null) {
                            orderByClause += selectOrder;
                        }
                       
                        orderByClause += "weight desc";
                        example.setOrderByClause(orderByClause);
                        PageHelper.startPage(environment.getArgument("pageNumber"), environment.getArgument("pageSize"));
                        List<Product> list = productMapper.selectByExample(example);
                        return list;
                    } ).build();
        }
        return listQueryField;
    }
    
    @Autowired(required = true)
    public void setProductMapper(ProductMapper productMapper) {
        RecommendProductType.productMapper = productMapper;
    }
    
    @Autowired(required = true)
    public void setGuaranteeTypeMappingMapper(GuaranteeTypeMappingMapper guaranteeTypeMappingMapper) {
        RecommendProductType.guaranteeTypeMappingMapper = guaranteeTypeMappingMapper;
    }
    
    @Autowired(required = true)
    public void setProductTypeMappingMapper(ProductTypeMappingMapper productTypeMappingMapper) {
        RecommendProductType.productTypeMappingMapper = productTypeMappingMapper;
    }
    
    @Autowired(required = true)
    public void setSelectOrderMapper(SelectOrderMapper selectOrderMapper) {
        RecommendProductType.selectOrderMapper = selectOrderMapper;
    }
    
    @Autowired(required = true)
    public void setLoanAmountRangeMapper(LoanAmountRangeMapper loanAmountRangeMapper) {
        RecommendProductType.loanAmountRangeMapper = loanAmountRangeMapper;
    }
}
