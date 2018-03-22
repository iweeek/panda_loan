package com.pinganzhiyuan.graphql;

import static org.hamcrest.CoreMatchers.nullValue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.mapping.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinganzhiyuan.mapper.AppClientMapper;
import com.pinganzhiyuan.mapper.ClientColumnMappingMapper;
import com.pinganzhiyuan.mapper.ColumnMapper;
import com.pinganzhiyuan.mapper.GuaranteeProductMappingMapper;
import com.pinganzhiyuan.mapper.GuaranteeTypeMappingMapper;
import com.pinganzhiyuan.mapper.H5AppClientMapper;
import com.pinganzhiyuan.mapper.H5ClientColumnMappingMapper;
import com.pinganzhiyuan.mapper.H5ClientVersionMapper;
import com.pinganzhiyuan.mapper.H5ColumnMapper;
import com.pinganzhiyuan.mapper.H5ProductClientVersionMappingMapper;
import com.pinganzhiyuan.mapper.H5ProductColumnMappingMapper;
import com.pinganzhiyuan.mapper.LandingChannelMapper;
import com.pinganzhiyuan.mapper.LoanAmountRangeMapper;
import com.pinganzhiyuan.mapper.ProductColumnMappingMapper;
import com.pinganzhiyuan.mapper.ProductMapper;
import com.pinganzhiyuan.mapper.ProductTypeMappingMapper;
import com.pinganzhiyuan.mapper.SelectOrderMapper;
import com.pinganzhiyuan.mapper.TermMapper;
import com.pinganzhiyuan.model.AppClient;
import com.pinganzhiyuan.model.AppClientExample;
import com.pinganzhiyuan.model.ClientColumnMapping;
import com.pinganzhiyuan.model.ClientColumnMappingExample;
import com.pinganzhiyuan.model.ClientVersion;
import com.pinganzhiyuan.model.Column;
import com.pinganzhiyuan.model.ColumnExample;
import com.pinganzhiyuan.model.GuaranteeProductMapping;
import com.pinganzhiyuan.model.GuaranteeProductMappingExample;
import com.pinganzhiyuan.model.GuaranteeTypeMapping;
import com.pinganzhiyuan.model.GuaranteeTypeMappingExample;
import com.pinganzhiyuan.model.H5AppClient;
import com.pinganzhiyuan.model.H5AppClientExample;
import com.pinganzhiyuan.model.H5ClientColumnMapping;
import com.pinganzhiyuan.model.H5ClientColumnMappingExample;
import com.pinganzhiyuan.model.H5ClientVersion;
import com.pinganzhiyuan.model.H5ClientVersionExample;
import com.pinganzhiyuan.model.H5Column;
import com.pinganzhiyuan.model.H5ProductClientVersionMapping;
import com.pinganzhiyuan.model.H5ProductClientVersionMappingExample;
import com.pinganzhiyuan.model.H5ProductColumnMapping;
import com.pinganzhiyuan.model.H5ProductColumnMappingExample;
import com.pinganzhiyuan.model.LandingChannel;
import com.pinganzhiyuan.model.LandingChannelExample;
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
    private static GraphQLFieldDefinition h5ListQueryField;
    
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
    private static ClientColumnMappingMapper clientColumnMappingMapper; 
    private static H5AppClientMapper h5AppClientMapper;
    private static H5ClientVersionMapper h5ClientVersionMapper;
    private static LandingChannelMapper landingChannelMapper;
    private static H5ProductClientVersionMappingMapper h5ProductClientVersionMappingMapper;
    private static H5ProductColumnMappingMapper h5ProductColumnMappingMapper;
    private static H5ColumnMapper h5ColumnMapper;
    private static H5ClientColumnMappingMapper h5ClientColumnMappingMapper;
    
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
                        List<Long> productIdList = new ArrayList<Long>();
                        if (guaranteeId != null && guaranteeId != 0) {
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
                            
                            // 根据栏位
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
                            
                            // 根据APP
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
                            
                        }
                        
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
                        
                        // 近七日排行榜单独拿出来处理
                        Integer typeId = environment.getArgument("typeId");
                        if (typeId != null) {
                            List<Long> productIds = new ArrayList<Long>();
                            productIds.addAll(filterColumn(packageName, channelId));
                            // 返回产品
                            ProductExample productExample = new ProductExample();
                            productExample.createCriteria()
                                          .andIdIn(productIds)
                                          .andIsPublishedEqualTo(true);
//                                          .andApplyTimesGreaterThan(0);
                            productExample.setOrderByClause(" apply_times desc, weight desc ");
                            PageHelper.startPage(pageNumber, pageSize);
                            List<Product> products = productMapper.selectByExample(productExample);
                            
                            List<Product> filterList = new ArrayList<>();
                            // 根据APP
                            for (Product product : products) {
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
                        }
                        
                        PageHelper.startPage(pageNumber, pageSize);
                        List<Product> list = productMapper.selectByExample(example);
                        List<Product> filterList = new ArrayList<>();
                        // 根据APP做过滤
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
    
    
    public static GraphQLFieldDefinition getH5SearchListField() {
        if(h5ListQueryField == null) {
        	h5ListQueryField = GraphQLFieldDefinition.newFieldDefinition()
                    .argument(GraphQLArgument.newArgument().name("productTypeId").type(Scalars.GraphQLLong).build())
                    .argument(GraphQLArgument.newArgument().name("pageNumber").type(Scalars.GraphQLInt).build())
                    .argument(GraphQLArgument.newArgument().name("pageSize").type(Scalars.GraphQLInt).build())
                    .argument(GraphQLArgument.newArgument().name("h5WebName").type(Scalars.GraphQLString).build())
                    .argument(GraphQLArgument.newArgument().name("h5ChannelUid").type(Scalars.GraphQLString).build())
                    .argument(GraphQLArgument.newArgument().name("platformId").type(Scalars.GraphQLString).build())
                    .name("h5RecommendProducts")
                    .description("获取产品列表")
                    .type(new GraphQLList(getType()))
                    .dataFetcher(environment -> {
                    	
	                    	Long h5AppId = null;
	                		Long h5ChannelId = null;
	                		// 匹配的产品ID
	                		List<Long> h5ProductIDs = null;
	                		List<Product> products = null;
	                		
	                		// 可以单独处理top_nav
	                		/*
                        Long productTypeId = environment.getArgument("productTypeId");
                        if (productTypeId != null) {
                        		H5Column h5Column = h5ColumnMapper.selectByPrimaryKey(productTypeId);
                            System.out.println("h5Column: " + h5Column);
                            
                            // 根据栏位
                            h5ProductIDs = filterProductWithH5ColumnKey(h5Column.getH5ColumnKey());
                            System.out.println("h5ProductIDs：" + h5ProductIDs);
                            
                            Integer pageNumber = environment.getArgument("pageNumber");
                            if (pageNumber == null) {
                                pageNumber = 1;
                            }
                            
                            Integer pageSize = environment.getArgument("pageSize");
                            if (pageSize == null) {
                                pageSize = 10;
                            }
                            
                            PageHelper.startPage(pageNumber, pageSize);
                            Map<String, Object> map = new HashMap<>();
                            map.put("list", h5ProductIDs);
//                            List<Product> list = productMapper.selectByExample(productExample);
                            List<Product> products = 
                            		productMapper.associateWithH5ProductColumnMapping(map);
                            return products;
                        }
                        */
	                		
	                		String h5WebName = environment.getArgument("h5WebName");
	                	    if (h5WebName != null) {
	                	    	 	H5AppClientExample h5AppClientExample = new H5AppClientExample();
	                	         h5AppClientExample.createCriteria().andNameEqualTo(h5WebName);
	                	         List<H5AppClient> h5AppClients = h5AppClientMapper.selectByExample(h5AppClientExample);
	                	    		if (h5AppClients != null && h5AppClients.size() != 0) {
	                	    			h5AppId = h5AppClients.get(0).getId();
	                	    		}
	                	    }
	                	    
	                	    String landingChannelUid = environment.getArgument("h5ChannelUid");
	                	    LandingChannelExample landingChannelExample = new LandingChannelExample();
	                	    landingChannelExample.createCriteria().andChannelUidEqualTo(landingChannelUid);
	                	    List<LandingChannel> landingChannel = landingChannelMapper.selectByExample(landingChannelExample);
	                	    if (landingChannel != null && landingChannel.size() != 0) {
	                	    		h5ChannelId = landingChannel.get(0).getId();
	                	    } 
	                	    
	                	    String platformId = environment.getArgument("platformId");
	                	    
	                	    if (h5AppId != null && h5ChannelId != null) {
	                	    		H5ClientVersionExample h5ClientVersionExample = new H5ClientVersionExample();
	                	    		h5ClientVersionExample.createCriteria().andH5AppIdEqualTo(h5AppId)
	                	    								.andH5ChannelIdEqualTo(h5ChannelId)
	                	    								.andPlatformIdEqualTo(Byte.valueOf(platformId));
	                	    		List<H5ClientVersion> h5ClientVersions = h5ClientVersionMapper.selectByExample(h5ClientVersionExample);
	                	    		
	                	    		if (h5ClientVersions != null && h5ClientVersions.size() != 0) {
	                	    			long h5ClientVersionId = h5ClientVersions.get(0).getId();
	                	    			
	                	    			H5ClientColumnMappingExample h5ClientColumnMappingExample =
	                	    					new  H5ClientColumnMappingExample();
	                	    			h5ClientColumnMappingExample.createCriteria()
	                	    					.andH5ClientVersionIdEqualTo(h5ClientVersionId)
	                	    					.andStatusEqualTo((byte) 1);
	                	    			List<H5ClientColumnMapping> h5ClientColumnMappings = 
	                	    					h5ClientColumnMappingMapper.selectByExample(h5ClientColumnMappingExample);
	                	    			
	                	    			Long productTypeId = environment.getArgument("productTypeId");
                                if (productTypeId != null) {
                                		H5Column h5Column = h5ColumnMapper.selectByPrimaryKey(productTypeId);
                                		for (H5ClientColumnMapping h5ClientColumnMapping : h5ClientColumnMappings) {
                                			if (h5Column.getH5ColumnKey().equals(h5ClientColumnMapping.getH5ColumnKey())) {
                                				// 匹配了对应的栏位了
                                				
                                				// 根据栏位查找产品
                                                h5ProductIDs = filterProductWithH5ColumnKey(h5Column.getH5ColumnKey());
                                                System.out.println("h5ProductIDs：" + h5ProductIDs);
                                                
                                                Integer pageNumber = environment.getArgument("pageNumber");
                                                if (pageNumber == null) {
                                                    pageNumber = 1;
                                                }
                                                
                                                Integer pageSize = environment.getArgument("pageSize");
                                                if (pageSize == null) {
                                                    pageSize = 10;
                                                }
                                                
                                                PageHelper.startPage(pageNumber, pageSize);
                                                Map<String, Object> map = new HashMap<>();
                                                map.put("list", h5ProductIDs);
//                                                List<Product> list = productMapper.selectByExample(productExample);
                                                products = 
                                                		productMapper.associateWithH5ProductColumnMapping(map);
                                                return products;
                                				
                                			}
                                		}
                                }
	                	    		}
	                	    }
	                	    return products;
                    } ).build();
        }
        return h5ListQueryField;
    }
    
    public static List<Long> filterProductWithH5ColumnKey(String h5Columnkey) {
    		List<Long> h5ProductIDs = new ArrayList<>();
    		// 根据栏位
        H5ProductColumnMappingExample h5ProductColumnMappingExample =
        		new H5ProductColumnMappingExample();
        h5ProductColumnMappingExample.createCriteria()
        		.andH5ColumnKeyEqualTo(h5Columnkey)
        		.andStatusEqualTo((byte) 1);
        h5ProductColumnMappingExample.setOrderByClause("sequence desc");
        List<H5ProductColumnMapping> h5ProductColumnMappings = 
        		h5ProductColumnMappingMapper.selectByExample(h5ProductColumnMappingExample);
        
        h5ProductIDs = new ArrayList<>();
        if (h5ProductColumnMappings.size() > 0) {
            for (H5ProductColumnMapping mapping : h5ProductColumnMappings) {
            		h5ProductIDs.add(mapping.getProductId());
            }
        }
        
        return h5ProductIDs;
    }
    
    /*
    public static GraphQLFieldDefinition getH5SearchListFieldOld() {
        if(h5ListQueryField == null) {
        	h5ListQueryField = GraphQLFieldDefinition.newFieldDefinition()
                    .argument(GraphQLArgument.newArgument().name("productTypeId").type(Scalars.GraphQLLong).build())
                    .argument(GraphQLArgument.newArgument().name("pageNumber").type(Scalars.GraphQLInt).build())
                    .argument(GraphQLArgument.newArgument().name("pageSize").type(Scalars.GraphQLInt).build())
                    .argument(GraphQLArgument.newArgument().name("h5WebName").type(Scalars.GraphQLString).build())
                    .argument(GraphQLArgument.newArgument().name("h5ChannelUid").type(Scalars.GraphQLString).build())
                    .argument(GraphQLArgument.newArgument().name("platformId").type(Scalars.GraphQLString).build())
                    .name("h5RecommendProducts")
                    .description("获取产品列表")
                    .type(new GraphQLList(getType()))
                    .dataFetcher(environment -> {
                    	
	                    	Long h5AppId = null;
	                		Long h5ChannelId = null;
	                		// 匹配的产品ID
	                		List<Long> h5ProductIDs = null;
	                		
	                		// 可以单独处理top_nav
                        Long productTypeId = environment.getArgument("productTypeId");
                        if (productTypeId != null) {
                        		H5Column h5Column = h5ColumnMapper.selectByPrimaryKey(productTypeId);
                            System.out.println("h5Column: " + h5Column);
                            
                            // 根据栏位
                            H5ProductColumnMappingExample h5ProductColumnMappingExample =
                            		new H5ProductColumnMappingExample();
                            h5ProductColumnMappingExample.createCriteria()
                            		.andH5ColumnKeyEqualTo(h5Column.getH5ColumnKey())
                            		.andStatusEqualTo((byte) 1);
                            h5ProductColumnMappingExample.setOrderByClause("sequence desc");
                            List<H5ProductColumnMapping> h5ProductColumnMappings = 
                            		h5ProductColumnMappingMapper.selectByExample(h5ProductColumnMappingExample);
                            
                            h5ProductIDs = new ArrayList<>();
                            if (h5ProductColumnMappings.size() > 0) {
                                for (H5ProductColumnMapping mapping : h5ProductColumnMappings) {
                                		h5ProductIDs.add(mapping.getProductId());
                                }
                            }
                            System.out.println("h5ProductIDs：" + h5ProductIDs);
                            
//                            if (h5ProductIDs.size() == 0) {
//                                return null;
//                            }
//                            ProductExample productExample = new ProductExample();
//                            Criteria criteria = productExample.createCriteria();
//                            criteria.andIsPublishedEqualTo(true);
//                            
//                            if (h5ProductIDs.size() != 0) {
//                                criteria.andIdIn(h5ProductIDs);
//                            }
                            
                            Integer pageNumber = environment.getArgument("pageNumber");
                            if (pageNumber == null) {
                                pageNumber = 1;
                            }
                            
                            Integer pageSize = environment.getArgument("pageSize");
                            if (pageSize == null) {
                                pageSize = 10;
                            }
                            
                            PageHelper.startPage(pageNumber, pageSize);
                            Map<String, Object> map = new HashMap<>();
                            map.put("list", h5ProductIDs);
//                            List<Product> list = productMapper.selectByExample(productExample);
                            List<Product> products = 
                            		productMapper.associateWithH5ProductColumnMapping(map);
                            return products;
                        }
	                		
	                		String h5WebName = environment.getArgument("h5WebName");
	                	    if (h5WebName != null) {
	                	    	 	H5AppClientExample h5AppClientExample = new H5AppClientExample();
	                	         h5AppClientExample.createCriteria().andNameEqualTo(h5WebName);
	                	         List<H5AppClient> h5AppClients = h5AppClientMapper.selectByExample(h5AppClientExample);
	                	    		if (h5AppClients != null && h5AppClients.size() != 0) {
	                	    			h5AppId = h5AppClients.get(0).getId();
	                	    		}
	                	    }
	                	    
	                	    String landingChannelUid = environment.getArgument("h5ChannelUid");
	                	    LandingChannelExample landingChannelExample = new LandingChannelExample();
	                	    landingChannelExample.createCriteria().andChannelUidEqualTo(landingChannelUid);
	                	    List<LandingChannel> landingChannel = landingChannelMapper.selectByExample(landingChannelExample);
	                	    if (landingChannel != null && landingChannel.size() != 0) {
	                	    		h5ChannelId = landingChannel.get(0).getId();
	                	    } 
	                	    
	                	    String platformId = environment.getArgument("platformId");
	                	    
	                	    if (h5AppId != null && h5ChannelId != null) {
	                	    		H5ClientVersionExample h5ClientVersionExample = new H5ClientVersionExample();
	                	    		h5ClientVersionExample.createCriteria().andH5AppIdEqualTo(h5AppId)
	                	    								.andH5ChannelIdEqualTo(h5ChannelId)
	                	    								.andPlatformIdEqualTo(Byte.valueOf(platformId));
	                	    		List<H5ClientVersion> h5ClientVersions = h5ClientVersionMapper.selectByExample(h5ClientVersionExample);
	                	    		
	                	    		if (h5ClientVersions != null && h5ClientVersions.size() != 0) {
	                	    			long h5ClientVersionId = h5ClientVersions.get(0).getId();
	                	    			
	                	    			H5ProductClientVersionMappingExample h5ProductClientVersionMappingExample = 
	                	    					new H5ProductClientVersionMappingExample();
		                	    		h5ProductClientVersionMappingExample.createCriteria()
		                	    			.andH5ClientVersionIdEqualTo(h5ClientVersionId)
		                	    			.andStatusEqualTo((byte) 1);
		                	    		List<H5ProductClientVersionMapping> h5ProductClientVersionMappings = 
		                	    				h5ProductClientVersionMappingMapper.selectByExample(h5ProductClientVersionMappingExample);
		                	    		
		                	    		h5ProductIDs = new ArrayList<Long>();
		                	    		for(H5ProductClientVersionMapping h5ProductClientVersionMapping : 
		                	    			h5ProductClientVersionMappings) {
		                	    			h5ProductIDs.add(Long.valueOf((h5ProductClientVersionMapping.getProductId())));
		                	    		}
	                	    		}
	                	    }

	                	    ProductExample productExample = new ProductExample();
                        Criteria criteria = productExample.createCriteria();
                        criteria.andIsPublishedEqualTo(true);
                        
                        if (h5ProductIDs.size() != 0) {
                            criteria.andIdIn(h5ProductIDs);
                        }
                        
                        String orderByClause = "";
                        orderByClause += "weight desc";
                        productExample.setOrderByClause(orderByClause);
                        
                        Integer pageNumber = environment.getArgument("pageNumber");
                        if (pageNumber == null) {
                            pageNumber = 1;
                        }
                        
                        Integer pageSize = environment.getArgument("pageSize");
                        if (pageSize == null) {
                            pageSize = 10;
                        }
                        
                        PageHelper.startPage(pageNumber, pageSize);
                        List<Product> list = productMapper.selectByExample(productExample);
                        return list;
                    } ).build();
        }
        return h5ListQueryField;
    }
    
    */
    
    /**
     *  抽取成一个方法，根据栏位过滤，七日排行榜
     * @param packageName
     * @param channelId
     * @return
     */
    public static List<Long> filterColumn(String packageName, Long channelId) {
        int platform;
        String columnKey = "top_right_entry_01";
        
        if (channelId == 13) {
            platform = 1;
        } else {
            platform = 0;
        }
        // 根据栏位
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
        
        List<Long> productIds = new ArrayList<Long>();
        for (ProductColumnMapping mapping : productColumnMappings) {
            productIds.add(mapping.getProductId());
        }
        return productIds;
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
    @Autowired(required = true)
    public void setClientColumnMappingMapper(ClientColumnMappingMapper clientColumnMappingMapper) {
        RecommendProductType.clientColumnMappingMapper = clientColumnMappingMapper;
    }
    @Autowired(required = true)
    public void setH5AppClientMapper(H5AppClientMapper h5AppClientMapper) {
		RecommendProductType.h5AppClientMapper = h5AppClientMapper;
	}
    @Autowired(required = true)
	public void setH5ClientVersionMapper(H5ClientVersionMapper h5ClientVersionMapper) {
		RecommendProductType.h5ClientVersionMapper = h5ClientVersionMapper;
	}
    @Autowired(required = true)
	public void setLandingChannelMapper(LandingChannelMapper landingChannelMapper) {
		RecommendProductType.landingChannelMapper = landingChannelMapper;
	}
    @Autowired(required = true)
	public void setH5ProductClientVersionMappingMapper(
			H5ProductClientVersionMappingMapper h5ProductClientVersionMappingMapper) {
		RecommendProductType.h5ProductClientVersionMappingMapper = h5ProductClientVersionMappingMapper;
	}
    @Autowired(required = true)
	public void setH5ProductColumnMappingMapper(H5ProductColumnMappingMapper h5ProductColumnMappingMapper) {
		RecommendProductType.h5ProductColumnMappingMapper = h5ProductColumnMappingMapper;
	}
    @Autowired(required = true)
	public void setH5ColumnMapper(H5ColumnMapper h5ColumnMapper) {
		RecommendProductType.h5ColumnMapper = h5ColumnMapper;
	}
    @Autowired(required = true)
	public void setH5ClientColumnMappingMapper(H5ClientColumnMappingMapper h5ClientColumnMappingMapper) {
		RecommendProductType.h5ClientColumnMappingMapper = h5ClientColumnMappingMapper;
	}
    
}
