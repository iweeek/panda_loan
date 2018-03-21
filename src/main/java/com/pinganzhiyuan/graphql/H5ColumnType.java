package com.pinganzhiyuan.graphql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pinganzhiyuan.mapper.H5AppClientMapper;
import com.pinganzhiyuan.mapper.H5ClientColumnMappingMapper;
import com.pinganzhiyuan.mapper.H5ClientVersionMapper;
import com.pinganzhiyuan.mapper.H5ColumnMapper;
import com.pinganzhiyuan.mapper.H5ProductColumnMappingMapper;
import com.pinganzhiyuan.mapper.LandingChannelMapper;
import com.pinganzhiyuan.model.H5AppClient;
import com.pinganzhiyuan.model.H5AppClientExample;
import com.pinganzhiyuan.model.H5ClientVersion;
import com.pinganzhiyuan.model.H5ClientVersionExample;
import com.pinganzhiyuan.model.H5Column;
import com.pinganzhiyuan.model.LandingChannel;
import com.pinganzhiyuan.model.LandingChannelExample;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

@Component
public class H5ColumnType {
    
    private static GraphQLFieldDefinition singleQueryField;
    private static GraphQLFieldDefinition listQueryField;
    
    private static H5ClientVersionMapper h5ClientVersionMapper;
    private static H5ClientColumnMappingMapper h5ClientColumnMappingMapper; 
    
    private static H5ColumnMapper h5ColumnMapper;
    private static H5ProductColumnMappingMapper h5ProductColumnMappingMapper;
    private static H5AppClientMapper h5AppClientMapper;
    private static LandingChannelMapper landingChannelMapper;
    

    private static GraphQLObjectType type;
   

    public static GraphQLObjectType getType() {
        if (type == null) {
            type = GraphQLObjectType
                    .newObject().name("H5Column").description("H5页面的栏位")
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("id")
                            .description("唯一主键")
                            .type(Scalars.GraphQLLong)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("h5ColumnKey")
                            .description("逻辑主键")
                            .type(Scalars.GraphQLString)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("h5ClientVersionId")
                            .description("h5版本ID")
                            .type(Scalars.GraphQLBigInteger)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("status")
                            .description("状态")
                            .type(Scalars.GraphQLInt)
                            .build())
                    .field(GraphQLFieldDefinition
	                    		.newFieldDefinition().name("name")
	                    		.description("给后台人员看")
	                    		.type(Scalars.GraphQLString)
	                    		.build())
                    .field(GraphQLFieldDefinition
	                    		.newFieldDefinition().name("title")
	                    		.description("标题")
	                    		.type(Scalars.GraphQLString)
	                    		.build())
                    .field(GraphQLFieldDefinition
	                    		.newFieldDefinition().name("subtitle")
	                    		.description("副标题")
	                    		.type(Scalars.GraphQLString)
	                    		.build())
                    .field(GraphQLFieldDefinition
	                    		.newFieldDefinition().name("url")
	                    		.description("为 H5 预留")
	                    		.type(Scalars.GraphQLString)
	                    		.build())
                    .field(GraphQLFieldDefinition
	                    		.newFieldDefinition().name("iconUrl")
	                    		.description("logo地址")
	                    		.type(Scalars.GraphQLString)
	                    		.build())
                    .build();
        }
        return type;
    }
    
    public static GraphQLFieldDefinition getListQueryField() {
        if(listQueryField == null) {
            listQueryField = GraphQLFieldDefinition.newFieldDefinition()
            			.argument(GraphQLArgument.newArgument().name("h5WebName").type(Scalars.GraphQLString).build())
                    .argument(GraphQLArgument.newArgument().name("h5ChannelUid").type(Scalars.GraphQLString).build())
                    .argument(GraphQLArgument.newArgument().name("platformId").type(Scalars.GraphQLString).build())
                    .name("h5Columns")
                    .description("对应H5页面栏位列表")
                    .type(new GraphQLList(getType()))
                    .dataFetcher(environment ->  {
                    	
	                    	Long h5AppId = null;
	                		Long h5ChannelId = null;
	                		List<H5Column> h5Columns = null;
                        
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
//	                	    			H5ClientColumnMappingExample h5ClientColumnMappingExample = 
//	                	    					new H5ClientColumnMappingExample();
//	                	    			h5ClientColumnMappingExample.createCriteria()
//	                	    					.andH5ClientVersionIdEqualTo(h5ClientVersionId)
//	                	    					.andStatusEqualTo((byte) 1); 
//	                	    			List<H5ClientColumnMapping> h5ClientColumnMappings = 
//	                	    					h5ClientColumnMappingMapper.selectByExample(h5ClientColumnMappingExample);
//	                	    			
//	                	    			List<Long> h5ColumnIds = new ArrayList<>();
//	                	    			for (H5ClientColumnMapping h5ClientColumnMapping : h5ClientColumnMappings) {
//	                	    				h5ColumnIds.add(h5ClientColumnMapping.getId());
//	                	    			}
//	                	    			
//	                	    			H5ColumnExample h5ColumnExample = new H5ColumnExample();
//	                	    			h5ColumnExample.createCriteria().andIdIn(h5ColumnIds);
	                	    			h5Columns = h5ColumnMapper.selectH5ColumnWithClientColumnMapping(h5ClientVersionId);
	                	    			return h5Columns;
	                	    		}
	                	    }
	                	    return h5Columns;
                    } ).build();
        }
        return listQueryField;
    }
    
    @Autowired(required = true)
	public void setH5ClientVersionMapper(H5ClientVersionMapper h5ClientVersionMapper) {
		H5ColumnType.h5ClientVersionMapper = h5ClientVersionMapper;
	}
    @Autowired(required = true)
	public void setH5ClientColumnMappingMapper(H5ClientColumnMappingMapper h5ClientColumnMappingMapper) {
		H5ColumnType.h5ClientColumnMappingMapper = h5ClientColumnMappingMapper;
	}
    @Autowired(required = true)
	public void setH5ColumnMapper(H5ColumnMapper h5ColumnMapper) {
		H5ColumnType.h5ColumnMapper = h5ColumnMapper;
	}
    @Autowired(required = true)
	public void setH5ProductColumnMappingMapper(H5ProductColumnMappingMapper h5ProductColumnMappingMapper) {
		H5ColumnType.h5ProductColumnMappingMapper = h5ProductColumnMappingMapper;
	}
    @Autowired(required = true)
	public void setH5AppClientMapper(H5AppClientMapper h5AppClientMapper) {
		H5ColumnType.h5AppClientMapper = h5AppClientMapper;
	}
    @Autowired(required = true)
	public void setLandingChannelMapper(LandingChannelMapper landingChannelMapper) {
		H5ColumnType.landingChannelMapper = landingChannelMapper;
	}
}
