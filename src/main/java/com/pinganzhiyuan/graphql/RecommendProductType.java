package com.pinganzhiyuan.graphql;

import static org.hamcrest.CoreMatchers.nullValue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.mapping.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinganzhiyuan.mapper.AppClientMapper;
import com.pinganzhiyuan.mapper.ColumnMapper;
import com.pinganzhiyuan.mapper.GuaranteeProductMappingMapper;
import com.pinganzhiyuan.mapper.GuaranteeTypeMappingMapper;
import com.pinganzhiyuan.mapper.LoanAmountRangeMapper;
import com.pinganzhiyuan.mapper.ProductColumnMappingMapper;
import com.pinganzhiyuan.mapper.ProductMapper;
import com.pinganzhiyuan.mapper.ProductTypeMappingMapper;
import com.pinganzhiyuan.mapper.SelectOrderMapper;
import com.pinganzhiyuan.mapper.TermMapper;
import com.pinganzhiyuan.model.AppClient;
import com.pinganzhiyuan.model.AppClientExample;
import com.pinganzhiyuan.model.Column;
import com.pinganzhiyuan.model.ColumnExample;
import com.pinganzhiyuan.model.GuaranteeProductMapping;
import com.pinganzhiyuan.model.GuaranteeProductMappingExample;
import com.pinganzhiyuan.model.GuaranteeTypeMapping;
import com.pinganzhiyuan.model.GuaranteeTypeMappingExample;
import com.pinganzhiyuan.model.Product;
import com.pinganzhiyuan.model.ProductColumnMapping;
import com.pinganzhiyuan.model.ProductColumnMappingExample;
import com.pinganzhiyuan.model.ProductExample;
import com.pinganzhiyuan.model.ProductExample.Criteria;
import com.pinganzhiyuan.model.ProductTypeMappingExample;
import com.pinganzhiyuan.model.SelectOrder;
import com.pinganzhiyuan.model.SelectOrderExample;
import com.pinganzhiyuan.model.Term;
import com.pinganzhiyuan.model.TermExample;
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
    private static GuaranteeProductMappingMapper guaranteeProductMappingMapper;
    private static ProductTypeMappingMapper productTypeMappingMapper;
    private static SelectOrderMapper selectOrderMapper;
    private static LoanAmountRangeMapper loanAmountRangeMapper;
    private static TermMapper termMapper;
    private static AppClientMapper appClientMapper;
    
    private static ColumnMapper columnMapper;
    private static ProductColumnMappingMapper productColumnMappingMapper;
    
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
                    // 2018年01月29日 新增maxTerm、dayRate
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("maxTerm")
                            .description("贷款期限上限")
                            .type(Scalars.GraphQLInt)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("minTerm")
                            .description("贷款期限下限")
                            .type(Scalars.GraphQLInt)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("dayRate")
                            .description("日利率")
                            .type(Scalars.GraphQLString)
                            .dataFetcher(environment -> {
                                Product product = environment.getSource();
                                String secondTags = product.getSecondTags();
                                if (secondTags != null) {
                                    Pattern p = Pattern.compile("日利率(.*?)\\%起");
                                    Matcher m = p.matcher(secondTags);
                                    if (m.find()) {
                                        return m.group(1);
                                    }
                                    return "0";
                                }
                                return "0";
                             })
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
                    .argument(GraphQLArgument.newArgument().name("typeId").type(Scalars.GraphQLInt).build())
                    .argument(GraphQLArgument.newArgument().name("productTypeId").type(Scalars.GraphQLLong).build())
                    .argument(GraphQLArgument.newArgument().name("pageNumber").type(Scalars.GraphQLInt).build())
                    .argument(GraphQLArgument.newArgument().name("pageSize").type(Scalars.GraphQLInt).build())
                    .argument(GraphQLArgument.newArgument().name("packageName").type(Scalars.GraphQLString).build())
                    .argument(GraphQLArgument.newArgument().name("channelId").type(Scalars.GraphQLLong).build())
                    .name("recommendProducts")
                    .description("获取产品列表")
                    .type(new GraphQLList(getType()))
                    .dataFetcher(environment -> {
                        // appClient列表对应的aid
                        String packageName = environment.getArgument("packageName");
                        Long channelId = environment.getArgument("channelId");
                        AppClientExample exp = new AppClientExample();
                        exp.createCriteria()
                               .andPackageNameEqualTo(packageName)
                               .andChannelIdEqualTo(channelId);
                        List<AppClient> appClients = appClientMapper.selectByExample(exp);
                        
                        Long allowAppId = 0l;
                        if (appClients != null && appClients.size() != 0) {
                            allowAppId = appClients.get(0).getId();
                        }
                        
//                        String guaranteeIds = environment.getArgument("guaranteeIds");
                        Long guaranteeId = environment.getArgument("guaranteeId");
                        List<GuaranteeTypeMapping> guaranteeTypeMappingList = null;
                        List<Long> productIdList = new ArrayList<Long>();
                        if (guaranteeId != null && guaranteeId != 0) {
                            //两次映射的逻辑
//                            GuaranteeTypeMappingExample gExample = new GuaranteeTypeMappingExample();
//                            gExample.or().andGuaranteeIdEqualTo(guaranteeId);
//                            
//                            guaranteeTypeMappingList = guaranteeTypeMappingMapper.selectByExample(gExample);
//                            for (GuaranteeTypeMapping guaranteeTypeMapping : guaranteeTypeMappingList) {
//                              ProductTypeMappingExample example = new ProductTypeMappingExample();
//                              example.or().andTypeIdEqualTo(guaranteeTypeMapping.getProductTypeId());
//                              List<ProductTypeMapping> productTypeMappingList = productTypeMappingMapper.selectByExample(example);
//                              for (ProductTypeMapping mapping : productTypeMappingList) {
//                                  productIdList.add(mapping.getProductId());
//                              }
//                          }
                            
                            //一级映射关系
                            GuaranteeProductMappingExample example = new GuaranteeProductMappingExample();
                            example.createCriteria().andGuaranteeIdEqualTo(guaranteeId);
                            List<GuaranteeProductMapping> list = guaranteeProductMappingMapper.selectByExample(example);
                            for (GuaranteeProductMapping mapping : list) {
                              productIdList.add(mapping.getProductId());
                            }
                        }
                        
                        // 可以单独处理top_nav
                        Long productTypeId = environment.getArgument("productTypeId");
                        if (productTypeId != null) {
                            Column column = columnMapper.selectByPrimaryKey(productTypeId);
                            System.out.println("column: " + column);
                            
                            ProductColumnMappingExample productColumnMappingExample = new ProductColumnMappingExample();
                            productColumnMappingExample.createCriteria().andColumnKeyEqualTo(column.getColumnKey());
                            List<ProductColumnMapping> productColumnMappings = 
                                    productColumnMappingMapper.selectByExample(productColumnMappingExample);

                            if (productColumnMappings.size() > 0) {
                                for (ProductColumnMapping mapping : productColumnMappings) {
                                  productIdList.add(mapping.getProductId());
                                }
                            }
                            
                            System.out.println("productIdList：" + productIdList);
                            
                            if (productIdList.size() == 0) {
                                return null;
                            }
                            
                            ProductExample example = new ProductExample();
                            Criteria criteria = example.createCriteria();
                            criteria.andIsPublishedEqualTo(true);
                            
                            if (productIdList.size() != 0) {
                                criteria.andIdIn(productIdList);
                            }
                            
                            example.setOrderByClause(" weight desc ");
                            List<Product> list = productMapper.selectByExample(example);
                            
                            // 新增过滤 app 和渠道的筛选条件
                            List<Product> filterList = new ArrayList<>();
                            for (Product product : list) {
                                if (product.getAppClientIds() != null) {
                                    String[] split = product.getAppClientIds().split(",");
                                    for (String id : split) {
                                        if (String.valueOf(allowAppId).equals(id)) {
                                            filterList.add(product);
                                        }
                                    }
                                }
                            }
                            
                            return filterList;
                            
                           
//                          List<ProductTypeMapping> list = productTypeMappingMapper.selectByExample(example);
//                            ProductTypeMappingExample example = new ProductTypeMappingExample();
//                            example.createCriteria().andTypeIdEqualTo(productTypeId);
//                            
//                            List<ProductTypeMapping> list = productTypeMappingMapper.selectByExample(example);
//                            if (list.size() > 0) {
//                                for (ProductTypeMapping mapping : list) {
//                                  productIdList.add(mapping.getProductId());
//                              }
//                            }
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
                        
                        Term term = null;
                        Integer termId = environment.getArgument("term");
                        if (termId != null && termId != 0) {
                            TermExample example = new TermExample();
                            example.createCriteria().andIdEqualTo(Long.valueOf(termId));
                            List<Term> list = termMapper.selectByExample(example);
                            if (list.size() != 0) {
                                term = list.get(0);
                            }
                        }
                        
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
                        
                        Integer typeId = environment.getArgument("typeId");
                        
                        ProductExample example = new ProductExample();
                        Criteria criteria = example.createCriteria();
                        criteria.andIsPublishedEqualTo(true);
                        
                        if (productIdList.size() != 0) {
                            criteria.andIdIn(productIdList);
                        }
                        
                        if (term != null) {
                            if (!term.getDuration().equals("0")) {
                                criteria
                                    .andMinTermLessThanOrEqualTo(Integer.valueOf(term.getDuration()))
                                    .andMaxTermGreaterThanOrEqualTo(Integer.valueOf(term.getDuration()));
                            }
                            
                        }
                        
                        if (loanAmountRange != null) {
                            if (!(loanAmountRange.getMinAmount() == 0 && loanAmountRange.getMaxAmount() == 0)) {
                                criteria.andMinAmountLessThanOrEqualTo(loanAmountRange.getMinAmount()).andMaxAmountGreaterThanOrEqualTo(loanAmountRange.getMaxAmount());
                            }
                        }
                        
                        if (typeId != null) {
                            criteria.andApplyTimesGreaterThan(0);
                        }
                        
                        String orderByClause = "";
                        if (selectOrder != null && !selectOrder.equals("")) {
                            orderByClause += selectOrder + ", ";
                        }
                       
                        orderByClause += "weight desc";
                        example.setOrderByClause(orderByClause);
                        
                        Integer pageNumber = environment.getArgument("pageNumber");
                        if (pageNumber == null) {
                            pageNumber = 1;
                        }
                        
                        Integer pageSize = environment.getArgument("pageSize");
                        if (pageSize == null) {
                            pageSize = 10;
                        }
                        
                        PageHelper.startPage(pageNumber, pageSize);
                        List<Product> list = productMapper.selectByExample(example);
                        List<Product> filterList = new ArrayList<>();
                        for (Product product : list) {
                            if (product.getAppClientIds() != null) {
                                String[] split = product.getAppClientIds().split(",");
                                for (String id : split) {
                                    if (String.valueOf(allowAppId).equals(id)) {
                                        filterList.add(product);
                                    }
                                }
                            }
                        }
                        return filterList;
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
    
    @Autowired(required = true)
    public void setGuaranteeProductMappingMapper(GuaranteeProductMappingMapper guaranteeProductMappingMapper) {
        RecommendProductType.guaranteeProductMappingMapper = guaranteeProductMappingMapper;
    }
    
    @Autowired(required = true)
    public void setProductColumnMappingMapper(ProductColumnMappingMapper productColumnMappingMapper) {
        RecommendProductType.productColumnMappingMapper = productColumnMappingMapper;
    }
    @Autowired(required = true)
    public void setColumnMapper(ColumnMapper columnMapper) {
        RecommendProductType.columnMapper = columnMapper;
    }
    @Autowired(required = true)
    public void setTermMapper(TermMapper termMapper) {
        RecommendProductType.termMapper = termMapper;
    }
    
    @Autowired(required = true)
    public void setAppClientMapper(AppClientMapper appClientMapper) {
        RecommendProductType.appClientMapper = appClientMapper;
    }
}
