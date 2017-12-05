package com.pinganzhiyuan.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pinganzhiyuan.graphql.RecommendProductType;
import com.pinganzhiyuan.model.Product;
import com.pinganzhiyuan.service.GraphQLService;
import com.pinganzhiyuan.service.ProductService;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;


@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public List<Product> getProductList() {
        // TODO Auto-generated method stub
        return null;
    }

}
