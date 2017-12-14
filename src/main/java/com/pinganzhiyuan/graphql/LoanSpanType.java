package com.pinganzhiyuan.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pinganzhiyuan.mapper.LoanSpanMapper;
import com.pinganzhiyuan.model.LoanSpan;
import com.pinganzhiyuan.model.LoanSpanExample;

import graphql.Scalars;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

@Component
public class LoanSpanType {
    
    private static GraphQLFieldDefinition singleQueryField;
    private static GraphQLFieldDefinition listQueryField;
    
    private static LoanSpanMapper loanSpanMapper;

    private static GraphQLObjectType type;

    public static GraphQLObjectType getType() {
        if (type == null) {
            type = GraphQLObjectType
                    .newObject().name("LoanSpan").description("贷款区间")
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("id")
                            .description("唯一主键")
                            .type(Scalars.GraphQLLong)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("loanCeiling")
                            .description("贷款下限")
                            .type(Scalars.GraphQLInt)
                            .build())
                    .field(GraphQLFieldDefinition
                            .newFieldDefinition().name("loanFloor")
                            .description("贷款下限")
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
                    .name("loanSpans")
                    .description("贷款区间列表")
                    .type(new GraphQLList(getType()))
                    .dataFetcher(environment ->  {
                        LoanSpanExample example = new LoanSpanExample();
                        example.setOrderByClause("sequency asc");
                        List<LoanSpan> list = loanSpanMapper.selectByExample(example);
                        return list;
                    } ).build();
        }
        return listQueryField;
    }
    
    @Autowired(required = true)
    public void setLoanSpanMapper(LoanSpanMapper loanSpanMapper) {
        LoanSpanType.loanSpanMapper = loanSpanMapper;
    }
}
